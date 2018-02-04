package com.gk.anagram.dictionary.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gk.anagram.configuration.AppConfiguration;
import com.gk.anagram.delivery.response.AnagramResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfiguration.class })
@TestPropertySource("classpath:test.application.properties")
public class TestFileBasedCache {

	@Autowired
	private FileBasedCache subject;

	@Before
	public void setUp() throws Exception {
		subject.loadCache();
	}

	@Test
	public void testAnagram() {
		List<AnagramResponse> result = subject.anagram(new String[] { "keep", "vira", "David" });

		assertTrue(result.size() == 3);

		AnagramResponse keepAnagram = result.get(0);
		AnagramResponse viraAnagram = result.get(1);
		AnagramResponse davidAnagram = result.get(2);

		assertEquals(keepAnagram.getKey(), "keep");
		assertEquals(viraAnagram.getKey(), "vira");
		assertEquals(davidAnagram.getKey(), "David");
		
		assertTrue(keepAnagram.getAnagrams().length == 2);
		assertTrue(viraAnagram.getAnagrams().length == 2);
		assertTrue(davidAnagram.getAnagrams().length == 0);
		
		assertTrue(Arrays.asList(keepAnagram.getAnagrams()).contains("eekp"));
		assertTrue(Arrays.asList(keepAnagram.getAnagrams()).contains("peek"));
		
		assertTrue(Arrays.asList(viraAnagram.getAnagrams()).contains("ravi"));
		assertTrue(Arrays.asList(viraAnagram.getAnagrams()).contains("arvi"));


	}

}
