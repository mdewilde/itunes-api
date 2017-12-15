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
package be.ceau.itunesapi.response.feedgenerator;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import be.ceau.itunesapi.response.feedgenerator.Link.LinkDeserializer;

/**
 * Single link in an iTunes {@link Feed}.
 */
@JsonDeserialize(using = LinkDeserializer.class)
public class Link implements Serializable {

	private static final long serialVersionUID = 1501415268127L;

	public Link() {
		
	}
	
	public Link(String type, String uri) {
		this.type = type;
		this.uri = uri;
	}

	private String type;
	private String uri;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Link [type=")
				.append(type)
				.append(", uri=")
				.append(uri)
				.append("]")
				.toString();
	}

	public static class LinkDeserializer extends JsonDeserializer<Link> {

		@Override
		public Link deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			JsonNode node = p.getCodec().readTree(p);
			Entry<String, JsonNode> entry = node.fields().next();
	        return new Link(entry.getKey(), entry.getValue().asText());
		}

	}
	
}
