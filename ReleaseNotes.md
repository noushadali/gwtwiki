

## Version 3.1.01-SNAPSHOT ([unreleased](MavenSupport.md)) ##
  * the new Bliki engine version now depends on Java 1.6
  * API changes (compared to 3.0.x versions)

## Version 3.0.20-SNAPSHOT ([unreleased](MavenSupport.md)) ##
  * add English namespace strings as global aliases for any locale - [Issue 124](https://code.google.com/p/gwtwiki/issues/detail?id=124)
  * let formatnum keep the decimal point if given and also keep the number of decimals given (e.g. don't round such numbers like 90.0 down to 90) - [r8055](https://code.google.com/p/gwtwiki/source/detail?r=8055), [r8059](https://code.google.com/p/gwtwiki/source/detail?r=8059)
  * fixed mod function of #expr not truncating its parameters to integers - [r8054](https://code.google.com/p/gwtwiki/source/detail?r=8054)
  * preserving newlines and whitespace - [Issue 122](https://code.google.com/p/gwtwiki/issues/detail?id=122)
  * fixed skipping empty implicitely numbered parameters - [r7785](https://code.google.com/p/gwtwiki/source/detail?r=7785)
  * switch: don't parse RHS value if not needed (improves performance) - [r7784](https://code.google.com/p/gwtwiki/source/detail?r=7784)
  * fixed last character of template name removed if '~' - [r7780](https://code.google.com/p/gwtwiki/source/detail?r=7780)
  * increased TEMPLATE\_BUFFER\_LIMIT and TEMPLATE\_VALUE\_LIMIT for rendering newer Wikipedia dumps
  * allow `<abbr>` HTML tags
  * carriage-return in template parameters is not removed - [Issue 121](https://code.google.com/p/gwtwiki/issues/detail?id=121)
  * template parameter in template parameter name does not work - [Issue 120](https://code.google.com/p/gwtwiki/issues/detail?id=120)
  * add implicit `<ul>` if parsing encountered `<li>` tags without ol or ul - [Issue 118](https://code.google.com/p/gwtwiki/issues/detail?id=118)
  * Improvements in namespace handling - [Issue115](https://code.google.com/p/gwtwiki/issues/detail?id=115)
  * Rendering non-existing transclude should display a (red) link - [Issue114](https://code.google.com/p/gwtwiki/issues/detail?id=114)
  * Changed user-agent string for querying the Wikipedia API - [Issue113](https://code.google.com/p/gwtwiki/issues/detail?id=113)
  * preserving newlines and whitespace - [Issue122](https://code.google.com/p/gwtwiki/issues/detail?id=122)
  * don't parse invalid template names as templates - [Issue123](https://code.google.com/p/gwtwiki/issues/detail?id=123)
  * avoid generating objects for garbage collections, if not necessary - [Issue 125](https://code.google.com/p/gwtwiki/issues/detail?id=125)
  * add English namespace strings as global aliases for any locale - [Issue124](https://code.google.com/p/gwtwiki/issues/detail?id=124)
  * added support for several new magic words: TALKPAGE, TALKPAGEE, SUBJECTPAGENAME, SUBJECTPAGENAMEE, ARTICLEPAGENAME, ARTICLEPAGENAMEE, BASEPAGENAME, BASEPAGENAMEE, SUBPAGENAME, SUBPAGENAMEE - [r8375](https://code.google.com/p/gwtwiki/source/detail?r=8375), [r8376](https://code.google.com/p/gwtwiki/source/detail?r=8376), [r8381](https://code.google.com/p/gwtwiki/source/detail?r=8381)
  * added support for "Portal" and "Portal talk" namespaces - [r8385](https://code.google.com/p/gwtwiki/source/detail?r=8385)
  * missing ability to get bliki library version - [Issue127](https://code.google.com/p/gwtwiki/issues/detail?id=127)
  * parse HTML comments until EOF even if ending tag is not found - [r8392](https://code.google.com/p/gwtwiki/source/detail?r=8392)
  * adapted link rendering -> no css class "externallink" anymore - instead use "external free", "external text" and "external autonumber" - [r8667](https://code.google.com/p/gwtwiki/source/detail?r=8667)
  * remove any "#label" markers in transcluded template/page names (like MediaWiki) - [r8668](https://code.google.com/p/gwtwiki/source/detail?r=8668)
  * don't parse wiki markup in `<pre>` environments - [r8669](https://code.google.com/p/gwtwiki/source/detail?r=8669)
  * incorrect parsing of links if an additional HTML tag is appended - [Issue 131](https://code.google.com/p/gwtwiki/issues/detail?id=131)
  * run and pass MediaWiki test cases - [Issue129](https://code.google.com/p/gwtwiki/issues/detail?id=129)

## Version 3.0.19 ##
  * Fullurl parser function uses the english Wikipedia  - [Issue111](https://code.google.com/p/gwtwiki/issues/detail?id=111)
  * Recursion counters managed incorrectly - [Issue110](https://code.google.com/p/gwtwiki/issues/detail?id=110)
  * Improve the behaviour of the NAMESPACE magic word - [Issue108](https://code.google.com/p/gwtwiki/issues/detail?id=108)
  * Improve the rendering of the `Template:Convert` - [Issue107](https://code.google.com/p/gwtwiki/issues/detail?id=107)
  * thumb-images should also stop pre-tags - [Issue106](https://code.google.com/p/gwtwiki/issues/detail?id=106)
  * image parser eats characters of text following directly after a wiki image link - [Issue105](https://code.google.com/p/gwtwiki/issues/detail?id=105)
  * linebreaks with no starting space char do not separate preformatted text - [Issue104](https://code.google.com/p/gwtwiki/issues/detail?id=104)
  * improved rendering of image format - [Issue 103](https://code.google.com/p/gwtwiki/issues/detail?id=103)
  * incorrect rendering of newlines/spaces in #... parser functions - [Issue102](https://code.google.com/p/gwtwiki/issues/detail?id=102)
  * internal links do not render correctly in some browsers - [Issue101](https://code.google.com/p/gwtwiki/issues/detail?id=101)
  * delete dependency for commons-lang library - [Issue100](https://code.google.com/p/gwtwiki/issues/detail?id=100)
  * syntax highlighting for sql does not work properly - [Issue99](https://code.google.com/p/gwtwiki/issues/detail?id=99)
  * avoid tags with empty content - [Issue98](https://code.google.com/p/gwtwiki/issues/detail?id=98)

## Version 3.0.18 ##
  * slow parsing of huge tables - [Issue97](https://code.google.com/p/gwtwiki/issues/detail?id=97)
  * `Encoder#encodeTitleLocalUrl()` creates invalid Windows file names - [Issue95](https://code.google.com/p/gwtwiki/issues/detail?id=95)
  * allow ignoring tag extensions through configuration - [Issue94](https://code.google.com/p/gwtwiki/issues/detail?id=94)
  * Simplify basic usage with a static `WikiModel#toHtml()` and `WikiModel#toText()` method - [Issue93](https://code.google.com/p/gwtwiki/issues/detail?id=93)
  * `AbstractWikiModel#setUp()` forgets to re-set fRedirectLink in - [Issue92](https://code.google.com/p/gwtwiki/issues/detail?id=92)
  * fixed duplication of rendering (external) links  - [Issue90](https://code.google.com/p/gwtwiki/issues/detail?id=90)
  * Extended the IWikiModel#render() method with a boolean parameter which indicates, if the text should be rendered directly in template topic mode or not - [Issue86](https://code.google.com/p/gwtwiki/issues/detail?id=86)
  * Incorrect parsing of noinclude, includeonly, and onlyinclude - [Issue86](https://code.google.com/p/gwtwiki/issues/detail?id=86)
  * Template substitution uses wrong cache value - [Issue85](https://code.google.com/p/gwtwiki/issues/detail?id=85)
  * Configuration change - loading of `interwiki.properties` file - [Issue84](https://code.google.com/p/gwtwiki/issues/detail?id=84)
  * missing support for behavior switches - [Issue83](https://code.google.com/p/gwtwiki/issues/detail?id=83)
  * possible recursive loop in template parameter substitution - [Issue82](https://code.google.com/p/gwtwiki/issues/detail?id=82)
  * refactored the `subst:...` and `safesubst:...` template functions into the preprocessor step - [Issue81](https://code.google.com/p/gwtwiki/issues/detail?id=81)
  * don't strip whitespace from unnamed template parameters - [Issue80](https://code.google.com/p/gwtwiki/issues/detail?id=80)
  * improved `#time` template function - [Issue73](https://code.google.com/p/gwtwiki/issues/detail?id=73)
  * implemented `#titleparts` template function - [Issue78](https://code.google.com/p/gwtwiki/issues/detail?id=78)
  * nesting links and templates with parameters inside a table disrupts the table - [Issue77](https://code.google.com/p/gwtwiki/issues/detail?id=77)
  * Brazillian Portuguese translation - [Issue76](https://code.google.com/p/gwtwiki/issues/detail?id=76)

## Version 3.0.17 ##
  * engine fails to render bold and italic text properly, if text is a link / namespace - [Issue75](https://code.google.com/p/gwtwiki/issues/detail?id=75)
  * improved incomplete implementation of the time template function - [Issue73](https://code.google.com/p/gwtwiki/issues/detail?id=73)
  * fixed wrong href links for `<ref>` and `<references>` tags - [r3801](https://code.google.com/p/gwtwiki/source/detail?r=3801)
  * one-character Section Headers not rendered - [Issue72](https://code.google.com/p/gwtwiki/issues/detail?id=72)
  * WikiArticle missing revision information - [Issue71](https://code.google.com/p/gwtwiki/issues/detail?id=71)
  * `__TOC__` element following a single `<h1>` but before multiple `<h2>` elements results in the table of contents ONLY displaying the `<h1>` element in the TOC. - [Issue12](https://code.google.com/p/gwtwiki/issues/detail?id=12)
  * source tag for "sql" adds empty line as first line - [Issue69](https://code.google.com/p/gwtwiki/issues/detail?id=69)
  * WikiModel's setUp() and tearDown() do not reset TOC info - [Issue68](https://code.google.com/p/gwtwiki/issues/detail?id=68)
  * source code comments in source tags not rendered - [Issue67](https://code.google.com/p/gwtwiki/issues/detail?id=67)
  * wordcount attribute not read correctly because of case mismatch - [Issue66](https://code.google.com/p/gwtwiki/issues/detail?id=66)
  * Source tag fails to render groovy source properly - [Issue65](https://code.google.com/p/gwtwiki/issues/detail?id=65)
  * Multiple Sections with the same name don't have different anchor tags - [Issue64](https://code.google.com/p/gwtwiki/issues/detail?id=64)
  * Use similar CSS classes like Wikipedia for image thumbs (thumb, thumbcaption, thumbinner)

## Version 3.0.16 ##
  * Maven repository is unusable with Java 5 - [Issue61](https://code.google.com/p/gwtwiki/issues/detail?id=61)
  * Wikipedia Template:Citation/core contains `<nowiki />` tags, which breaks rendering of templates - [Issue59](https://code.google.com/p/gwtwiki/issues/detail?id=59)
  * Patch for "Template parameter expansion with mixed named/unnamed parameters"  - [Issue56](https://code.google.com/p/gwtwiki/issues/detail?id=56)
  * removed Maven dependencies for packages commons-validator 1.3.1 and oro 2.0. - [r2494](https://code.google.com/p/gwtwiki/source/detail?r=2494)
  * added JARs for Java sources and Javadoc to Maven repository
  * Made addToTableOfContent() method protected. - [Issue51](https://code.google.com/p/gwtwiki/issues/detail?id=51)
  * Parser is too strict on #redirect - [Issue50](https://code.google.com/p/gwtwiki/issues/detail?id=50)
  * Use "syntaxhighlight" and "source" tags the same way. See: [Extension:SyntaxHighlight\_GeSHi Alternative\_Tag](http://www.mediawiki.org/wiki/Extension:SyntaxHighlight_GeSHi#Alternative_Tag)
  * deleted info.bliki.api.Category use info.bliki.api.PageInfo instead
  * performance improvements: parseURIScheme() did to much parsing and isCamelCaseEnabled() was called to often. - [r2105](https://code.google.com/p/gwtwiki/source/detail?r=2105)

## Version 3.0.15 ##
  * new parser functions {{formatnum:...}} and {{plural:...}}
  * added a [Google Chart API wiki tag extension](TagExtensions.md) example
  * added SQL source code highlighting - [Issue47](https://code.google.com/p/gwtwiki/issues/detail?id=47)
  * changed info.bliki.wiki.template.ITemplateFunction#parseFunction() method signature
  * Refactoring - extract method `substituteTemplateCall(templateName, parameterTreeMap, writer)` to IWikiModel interface and default implementation to AbstractWikiModel, so that users can override the default behaviour - [r1515](https://code.google.com/p/gwtwiki/source/detail?r=1515)
  * new Dump2HTMLCreatorExample.java - create static HTML files from a given Mediawiki dump. See MediaWikiDumpSupport.
  * incompatible changes with older versions in `info.bliki.wiki.dump.IArticleFilter interface`
  * MediaWiki authentication no longer works. Patch from user shilad - [Issue44](https://code.google.com/p/gwtwiki/issues/detail?id=44)
  * Demo application [DumpExample.java](http://code.google.com/p/gwtwiki/source/browse/trunk/info.bliki.wiki/bliki-core/src/test/java/info/bliki/wiki/dump/DumpExample.java), which iterates through a compressed or uncompressed Wikipedia XML dump file (depending on the given file extension _.gz_, _.bz2_ or _.xml_) and prints the title and raw wiki text of the articles. See MediaWikiDumpSupport. - [r1349](https://code.google.com/p/gwtwiki/source/detail?r=1349)
  * added maven dependency to [commons-compress](http://commons.apache.org/compress/)
  * Ignore space and tab characters at the beginning of a wikipedia table row or cell
  * "pre" tag with "name" attribute is not a good idea in syntax highlighters - [Issue43](https://code.google.com/p/gwtwiki/issues/detail?id=43)
  * IDs can't contain "." at the begining and "(", ")", "/" elsewere - [Issue41](https://code.google.com/p/gwtwiki/issues/detail?id=41)

## Version 3.0.14 ##
  * Added {{#iferror:...}} parser function
  * Improved template parser
  * [MediaWikiAPISupport](MediaWikiAPISupport.md): GZIP support for getting contents - [Issue35](https://code.google.com/p/gwtwiki/issues/detail?id=35)
  * Added {{subst:...}} parser function
  * Added info.bliki.api.creator.HTMLCreatorExample to load a wiki page, templates and images from en.wikipedia.org and render it into an HTML file.
  * BlikiConverter - A converter tool for using the Wiki2HTML, Plain2Wiki and HTML2Wiki conversion functions in a Java Swing GUI ([r841](https://code.google.com/p/gwtwiki/source/detail?r=841))
  * Fixed PlainTextConverter ignores the text field in between [ ] - [Issue34](https://code.google.com/p/gwtwiki/issues/detail?id=34)
  * Set an optional template call cache implementation in the IConfiguration#setTemplateCallsCache(Map<String, String> map) method. The cache implementation could be based on [JSR 107](http://jcp.org/en/jsr/detail?id=107) for example. Template calls which use the same parameters over and over again do lookup this cache and use the preparsed result if available ([r779](https://code.google.com/p/gwtwiki/source/detail?r=779)).
  * Wikipedia API: Fixed problems with intranet wiki and "byte order mark" - [Issue33](https://code.google.com/p/gwtwiki/issues/detail?id=33)
  * Fixed Image links that have intra-page link are broken - [Issue31](https://code.google.com/p/gwtwiki/issues/detail?id=31)
  * Fixed html output for some preformatted text isn't encoded - [Issue30](https://code.google.com/p/gwtwiki/issues/detail?id=30)
  * Fixed some image attributes are not encoded - [Issue29](https://code.google.com/p/gwtwiki/issues/detail?id=29)
  * Fixed html table output can be invalid if input wiki markup is invalid - [Issue28](https://code.google.com/p/gwtwiki/issues/detail?id=28)
  * HTML output for references does not encode some attribute values - [Issue27](https://code.google.com/p/gwtwiki/issues/detail?id=27)
  * Fixed HTML output is invalid for some references with template interaction - [Issue26](https://code.google.com/p/gwtwiki/issues/detail?id=26)
  * Fixed HTML output is invalid for some images with inline quotes - [Issue25](https://code.google.com/p/gwtwiki/issues/detail?id=25)
  * Change Performance issue : toLowerCase on parseURIScheme - [Issue23](https://code.google.com/p/gwtwiki/issues/detail?id=23)
  * Added simple python code formatter
  * Improved source code formatter handling. Try to auto detect some programming languages.


## Version 3.0.13 ##
  * more JUnit wiki parser tests
  * Changed encoding for Maven explicitly to UTF-8
  * Added Wikipedia namespaces class
  * Fixed [Issue19](https://code.google.com/p/gwtwiki/issues/detail?id=19)
  * Fixed [Issue16](https://code.google.com/p/gwtwiki/issues/detail?id=16)

## Version 3.0.12 ##
  * Don't convert first character to uppercase character for interwiki topics
  * Allow floating-point numbers like 1.0E10 in math expressions.
  * Avoid unnecessary memory allocation for substrings
  * Add support for telefone call - [Issue11](https://code.google.com/p/gwtwiki/issues/detail?id=11)
  * [MediaWikiAPISupport](MediaWikiAPISupport.md): added "edittoken" for query
  * [MediaWikiAPISupport](MediaWikiAPISupport.md): added "edit" action support.
  * [MediaWikiAPISupport](MediaWikiAPISupport.md): use builder pattern to create the query for the Wikipedia API
  * [MediaWikiAPISupport](MediaWikiAPISupport.md): added Parse action support
  * [MediaWikiAPISupport](MediaWikiAPISupport.md): added the "lgdomain" parameter for User() constructor and Connector#login() method - [Issue8](https://code.google.com/p/gwtwiki/issues/detail?id=8)
  * More Mediawiki compatible handling for non-closed tags: `&lt;noinclude>, &lt;includeonly>, &lt;onlyinclude>`

## Version 3.0.11 ##
  * the bliki-core Maven artifact is now available in this repository (thanks Daniel Sendula). More information can be found in page MavenSupport
  * support for the `<onlyinclude>` tag in templates
  * support for Image size format {width}x{height}px
  * dropped Trac support
  * Using '.' instead of '%' in table of content "anchor links"
  * Using Flying Saucer - R8pre2 now
  * Italian language properties contributed by Giuseppe Profiti
  * Added first version of PlainTextConverter, a converter which renders the internal tree node representation as plain text without HTML tags and images