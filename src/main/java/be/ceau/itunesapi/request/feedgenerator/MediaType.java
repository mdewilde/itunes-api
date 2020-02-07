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
package be.ceau.itunesapi.request.feedgenerator;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import be.ceau.itunesapi.FeedGenerator;

/**
 * Possible media types to request in the RSS Feed Generator.
 * 
 * @see FeedGenerator
 */
public enum MediaType {

	APPLE_MUSIC("apple-music", EnumSet.of(FeedType.NEW_MUSIC, FeedType.HOT_TRACKS, FeedType.TOP_SONGS, FeedType.TOP_ALBUMS, FeedType.HOT_TRACKS_COUNTRY)),
	ITUNES_MUSIC("itunes-music", EnumSet.of(FeedType.NEW_MUSIC, FeedType.RECENT_RELEASES, FeedType.HOT_ALBUMS, FeedType.TOP_SONGS, FeedType.TOP_ALBUMS, FeedType.HOT_TRACKS_COUNTRY)),
	IOS_APPS("ios-apps", EnumSet.of(FeedType.NEW_APPS_WE_LOVE, FeedType.NEW_GAMES_WE_LOVE, FeedType.TOP_FREE_IPAD, FeedType.TOP_GROSSING_IPAD, FeedType.TOP_FREE, FeedType.TOP_PAID, FeedType.TOP_GROSSING, FeedType.TOP_FREE_GAMES, FeedType.TOP_PAID_GAMES)),
	MACOS_APPS("macos-apps", EnumSet.of(FeedType.TOP_MAC_APPS, FeedType.TOP_FREE_MAC_APPS, FeedType.TOP_PAID_MAC_APPS, FeedType.TOP_GROSSING_MAC_APPS)),
	AUDIOBOOKS("audiobooks", EnumSet.of(FeedType.TOP_AUDIOBOOKS)),
	BOOKS("books", EnumSet.of(FeedType.TOP_PAID, FeedType.TOP_FREE)),
	TV_SHOWS("tv-shows", EnumSet.of(FeedType.TOP_TV_EPISODES, FeedType.TOP_TV_SEASONS)),
	MOVIES("movies", EnumSet.of(FeedType.TOP_MOVIES, FeedType.TOP_MOVIES_ACTION_AND_ADVENTURE, FeedType.TOP_MOVIES_DOCUMENTARY)),
	ITUNES_U("itunes-u", EnumSet.of(FeedType.TOP_ITUNES_U_COLLECTION, FeedType.TOP_ITUNES_U_COURSES)),
	PODCASTS("podcasts", EnumSet.of(FeedType.TOP_PODCASTS)),
	MUSIC_VIDEOS("music-videos", EnumSet.of(FeedType.TOP_MUSIC_VIDEOS));

	private final String code;
	private final Set<FeedType> feedTypes;

	private MediaType(String code, EnumSet<FeedType> feedTypes) {
		this.code = code;
		this.feedTypes = Collections.unmodifiableSet(feedTypes);
	}

	/**
	 * @return {@link String} to use in the generated feed URL
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return unmodifiable {@link Set} containing all {@link FeedType} instances
	 *         that are compatible with this {@link MediaType}
	 */
	public Set<FeedType> getCompatibleFeedTypes() {
		return feedTypes;
	}
	
}