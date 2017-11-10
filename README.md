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
_See also_ [Search API page on apple.com](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching)

##### Lookup
Lookup Bruce Springsteen albums by his iTunes artist id, 178834:
		
```Java
Response response = new Lookup()
	.addId("178834")
	.setEntity(Entity.ALBUM)
	.execute();
```

_See also_ [Lookup API page on apple.com](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#lookup)

##### Feed Generator
The purpose of the Feed Generator API is to create custom RSS feeds of specific iTunes Store content, such as charts and new entries.

This library allows creating feed URLs programmatically. It also allows retrieving the feed content directly.

For example, create a feed URL for the top 10 hot albums for Apple Music in France:

```Java
String url = new FeedGenerator()
	.setCountry(Country.FRANCE)
	.setMediaType(MediaType.APPLE_MUSIC)
	.setFeedType(FeedType.HOT_ALBUMS)
	.setResultsLimit(10)
	.getUrl();
```

To retrieve the feed content directly:

```Java
Feed feed = new FeedGenerator()
	.setAllowExplicit(true)
	.setCountry(Country.FRANCE)
	.setMediaType(MediaType.APPLE_MUSIC)
	.setFeedType(FeedType.HOT_ALBUMS)
	.setResultsLimit(10)
	.execute();
```

_See also_ [Feed Generator page on apple.com](https://rss.itunes.apple.com/)

##### Genre ID
Get the full genre hierarchy for the iTunes store, along with relevant links for each genre.

```Java
GenreIdsResponse response = new GenreIdsAppendix().getGenres();
```

_See also_ [Genre ID page on apple.com](https://affiliate.itunes.apple.com/resources/documentation/genre-mapping/)

##### HTTP connection setup

**iTunes Search** allows specifying custom logic to perform HTTP requests. To do so, implement the `be.ceau.itunessearch.Connector` interface and pass an instance to the relevant API entry point:

  * `be.ceau.itunessearch.Search.execute(Connector)`
  * `be.ceau.itunessearch.Lookup.execute(Connector)`
  * `be.ceau.itunessearch.FeedGenerator.execute(Connector)`
  * `be.ceau.itunessearch.GenreIdsAppendix.execute(Connector)`

### Requirements
This library requires Java 7 or higher.

### Maven Central
Include this project directly from Maven Central
```XML
	<dependency>
		<groupId>be.ceau</groupId>
		<artifactId>itunes-search</artifactId>
		<version>${project.version}</version>
	</dependency>
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