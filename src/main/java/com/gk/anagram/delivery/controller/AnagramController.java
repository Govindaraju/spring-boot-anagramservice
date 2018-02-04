package com.gk.anagram.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gk.anagram.delivery.response.AnagramResponse;
import com.gk.anagram.dictionary.cache.DictionaryCache;

@RestController
public class AnagramController {

	@Autowired
	private DictionaryCache dictionaryCache;
	
	@GetMapping(path="/service/test")
	public String test() {
		return "Running ";
	}
	

	@GetMapping(path="/{keys}")
	public List<AnagramResponse> anagram(@PathVariable String[] keys) {
		return dictionaryCache.anagram(keys);
	}
}
