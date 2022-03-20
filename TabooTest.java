// TabooTest.java
// Taboo class tests -- nothing provided.

import junit.framework.TestCase;

import java.util.*;

public class TabooTest extends TestCase {

    private List<String> stringToList(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            list.add(Character.toString(s.charAt(i)));
        }
        return list;
    }

    private Set<String> stringToSet(String s) {
        if(s == "") return Collections.emptySet();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(Character.toString(s.charAt(i)));
        }
        return set;
    }

    public void testNoFollow1() {
        List<String> a = stringToList("afgab");

        Taboo taboo = new Taboo (a);

        Set<String> noFollowA = stringToSet("fb");
        Set<String> noFollowF = stringToSet("g");
        Set<String> noFollowB = stringToSet("");      //case when s is last char
        Set<String> noFollowJ = stringToSet("");      //case when char is not in string

        assertEquals(noFollowA, taboo.noFollow("a"));
        assertEquals(noFollowF, taboo.noFollow("f"));
        assertEquals(noFollowB, taboo.noFollow("b"));
        assertEquals(noFollowJ, taboo.noFollow("j"));
    }

    //test on integers
    public void testNoFollow2() {
        List<Integer> a = Arrays.asList(4,5,1,2,5,2,3);
        Taboo taboo = new Taboo (a);

        List<Integer> b = Arrays.asList(1,2);       // 5 no follow cases
        List<Integer> c = Arrays.asList(2);         // 1 no follow cases

        Set<Integer> noFollow5 = new HashSet<>(b);
        Set<Integer> noFollow1 = new HashSet<>(c);
        Set<Integer> noFollow3 = Collections.emptySet();
        Set<Integer> noFollow7 = Collections.emptySet();

        assertEquals(noFollow5, taboo.noFollow(5));
        assertEquals(noFollow1, taboo.noFollow(1));
        assertEquals(noFollow3, taboo.noFollow(3));
        assertEquals(noFollow7, taboo.noFollow(7));
    }

    //cases with NULL
    public void testNoFollow3() {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("l");
        a.add("e");
        a.add("a");
        a.add(null);
        a.add("e");
        a.add("e");
        a.add("a");
        a.add("o");

        Taboo taboo = new Taboo (a);

        Set<String> noFollowA = stringToSet("lo");
        Set<String> noFollowE = stringToSet("ae"); // case where same objects are neighbor

        assertEquals(noFollowA, taboo.noFollow("a"));
        assertEquals(noFollowE, taboo.noFollow("e"));

    }

    public void testReduce1() {
        List<String> a = stringToList("faabgak");

        Taboo taboo = new Taboo (a);

        List<String> str1 = stringToList(""); //empty str
        List<String> str2 = stringToList("gamaakhj"); // two delete in sequence.
        List<String> str3 = stringToList("cekiikm"); // without violation

        taboo.reduce(str1);
        taboo.reduce(str2);
        taboo.reduce(str3);

        List<String> str1Red = stringToList("");
        List<String> str2Red = stringToList("gmahj");
        List<String> str3Red = stringToList("cekiikm");

        assertEquals(str1Red, str1);
        assertEquals(str2Red, str2);
        assertEquals(str3Red, str3);
    }

    public void testReduce2() {
        List<Integer> a = Arrays.asList(2,4,5,6,2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(5);
        b.add(5);
        b.add(6);
        b.add(2);
        b.add(4);

        Taboo taboo = new Taboo (a);

        List<Integer> res = Arrays.asList(3,5,5,2);
        taboo.reduce(b);
        assertTrue(res.equals(b));
    }
}
