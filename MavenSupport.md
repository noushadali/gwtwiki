The following examples demonstrate the configuration of the bliki engine for a Maven project.



## Include release version (3.0.x) ##
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>test</groupId>
        <artifactId>test-bliki</artifactId>
        <packaging>jar</packaging>
        <version>0.0.1</version>

	<dependencies>
		<dependency>
			<groupId>info.bliki.wiki</groupId>
			<artifactId>bliki-core</artifactId>
			<version>3.0.19</version>
		</dependency>
	</dependencies>

...

...
        <repositories>
                <repository>
                        <id>info-bliki-repository</id>
                        <url>http://gwtwiki.googlecode.com/svn/maven-repository/</url>
                        <releases>
                                <enabled>true</enabled>
                        </releases>
                        <snapshots>
                                <enabled>false</enabled>
                        </snapshots>
                </repository>
        </repositories>
</project>
```

## Include unreleased (snapshot) version 3.0.x ##
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>test</groupId>
        <artifactId>test-bliki</artifactId>
        <packaging>jar</packaging>
        <version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>info.bliki.wiki</groupId>
			<artifactId>bliki-core</artifactId>
			<version>3.0.20-SNAPSHOT</version>
		</dependency>
	</dependencies>

...

...
        <repositories>
                <repository>
                        <id>info-bliki-repository</id>
                        <url>http://gwtwiki.googlecode.com/svn/maven-snapshot-repository/</url>
                        <releases>
                                <enabled>false</enabled>
                        </releases>
                        <snapshots>
                                <enabled>true</enabled>
                        </snapshots>
                </repository>
        </repositories>
</project>
```

## Include unreleased (snapshot) version 3.1.x ##
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>test</groupId>
        <artifactId>test-bliki</artifactId>
        <packaging>jar</packaging>
        <version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>info.bliki.wiki</groupId>
			<artifactId>bliki-core</artifactId>
			<version>3.1.01-SNAPSHOT</version>
		</dependency>
	</dependencies>

...

...
        <repositories>
                <repository>
                        <id>info-bliki-repository</id>
                        <url>http://gwtwiki.googlecode.com/svn/maven-snapshot-repository/</url>
                        <releases>
                                <enabled>false</enabled>
                        </releases>
                        <snapshots>
                                <enabled>true</enabled>
                        </snapshots>
                </repository>
        </repositories>
</project>
```