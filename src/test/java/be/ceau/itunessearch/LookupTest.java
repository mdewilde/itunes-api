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

import org.junit.Test;

import be.ceau.itunessearch.enums.Entity;
import be.ceau.itunessearch.models.Lookup;
import be.ceau.itunessearch.models.Response;
import be.ceau.itunessearch.models.Result;

public class LookupTest {

	@Test
	public void lookup() {
		Lookup lookup = new Lookup();
		lookup.addId("124043755");
		Searcher searcher = new Searcher();
		Response response = searcher.lookup(lookup);
		System.out.println(response);
		if (response == null || response.getResultCount() == 0) {
			throw new IllegalArgumentException("no results");
		}
	}
	
	@Test
	public void albums() {
		Lookup lookup = new Lookup();
		lookup.addId("178834");
		lookup.setEntity(Entity.ALBUM);
		Searcher searcher = new Searcher();
		Response response = searcher.lookup(lookup);
		System.out.println(response);
		
		for (Result result : response.getResults()) {
			System.out.println(result.getCollectionName());
		}
		if (response == null || response.getResultCount() == 0) {
			throw new IllegalArgumentException("no results");
		}
	}
	
}
