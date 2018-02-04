package com.gk.anagram.dictionary.builder;

import static com.gk.anagram.util.StringUtil.modifyWithItsCharactersArrangedAlphabetically;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TestSimpleAnagramDictionaryBuilder {

	SimpleAnagramDictionaryBuilder subject;
	
	@Before
	public void setUp() throws Exception {
		subject = new SimpleAnagramDictionaryBuilder();
	}

	@Test
	public void testBuild_listWithAnagrams() {
		List<String> wordList = Arrays.asList("keep","peek","ravi","arvi","smt","tms","mts","govind's");
		Map<String, Set<String>> result = subject.build(wordList);
		
		assertTrue(result.keySet().size() == 4);
		
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("keep")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("peek")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("ravi")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("arvi")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("smt")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("tms")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("mts")));
		assertTrue(result.keySet().contains(modifyWithItsCharactersArrangedAlphabetically("govind's")));
		
		Set<String> surrogateKeyOf_ravi = result.get(modifyWithItsCharactersArrangedAlphabetically("ravi"));
		assertTrue(surrogateKeyOf_ravi.contains("arvi"));
		assertTrue(surrogateKeyOf_ravi.contains("ravi"));

	}

}
