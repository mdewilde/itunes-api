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
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import be.ceau.itunesapi.http.URLConnector;
import be.ceau.itunesapi.request.Country;
import be.ceau.itunesapi.request.search.Media;
import be.ceau.itunesapi.response.Response;
import be.ceau.itunesapi.response.Result;

public class SearchTest {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
	}

	/**
	 * Find podcast Uhh Yeah Dude
	 */
	@Test
	public void searchPodcasts() {
		Response response = new Search("uhh yeah dude")
				.setCountry(Country.UNITED_STATES)
				.setMedia(Media.PODCAST)
				.execute();
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getResultCount() > 0);
		Assert.assertNotNull(response.getResults());
	}

	@Test
	public void searchSoftware() {
		Response response = new Search("facebook")
				.setCountry(Country.UNITED_STATES)
				.setMedia(Media.SOFTWARE)
				.execute();
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getResultCount() > 0);
		Assert.assertNotNull(response.getResults());
	}

	/**
	 * A term must be set before searching
	 */
	@Test(expected = IllegalStateException.class)
	public void emptyRequest() {
		new Search().build();
	}

	@Test
	public void connectorTest() throws IOException {
		String request = new Search().setTerm("north").setCountry(Country.CANADA).setMedia(Media.PODCAST).build();
		String response = new URLConnector().get(request);
		Assert.assertNotNull(response);
	}

	@Test(expected = IllegalArgumentException.class)
	public void connectorNotNull() {
		new Search().setTerm("north").setCountry(Country.CANADA).setMedia(Media.PODCAST).execute(null);
	}

	@Test
	public void mediaTest() throws IOException {
		for (Media media : Media.values()) {
			Search request = new Search()
					.setTerm("springsteen")
					.setCountry(Country.UNITED_STATES)
					.setMedia(media)
					.setLimit(2);
			String response = new URLConnector().get(request.build());
			Assert.assertNotNull(response);
		}
	}

	@Test
	public void emptyCollectionsNotNull() throws IOException {
		Result result = new Result();
		Assert.assertTrue(result.getAdvisories().isEmpty());
		Assert.assertTrue(result.getGenreIds().isEmpty());
		Assert.assertTrue(result.getGenres().isEmpty());
		Assert.assertTrue(result.getIpadScreenshotUrls().isEmpty());
		Assert.assertTrue(result.getAppletvScreenshotUrls().isEmpty());
		Assert.assertTrue(result.getFeatures().isEmpty());
		Assert.assertTrue(result.getSupportedDevices().isEmpty());
		Assert.assertTrue(result.getAdvisories().isEmpty());
		Assert.assertTrue(result.getScreenshotUrls().isEmpty());
		Assert.assertTrue(result.getLanguageCodesISO2A().isEmpty());
	}

	@Test
	public void parseTest() throws JsonProcessingException, IOException {
		String sample = LineReader.readFile("uyd.json");
		Response response = Response.READER.readValue(sample);

		Assert.assertEquals(1, response.getResultCount());
		Assert.assertEquals(1, response.getResults().size());

		Result result = response.getResults().get(0);
		Assert.assertNotNull(result);
		Assert.assertEquals("track", result.getWrapperType());
		Assert.assertEquals("podcast", result.getKind());
		Assert.assertEquals(124043755, result.getCollectionId().longValue());
		Assert.assertEquals(124043755, result.getTrackId().intValue());
		Assert.assertEquals("Seth Romatelli and Jonathan Larroquette", result.getArtistName());
		Assert.assertEquals("Uhh Yeah Dude", result.getCollectionName());
		Assert.assertEquals("Uhh Yeah Dude", result.getTrackName());
		Assert.assertEquals("Uhh Yeah Dude", result.getCollectionCensoredName());
		Assert.assertEquals("Uhh Yeah Dude", result.getTrackCensoredName());
		Assert.assertEquals("https://itunes.apple.com/us/podcast/uhh-yeah-dude/id124043755?mt=2&uo=4", result.getCollectionViewUrl());
		Assert.assertEquals("http://feeds.feedburner.com/uhhyeahdude/podcast", result.getFeedUrl());

		Assert.assertEquals("https://itunes.apple.com/us/podcast/uhh-yeah-dude/id124043755?mt=2&uo=4", result.getTrackViewUrl());
		Assert.assertEquals("http://is4.mzstatic.com/image/thumb/Music4/v4/34/69/a7/3469a700-7d00-12d2-f25a-6213cfdddfaa/source/30x30bb.jpg", result.getArtworkUrl30());
		Assert.assertEquals("http://is4.mzstatic.com/image/thumb/Music4/v4/34/69/a7/3469a700-7d00-12d2-f25a-6213cfdddfaa/source/60x60bb.jpg", result.getArtworkUrl60());
		Assert.assertEquals("http://is4.mzstatic.com/image/thumb/Music4/v4/34/69/a7/3469a700-7d00-12d2-f25a-6213cfdddfaa/source/100x100bb.jpg", result.getArtworkUrl100());
		Assert.assertTrue(result.getCollectionPrice().compareTo(BigDecimal.ZERO) == 0);
		Assert.assertTrue(result.getTrackPrice().compareTo(BigDecimal.ZERO) == 0);
		Assert.assertTrue(result.getTrackRentalPrice().compareTo(BigDecimal.ZERO) == 0);
		Assert.assertTrue(result.getCollectionHdPrice().compareTo(BigDecimal.ZERO) == 0);
		Assert.assertTrue(result.getTrackHdPrice().compareTo(BigDecimal.ZERO) == 0);
		Assert.assertTrue(result.getTrackHdRentalPrice().compareTo(BigDecimal.ZERO) == 0);
		Assert.assertEquals("2017-12-12T02:25:00Z", result.getReleaseDate());
		Assert.assertEquals("explicit", result.getCollectionExplicitness());
		Assert.assertEquals("explicit", result.getTrackExplicitness());
		Assert.assertEquals(200, result.getTrackCount().intValue());
		Assert.assertEquals("USA", result.getCountry());
		Assert.assertEquals("USD", result.getCurrency());
		Assert.assertEquals("Comedy", result.getPrimaryGenreName());
	}

}
