package be.ceau.itunessearch.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import be.ceau.itunessearch.enums.Entity;
import be.ceau.itunessearch.enums.Sort;

public class Lookup implements Serializable {

	private static final long serialVersionUID = 1479238701182L;

	private static final String API_ENDPOINT = "https://itunes.apple.com/lookup?";

	private final Set<String> ids = new HashSet<String>();
	private final Set<String> amgArtistIds = new HashSet<String>();
	private final Set<String> amgAlbumIds = new HashSet<String>();
	private final Set<String> amgVideoIds = new HashSet<String>();
	private final Set<String> upcs = new HashSet<String>();
	private final Set<String> isbns = new HashSet<String>();

	private Entity entity;
	private int limit;
	private Sort sort;
	
	public Set<String> getIds() {
		return ids;
	}

	public void setIds(Set<String> ids) {
		this.ids.clear();
		if (ids != null) {
			this.ids.addAll(ids);
		}
	}

	public Set<String> getAmgArtistIds() {
		return amgArtistIds;
	}

	public void setAmgArtistIds(Set<String> amgArtistIds) {
		this.amgArtistIds.clear();
		if (amgArtistIds != null) {
			this.amgArtistIds.addAll(amgArtistIds);
		}
	}

	public Set<String> getAmgAlbumIds() {
		return amgAlbumIds;
	}

	public void setAmgAlbumId(Set<String> amgAlbumIds) {
		this.amgAlbumIds.clear();
		if (amgAlbumIds != null) {
			this.amgAlbumIds.addAll(amgAlbumIds);
		}
	}

	public Set<String> getAmgVideoIds() {
		return amgVideoIds;
	}

	public void setAmgVideoIds(Set<String> amgVideoIds) {
		this.amgVideoIds.clear();
		if (amgVideoIds != null) {
			this.amgVideoIds.addAll(amgVideoIds);
		}
	}

	public Set<String> getUpcs() {
		return upcs;
	}

	public void setUpcs(Set<String> upcs) {
		this.upcs.clear();
		if (upcs != null) {
			this.upcs.addAll(upcs);
		}
	}

	public Set<String> getIsbns() {
		return isbns;
	}

	public void setIsbns(Set<String> isbns) {
		this.isbns.clear();
		if (isbns != null) {
			this.isbns.addAll(isbns);
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
	 * Create the request URL for this {@link Lookup}
	 * 
	 * @return full request URL matching this {@link Lookup}
	 */
	public String build() {
		return new StringBuilder(API_ENDPOINT)
					.append(idParam())
					.append(amgArtistIdParam())
					.append(amgAlbumIdParam())
					.append(amgVideoIdParam())
					.append(upcParam())
					.append(isbnParam())
					.append(entityParam())
					.append(limitParam())
					.append(sortParam())
					.toString();
	}

	/**
	 * @return "id=xxxx"
	 */
	private String idParam() {
		return String.join(",", ids);
	}
	
	/**
	 * @return "&amgArtistId=XX" or empty string
	 */
	private String amgArtistIdParam() {
		return String.join(",", amgArtistIds);
	}

	/**
	 * @return "&amgAlbumId=XX" or empty string
	 */
	private String amgAlbumIdParam() {
		return String.join(",", amgAlbumIds);
	}

	/**
	 * @return "&amgVideoId=XX" or empty string
	 */
	private String amgVideoIdParam() {
		return String.join(",", amgVideoIds);
	}

	/**
	 * @return "&upc=XX" or empty string
	 */
	private String upcParam() {
		return String.join(",", upcs);
	}
	
	/**
	 * @return "&isbn=XX" or empty string
	 */
	private String isbnParam() {
		return String.join(",", isbns);
	}

	/**
	 * @return "&entity=XX" or empty string
	 */
	private String entityParam() {
		return String.join(",", ids);
	}

	/**
	 * @return "&limit=XX" or empty string
	 */
	private String limitParam() {
		return String.join(",", ids);
	}

	/**
	 * @return "&sort=XX" or empty string
	 */
	private String sortParam() {
		return String.join(",", ids);
	}

}
