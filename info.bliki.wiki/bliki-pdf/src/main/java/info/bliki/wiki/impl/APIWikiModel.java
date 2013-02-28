package info.bliki.wiki.impl;

import info.bliki.api.Page;
import info.bliki.api.User;
import info.bliki.api.creator.ImageData;
import info.bliki.api.creator.TopicData;
import info.bliki.api.creator.WikiDB;
import info.bliki.htmlcleaner.ContentToken;
import info.bliki.htmlcleaner.TagNode;
import info.bliki.wiki.filter.AbstractParser;
import info.bliki.wiki.filter.Encoder;
import info.bliki.wiki.filter.WikipediaParser;
import info.bliki.wiki.filter.WikipediaPreTagParser;
import info.bliki.wiki.filter.AbstractParser.ParsedPageName;
import info.bliki.wiki.model.Configuration;
import info.bliki.wiki.model.ImageFormat;
import info.bliki.wiki.model.WikiModel;
import info.bliki.wiki.namespaces.INamespace.NamespaceCode;
import info.bliki.wiki.tags.WPATag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Wiki model implementation which uses the <code>info.bliki.api</code> package
 * for downloading templates and images from a defined wiki.
 * 
 */
public class APIWikiModel extends WikiModel {
	private WikiDB fWikiDB;

	private final String fImageDirectoryName;
	static {
		TagNode.addAllowedAttribute("style");
	}

	private final User fUser;

	/**
	 * WikiModel which loads the templates and images through the <a
	 * href="http://meta.wikimedia.org/w/api.php">Wikimedia API</a>
	 * 
	 * @param user
	 *          a user for the <a
	 *          href="http://meta.wikimedia.org/w/api.php">Wikimedia API</a>
	 * @param wikiDB
	 *          a wiki database to retrieve already downloaded topics and
	 *          templates
	 * @param imageBaseURL
	 *          a url string which must contains a &quot;${image}&quot; variable
	 *          which will be replaced by the image name, to create links to
	 *          images.
	 * @param linkBaseURL
	 *          a url string which must contains a &quot;${title}&quot; variable
	 *          which will be replaced by the topic title, to create links to
	 *          other wiki topics.
	 * @param imageDirectoryName
	 *          a directory for storing downloaded Wikipedia images. The directory
	 *          must already exist.
	 */
	public APIWikiModel(User user, WikiDB wikiDB, String imageBaseURL, String linkBaseURL, String imageDirectoryName) {
		this(user, wikiDB, Locale.ENGLISH, imageBaseURL, linkBaseURL, imageDirectoryName);
	}

	/**
	 * WikiModel which loads the templates and images through the <a
	 * href="http://meta.wikimedia.org/w/api.php">Wikimedia API</a>
	 * 
	 * @param user
	 *          a user for the <a
	 *          href="http://meta.wikimedia.org/w/api.php">Wikimedia API</a>
	 * @param wikiDB
	 *          a wiki database to retrieve already downloaded topics and
	 *          templates
	 * @param locale
	 *          a locale for loading language specific resources
	 * @param imageBaseURL
	 *          a url string which must contains a &quot;${image}&quot; variable
	 *          which will be replaced by the image name, to create links to
	 *          images.
	 * @param linkBaseURL
	 *          a url string which must contains a &quot;${title}&quot; variable
	 *          which will be replaced by the topic title, to create links to
	 *          other wiki topics.
	 * @param imageDirectoryName
	 *          a directory for storing downloaded Wikipedia images. The directory
	 *          must already exist.
	 */
	public APIWikiModel(User user, WikiDB wikiDB, Locale locale, String imageBaseURL, String linkBaseURL, String imageDirectoryName) {
		super(Configuration.DEFAULT_CONFIGURATION, locale, imageBaseURL, linkBaseURL);
		fUser = user;
		fWikiDB = wikiDB;
		if (imageDirectoryName != null) {
			if (imageDirectoryName.charAt(imageDirectoryName.length() - 1) == '/') {
				fImageDirectoryName = imageDirectoryName;
			} else {
				fImageDirectoryName = imageDirectoryName + "/";
			}
			File file = new File(fImageDirectoryName);
			if (!file.exists()) {
				file.mkdir();
			}
		} else {
			fImageDirectoryName = null;
		}
	}

