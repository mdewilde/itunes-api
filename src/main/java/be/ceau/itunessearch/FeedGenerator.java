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

import be.ceau.itunessearch.enums.Country;
import be.ceau.itunessearch.enums.FeedFormat;
import be.ceau.itunessearch.enums.FeedType;
import be.ceau.itunessearch.enums.MediaType;

/**
 * Request object for the iTunes Feed Generator API.
 *
 * @see <a href="https://rss.itunes.apple.com">rss.itunes.apple.com</a>
 */
public class FeedGenerator implements Serializable {

	private static final long serialVersionUID = 1501610083087L;

	private static final String API_ENDPOINT = "https://rss.itunes.apple.com/api/v1/";

	private Country country = Country.UNITED_STATES;

	private MediaType mediaType = MediaType.APPLE_MUSIC;

	private FeedType feedType = FeedType.NEW_MUSIC;

	private int resultsLimit = 10;

	private boolean allowExplicit = true;

	private FeedFormat format = FeedFormat.JSON;

	/**
	 * Construct a valid feed URL based on the current state of this
	 * {@link FeedGenerator}
	 * 
	 * @return url as {@link String}, never {@code null}
	 */
	public String getUrl() {
		return new StringBuilder()
				.append(API_ENDPOINT)
				.append(country.getIso())
				.append('/')
				.append(mediaType.getCode())
				.append('/')
				.append(feedType.getCode())
				.append('/')
				.append(resultsLimit)
				.append('/')
				.append(allowExplicit ? "explicit" : "non-explicit")
				.append('/')
				.append(format.getCode())
				.toString();
	}

	/**
	 * Queries iTunes using the current state of this {@link FeedGenerator}
	 * 
	 * @return parsed {@link Feed}
	 */
	public Feed execute() {
		return execute(URLConnector.INSTANCE);
	}

	/**
	 * Execute this Feed Generator API request using the provided
	 * {@link Connector} implementation.
	 * 
	 * @param connector
	 *            {@link Connector} implementation, not {@code null}
	 * @return parsed {@link Feed} response from iTunes
	 * @throws IllegalArgumentException
	 *             if argument {@code null}
	 * @throws RuntimeException
	 *             wrapping any {@link IOException} thrown performing the
	 *             request or parsing the response
	 */
	public Feed execute(Connector connector) {
		if (connector == null) {
			throw new IllegalArgumentException("connector can not be null");
		}
		FeedFormat chosenFormat = getFormat();
		setFormat(FeedFormat.JSON);
		String url = getUrl();
		setFormat(chosenFormat);
		try {
			String response = connector.get(url);
			System.out.println(response);
			return Response.READER.readValue(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Country getCountry() {
		return country;
	}

	/**
	 * Default value is {@link Country#UNITED_STATES}
	 * 
	 * @param country
	 *            a {@link Country}, not {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public FeedGenerator setCountry(Country country) {
		if (country == null) {
			throw new IllegalArgumentException("country must be specified");
		}
		this.country = country;
		return this;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * Default value is {@link MediaType#APPLE_MUSIC} <br>
	 * <br>
	 * Setting {@link MediaType} also changes the {@link FeedType} to be compatible
	 * with the given {@link MediaType}
	 * 
	 * @param mediaType
	 *            a {@link MediaType}, not {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public FeedGenerator setMediaType(MediaType mediaType) {
		if (country == null) {
			throw new IllegalArgumentException("mediaType must be specified");
		}
		this.mediaType = mediaType;
		setFeedType(mediaType.getCompatibleFeedTypes().iterator().next());
		return this;
	}

	public FeedType getFeedType() {
		return feedType;
	}

	/**
	 * Default value is {@link FeedType#NEW_MUSIC} <br>
	 * <br>
	 * The given {@link FeedType} must be compatible with the current
	 * {@link MediaType}. Refer to {@link MediaType#getCompatibleFeedTypes()} to
	 * determine which {@link FeedType} instances are compatible with the current
	 * {@link MediaType}.
	 * 
	 * @param feedType
	 *            a {@link FeedType}, not {@code null}
	 * @return {@code this} instance for method chaining
	 * @see MediaType#getCompatibleFeedTypes()
	 */
	public FeedGenerator setFeedType(FeedType feedType) {
		if (feedType == null) {
			throw new IllegalArgumentException("feedType must be specified");
		}
		if (!mediaType.getCompatibleFeedTypes().contains(feedType)) {
			throw new IllegalArgumentException("feedType must be compatible with mediaType");
		}
		this.feedType = feedType;
		return this;
	}

	public int getResultsLimit() {
		return resultsLimit;
	}

	/**
	 * Default value is {@code 10} <br>
	 * <br>
	 * Note that Apple limits results to 200, even when more are requested
	 * 
	 * @param resultsLimit
	 *            a positive integer
	 * @return {@code this} instance for method chaining
	 */
	public FeedGenerator setResultsLimit(int resultsLimit) {
		if (resultsLimit < 1) {
			throw new IllegalArgumentException("resultsLimit must be a positive integer");
		}
		this.resultsLimit = resultsLimit;
		return this;
	}

	public boolean isAllowExplicit() {
		return allowExplicit;
	}

	/**
	 * Default value is {@code true}
	 * 
	 * @param allowExplicit
	 *            true if explicit results may be included
	 * @return {@code this} instance for method chaining
	 */
	public FeedGenerator setAllowExplicit(boolean allowExplicit) {
		this.allowExplicit = allowExplicit;
		return this;
	}

	public FeedFormat getFormat() {
		return format;
	}

	/**
	 * Default value is {@link FeedFormat#JSON}
	 * 
	 * @param format
	 *            a {@link FeedFormat}, not {@code null}
	 * @return {@code this} instance for method chaining
	 */
	public FeedGenerator setFormat(FeedFormat format) {
		this.format = format;
		return this;
	}

}
