package com.gk.anagram.util;

import java.util.Arrays;

public class StringUtil {

	public static String modifyWithItsCharactersArrangedAlphabetically(String natural) {
		char[] charArray = natural.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
}
