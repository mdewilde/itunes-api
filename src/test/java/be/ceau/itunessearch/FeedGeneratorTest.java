/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>
	
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
package be.ceau.itunessearch;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import be.ceau.itunessearch.enums.FeedType;
import be.ceau.itunessearch.enums.MediaType;

public class FeedGeneratorTest {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
	}

	@Test
	public void defaultUrl() {
		Assert.assertEquals(new FeedGenerator().getUrl(), "https://rss.itunes.apple.com/api/v1/US/apple-music/new-music/10/explicit/json");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void incompatibleFeedType() {
		new FeedGenerator()
			.setMediaType(MediaType.AUDIOBOOKS)
			.setFeedType(FeedType.TOP_PODCASTS);
	}

	@Test
	public void parseTest() throws JsonProcessingException, IOException {
		String sample = LineReader.readFile("feedsample.json");
		JsonNode json = Feed.READER.readTree(sample).get("feed");
		Feed feed = Feed.READER.treeToValue(json, Feed.class);
		Assert.assertEquals(feed.getResults().size(), 4);
		Assert.assertEquals(feed.getCopyright(), "Copyright © 2017 Apple Inc. Все права защищены.");
		Assert.assertEquals(feed.getLinks().get(0).getType(), "self");
		Assert.assertEquals(feed.getLinks().get(0).getUri(), "https://rss.itunes.apple.com/api/v1/US/apple-music/new-music/4/explicit/json");
		Assert.assertEquals(feed.getResults().get(0).getContentAdvisoryRating(), "");
	}
	
}
