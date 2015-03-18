# How to convert Mediawiki text to PDF #
There's partial support for converting a Wikipedia text into a PDF document.

See for example the [PDFCreatorTest.java](http://code.google.com/p/gwtwiki/source/browse/trunk/info.bliki.wiki.test/bliki-test/src/main/java/info/bliki/api/PDFCreatorTest.java) file:
```
        private static void testWikipediaENAPI(String title) {
                String[] listOfTitleStrings = {
                        title
                };
                String titleURL = Encoder.encodeTitleLocalUrl(title);
                User user = new User("", "", "http://en.wikipedia.org/w/api.php");
                user.login();
                WikiDB db = null;
                String mainDirectory = "c:/temp/";
                // the following subdirectory should not exist if you would like to create a
                // new database
                String databaseSubdirectory = "WikiDB";
                // the following directory must exist for image downloads
                String imageDirectory = "c:/temp/WikiImages";
                try {
                        db = new WikiDB(mainDirectory, databaseSubdirectory);
                        APIWikiModel myWikiModel = new APIWikiModel(user, db, "${image}", "file:///c:/temp/${title}", imageDirectory);
                        DocumentCreator creator = new DocumentCreator(myWikiModel, user, listOfTitleStrings);

                        creator.renderPDFToFile(mainDirectory, titleURL + ".pdf", HTMLConstants.CSS_PRINTER_STYLE);
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        if (db != null) {
                                try {
                                        db.tearDown();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
```

The PDF Generation is based on the ''Flying Saucer All-Java XHTML Renderer'' project. See these webpages for more information:
  * [Homepage](https://xhtmlrenderer.dev.java.net/)
  * [XHTML to PDF Conversion, XHTML to Image Conversion or XHTML to Scalable Vector Graphics (SVG) Conversion](http://today.java.net/pub/a/today/2006/10/31/combine-facelets-and-flying-saucer-renderer.html)