	/**
	 * Get the raw wiki text for the given namespace and article name. This model
	 * implementation uses a Derby database to cache downloaded wiki template
	 * texts.
	 * 
	 * @param parsedPagename
	 *          the parsed template name
	 * @param templateParameters
	 *          if the namespace is the <b>Template</b> namespace, the current
	 *          template parameters are stored as <code>String</code>s in this map
	 * 
	 * @return <code>null</code> if no content was found
	 * 
	 * @see info.bliki.api.User#queryContent(String[])
	 */
	@Override
	public String getRawWikiContent(ParsedPageName parsedPagename, Map<String, String> templateParameters) {
		String result = super.getRawWikiContent(parsedPagename, templateParameters);
		if (result != null) {
			// found magic word template
			return result;
		}

		if (parsedPagename.namespace.isType(NamespaceCode.TEMPLATE_NAMESPACE_KEY)) {
			String content = null;
			String fullPageName = parsedPagename.namespace.makeFullPagename(parsedPagename.pagename);
			try {
				TopicData topicData = fWikiDB.selectTopic(fullPageName);
				if (topicData != null) {
					content = topicData.getContent();
					content = getRedirectedWikiContent(content, templateParameters);
					if (content != null) {
						return content.length() == 0 ? null : content;
					} else {
						return null;
					}
				}
				String[] listOfTitleStrings = { fullPageName };
				fUser.login();
				List<Page> listOfPages = fUser.queryContent(listOfTitleStrings);
				if (listOfPages.size() > 0) {
					Page page = listOfPages.get(0);
					content = page.getCurrentContent();
					if (content != null) {
						// System.out.println(name);
						// System.out.println(content);
						// System.out.println("-----------------------");
						topicData = new TopicData(fullPageName, content);
						fWikiDB.insertTopic(topicData);
						content = getRedirectedWikiContent(content, templateParameters);
						if (content != null) {
							content = content.length() == 0 ? null : content;
						}
					}
				}
				return content;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getRedirectedWikiContent(String rawWikitext, Map<String, String> templateParameters) {
		if (rawWikitext.length() < 9) {
			// less than "#REDIRECT" string
			return rawWikitext;
		}
		String redirectedLink = WikipediaParser.parseRedirect(rawWikitext, this);
		if (redirectedLink != null) {
			ParsedPageName redirParsedPage = AbstractParser.parsePageName(this, redirectedLink, fNamespace.getTemplate(), true, true);
			try {
				int level = incrementRecursionLevel();
				// TODO: what to do if parsing the title failed due to invalid syntax?
				if (level > Configuration.PARSER_RECURSION_LIMIT || !redirParsedPage.valid) {
					return "Error - getting content of redirected link: " + redirParsedPage.namespace + ":" + redirParsedPage.pagename;
				}
				return getRawWikiContent(redirParsedPage, templateParameters);
			} finally {
				decrementRecursionLevel();
			}
		}
		return rawWikitext;
	}

	public void appendInternalImageLink(String hrefImageLink, String srcImageLink, ImageFormat imageFormat) {
		try {
			String imageName = imageFormat.getFilename();
			ImageData imageData = fWikiDB.selectImage(imageName);
			if (imageData != null) {
				File file = new File(imageData.getFilename());
				if (file.exists()) {
					super.appendInternalImageLink(hrefImageLink, "file:///" + imageData.getFilename(), imageFormat);
					return;
				}
			}
			String imageNamespace = fNamespace.getImage().getPrimaryText();
			setDefaultThumbWidth(imageFormat);
			String[] listOfTitleStrings = { imageNamespace + ":" + imageName };
			fUser.login();
			List<Page> listOfPages;
			if (imageFormat.getWidth() > 0) {
				listOfPages = fUser.queryImageinfo(listOfTitleStrings, imageFormat.getWidth());
			} else {
				listOfPages = fUser.queryImageinfo(listOfTitleStrings);
			}
			if (listOfPages.size() > 0) {
				Page page = listOfPages.get(0);
				imageData = new ImageData(imageName);

				// download the image to fImageDirectoryName directory
				FileOutputStream os = null;
				try {
					String imageUrl;
					if (imageFormat.getWidth() > 0) {
						imageUrl = page.getImageThumbUrl();
					} else {
						imageUrl = page.getImageUrl();
					}

					String urlImageName = Encoder.encodeTitleLocalUrl(page.getTitle());
					if (imageUrl != null) {
						int index = imageUrl.lastIndexOf('/');
						if (index > 0) {
							urlImageName = Encoder.encodeTitleLocalUrl(imageUrl.substring(index + 1));
						}
					}
					if (fImageDirectoryName != null) {
						String filename = fImageDirectoryName + urlImageName;
						File file = new File(filename);
						if (!file.exists()) {
							// if the file doesn't exist try to download from Wikipedia
							os = new FileOutputStream(filename);
							page.downloadImageUrl(os, imageUrl);
						}
						imageData.setUrl(imageUrl);
						imageData.setFilename(filename);
						fWikiDB.insertImage(imageData);
						super.appendInternalImageLink(hrefImageLink, "file:///" + filename, imageFormat);
					}
					return;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					if (os != null) {
						try {
							os.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void appendInternalLink(String topic, String hashSection, String topicDescription, String cssClass, boolean parseRecursive) {
//		// WPATag aTagNode = new WPATag();
//		// append(aTagNode);
//		// aTagNode.addAttribute("id", "w", true);
//		// String href = topic;
//		// if (hashSection != null) {
//		// href = href + '#' + hashSection;
//		// }
//		// aTagNode.addAttribute("href", href, true);
//		// if (cssClass != null) {
//		// aTagNode.addAttribute("class", cssClass, true);
//		// }
//		// aTagNode.addObjectAttribute("wikilink", topic);
//		//
//		// // Show only descriptions no internal wiki links
//		// ContentToken text = new ContentToken(topicDescription);
//		// // append(text);
//		// aTagNode.addChild(text);
//		String description = topicDescription.trim();
//		WPATag aTagNode = new WPATag();
//		// append(aTagNode);
//		aTagNode.addAttribute("id", "w", true);
//		String href = topic;
//		if (hashSection != null) {
//			href = href + '#' + hashSection;
//		}
//		aTagNode.addAttribute("href", href, true);
//		if (cssClass != null) {
//			aTagNode.addAttribute("class", cssClass, true);
//		}
//		aTagNode.addObjectAttribute("wikilink", topic);
//		pushNode(aTagNode);
//		if (parseRecursive) {
//			WikipediaPreTagParser.parseRecursive(description, this, false, true);
//		} else {
//			aTagNode.addChild(new ContentToken(description));
//		}
//		popNode();
//		// ContentToken text = new ContentToken(topicDescription);
//		// aTagNode.addChild(text);
//	}

	public void parseInternalImageLink(String imageNamespace, String rawImageLink) {
		String imageSrc = getImageBaseURL();
		if (imageSrc != null) {
			String imageHref = getWikiBaseURL();
			ImageFormat imageFormat = ImageFormat.getImageFormat(rawImageLink, imageNamespace);

			String imageName = imageFormat.getFilename();
			// String sizeStr = imageFormat.getSizeStr();
			// if (sizeStr != null) {
			// imageName = sizeStr + '-' + imageName;
			// }
			// if (imageName.endsWith(".svg")) {
			// imageName += ".png";
			// }
			imageName = Encoder.encodeUrl(imageName);
			// if (replaceColon()) {
			// imageName = imageName.replaceAll(":", "/");
			// }
			if (replaceColon()) {
				imageHref = imageHref.replace("${title}", imageNamespace + '/' + imageName);
				imageSrc = imageSrc.replace("${image}", imageName);
			} else {
				imageHref = imageHref.replace("${title}", imageNamespace + ':' + imageName);
				imageSrc = imageSrc.replace("${image}", imageName);
			}
			appendInternalImageLink(imageHref, imageSrc, imageFormat);
		}
	}
}
