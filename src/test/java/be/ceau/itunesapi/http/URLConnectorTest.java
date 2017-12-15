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
package be.ceau.itunesapi.http;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import be.ceau.itunesapi.http.URLConnector;

public class URLConnectorTest {

	@Test(expected = MalformedURLException.class)
	public void nullArgument() throws IOException {
		URLConnector.INSTANCE.get(null);
	}

	@Test(expected = MalformedURLException.class)
	public void noSchemeArgument() throws IOException {
		URLConnector.INSTANCE.get("www.apple.com");
	}

	@Test
	public void appleDotCom() throws IOException {
		String appleDotCom = URLConnector.INSTANCE.get("https://www.apple.com");
		Assert.assertNotNull(appleDotCom);
		Assert.assertTrue(!appleDotCom.isEmpty());
	}

}
