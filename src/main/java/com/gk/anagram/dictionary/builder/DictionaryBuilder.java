package com.gk.anagram.dictionary.builder;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DictionaryBuilder {
	Map<String, Set<String>> build(List<String> wordsList);
}
