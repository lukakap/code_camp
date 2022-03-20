

// CS108 HW1 -- String static methods

import java.util.HashSet;

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int maxCount = 1;
		for(int i = 0; i < str.length() - 1; i++) {
			int count = 1;
			while(str.charAt(i)==str.charAt(i+1)) {
				count++;
				i++;
				if(i >= str.length() - 1) break;
			}
			if(count > maxCount) maxCount = count;
		}

		if(str.equals("")) maxCount = 0;
		return maxCount; //
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String replacedStr = "";
		for(int i = 0; i < str.length(); i++) {
			String replacedStrHelper = "";
			if(Character.isDigit(str.charAt(i))){
				if(i == str.length() - 1) break;
				for(int j = 0 ; j < str.charAt(i) - '0'; j++) {
					replacedStr += str.charAt(i+1);
				}
			} else {
				replacedStr += str.charAt(i);
			}
		}

		return replacedStr;
	}



	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> set = new HashSet();
		for(int i = 0 ; i <= a.length() - len; i++) {
			String subStr = a.substring(i,i+len);
			set.add(subStr);
		}
		for(int i = 0 ; i <= b.length() - len; i++) {
			String subStr = b.substring(i,i+len);
			if(set.contains(subStr)) return true;
		}
		return false;

	}
}
