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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

/**
 * iTunes Feed Generator response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed implements Serializable {

	private static final long serialVersionUID = 1501414948136L;

	/**
	 * Reusable, threadsafe {@link ObjectReader} instance for deserializing iTunes
	 * response into {@link Feed} instance.
	 */
	public static final ObjectReader READER = new ObjectMapper().readerFor(Feed.class);

	private String title;
	private String id;
	private Author author;
	private final List<Link> links = new ArrayList<Link>();
	private String copyright;
	private String country;
	private String icon;
	private String updated;
	private final List<Result> results = new ArrayList<Result>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	/**
	 * @return modifiable {@link List} of {@link Result} instances, never
	 *         {@code null}
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * @return modifiable {@link List} of {@link Result} instances, never
	 *         {@code null}
	 */
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results.clear();
		if (results != null) {
			this.results.addAll(results);
		}
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Feed [title=")
				.append(title)
				.append(", id=")
				.append(id)
				.append(", author=")
				.append(author)
				.append(", links=")
				.append(links)
				.append(", copyright=")
				.append(copyright)
				.append(", country=")
				.append(country)
				.append(", icon=")
				.append(icon)
				.append(", updated=")
				.append(updated)
				.append(", results=")
				.append(results)
				.append("]")
				.toString();
	}

}
