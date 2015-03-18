# Bliki parser integration into www.jamwiki.org wiki #
From Bliki version 3.0.12-SNAPSHOT and JAMWiki 0.8.0-SNAPSHOT on, the Bliki parser engine can be used in the jamwiki software:
  * [www.jamwiki.org](http://www.jamwiki.org)

After installing JAMWiki change the parser parameter in the file:
> `jamwiki-war/WEB-INF/classes/jamwiki.properties`
to this class:
> `parser=org.jamwiki.parser.bliki.BlikiParser`

Restart JAMWiki and the new parser should be used.