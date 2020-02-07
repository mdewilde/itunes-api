/*
	Copyright 2020 Marceau Dewilde <m@ceau.be>
	
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
package be.ceau.itunesapi;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.ceau.itunesapi.http.Connector;
import be.ceau.itunesapi.http.URLConnector;
import be.ceau.itunesapi.request.Country;
import be.ceau.itunesapi.request.Entity;
import be.ceau.itunesapi.request.search.Attribute;
import be.ceau.itunesapi.request.search.Lang;
import be.ceau.itunesapi.request.search.Media;
import be.ceau.itunesapi.response.Response;

/**
 * Request object for the iTunes Search API.
 * 
 * @see <a href="https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching">Search API</a>
 */
public class Search implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Search.class);

	private static final long serialVersionUID = 1476515615735L;

	private static final String API_ENDPOINT = "https://itunes.apple.com/search?";

	private String term;
	private Country country;
	private Media media;
	private Entity entity;
	private Attribute attribute;
	private Integer limit;
	private Lang lang;
	private Integer version;
	private Boolean explicit;

	/**
	 * No-arg constructor.
	 */
	public Search() {

	}

	/**
	 * Constructor.
	 * 
	 * @param term
	 *            word or phrase to search for, {@link String}, can be
	 *            {@code null}
	 */
	public Search(String term) {
		this.term = term;
	}

	/**
	 * Execute this iTunes Search API request.
	 * 
	 * @return parsed {@link Response} from iTunes
	 * @throws IllegalStateException
	 *             as thrown by {@link #build()}
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 */
	public Response execute() {
		return execute(URLConnector.INSTANCE);
	}

	/**
	 * Execute this iTunes Search API request using the provided
	 * {@link Connector} implementation.
	 * 
	 * @param connector
	 *            {@link Connector} implementation, not {@code null}
	 * @return parsed {@link Response} from iTunes
	 * @throws IllegalArgumentException
	 *             if argument {@code null}
	 * @throws IllegalStateException
	 *             as thrown by {@link #build()}
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 */
	public Response execute(Connector connector) {
		if (connector == null) {
			throw new IllegalArgumentException("connector can not be null");
		}
		try {
			String url = build();
			String response = connector.get(url);
			logger.trace("{} -> {}", url, response);
			return Response.READER.readValue(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return {@link String} instance, or {@code null}
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term
	 *            word or phrase to search for, {@link String}, can be
	 *            {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public Search setTerm(String term) {
		this.term = term;
		return this;
	}

	/**
	 * @return {@link Country} instance, or {@code null}
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            {@link Country}, can be {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public Search setCountry(Country country) {
		this.country = country;
		return this;
	}

	/**
	 * @return {@link Media} instance, or {@code null}
	 */
	public Media getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            {@link Media}, can be {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public Search setMedia(Media media) {
		this.media = media;
		return this;
	}

	/**
	 * @return {@link Entity} instance, or {@code null}
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            {@link Entity}, can be {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public Search setEntity(Entity entity) {
		this.entity = entity;
		return this;
	}

	/**
	 * @return {@link Attribute} instance, or {@code null}
	 */
	public Attribute getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute
	 *            {@link Attribute}, can be {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public Search setAttribute(Attribute attribute) {
		this.attribute = attribute;
		return this;
	}

	/**
	 * @return {@link Integer} instance, or {@code null}
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * The number of search results you want the iTunes Store to return. For
	 * example: 25. The default is 50. Valid between 1 and 200.
	 * 
	 * @param limit
	 *            {@code int} between 1 (inclusive) and 200 (inclusive)
	 * @return {@code this} instance for method chaining
	 * @throws IllegalArgumentException
	 *             if limit not valid
	 */
	public Search setLimit(int limit) {
		if (limit < 1 || limit > 200) {
			throw new IllegalArgumentException("limit must be between 1 and 200");
		}
		this.limit = limit;
		return this;
	}

	/**
	 * @return {@link Lang} instance, or {@code null}
	 */
	public Lang getLang() {
		return lang;
	}

	/**
	 * @param lang
	 *            {@link Lang}, can be {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public Search setLang(Lang lang) {
		this.lang = lang;
		return this;
	}

	/**
	 * @return {@link Integer} instance, or {@code null}
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * The search result key version you want to receive back from your search.
	 * The default is 2. Valid are 1 or 2
	 * 
	 * @param version
	 *            {@code int} 1 or 2
	 * @return {@code this} instance for method chaining
	 * @throws IllegalArgumentException
	 *             if version not valid
	 */
	public Search setVersion(int version) {
		if (version != 1 && version != 2) {
			throw new IllegalArgumentException("version must be 1 or 2");
		}
		this.version = version;
		return this;
	}

	/**
	 * @return {@link Boolean} instance, or {@code null}
	 */
	public Boolean isExplicit() {
		return explicit;
	}

	/**
	 * @param explicit
	 *            {@code boolean} indicating whether or not to include explicit
	 *            results
	 * @return {@code this} instance for method chaining
	 */
	public Search setExplicit(boolean explicit) {
		this.explicit = explicit;
		return this;
	}

	/**
	 * Create the request URL for this {@link Search}
	 * 
	 * @return full request URL matching this {@link Search}
	 * @throws IllegalStateException
	 *             if no term is set in this {@link Search}
	 */
	public String build() {
		return new StringBuilder(API_ENDPOINT).append(termParam()).append(countryParam()).append(mediaParam())
				.append(entityParam()).append(attributeParam()).append(limitParam()).append(langParam())
				.append(versionParam()).append(explicitParam()).toString();
	}

	/**
	 * @return "term=xxxx"
	 * @throws IllegalStateException
	 *             if term is empty or blank
	 */
	private String termParam() {
		if (term == null) {
			throw new IllegalStateException("you must provide a search term");
		}
		String t = term.trim();
		try {
			t = URLEncoder.encode(t, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
		if (t.length() == 0) {
			throw new IllegalStateException("you must provide a search term");
		}
		return "term=" + t;
	}

	/**
	 * @return "&country=XX" or empty {@link String}
	 */
	private String countryParam() {
		if (country != null) {
			return "&country=" + country.getIso();
		}
		return "";
	}

	/**
	 * @return "&media=XX" or empty {@link String}
	 */
	private String mediaParam() {
		if (media != null) {
			return "&media=" + media.getName();
		}
		return "";
	}

	/**
	 * @return "&entity=XX" or empty {@link String}
	 */
	private String entityParam() {
		if (entity != null) {
			return "&entity=" + entity.getName();
		}
		return "";
	}

	/**
	 * @return "&attribute=XX" or empty {@link String}
	 */
	private String attributeParam() {
		if (attribute != null) {
			return "&attribute=" + attribute.getName();
		}
		return "";
	}

	/**
	 * @return "&limit=XX" or empty {@link String}
	 */
	private String limitParam() {
		if (limit != null) {
			return "&limit=" + limit;
		}
		return "";
	}

	/**
	 * @return "&lang=XX" or empty {@link String}
	 */
	private String langParam() {
		if (lang != null) {
			return "&lang=" + lang.getCode();
		}
		return "";
	}

	/**
	 * @return "&version=XX" or empty {@link String}
	 */
	private String versionParam() {
		if (version != null) {
			return "&version=" + version;
		}
		return "";
	}

	/**
	 * @return "&explicit=XX" or empty {@link String}
	 */
	private String explicitParam() {
		if (explicit != null) {
			return explicit ? "&explicit=Yes" : "&explicit=No";
		}
		return "";
	}

}
