package random;

import java.util.ArrayList;

public class StringPermutations {

	public static void main(String[] args) {
		PermutationGenerator obj = new PermutationGenerator() ;
		obj.printPermutations("abc") ;
	}

}

class PermutationGenerator {
	public void printPermutations(String input) {
		ArrayList<String> permutations = new ArrayList<String>() ;
		permutations = findPermutations(input, "", permutations) ;
		
		for(String temp: permutations)
			System.out.println(temp) ;
	}
	
	public ArrayList<String> findPermutations(String input, String prefix, ArrayList<String> currList) {
		if(input.length() == 1) {
			currList.add(prefix + input) ;
			return currList ;
		}
		
		for(int i=0 ; i<input.length() ; i++) {
			char thisChar = input.charAt(i) ;
			String thisPrefix = prefix + thisChar ;
			
			String lPart = "" ;
			if(i>0)
				lPart = input.substring(0, i) ;
			String rPart = "" ;
			if(i<input.length()-1)
				rPart = input.substring(i+1, input.length()) ;
			
			String thisInput = lPart + rPart ;
			
			findPermutations(thisInput, thisPrefix, currList) ;
		}
		return currList ;
	}
}
