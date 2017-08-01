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
import java.io.Serializable;

/**
 * Implementation of the Genre IDs Appendix API.
 *
 * @see <a href="https://affiliate.itunes.apple.com/resources/documentation/genre-mapping/">Genre ID API</a>
 */
public class GenreIdsAppendix implements Serializable {

	private static final long serialVersionUID = 1501610161047L;

	private static final String API_ENDPOINT = "https://itunes.apple.com/WebObjects/MZStoreServices.woa/ws/genres";

	/**
	 * Execute this Genre IDs Appendix request.
	 * 
	 * @return parsed {@link GenreIdsResponse} from iTunes
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 */
	public GenreIdsResponse execute() {
		return execute(URLConnector.INSTANCE);
	}
	
	/**
	 * Execute this Genre IDs Appendix request using the provided
	 * {@link Connector} implementation.
	 * 
	 * @param connector
	 *            {@link Connector} implementation, not {@code null}
	 * @return parsed {@link GenreIdsResponse} response from iTunes
	 * @throws IllegalArgumentException
	 *             if argument {@code null}
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 */
	public GenreIdsResponse execute(Connector connector) {
		if (connector == null) {
			throw new IllegalArgumentException("connector can not be null");
		}
		try {
			String response = connector.get(API_ENDPOINT);
			return GenreIdsResponse.parse(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
