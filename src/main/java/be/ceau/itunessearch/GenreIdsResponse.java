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
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

/**
 * iTunes Genre ID response
 */
public class GenreIdsResponse implements Serializable {

	private static final long serialVersionUID = 1501610206217L;

	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final MapType MAP_TYPE = MAPPER.getTypeFactory().constructMapType(HashMap.class, Integer.class, Genre.class);

	private final Map<Integer, Genre> genres = new HashMap<Integer, Genre>();

	/**
	 * Static factory for parsing a valid JSON response to a new
	 * {@link GenreIdsResponse} instance
	 * 
	 * @param json
	 * @return
	 * @throws IOException
	 */
	public static GenreIdsResponse parse(String json) throws IOException {
		if (json == null) {
			throw new IllegalArgumentException("json argument can not be null");
		}
		Map<Integer, Genre> map = MAPPER.readValue(json, MAP_TYPE);
		GenreIdsResponse response = new GenreIdsResponse();
		response.genres.putAll(map);
		return response;
	}

	public Map<Integer, Genre> getGenres() {
		return genres;
	}

}
