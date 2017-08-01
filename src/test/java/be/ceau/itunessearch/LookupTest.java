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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.ceau.itunessearch.enums.Entity;

public class LookupTest {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
	}

	@Test
	public void idsIsNotNull() {
		Assert.assertNotNull(new Lookup().getIds());
	}

	@Test
	public void albums() {
		Response response = new Lookup()
			.addId("178834")
			.setEntity(Entity.ALBUM)
			.execute();
		Assert.assertTrue(response.getResultCount() > 0);
		Assert.assertEquals(response.getResults().size(), response.getResultCount());
	}

}
