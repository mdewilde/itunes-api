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
package be.ceau.itunesapi.request;

/**
 * <p>
 * The type of results you want returned, relative to the specified media type.
 * </p>
 * <p>
 * For example: {@code movieArtist} for a movie media type search.
 * </p>
 * <p>
 * iTunes default is the track entity associated with the specified media type.
 * </p>
 */
public enum Entity {

	ALBUM("album"), 
	ALL_ARTIST("allArtist"), 
	ALL_TRACK("allTrack"), 
	AUDIOBOOK("audiobook"), 
	AUDIOBOOK_AUTHOR("audiobookAuthor"), 
	EBOOK("ebook"), 
	IPAD_SOFTWARE("iPadSoftware"), 
	MAC_SOFTWARE("macSoftware"),
	MIX("mix"), 
	MOVIE("movie"), 
	MOVIE_ARTIST("movieArtist"), 
	MUSIC_ARTIST("musicArtist"), 
	MUSIC_TRACK("musicTrack"), 
	MUSIC_VIDEO("musicVideo"), 
	PODCAST("podcast"), 
	PODCAST_AUTHOR("podcastAuthor"), 
	SHORT_FILM("shortFilm"), 
	SHORT_FILM_ARTIST("shortFilmArtist"), 
	SOFTWARE("software"), 
	SONG("song"), 
	TV_EPISODE("tvEpisode"), 
	TV_SEASON("tvSeason");

	private final String name;
	private Entity(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
