#iTunes Search

[![Maven Central badge](https://maven-badges.herokuapp.com/maven-central/be.ceau/itunes-search/badge.svg)](https://mvnrepository.com/artifact/be.ceau/itunes-search)  [![Javadocs](https://javadoc.io/badge/be.ceau/itunes-search.svg)](https://javadoc.io/doc/be.ceau/itunes-search)  [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.txt)

**iTunes Search** is a Java client library providing easy programmatic access to four different iTunes APIs.

  * [Search API](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching)
  * [Lookup API](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#lookup)
  * [Feed Generator API](https://rss.itunes.apple.com/en-us)
  * [Genre ID API](https://affiliate.itunes.apple.com/resources/documentation/genre-mapping/)


### Usage

##### Search
Search for 15 podcasts with CBS Radio as author in the Canadian iTunes store:

```Java
Response response = new Search("cbs radio")
		.setCountry(Country.CANADA)
		.setAttribute(Attribute.AUTHOR_TERM)		
		.setLimit(15)
		.execute();
```

##### Lookup
Lookup Bruce Springsteen albums by his iTunes artist id, 178834:
		
```Java
Response response = new Lookup()
		.addId("178834")
		.setEntity(Entity.ALBUM)
		.execute();
```

##### Feed Generator
With the Feed Generator implementation, you can create both the URL as request the feed directly from your application.

To create a URL for a feed with the top 10 hot albums for Apple Music in France:

```Java
String url = new FeedGenerator()
		.setAllowExplicit(true)
		.setCountry(Country.FRANCE)
		.setMediaType(MediaType.APPLE_MUSIC)
		.setFeedType(FeedType.HOT_ALBUMS)
		.setResultsLimit(10)
		.getUrl();
```
To get the current state of that feed as parsed Java object hierarchy:

```Java
String url = new FeedGenerator()
		.setAllowExplicit(true)
		.setCountry(Country.FRANCE)
		.setMediaType(MediaType.APPLE_MUSIC)
		.setFeedType(FeedType.HOT_ALBUMS)
		.setResultsLimit(10)
		.getFeed();
```

##### Genre ID


##### HTTP connection setup 

iTunes Search allows specifying your own logic to perform HTTP requests. To do so, simply implement the `be.ceau.itunessearch.Connector` interface and pass an instance to the execute method of a `be.ceau.itunessearch.Search` or `be.ceau.itunessearch.Lookup`.

```Java
Response response = new Search("test")
		.execute(new YourConnectorImpl());
```

### Requirements
This library requires Java 7 or higher.

### Maven Central
Include this project directly from Maven Central
```XML
<groupId>be.ceau</groupId>
<artifactId>itunes-search</artifactId>
<version>${project.version}</version>
```

### GnuPG public key
Verify signature files with my [GnuPG public key](https://www.ceau.be/pubkey.gpg).

### Javadoc
View javadoc for current release at [javadoc.io](https://javadoc.io/doc/be.ceau/itunes-search).

### License
Licensed under [the Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.txt).

### Disclaimer
iTunes is a trademark of Apple Inc., registered in the U.S. and other countries.

This library has not been authorized, sponsored, or otherwise approved by Apple Inc.