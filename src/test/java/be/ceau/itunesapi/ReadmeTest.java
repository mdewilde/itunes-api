package be.ceau.itunesapi;

import org.junit.Assert;
import org.junit.Test;

import be.ceau.itunesapi.request.Country;
import be.ceau.itunesapi.request.search.Attribute;
import be.ceau.itunesapi.request.search.Media;
import be.ceau.itunesapi.response.Response;
import be.ceau.itunesapi.response.Result;

public class ReadmeTest {

	@Test
	public void cbsPodcasts() {
		Response response = new Search("cbs radio")
				.setCountry(Country.CANADA)
				.setAttribute(Attribute.AUTHOR_TERM)
				.setMedia(Media.PODCAST)
				.setLimit(15)
				.execute();
		Assert.assertEquals(15, response.getResultCount());
		for (Result result : response.getResults()) {
			Assert.assertEquals("podcast", result.getKind());
		}
	}

}
