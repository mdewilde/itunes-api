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
package be.ceau.itunessearch.enums;

/**
 * <p>
 * The attribute you want to search for in iTunes, relative to the specified
 * media type.
 * </p>
 * <p>
 * For example, if you want to search for an artist by name specify
 * {@code entity=allArtist&attribute=allArtistTerm}. In this example, if you
 * search for {@code term=maroon}, iTunes returns “Maroon 5” in the search
 * results, instead of all artists who have ever recorded a song with the word
 * “maroon” in the title.
 * </p>
 * <p>
 * iTunes default is all attributes associated with the specified media type.
 * </p>
 */
public enum Attribute {

	ACTOR_TERM("actorTerm"),
	ALBUM_TERM("albumTerm"),
	ALL_ARTIST_TERM("allArtistTerm"),
	ALL_TRACK_TERM("allTrackTerm"),
	ARTIST_TERM("artistTerm"),
	AUTHOR_TERM("authorTerm"),
	COMPOSER_TERM("composerTerm"),
	DESCRIPTION_TERM("descriptionTerm"),
	DIRECTOR_TERM("directorTerm"),
	FEATURE_FILM_TERM("featureFilmTerm"),
	GENRE_INDEX("genreIndex"),
	KEYWORDS_TERM("keywordsTerm"),
	LANGUAGE_TERM("languageTerm"),
	MIX_TERM("mixTerm"),
	MOVIE_ARTIST_TERM("movieArtistTerm"),
	MOVIE_TERM("movieTerm"),
	PRODUCER_TERM("producerTerm"),
	RATING_INDEX("ratingIndex"),
	RATING_TERM("ratingTerm"),
	RELEASE_YEAR_TERM("releaseYearTerm"),
	SHORT_FILM_TERM("shortFilmTerm"),
	SHOW_TERM("showTerm"),
	SOFTWARE_DEVELOPER("softwareDeveloper"),
	SONG_TERM("songTerm"),
	TITLE_TERM("titleTerm"),
	TV_EPISODE_TERM("tvEpisodeTerm"),
	TV_SEASON_TERM("tvSeasonTerm");

	private final String name;
	private Attribute(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
