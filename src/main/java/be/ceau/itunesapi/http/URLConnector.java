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
package be.ceau.itunesapi.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Default {@link Connector} implementation using {@link URLConnection}.
 */
public class URLConnector implements Connector, Serializable {

	private static final long serialVersionUID = 1476515538667L;

	/**
	 * Reusable, threadsafe {@link URLConnector} instance.
	 */
	public static final URLConnector INSTANCE = new URLConnector();

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MalformedURLException as thrown by {@link URL#URL(String)} 
	 */
	public String get(String link) throws IOException {
		URL url = new URL(link);
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openConnection().getInputStream(), StandardCharsets.UTF_8))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			return sb.toString().trim();
		}
	}

}
