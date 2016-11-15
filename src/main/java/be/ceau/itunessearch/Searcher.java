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
import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import be.ceau.itunessearch.models.Lookup;
import be.ceau.itunessearch.models.Request;
import be.ceau.itunessearch.models.Response;

public class Searcher implements Serializable {

	private static final long serialVersionUID = 1476515480421L;

	private final ObjectReader reader = new ObjectMapper().readerFor(Response.class);

	private final Connector connector;

	/**
	 * Construct a new {@link Searcher} with default {@link URLConnector}
	 */
	public Searcher() {
		this.connector = new URLConnector();
	}

	/**
	 * Construct a new {@link Searcher} with custom {@link Connector}
	 * implementation
	 * 
	 * @throws IllegalArgumentException
	 *             if argument {@code null}
	 */
	public Searcher(Connector connector) {
		if (connector == null) {
			throw new IllegalArgumentException("Connector can not be null");
		}
		this.connector = connector;
	}

	/**
	 * Perform the search request.
	 * 
	 * @return parsed {@link Response} from iTunes
	 * @throws IllegalArgumentException
	 *             if argument {@code null}
	 * @throws IllegalStateException
	 *             as thrown by {@link Request#build()}
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 */
	public Response search(Request request) {
		if (request == null) {
			throw new IllegalArgumentException("Request can not be null");
		}
		try {
			String response = connector.get(request.build());
			return reader.readValue(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Convenience method to search for a specific term. Return the response
	 * from iTunes. <br>
	 * Equivalent to:<br>
	 * {@code searcher.search(new Request(term));}
	 * 
	 * @return parsed {@link Response} from iTunes
	 * @throws IllegalArgumentException
	 *             if argument {@code null}
	 * @throws IllegalStateException
	 *             as thrown by {@link Request#build()}
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 * @see Searcher#search(Request)
	 */
	public Response search(String term) {
		Request request = new Request(term);
		try {
			String response = connector.get(request.build());
			return reader.readValue(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Response lookup(Lookup lookup) {
		try {
			String response = connector.get(lookup.build());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
