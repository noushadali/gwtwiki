The  Java Wikipedia API (Bliki engine) is a parser library for converting Wikipedia wikitext notation to HTML.

>>> **[the Java Wikipedia API Sources has moved to GIT on Bitbucket.org](https://bitbucket.org/axelclk/info.bliki.wiki/)** <<<

>>> **[try the online converter on Google App Engine](http://w-i-k-i.appspot.com/)** <<<

Features:
  * renders [Mediawiki/Wikipedia wiki syntax to HTML](Mediawiki2HTML.md). It supports:
    * wiki tags for bold, italic, headers, nowiki, source, table of content,...
    * wiki tables, lists, categories, footnotes (references)
    * [Image:...](http://en.wikipedia.org/wiki/Image_markup) tag support
    * wiki [&lt;source&gt;](http://www.mediawiki.org/wiki/Extension:SyntaxHighlight_GeSHi) tag for syntax highlighting of source code fragments: [java, php, python, html/xml, javascript,...](SourceCode2HTML.md)
    * templates [(includeonly, noinclude,...)](http://en.wikipedia.org/wiki/Help:Template#Controlling_what_gets_transcluded)]
      * The following [template parser functions](http://www.mediawiki.org/wiki/Help:ParserFunctions) are implemented:
      * Expr, If, Ifeq, Iferror, Ifexist, Ifexpr, LC, LCFirst, Padleft, Padright, Subst, Switch, Tag, UC, UCFirst, URLEncode
      * only partial support is available for: Fullurl, Localurl, NS, Time
  * extendable through a [model interface (IWikiModel.java)](WikiModels.md)
  * converts [HTML to Wikipedia, JSPWiki, Trac, MoinMoin, Google Code](HTML2Mediawiki.md) text (available as Appengine, GWT application)
  * helper classes for the [Wikimedia api.php](MediaWikiAPISupport.md) for downloading wiki texts...
  * Example [HTMLCreatorExample.java](Mediawiki2HTML#Advanced_example_for_converting_Wikipedia_texts_to_HTML.md) which shows, how to download a complete wiki page with templates and images and render it to HTML. The templates are cached in a Derby database.
  * helper classes to work with [MediaWiki XML dump](MediaWikiDumpSupport.md) files.
  * [BlikiConverter](http://code.google.com/p/gwtwiki/source/browse/trunk/info.bliki.wiki/bliki-core/src/main/java/info/bliki/wiki/BlikiConverter.java) - A converter tool for using the `Wiki2HTML, Plain2Wiki and HTML2Wiki` conversion methods in a Java Swing GUI
  * [Projects](PoweredBy.md) using the library

<a href='http://flattr.com/thing/689794/Java-Wikipedia-API'>
<img src='http://api.flattr.com/button/flattr-badge-large.png' alt='Flattr this' border='0' title='Flattr this' /></a>

&lt;wiki:gadget url="http://www.ohloh.net/p/62334/widgets/project\_basic\_stats.xml" height="250"  border="1" /&gt;