/*
	Copyright 2019 Marceau Dewilde <m@ceau.be>
	
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

import be.ceau.itunesapi.GenreIdsAppendix;
import be.ceau.itunesapi.response.genreidsappendix.Genre;
import be.ceau.itunesapi.response.genreidsappendix.GenreIdsResponse;

public class GenreIdsAppendixTest {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
	}

	@Test
	public void getGenres() throws JsonProcessingException, IOException {
		GenreIdsResponse response = new GenreIdsAppendix().execute();
		Assert.assertNotNull(response);
		Assert.assertTrue(!response.getGenres().isEmpty());
		for (Genre genre : response.getGenres().values()) {
			Assert.assertNotNull(genre);
		}
	}
	
}
