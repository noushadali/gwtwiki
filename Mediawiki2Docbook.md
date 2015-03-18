# How to convert Mediawiki to Docbook #
There's partial support for converting a Wikipedia text into a Docbook document.

```
	// some wiki text stored in a test string:
	public final static String TEST1 = "...";

	public void testDocbook() {
		WikiModel myWikiModel = new WikiTestModel("file:///c:/temp/${image}", "file:///c:/temp/${title}");
		String renderedXHTML = myWikiModel.render(TEST1);
		DocbookGenerator gen = new DocbookGenerator();
		try {
			String output = gen.create(renderedXHTML, DocbookGenerator.HEADER_TEMPLATE, DocbookGenerator.FOOTER, "Big Docbook Test");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
```