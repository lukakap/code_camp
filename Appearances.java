import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Iterator itA = a.iterator();
		Iterator itB = b.iterator();
		HashMap<T,Integer> elementsA = new HashMap<T, Integer>();
		HashMap<T,Integer> elementsB = new HashMap<T, Integer>();
		fillHashMap(elementsA, itA);
		fillHashMap(elementsB, itB);

		int res = 0;
		Set<T> keys = elementsA.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext()) {
			T element = (T)it.next();
			if(elementsB.containsKey(element)){
				if(elementsA.get(element) == elementsB.get(element)) {
					res++;
				}
			}
		}
		return res;
	}

	private static <T> void fillHashMap(HashMap<T,Integer> elements, Iterator it) {
		while (it.hasNext()){
			T newElement = (T) it.next();
			if(elements.containsKey(newElement)){
				elements.replace(newElement,elements.get(newElement)+1);
			} else {
				elements.put(newElement,1);
			}
		}
	}

}
