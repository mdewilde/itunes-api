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
package be.ceau.itunessearch.models;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import be.ceau.itunessearch.enums.Attribute;
import be.ceau.itunessearch.enums.Country;
import be.ceau.itunessearch.enums.Entity;
import be.ceau.itunessearch.enums.Lang;
import be.ceau.itunessearch.enums.Media;

public class Request implements Serializable {

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

	public Request() {
		
	}
	
	public Request(String term) {
		this.term = term;
	}
	
	public String getTerm() {
		return term;
	}

	public Request setTerm(String term) {
		this.term = term;
		return this;
	}

	public Country getCountry() {
		return country;
	}

	public Request setCountry(Country country) {
		this.country = country;
		return this;
	}

	public Media getMedia() {
		return media;
	}

	public Request setMedia(Media media) {
		this.media = media;
		return this;
	}

	public Entity getEntity() {
		return entity;
	}

	public Request setEntity(Entity entity) {
		this.entity = entity;
		return this;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public Request setAttribute(Attribute attribute) {
		this.attribute = attribute;
		return this;
	}

	public int getLimit() {
		return limit;
	}

	/**
	 * The number of search results you want the iTunes Store to return. For
	 * example: 25. The default is 50. Valid between 1 and 200.
	 * 
	 * @param limit
	 * @throws IllegalArgumentException if limit not valid
	 */
	public Request setLimit(int limit) {
		if (limit < 1 || limit > 200) {
			throw new IllegalArgumentException("limit must be between 1 and 200");
		}
		this.limit = limit;
		return this;
	}

	public Lang getLang() {
		return lang;
	}

	public Request setLang(Lang lang) {
		this.lang = lang;
		return this;
	}

	public int getVersion() {
		return version;
	}

	/**
	 * The search result key version you want to receive back from your
	 * search. The default is 2. Valid are 1 or 2
	 * 
	 * @param version
	 * @throws IllegalArgumentException if version not valid
	 */
	public Request setVersion(int version) {
		if (version != 1 && version != 2) {
			throw new IllegalArgumentException("version must be 1 or 2");
		}
		this.version = version;
		return this;
	}

	public boolean isExplicit() {
		return explicit;
	}

	public Request setExplicit(boolean explicit) {
		this.explicit = explicit;
		return this;
	}

	/**
	 * Create the request URL for this {@link Request}
	 * 
	 * @return full request URL matching this {@link Request}
	 * @throws IllegalStateException
	 *             if no term is set in this {@link Request}
	 */
	public String build() {
		return new StringBuilder(API_ENDPOINT)
					.append(termParam())
					.append(countryParam())
					.append(mediaParam())
					.append(entityParam())
					.append(attributeParam())
					.append(limitParam())
					.append(langParam())
					.append(versionParam())
					.append(explicitParam())
					.toString();
	}

	/**
	 * @return "term=xxxx"
	 * @throws IllegalStateException if term is empty or blank
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
	 * @return "&country=XX" or empty string
	 */
	private String countryParam() {
		if (country != null) {
			return "&country=" + country.getIso();
		}
		return "";
	}

	/**
	 * @return "&media=XX" or empty string
	 */
	private String mediaParam() {
		if (media != null) {
			return "&media=" + media.getName();
		}
		return "";
	}

	/**
	 * @return "&entity=XX" or empty string
	 */
	private String entityParam() {
		if (entity != null) {
			return "&entity=" + entity.getName();
		}
		return "";
	}

	/**
	 * @return "&attribute=XX" or empty string
	 */
	private String attributeParam() {
		if (attribute != null) {
			return "&attribute=" + attribute.getName();
		}
		return "";
	}
	
	/**
	 * @return "&limit=XX" or empty string
	 */
	private String limitParam() {
		if (limit != null) {
			return "&limit=" + limit;
		}
		return "";
	}

	/**
	 * @return "&lang=XX" or empty string
	 */
	private String langParam() {
		if (lang != null) {
			return "&lang=" + lang.getCode();
		}
		return "";
	}

	/**
	 * @return "&version=XX" or empty string
	 */
	private String versionParam() {
		if (version != null) {
			return "&version=" + version;
		}
		return "";
	}

	/**
	 * @return "&explicit=XX" or empty string
	 */
	private String explicitParam() {
		if (explicit != null) {
			if (explicit) {
				return "&explicit=Yes";
			} else {
				return "&explicit=No";
			}
		}
		return "";
	}
 
}
