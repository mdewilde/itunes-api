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

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;

class LineReader {

	@Before
	public void setup() {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace");
	}

	/**
	 * @param file
	 *            {@link String} name of a classpath resource, not {@code null}
	 * @return new, modifiable {@link List} on every invocation
	 */
	public static List<String> readLines(String file) {
		Objects.requireNonNull(file);
		List<String> words = new ArrayList<String>();
		InputStream in = null;
		InputStreamReader is = null;
		BufferedReader br = null;
		try {
			in = LineReader.class.getClassLoader().getResourceAsStream(file);
			is = new InputStreamReader(in, StandardCharsets.UTF_8);
			br = new BufferedReader(is);
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line.trim());
			}
			return words;
		} catch (IOException e) {
			throw new IllegalStateException("loading did not complete successfully", e);
		} finally {
			closeQuietly(br);
			closeQuietly(is);
			closeQuietly(in);
		}
	}

	/**
	 * @param file
	 *            {@link String} name of a classpath resource, not {@code null}
	 * @return {@link String} contents of the given file
	 */
	public static String readFile(String file) {
		StringBuilder sb = new StringBuilder();
		for (String line : readLines(file)) {
			sb.append(line).append(System.lineSeparator());
		}
		return sb.toString();
	}

	private static void closeQuietly(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException e) {
			}
		}
	}

}
