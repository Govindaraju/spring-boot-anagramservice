package com.gk.anagram.dictionary.cache;

import static com.gk.anagram.util.StringUtil.modifyWithItsCharactersArrangedAlphabetically;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.gk.anagram.delivery.response.AnagramResponse;
import com.gk.anagram.dictionary.builder.DictionaryBuilder;
import com.gk.anagram.repository.Repository;

public class FileBasedCache implements DictionaryCache {

	@Autowired
	private Repository repository;

	@Autowired
	private DictionaryBuilder dictionaryBuilder;

	private Map<String, Set<String>> anagramDictionaryMap;

	@Override
	public void loadCache() {
		List<String> wordsList = repository.load();
		anagramDictionaryMap = dictionaryBuilder.build(wordsList);
	}

	@Override
	public List<AnagramResponse> anagram(String[] keys) {
		return Arrays.stream(keys).map(key -> anagramList(key)).collect(Collectors.toList());
	}

	private AnagramResponse anagramList(String naturalKey) {
		String surrogateKey = modifyWithItsCharactersArrangedAlphabetically(naturalKey);
		return new AnagramResponse(naturalKey, anagramsOf(surrogateKey,naturalKey));
	}

	private String[] anagramsOf(String lookupKey, String naturalKey) {
		String anagrams[] = new String[0];
		Set<String> result = anagramDictionaryMap.get(lookupKey);

		if (result != null) {
			result.remove(naturalKey);
			anagrams = result.toArray(new String[0]);
		}

		return anagrams;
	}

}
