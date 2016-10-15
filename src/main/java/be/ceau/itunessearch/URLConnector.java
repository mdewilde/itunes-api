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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

/**
 * Default {@link Connector} implementation using {@link URLConnection}.
 */
public class URLConnector implements Connector, Serializable {

	private static final long serialVersionUID = 1476515538667L;

	/**
	 * {@inheritDoc}
	 */
	public String get(String link) throws IOException {
		URL url = new URL(link);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
			sb.append(System.getProperty("line.separator"));
		}
		in.close();
		return sb.toString().trim();
	}

}
