/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>
	
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import be.ceau.itunessearch.enums.Entity;
import be.ceau.itunessearch.enums.Sort;

/**
 * Request object for the iTunes <strong>lookup</strong> API.
 */
public class Lookup implements Serializable {

	private static final long serialVersionUID = 1479238701182L;

	private static final String API_ENDPOINT = "https://itunes.apple.com/lookup?";

	private static final String ID = "id";
	private static final String AMG_ARTIST_ID = "amgArtistId";
	private static final String AMG_ALBUM_ID = "amgAlbumId";
	private static final String AMG_VIDEO_ID = "amgVideoId";
	private static final String UPC = "upc";
	private static final String ISBN = "isbn";

	private final Map<String, Set<String>> map;
	private Entity entity;
	private int limit;
	private Sort sort;

	public Lookup() {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		map.put(ID, new HashSet<String>());
		map.put(AMG_ARTIST_ID, new HashSet<String>());
		map.put(AMG_ALBUM_ID, new HashSet<String>());
		map.put(AMG_VIDEO_ID, new HashSet<String>());
		map.put(UPC, new HashSet<String>());
		map.put(ISBN, new HashSet<String>());
		this.map = Collections.unmodifiableMap(map);
	}
	
	public Set<String> getIds() {
		return map.get(ID);
	}

	public void addId(String id) {
		if (id != null) {
			map.get(ID).add(id);
		}
	}
	
	public void setIds(Set<String> ids) {
		map.get(ID).clear();
		if (ids != null) {
			for (String id : ids) {
				addId(id);
			}
		}
	}

	public Set<String> getAmgArtistIds() {
		return map.get(AMG_ARTIST_ID);
	}

	public void addAmgArtistId(String amgArtistId) {
		if (amgArtistId != null) {
			map.get(AMG_ARTIST_ID).add(amgArtistId);
		}
	}
	
	public void setAmgArtistIds(Set<String> amgArtistIds) {
		map.get(AMG_ARTIST_ID).clear();
		if (amgArtistIds != null) {
			for (String amgArtistId : amgArtistIds) {
				addAmgArtistId(amgArtistId);
			}
		}
	}

	public Set<String> getAmgAlbumIds() {
		return map.get(AMG_ALBUM_ID);
	}

	public void addAmgAlbumId(String isbn) {
		if (isbn != null) {
			map.get(AMG_ALBUM_ID).add(isbn);
		}
	}

	public void setAmgAlbumId(Set<String> amgAlbumIds) {
		map.get(AMG_ALBUM_ID).clear();
		if (amgAlbumIds != null) {
			for (String amgAlbumId : amgAlbumIds) {
				addAmgAlbumId(amgAlbumId);
			}
		}
	}

	public Set<String> getAmgVideoIds() {
		return map.get(AMG_VIDEO_ID);
	}

	public void addAmgVideoId(String amgVideoId) {
		if (amgVideoId != null) {
			map.get(AMG_VIDEO_ID).add(amgVideoId);
		}
	}

	public void setAmgVideoIds(Set<String> amgVideoIds) {
		map.get(AMG_VIDEO_ID).clear();
		if (amgVideoIds != null) {
			for (String amgVideoId : amgVideoIds) {
				addAmgVideoId(amgVideoId);
			}
		}
	}

	public Set<String> getUpcs() {
		return map.get(UPC);
	}

	public void addUpc(String upc) {
		if (upc != null) {
			map.get(UPC).add(upc);
		}
	}

	public void setUpcs(Set<String> upcs) {
		map.get(UPC).clear();
		if (upcs != null) {
			for (String upc : upcs) {
				addUpc(upc);
			}
		}
	}

	public Set<String> getIsbns() {
		return map.get(ISBN);
	}

	public void addIsbn(String isbn) {
		if (isbn != null) {
			map.get(ISBN).add(isbn);
		}
	}

	public void setIsbns(Set<String> isbns) {
		map.get(ISBN).clear();
		if (isbns != null) {
			for (String isbn : isbns) {
				addIsbn(isbn);
			}
		}
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	/**
	 * Create the request url for this {@link Lookup}
	 * 
	 * @return full request url {@link String} matching this {@link Lookup}
	 */
	public String build() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Set<String>> entry : map.entrySet()) {
			if (!entry.getValue().isEmpty()) {
				if (sb.length() > 0) {
					sb.append("&");
				}
				try {
					String q = URLEncoder.encode(String.join(",", entry.getValue()), "UTF-8");
					sb.append(entry.getKey()).append("=").append(q);
				} catch (UnsupportedEncodingException e) {
					throw new IllegalStateException(e);
				}
			}
		}
		if (entity != null) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append("entity").append("=").append(entity.getName());
		}
		if (limit > 0) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append("limit").append("=").append(limit);
		}
		if (sort != null) {
			if (sb.length() > 0) {
				sb.append("&");
			}
			sb.append("sort").append("=").append(sort.toString());
		}
		return API_ENDPOINT + sb.toString();
	}

}
