

## Introduction ##
See [Mediawiki - Help:Extension:ParserFunctions](http://www.mediawiki.org/wiki/Help:Extension:ParserFunctions) for example of parser functions.

In the Bliki engine many of these functions are predefined in the package `info.bliki.wiki.template`

## The parser function implementation ##
For your own parser function you need to implement an `AbstractTemplateFunction`. The following code shows a simple example to start with. The {{arg1:the first argument}} parser function call should simply return "the first argument".

```
...
import info.bliki.wiki.model.IWikiModel;
import info.bliki.wiki.template.AbstractTemplateFunction;
import java.util.List;

public class Arg1 extends AbstractTemplateFunction {
  public final static ITemplateFunction CONST = new Arg1();

  public Arg1() {

  }

  public String parseFunction(List<String> list, IWikiModel model,char[] src, int beginIndex, int endIndex) {
    if (list.size() > 0) {
      String result = parse(list.get(0), model);
      return result;
    }
    return null;
  }

} 
...
```

Now you can add the new parser function to the configuration in a static block of your own derived wiki model class:
```
...
static {
  Configuration.DEFAULT_CONFIGURATION.addTemplateFunction("arg1", Arg1.CONST); 
}
...
```

Now the new parser function syntax can be used in your wiki application.