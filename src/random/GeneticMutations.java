package random;

/*
 * Graph based solution for finding path between 2 strings
 * Input: The bank of all strings, the source string and the destination string
 * Output: The shortest path (mutation distance) between the source and the destination string
 * using only the strings in the bank
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GeneticMutations {

	public static void main(String[] args) {
		String[] bank = {"GAAAAAAA", "AAGAAAAA", "AAAAGAAA", "GGAAAAAA"} ;
		int mutDist = findMutationDistance("AAAAAAAA", "GGAAAAAA", bank) ;
		System.out.println("mutDist = " + mutDist) ;
	}

	static int findMutationDistance(String start, String end, String[] bank) {

		if(start.equals(end)) {
			return 0 ;
		}
		else if(distanceBetween(start, end) == 1) {
			return 1 ;
		}
		int finalDist = -1 ;
		HashMap<Integer, HashSet<String> > distSet = createDistSet(start, bank) ;
		distSet.put(0, new HashSet<String>()) ;
		distSet.get(0).add(start) ;
		int currIndex = 0, nextIndex = 1 ;

		while(distSet.containsKey(currIndex) && distSet.containsKey(nextIndex)) {
			HashSet<String> currSet = distSet.get(currIndex) ;
			Iterator<String> currIt = currSet.iterator() ;
			//System.out.println("currIndex=" + currIndex + " nextIndex=" + nextIndex) ;
			HashSet<String> nextSet = createNewSet(distSet, nextIndex) ;

			while(currIt.hasNext()) {
				String curr = currIt.next() ;
				//System.out.println("curr=" + curr) ;
				Iterator<String> nextIt = nextSet.iterator() ;
				while(nextIt.hasNext()) {
					String next = nextIt.next() ;
					//System.out.println("next=" + next) ;

					if(end.equals(next)) {
						//System.out.println("End and Next are equal");
						return nextIndex ;
					}
					else if(distanceBetween(curr, next) == 1) {
						nextIt.remove() ;
						//nextSet.remove(next) ;
					}
				}
			}
			if(! nextSet.isEmpty()) {
				if(distSet.containsKey(nextIndex)) {
					distSet.get(nextIndex).addAll(nextSet) ;
				}
				else {
					distSet.put(nextIndex, nextSet) ;
				}
			}
			currIndex++ ;
			nextIndex++ ;
		}
		return finalDist ;
	}

	private static HashMap<Integer, HashSet<String> > createDistSet(String start, String[] bank) {
		HashMap<Integer, HashSet<String> > distSet = new HashMap<>() ;

		for(String currStr: bank) {
			int dist = distanceBetween(start, currStr) ;

			if(distSet.containsKey(dist)) {
				distSet.get(dist).add(currStr) ;
			}
			else {
				HashSet<String> tempSet = new HashSet<String>() ;
				tempSet.add(currStr) ;
				distSet.put(dist, tempSet) ;
			}
		}

		return distSet ;
	}

	private static int distanceBetween(String start, String end) {
		int dist = 0 ;
		for(int i=0 ; i<start.length() ; i++) {
			if(start.charAt(i) != end.charAt(i)) {
				dist++ ;
			}
		}
		return dist ;
	}

	private static HashSet<String> createNewSet(HashMap<Integer, HashSet<String> > distSet, int nextIndex) {
		HashSet<String> oldSet = distSet.get(nextIndex) ;
		HashSet<String> newSet = new HashSet<String>() ;

		Iterator<String> oldIter = oldSet.iterator() ;

		while(oldIter.hasNext()) {
			newSet.add(oldIter.next()) ;
		}
		return newSet ;
	}
}
