package be.ceau.itunessearch.enums;

import java.util.Locale;

public enum Sort {

	POPULAR,
	RECENT;
	
	private final String string;
	private Sort() {
		this.string = name().toLowerCase(Locale.ENGLISH);
	}

	public String toString() {
		return this.string;
	}

}
