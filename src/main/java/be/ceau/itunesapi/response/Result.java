/*
	Copyright 2021 Marceau Dewilde <m@ceau.be>
	
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
package be.ceau.itunesapi.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Single result in an iTunes {@link Response}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {

	private static final long serialVersionUID = 1476515572439L;

	private String wrapperType;
	private String kind;

	private Long artistId;
	private Long collectionId;
	private Long trackId;
	private String bundleId;

	private String artistName;
	private String collectionName;
	private String trackName;

	private String collectionCensoredName;
	private String trackCensoredName;

	private String artistViewUrl;
	private String collectionViewUrl;
	private String trackViewUrl;
	private String feedUrl;
	private String previewUrl;

	private String artworkUrl30;
	private String artworkUrl60;
	private String artworkUrl100;
	private String artworkUrl512;
	private String artworkUrl600;

	private BigDecimal price;
	private BigDecimal collectionPrice;
	private BigDecimal trackPrice;
	private BigDecimal trackRentalPrice;
	private BigDecimal collectionHdPrice;
	private BigDecimal trackHdPrice;
	private BigDecimal trackHdRentalPrice;
	private String formattedPrice;

	private String releaseDate;

	private String collectionExplicitness;
	private String trackExplicitness;

	private Integer discCount;
	private Integer discNumber;

	private Integer trackCount;
	private Integer trackNumber;

	private String copyright;

	private Long trackTimeMillis;

	private String country;
	private String currency;

	private String primaryGenreId;
	private String primaryGenreName;

	private Boolean isStreamable;

	private String contentAdvisoryRating;

	private String shortDescription;
	private String longDescription;
	private String description;

	private final Set<String> genreIds = new HashSet<>();
	private final Set<String> genres = new HashSet<>();

	private final Set<String> ipadScreenshotUrls = new HashSet<>();
	private final Set<String> appletvScreenshotUrls = new HashSet<>();
	private final Set<String> features = new HashSet<>();
	private final Set<String> supportedDevices = new HashSet<>();
	private final Set<String> advisories = new HashSet<>();
	private final Set<String> screenshotUrls = new HashSet<>();

	private Boolean isGameCenterEnabled;
	private Integer averageUserRatingForCurrentVersion;
	
	private final Set<String> languageCodesISO2A = new HashSet<>();

	private Long fileSizeBytes;
	private Integer userRatingCountForCurrentVersion;
	private String trackContentRating;

	private String version;
	private Boolean isVppDeviceBasedLicensingEnabled;
	private String currentVersionReleaseDate;
	private String sellerName;
	private String minimumOsVersion;

	private Integer averageUserRating;
	private Integer userRatingCount;

	/**
	 * The name of the object returned by the search request.
	 * 
	 * @return track, collection, artist
	 */
	public String getWrapperType() {
		return wrapperType;
	}

	public void setWrapperType(String wrapperType) {
		this.wrapperType = wrapperType;
	}

	/**
	 * The kind of content returned by the search request.
	 * 
	 * @return book, album, coached-audio, feature-movie, interactive- booklet,
	 *         music-video, pdf podcast, podcast-episode, software-package,
	 *         song, tv-episode, artist
	 */
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public String getBundleId() {
		return bundleId;
	}

	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * The name of the artist returned by the search request.
	 * 
	 * @return String
	 */
	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	/**
	 * The name of the track, song, video, TV episode, and so on returned by the
	 * search request.
	 * 
	 * @return String
	 */
	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	/**
	 * The name of the collection returned by the search request, with
	 * objectionable words *’d out.
	 * 
	 * @return String
	 */
	public String getCollectionCensoredName() {
		return collectionCensoredName;
	}

	public void setCollectionCensoredName(String collectionCensoredName) {
		this.collectionCensoredName = collectionCensoredName;
	}

	/**
	 * The name of the track returned by the search request, with objectionable
	 * words *’d out.
	 * 
	 * @return String
	 */
	public String getTrackCensoredName() {
		return trackCensoredName;
	}

	public void setTrackCensoredName(String trackCensoredName) {
		this.trackCensoredName = trackCensoredName;
	}

	/**
	 * A URL to view the artist in the iTunes Store.
	 * 
	 * @return String
	 */
	public String getArtistViewUrl() {
		return artistViewUrl;
	}

	public void setArtistViewUrl(String artistViewUrl) {
		this.artistViewUrl = artistViewUrl;
	}

	/**
	 * A URL to view the collection in the iTunes Store.
	 * 
	 * @return String
	 */
	public String getCollectionViewUrl() {
		return collectionViewUrl;
	}

	public void setCollectionViewUrl(String collectionViewUrl) {
		this.collectionViewUrl = collectionViewUrl;
	}

	/**
	 * A URL to view the track in the iTunes Store.
	 * 
	 * @return String
	 */
	public String getTrackViewUrl() {
		return trackViewUrl;
	}

	public void setTrackViewUrl(String trackViewUrl) {
		this.trackViewUrl = trackViewUrl;
	}

	/**
	 * URL of the feed if podcast.
	 * 
	 * @return String
	 */
	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	/**
	 * A URL for the artwork associated with the returned media type, sized to
	 * 30x30 pixels.
	 * 
	 * @return String
	 */
	public String getArtworkUrl30() {
		return artworkUrl30;
	}

	public void setArtworkUrl30(String artworkUrl30) {
		this.artworkUrl30 = artworkUrl30;
	}

	/**
	 * A URL for the artwork associated with the returned media type, sized to
	 * 60x60 pixels.
	 * 
	 * @return String
	 */
	public String getArtworkUrl60() {
		return artworkUrl60;
	}

	public void setArtworkUrl60(String artworkUrl60) {
		this.artworkUrl60 = artworkUrl60;
	}

	/**
	 * A URL for the artwork associated with the returned media type, sized to
	 * 100x100 pixels.
	 * 
	 * @return String
	 */
	public String getArtworkUrl100() {
		return artworkUrl100;
	}

	public void setArtworkUrl100(String artworkUrl100) {
		this.artworkUrl100 = artworkUrl100;
	}

	/**
	 * A URL for the artwork associated with the returned media type, sized to
	 * 512x512 pixels.
	 * 
	 * @return String
	 */
	public String getArtworkUrl512() {
		return artworkUrl512;
	}

	public void setArtworkUrl512(String artworkUrl512) {
		this.artworkUrl512 = artworkUrl512;
	}

	/**
	 * A URL for the artwork associated with the returned media type, sized to
	 * 600x600 pixels.
	 * 
	 * @return String
	 */
	public String getArtworkUrl600() {
		return artworkUrl600;
	}

	public void setArtworkUrl600(String artworkUrl600) {
		this.artworkUrl600 = artworkUrl600;
	}

	/**
	 * @return the URL for the largest available artwork, or {@code null} if no
	 *         artwork available
	 */
	public String getLargestArtworkUrl() {
		if (artworkUrl600 != null) {
			return artworkUrl600;
		}
		if (artworkUrl512 != null) {
			return artworkUrl512;
		}
		if (artworkUrl100 != null) {
			return artworkUrl100;
		}
		if (artworkUrl60 != null) {
			return artworkUrl60;
		}
		return artworkUrl30;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCollectionPrice() {
		return collectionPrice;
	}

	public void setCollectionPrice(BigDecimal collectionPrice) {
		this.collectionPrice = collectionPrice;
	}

	public BigDecimal getTrackPrice() {
		return trackPrice;
	}

	public void setTrackPrice(BigDecimal trackPrice) {
		this.trackPrice = trackPrice;
	}

	public BigDecimal getTrackRentalPrice() {
		return trackRentalPrice;
	}

	public void setTrackRentalPrice(BigDecimal trackRentalPrice) {
		this.trackRentalPrice = trackRentalPrice;
	}

	public BigDecimal getCollectionHdPrice() {
		return collectionHdPrice;
	}

	public void setCollectionHdPrice(BigDecimal collectionHdPrice) {
		this.collectionHdPrice = collectionHdPrice;
	}

	public BigDecimal getTrackHdPrice() {
		return trackHdPrice;
	}

	public void setTrackHdPrice(BigDecimal trackHdPrice) {
		this.trackHdPrice = trackHdPrice;
	}

	public BigDecimal getTrackHdRentalPrice() {
		return trackHdRentalPrice;
	}

	public void setTrackHdRentalPrice(BigDecimal trackHdRentalPrice) {
		this.trackHdRentalPrice = trackHdRentalPrice;
	}

	public String getFormattedPrice() {
		return formattedPrice;
	}

	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * The Recording Industry Association of America (RIAA) parental advisory
	 * for the collection. For more information, see <a href=
	 * "http://itunes.apple.com/WebObjects/MZStore.woa/wa/parentalAdvisory">Apple</a>.
	 * 
	 * @return "explicit" (explicit lyrics, possibly explicit album cover),
	 *         "cleaned" (explicit lyrics bleeped out), "notExplicit" (no
	 *         explicit lyrics)
	 */
	public String getCollectionExplicitness() {
		return collectionExplicitness;
	}

	public void setCollectionExplicitness(String collectionExplicitness) {
		this.collectionExplicitness = collectionExplicitness;
	}

	/**
	 * The Recording Industry Association of America (RIAA) parental advisory
	 * for the track. For more information, see <a href=
	 * "http://itunes.apple.com/WebObjects/MZStore.woa/wa/parentalAdvisory">Apple</a>.
	 * 
	 * @return "explicit" (explicit lyrics, possibly explicit album cover),
	 *         "cleaned" (explicit lyrics bleeped out), "notExplicit" (no
	 *         explicit lyrics)
	 */
	public String getTrackExplicitness() {
		return trackExplicitness;
	}

	public void setTrackExplicitness(String trackExplicitness) {
		this.trackExplicitness = trackExplicitness;
	}

	public Integer getDiscCount() {
		return discCount;
	}

	public void setDiscCount(Integer discCount) {
		this.discCount = discCount;
	}

	public Integer getDiscNumber() {
		return discNumber;
	}

	public void setDiscNumber(Integer discNumber) {
		this.discNumber = discNumber;
	}

	public Integer getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}

	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Long getTrackTimeMillis() {
		return trackTimeMillis;
	}

	public void setTrackTimeMillis(Long trackTimeMillis) {
		this.trackTimeMillis = trackTimeMillis;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPrimaryGenreId() {
		return primaryGenreId;
	}

	public void setPrimaryGenreId(String primaryGenreId) {
		this.primaryGenreId = primaryGenreId;
	}

	public String getPrimaryGenreName() {
		return primaryGenreName;
	}

	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}

	public Boolean getIsStreamable() {
		return isStreamable;
	}

	public void setIsStreamable(Boolean isStreamable) {
		this.isStreamable = isStreamable;
	}

	public String getContentAdvisoryRating() {
		return contentAdvisoryRating;
	}

	public void setContentAdvisoryRating(String contentAdvisoryRating) {
		this.contentAdvisoryRating = contentAdvisoryRating;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(Collection<String> genreIds) {
		this.genreIds.clear();
		if (genreIds != null) {
			this.genreIds.addAll(genreIds);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getGenres() {
		return genres;
	}

	public void setGenres(Collection<String> genres) {
		this.genres.clear();
		if (genres != null) {
			this.genres.addAll(genres);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getIpadScreenshotUrls() {
		return ipadScreenshotUrls;
	}

	public void setIpadScreenshotUrls(Collection<String> ipadScreenshotUrls) {
		this.ipadScreenshotUrls.clear();
		if (ipadScreenshotUrls != null) {
			this.ipadScreenshotUrls.addAll(ipadScreenshotUrls);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getAppletvScreenshotUrls() {
		return appletvScreenshotUrls;
	}

	public void setAppletvScreenshotUrls(Collection<String> appletvScreenshotUrls) {
		this.appletvScreenshotUrls.clear();
		if (appletvScreenshotUrls != null) {
			this.appletvScreenshotUrls.addAll(appletvScreenshotUrls);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getFeatures() {
		return features;
	}

	public void setFeatures(Collection<String> features) {
		this.features.clear();
		if (features != null) {
			this.features.addAll(features);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getSupportedDevices() {
		return supportedDevices;
	}

	public void setSupportedDevices(Collection<String> supportedDevices) {
		this.supportedDevices.clear();
		if (supportedDevices != null) {
			this.supportedDevices.addAll(supportedDevices);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getAdvisories() {
		return advisories;
	}

	public void setAdvisories(Collection<String> advisories) {
		this.advisories.clear();
		if (advisories != null) {
			this.advisories.addAll(advisories);
		}
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getScreenshotUrls() {
		return screenshotUrls;
	}

	public void setScreenshotUrls(Collection<String> screenshotUrls) {
		this.screenshotUrls.clear();
		if (screenshotUrls != null) {
			this.screenshotUrls.addAll(screenshotUrls);
		}
	}

	public Boolean getIsGameCenterEnabled() {
		return isGameCenterEnabled;
	}

	public void setIsGameCenterEnabled(Boolean isGameCenterEnabled) {
		this.isGameCenterEnabled = isGameCenterEnabled;
	}

	public Integer getAverageUserRatingForCurrentVersion() {
		return averageUserRatingForCurrentVersion;
	}

	public void setAverageUserRatingForCurrentVersion(Integer averageUserRatingForCurrentVersion) {
		this.averageUserRatingForCurrentVersion = averageUserRatingForCurrentVersion;
	}

	/**
	 * @return modifiable {@link Set}, never {@code null}
	 */
	public Set<String> getLanguageCodesISO2A() {
		return languageCodesISO2A;
	}

	public void setLanguageCodesISO2A(Collection<String> languageCodesISO2A) {
		this.languageCodesISO2A.clear();
		if (languageCodesISO2A != null) {
			this.languageCodesISO2A.addAll(languageCodesISO2A);
		}
	}

	public Long getFileSizeBytes() {
		return fileSizeBytes;
	}

	public void setFileSizeBytes(Long fileSizeBytes) {
		this.fileSizeBytes = fileSizeBytes;
	}

	public Integer getUserRatingCountForCurrentVersion() {
		return userRatingCountForCurrentVersion;
	}

	public void setUserRatingCountForCurrentVersion(Integer userRatingCountForCurrentVersion) {
		this.userRatingCountForCurrentVersion = userRatingCountForCurrentVersion;
	}

	public String getTrackContentRating() {
		return trackContentRating;
	}

	public void setTrackContentRating(String trackContentRating) {
		this.trackContentRating = trackContentRating;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Boolean getIsVppDeviceBasedLicensingEnabled() {
		return isVppDeviceBasedLicensingEnabled;
	}

	public void setIsVppDeviceBasedLicensingEnabled(Boolean isVppDeviceBasedLicensingEnabled) {
		this.isVppDeviceBasedLicensingEnabled = isVppDeviceBasedLicensingEnabled;
	}

	public String getCurrentVersionReleaseDate() {
		return currentVersionReleaseDate;
	}

	public void setCurrentVersionReleaseDate(String currentVersionReleaseDate) {
		this.currentVersionReleaseDate = currentVersionReleaseDate;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getMinimumOsVersion() {
		return minimumOsVersion;
	}

	public void setMinimumOsVersion(String minimumOsVersion) {
		this.minimumOsVersion = minimumOsVersion;
	}

	public Integer getAverageUserRating() {
		return averageUserRating;
	}

	public void setAverageUserRating(Integer averageUserRating) {
		this.averageUserRating = averageUserRating;
	}

	public Integer getUserRatingCount() {
		return userRatingCount;
	}

	public void setUserRatingCount(Integer userRatingCount) {
		this.userRatingCount = userRatingCount;
	}

	@Override
	public String toString() {
		return "Result [wrapperType=" + wrapperType + ", kind=" + kind + ", artistId=" + artistId + ", collectionId="
				+ collectionId + ", trackId=" + trackId + ", bundleId=" + bundleId + ", artistName=" + artistName
				+ ", collectionName=" + collectionName + ", trackName=" + trackName + ", collectionCensoredName="
				+ collectionCensoredName + ", trackCensoredName=" + trackCensoredName + ", artistViewUrl="
				+ artistViewUrl + ", collectionViewUrl=" + collectionViewUrl + ", trackViewUrl=" + trackViewUrl
				+ ", feedUrl=" + feedUrl + ", previewUrl=" + previewUrl + ", artworkUrl30=" + artworkUrl30
				+ ", artworkUrl60=" + artworkUrl60 + ", artworkUrl100=" + artworkUrl100 + ", artworkUrl512="
				+ artworkUrl512 + ", artworkUrl600=" + artworkUrl600 + ", price=" + price + ", collectionPrice="
				+ collectionPrice + ", trackPrice=" + trackPrice + ", trackRentalPrice=" + trackRentalPrice
				+ ", collectionHdPrice=" + collectionHdPrice + ", trackHdPrice=" + trackHdPrice
				+ ", trackHdRentalPrice=" + trackHdRentalPrice + ", formattedPrice=" + formattedPrice + ", releaseDate="
				+ releaseDate + ", collectionExplicitness=" + collectionExplicitness + ", trackExplicitness="
				+ trackExplicitness + ", discCount=" + discCount + ", discNumber=" + discNumber + ", trackCount="
				+ trackCount + ", trackNumber=" + trackNumber + ", copyright=" + copyright + ", trackTimeMillis="
				+ trackTimeMillis + ", country=" + country + ", currency=" + currency + ", primaryGenreId="
				+ primaryGenreId + ", primaryGenreName=" + primaryGenreName + ", isStreamable=" + isStreamable
				+ ", contentAdvisoryRating=" + contentAdvisoryRating + ", shortDescription=" + shortDescription
				+ ", longDescription=" + longDescription + ", description=" + description + ", genreIds=" + genreIds
				+ ", genres=" + genres + ", ipadScreenshotUrls=" + ipadScreenshotUrls + ", appletvScreenshotUrls="
				+ appletvScreenshotUrls + ", features=" + features + ", supportedDevices=" + supportedDevices
				+ ", advisories=" + advisories + ", screenshotUrls=" + screenshotUrls + ", isGameCenterEnabled="
				+ isGameCenterEnabled + ", averageUserRatingForCurrentVersion=" + averageUserRatingForCurrentVersion
				+ ", languageCodesISO2A=" + languageCodesISO2A + ", fileSizeBytes=" + fileSizeBytes
				+ ", userRatingCountForCurrentVersion=" + userRatingCountForCurrentVersion + ", trackContentRating="
				+ trackContentRating + ", version=" + version + ", isVppDeviceBasedLicensingEnabled="
				+ isVppDeviceBasedLicensingEnabled + ", currentVersionReleaseDate=" + currentVersionReleaseDate
				+ ", sellerName=" + sellerName + ", minimumOsVersion=" + minimumOsVersion + ", averageUserRating="
				+ averageUserRating + ", userRatingCount=" + userRatingCount + "]";
	}
	
}
