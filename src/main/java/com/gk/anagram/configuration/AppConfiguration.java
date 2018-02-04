package com.gk.anagram.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gk.anagram.dictionary.builder.DictionaryBuilder;
import com.gk.anagram.dictionary.builder.SimpleAnagramDictionaryBuilder;
import com.gk.anagram.dictionary.cache.DictionaryCache;
import com.gk.anagram.dictionary.cache.FileBasedCache;
import com.gk.anagram.repository.FileRepository;
import com.gk.anagram.repository.Repository;

@Configuration
public class AppConfiguration {

	@Bean
	public Repository fileRepository() {
		return new FileRepository();
	}

	@Bean(initMethod = "loadCache")
	public DictionaryCache dataCache() {
		return new FileBasedCache();
	}
	
	@Bean
	public DictionaryBuilder simpleAnagramDictionaryBuilder() {
		return new SimpleAnagramDictionaryBuilder();
	}

}
