package com.gk.anagram.dictionary.builder;

import static com.gk.anagram.util.StringUtil.modifyWithItsCharactersArrangedAlphabetically;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleAnagramDictionaryBuilder implements DictionaryBuilder {

	private final Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();

	@Override
	public Map<String, Set<String>> build(List<String> wordsList) {
		wordsList.stream().forEach(word -> updateDictionary(word));
		return dictionary;
	}

	private void updateDictionary(String word) {
		String surrogateKey = modifyWithItsCharactersArrangedAlphabetically(word);

		Set<String> anagrams = dictionary.get(surrogateKey);

		if (anagrams == null) {
			anagrams = new HashSet<>();
			dictionary.put(surrogateKey, anagrams);
		}

		anagrams.add(word);
	}

}
