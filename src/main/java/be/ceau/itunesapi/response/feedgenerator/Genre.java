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
package be.ceau.itunesapi.response.feedgenerator;

import java.io.Serializable;

import be.ceau.itunesapi.response.genreidsappendix.GenreIdsResponse;

/**
 * Single entry in an iTunes {@link GenreIdsResponse}.
 */
public class Genre implements Serializable {

	private static final long serialVersionUID = 1501610118604L;

	private String genreId;
	private String name;
	private String url;

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Genre [genreId=")
				.append(genreId)
				.append(", name=")
				.append(name)
				.append(", url=")
				.append(url)
				.append("]")
				.toString();
	}

	
}
