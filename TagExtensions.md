

This is an [unreleased feature](MavenSupport.md).

## Introduction ##
In the following steps we create a new wiki tag which supports the [Google Chart API](http://code.google.com/apis/chart/).

A wiki text like the following should for example show a TeX formula as an Image:
```
  <chart cht=tx chl="x = \frac{-b \pm \sqrt {b^2-4ac}}{2a}" />
```

![http://chart.apis.google.com/chart?chl=x+%3D+%5Cfrac%7B-b+%5Cpm+%5Csqrt+%7Bb%5E2-4ac%7D%7D%7B2a%7D&cht=tx&i=i.png](http://chart.apis.google.com/chart?chl=x+%3D+%5Cfrac%7B-b+%5Cpm+%5Csqrt+%7Bb%5E2-4ac%7D%7D%7B2a%7D&cht=tx&i=i.png)

or the following should for example show a barchart
```
<chart 
  cht=bvs 
  chs=800x300 
  chbh=20,1 
  chxt=x,y 
  chco=76A4FB 
  chls=2.0   
chd=t:1,2,3,6,9,13,20,28,37,49,60,72,83,92,98,100,98,92,83,72,60,49,37,28,20,13,9,6,3,2,1 
/>
```

![http://chart.apis.google.com/chart?chbh=20%2C1&chco=76A4FB&chd=t%3A1%2C2%2C3%2C6%2C9%2C13%2C20%2C28%2C37%2C49%2C60%2C72%2C83%2C92%2C98%2C100%2C98%2C92%2C83%2C72%2C60%2C49%2C37%2C28%2C20%2C13%2C9%2C6%2C3%2C2%2C1&chls=2.0&chs=800x300&cht=bvs&chxt=x%2Cy&i=i.png](http://chart.apis.google.com/chart?chbh=20%2C1&chco=76A4FB&chd=t%3A1%2C2%2C3%2C6%2C9%2C13%2C20%2C28%2C37%2C49%2C60%2C72%2C83%2C92%2C98%2C100%2C98%2C92%2C83%2C72%2C60%2C49%2C37%2C28%2C20%2C13%2C9%2C6%2C3%2C2%2C1&chls=2.0&chs=800x300&cht=bvs&chxt=x%2Cy&i=i.png)

## The chart tag implementation ##
The complete source code for this "chart" tag can be found in SVN: [ChartTag.java](http://code.google.com/p/gwtwiki/source/browse/trunk/info.bliki.wiki/bliki-core/src/main/java/info/bliki/wiki/tags/extension/ChartTag.java)

To create a new tag extend the `HTMLTag` and implement the `INoBodyParsingTag`, because our chart tag needs no nested tag parsing:
```
public class ChartTag extends HTMLTag implements INoBodyParsingTag {
```
To allow all the [Google Chart API parameters](http://code.google.com/intl/de-DE/apis/chart/docs/chart_params.html) as attributes in the new tag, we define a set of allowed attributes and implement the `isAllowedAttribute()` method:
```
...
final static public HashSet<String> ALLOWED_ATTRIBUTES_SET = new HashSet<String>(997);

final static public String[] ALLOWED_ATTRIBUTES = { "alt", "chbh",....."chxtc" };

static {
  for (int i = 0; i < ALLOWED_ATTRIBUTES.length; i++) {
    ALLOWED_ATTRIBUTES_SET.add(ALLOWED_ATTRIBUTES[i]);
  }
}
...
...
public boolean isAllowedAttribute(String attName) {
  return ALLOWED_ATTRIBUTES_SET.contains(attName);
}
```

in the `renderHTML()` method the Google Chart API URL will be constructed from the given attribute values and embedded in an `<img .../>` HTML tag:
```
public void renderHTML(ITextConverter converter, Appendable buf, IWikiModel model) throws IOException {

                TagNode node = this;
                StringBuilder chartUrl = new StringBuilder(100);
                Map<String, String> tagAtttributes = node.getAttributes();
                Set<String> keysSet = tagAtttributes.keySet();
                for (String str : keysSet) {
                        if (str.equals("alt")) {
                                continue;
                        }
                        Utils.appendAmpersandEscapedAttribute(chartUrl, str, tagAtttributes);
                }

                buf.append("<img border=\"0\" src=\"http://chart.apis.google.com/chart?");
                buf.append(chartUrl);
                buf.append("\" alt=\"");
                Utils.appendEscapedAttribute(buf, "alt", tagAtttributes);
                buf.append("\" />");
        }

```

Now you can add the new tag to the configuration in a static block of your own derived wiki model class:
```
...
static {
  Configuration.DEFAULT_CONFIGURATION.addTokenTag("chart", new ChartTag());
}
...
```

Now the new chart tag syntax can be used in your wiki application.