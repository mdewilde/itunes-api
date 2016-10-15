#iTunes Search

![Maven Central badge](https://maven-badges.herokuapp.com/maven-central/be.ceau/itunes-search/badge.svg)


Java client for the [iTunes Search API](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/).


### Usage

```Java
Request request = new Request("ceau");
Response response = new Searcher().search(request);
```

iTunes Search allows specifying your own logic to perform HTTP requests. To do so, simply implement the `be.ceau.itunessearch.Connector` interface and construct a new `be.ceau.itunessearch.Searcher` with that implementation.

```Java
YourConnector connector = new YourConnector();
Searcher searcher = new Searcher(connector);
```

### Maven Central
Include this project directly from Maven Central
```XML
<groupId>be.ceau</groupId>
<artifactId>itunes-search</artifactId>
<version>${project.version}</version>
```

### GnuPG public key
Verify signature files with my [GnuPG public key](https://www.ceau.be/pubkey.gpg).

### License
Licensed under [the Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.txt).

### Disclaimer
iTunes is a trademark of Apple Inc., registered in the U.S. and other countries.

This library has not been authorized, sponsored, or otherwise approved by Apple Inc.