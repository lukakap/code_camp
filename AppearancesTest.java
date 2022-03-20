import junit.framework.TestCase;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}

	//cases where some elements exist both string but number is diff
	public void testSameCount3() {
		List<String> a = stringToList("fggrhhh");
		List<String> b = stringToList("lhlhphgffr");
		assertEquals(2, Appearances.sameCount(a, b));

		List<String> c = stringToList("a");
		List<String> d = stringToList("aa");
		assertEquals(0, Appearances.sameCount(c,d));
	}

	//Case where is empty strings
	public void testSameCount4() {
		List<String> a = stringToList("");
		List<String> b = stringToList("lhlhphgffr");
		assertEquals(0, Appearances.sameCount(a, b));

		List<String> c = stringToList("");
		List<String> d = stringToList("");
		assertEquals(0, Appearances.sameCount(c,d));
	}

	// integer tests. case when lists dont have same elements. when different from same element is only one.
	// same elements with diff sequence.
	public void testSameCount5(){
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		List<Integer> b = Arrays.asList(4, 4, 7);
		assertEquals(0,Appearances.sameCount(a,b));

		List<Integer> c = Arrays.asList(1, 1, 1, 1);
		List<Integer> d = Arrays.asList(1, 1, 1);
		assertEquals(0,Appearances.sameCount(c,d));

		List<Integer> e = Arrays.asList(2, 2, 2, 4, 4, 4);
		List<Integer> f = Arrays.asList(4, 2, 4, 2, 4, 2);
		assertEquals(2,Appearances.sameCount(e,f));

	}

}
