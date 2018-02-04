package com.gk.anagram.dictionary.cache;

import java.util.List;

import com.gk.anagram.delivery.response.AnagramResponse;

public interface DictionaryCache {
	void loadCache();
	List<AnagramResponse> anagram(String[] keys);
}
