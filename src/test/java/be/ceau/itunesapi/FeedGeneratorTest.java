/*
	Copyright 2021 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		https://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.itunesapi;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import be.ceau.itunesapi.request.Country;
import be.ceau.itunesapi.request.feedgenerator.FeedFormat;
import be.ceau.itunesapi.request.feedgenerator.FeedType;
import be.ceau.itunesapi.request.feedgenerator.MediaType;
import be.ceau.itunesapi.response.feedgenerator.Feed;

public class FeedGeneratorTest {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
	}

	@Test
	public void defaultUrl() {
		Assert.assertEquals("https://rss.itunes.apple.com/api/v1/us/apple-music/new-music/all/10/explicit.json", new FeedGenerator().getUrl());
	}

	@Test(expected = IllegalArgumentException.class)
	public void incompatibleFeedType() {
		new FeedGenerator()
				.setMediaType(MediaType.AUDIOBOOKS)
				.setFeedType(FeedType.TOP_PODCASTS);
	}

	@Test
	public void apiDiffTest() throws JsonProcessingException, IOException {
		Feed feed = new FeedGenerator()
				.setCountry(Country.UNITED_STATES)
				.setMediaType(MediaType.PODCASTS)
				.setFeedType(FeedType.TOP_PODCASTS)
				.setFormat(FeedFormat.JSON)
				.setResultsLimit(5)
				.setAllowExplicit(true)
				.execute();
		Assert.assertEquals(5, feed.getResults().size());
	}

	@Test
	public void parseTest() throws JsonProcessingException, IOException {
		String sample = LineReader.readFile("feedsample.json");
		JsonNode json = Feed.READER.readTree(sample).get("feed");
		Feed feed = Feed.READER.treeToValue(json, Feed.class);
		Assert.assertEquals(10, feed.getResults().size());
		Assert.assertEquals(feed.getCopyright(), "Hak Cipta © 2017 Apple Inc. Hak cipta dilindungi undang-undang.");
		Assert.assertEquals(feed.getLinks().get(0).getType(), "self");
		Assert.assertEquals("https://rss.itunes.apple.com/api/v1/us/podcasts/top-podcasts/all/10/explicit.json", feed.getLinks().get(0).getUri());
	}

}
