/*
	Copyright 2018 Marceau Dewilde <m@ceau.be>
	
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
package be.ceau.itunesapi.request.search;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import be.ceau.itunesapi.request.Entity;

/**
 * <p>
 * The media type you want to search for. For example: movie.
 * </p>
 * <p>
 * iTunes default is all.
 * </p>
 */
public enum Media {

	MOVIE("movie", 
			EnumSet.of(Entity.MOVIE_ARTIST, Entity.MOVIE), 
			EnumSet.of(Attribute.ACTOR_TERM, Attribute.GENRE_INDEX, Attribute.ARTIST_TERM, Attribute.SHORT_FILM_TERM, Attribute.PRODUCER_TERM, Attribute.RATING_TERM, Attribute.DIRECTOR_TERM, Attribute.RELEASE_YEAR_TERM, Attribute.FEATURE_FILM_TERM, Attribute.MOVIE_ARTIST_TERM, Attribute.MOVIE_TERM, Attribute.RATING_INDEX, Attribute.DESCRIPTION_TERM)), 
	PODCAST("podcast", 
			EnumSet.of(Entity.PODCAST_AUTHOR, Entity.PODCAST), 
			EnumSet.of(Attribute.TITLE_TERM, Attribute.LANGUAGE_TERM, Attribute.AUTHOR_TERM, Attribute.GENRE_INDEX, Attribute.ARTIST_TERM, Attribute.RATING_INDEX, Attribute.KEYWORDS_TERM, Attribute.DESCRIPTION_TERM)), 
	MUSIC("music", 
			EnumSet.of(Entity.MUSIC_ARTIST, Entity.MUSIC_TRACK, Entity.ALBUM, Entity.MUSIC_VIDEO, Entity.MIX, Entity.SONG), 
			EnumSet.of(Attribute.MIX_TERM, Attribute.GENRE_INDEX, Attribute.ARTIST_TERM, Attribute.COMPOSER_TERM, Attribute.ALBUM_TERM, Attribute.RATING_INDEX, Attribute.SONG_TERM)), 
	MUSIC_VIDEO("musicVideo", 
			EnumSet.of(Entity.MUSIC_ARTIST, Entity.MUSIC_VIDEO),
			EnumSet.of(Attribute.GENRE_INDEX, Attribute.ARTIST_TERM, Attribute.ALBUM_TERM, Attribute.RATING_INDEX, Attribute.SONG_TERM)), 
	AUDIOBOOK("audiobook",
			EnumSet.of(Entity.AUDIOBOOK_AUTHOR, Entity.AUDIOBOOK),
			EnumSet.of(Attribute.TITLE_TERM, Attribute.AUTHOR_TERM, Attribute.GENRE_INDEX, Attribute.RATING_INDEX)), 
	SHORT_FILM("shortFilm",
			EnumSet.of(Entity.SHORT_FILM_ARTIST, Entity.SHORT_FILM),
			EnumSet.of(Attribute.GENRE_INDEX, Attribute.ARTIST_TERM, Attribute.SHORT_FILM_TERM, Attribute.RATING_INDEX, Attribute.DESCRIPTION_TERM)), 
	TV_SHOW("tvShow",
			EnumSet.of(Entity.TV_EPISODE, Entity.TV_SEASON),
			EnumSet.of(Attribute.GENRE_INDEX, Attribute.TV_EPISODE_TERM, Attribute.SHOW_TERM, Attribute.TV_SEASON_TERM, Attribute.RATING_INDEX, Attribute.DESCRIPTION_TERM)),
	SOFTWARE("software",
			EnumSet.of(Entity.SOFTWARE, Entity.IPAD_SOFTWARE, Entity.MAC_SOFTWARE),
			EnumSet.of(Attribute.SOFTWARE_DEVELOPER)),
	EBOOK("ebook",
			EnumSet.of(Entity.EBOOK),
			EnumSet.noneOf(Attribute.class)),
	ALL("all",
			EnumSet.of(Entity.MOVIE, Entity.ALBUM, Entity.ALL_ARTIST, Entity.PODCAST, Entity.MUSIC_VIDEO, Entity.MIX, Entity.AUDIOBOOK, Entity.TV_SEASON, Entity.ALL_TRACK),
			EnumSet.of(Attribute.ACTOR_TERM, Attribute.LANGUAGE_TERM, Attribute.ALL_ARTIST_TERM, Attribute.TV_EPISODE_TERM, Attribute.SHORT_FILM_TERM, Attribute.DIRECTOR_TERM, Attribute.RELEASE_YEAR_TERM, Attribute.TITLE_TERM, Attribute.FEATURE_FILM_TERM, Attribute.RATING_INDEX, Attribute.KEYWORDS_TERM, Attribute.DESCRIPTION_TERM, Attribute.AUTHOR_TERM, Attribute.GENRE_INDEX, Attribute.MIX_TERM, Attribute.ALL_TRACK_TERM, Attribute.ARTIST_TERM, Attribute.COMPOSER_TERM, Attribute.TV_SEASON_TERM, Attribute.PRODUCER_TERM, Attribute.RATING_TERM, Attribute.SONG_TERM, Attribute.MOVIE_ARTIST_TERM, Attribute.SHOW_TERM, Attribute.MOVIE_TERM, Attribute.ALBUM_TERM));

	private final String name;
	private final Set<Entity> entities;
	private final Set<Attribute> attributes;
	private Media(String name, Set<Entity> entities, Set<Attribute> attributes) {
		this.name = name;
		this.entities = Collections.unmodifiableSet(entities);
		this.attributes = Collections.unmodifiableSet(attributes);
	}
	
	public String getName() {
		return this.name;
	}

	public Set<Entity> getEntities() {
		return entities;
	}

	public Set<Attribute> getAttributes() {
		return attributes;
	}
	
}
