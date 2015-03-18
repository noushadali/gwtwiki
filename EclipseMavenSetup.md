

## Prerequisite ##
I'm using these plugins under Eclipse:
  * [subclipse](http://subclipse.tigris.org/) plugin
  * [M2Eclipse](http://m2eclipse.sonatype.org/) plugin

## Setup ##
Install Subclipse and the Maven Eclipse plugins.
  1. In Eclipse go to menu _Help -> Software Updates -> Find and Install_.
  1. Choose "Search for new features to install"
  1. The required plugin URLs for subclipse and M2Eclipse are:
  1. http://subclipse.tigris.org/update_1.0.x
  1. http://m2eclipse.sonatype.org/sites/m2e/

Once installed, select the "SVN Repository" Eclipse perspective and add
  * https://gwtwiki.googlecode.com/svn/trunk/
as a repository URL.

Open the trunk node and _right click_ on the _info.bliki.wiki_ node, select the "Find/Check out as..." menu option.
In the following dialog box you can _Check out_ the source code from SVN.

## Maven install ##
Now change back to the Eclipse _Java perspective_.

For the Maven plugin to recognize the module dependencies you have to:
  * _right click_ in the _Package Explorer_ view on the info.bliki.wiki project node and choose the _Properties_ menu
  * in the left tree of the appearing dialog box select the Maven node.
  * in the right Maven panel enable the checkbox _Include Modules_

As a result the line
> `includeModules=true`
should be set in the file:
> `info.bliki.wiki/.settings/org.maven.ide.eclipse.prefs`

In the _Package Explorer_ view do a _right mouse click_ on the `pom.xml` file and select the menu _Run As -> Maven build..._.

In the appearing dialog box choose the _install_ goal and run Maven (or hit the _Run As -> Maven Install_ menu directly in the _Package Explorer_ views menu).