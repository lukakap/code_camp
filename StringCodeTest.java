// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import junit.framework.TestCase;

public class StringCodeTest extends TestCase {
	//
	// blowup
	//
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	//cases where len is more than length of each string

	public void testStringIntersect1() {
		assertEquals(false,StringCode.stringIntersect("abbccc","abbccc",7));
		assertEquals(false,StringCode.stringIntersect("a","a",2));
		assertEquals(false,StringCode.stringIntersect("b","c",2));
		assertEquals(false,StringCode.stringIntersect("ghhssfr","gggkkl",8));
	}

	//cases where len is 1

	public void testStringIntersect2() {
		assertEquals(true,StringCode.stringIntersect("abbccc","gggkkllbppp",1));
		assertEquals(true,StringCode.stringIntersect("qqqweeeert","wwwk",1));
		assertEquals(true,StringCode.stringIntersect("g","g",1));
		assertEquals(true,StringCode.stringIntersect("gb","b",1));
		assertEquals(true,StringCode.stringIntersect("k","kp",1));
		assertEquals(false,StringCode.stringIntersect("g","k",1));
		assertEquals(false,StringCode.stringIntersect("gk","b",1));
		assertEquals(false,StringCode.stringIntersect("k","pp",1));
		assertEquals(false,StringCode.stringIntersect("kprrlll","ojjggg",1));
	}

	//cases where len is diff from 1

	public void testStringIntersect3() {
		assertEquals(true,StringCode.stringIntersect("qqweeerrrrkkp","ggwwpppeeeer",3));
		assertEquals(true,StringCode.stringIntersect("arpggggllppprkhhhhh","zzxcccvvggggpo",4));
		assertEquals(true,StringCode.stringIntersect("kkpprrrltk","aaassllppprrebb",4));
		assertEquals(false,StringCode.stringIntersect("qqqekp","kjjjjlkg",2));
		assertEquals(false,StringCode.stringIntersect("ppppqqeeerr","fffggdddeemmmmm",3));
		assertEquals(false,StringCode.stringIntersect("qqqwweerrtty","kkmmppggeeww",3));
		assertEquals(false,StringCode.stringIntersect("","kkkgghjr",3));
	}

	// Need test cases for stringIntersect


	
}
