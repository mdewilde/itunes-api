/*
	Copyright 2016 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.itunessearch;

import java.io.IOException;

import org.junit.Test;

import be.ceau.itunessearch.enums.Country;
import be.ceau.itunessearch.enums.Media;
import be.ceau.itunessearch.models.Request;
import be.ceau.itunessearch.models.Response;

public class SearchTest {

	@Test
	public void searchPodcasts() {
		Request request = new Request();
		request.setTerm("uhh yeah dude");
		request.setCountry(Country.UNITED_STATES);
		request.setMedia(Media.PODCAST);
		Searcher searcher = new Searcher();
		Response response = searcher.search(request);
		System.out.println(response);
		if (response == null || response.getResultCount() == 0) {
			throw new IllegalArgumentException("no results");
		}
	}
	
	@Test(expected = IllegalStateException.class)
	public void emptyRequest() throws IOException {
		Request request = new Request();
		System.out.println(request.build());
		String response = new URLConnector().get(request.build());
		System.out.println(response);
	}

	@Test
	public void connectorTest() throws IOException {
		Request request = new Request();
		request.setTerm("north");
		request.setCountry(Country.CANADA);
		request.setMedia(Media.PODCAST);
		String response = new URLConnector().get(request.build());
		System.out.println(response);
	}

	@Test
	public void mediaTest() throws IOException {
		for (Media media : Media.values()) {
			Request request = new Request();
			request.setTerm("springsteen");
			request.setCountry(Country.UNITED_STATES);
			request.setMedia(media);
			request.setLimit(4);
			String response = new URLConnector().get(request.build());
			System.out.println(response);
		}
	}

}
