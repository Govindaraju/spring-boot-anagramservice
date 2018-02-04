package com.gk.anagram.delivery.response;

public class AnagramResponse {

	private String key;
	private String[] anagrams;

	public AnagramResponse(String key, String[] anagrams) {
		this.key = key;
		this.anagrams = anagrams;
	}

	public String getKey() {
		return key;
	}

	public String[] getAnagrams() {
		return anagrams;
	}
}
