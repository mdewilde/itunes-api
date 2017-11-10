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

import be.ceau.itunessearch.enums.Country;
import be.ceau.itunessearch.enums.Media;

public class SearchTest {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
	}
	
	/**
	 * Find podcast Uhh Yeah Dude
	 */
	@Test
	public void searchPodcasts() {
		Response response = 
				new Search("uhh yeah dude")
				.setCountry(Country.UNITED_STATES)
				.setMedia(Media.PODCAST)
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
	
}
