package random;

/*
 * Determining the maximum length of alternating characters in a string
 * For eg: in "aqwerplplprety", "plplp" is the longest alternating substring
 */

public class AlternatingString {

	public static void main(String[] args) {
		
		AlternatingString obj = new AlternatingString() ;
		int maxLength = obj.findMaxAlternatingLength("aqwerplplprety") ;
		System.out.println("MaxLength = " + maxLength) ;
	}
	
	private int findMaxAlternatingLength(final String input) {
		if(input.length() <= 1) {
			return input.length() ;
		}
		else if(input.length() <= 2) {
			if(input.charAt(0) != input.charAt(1)) {
				return 2 ;
			}
			else {
				return 0 ;
			}
		}
		
		int unit = input.charAt(0) != input.charAt(1) ? 2 : 0 ;
		int maxUnit = 0 ;
		for(int i=2 ; i<input.length() ; i++) {
			char one = input.charAt(i) ;
			char two = input.charAt(i-1) ;
			char three = input.charAt(i-2) ;
			
			if(one == three && one != two) {
				if(unit == 1) {
					unit = 3 ;
				}
				else {
					unit += 1 ;
				}
			}
			else {
				unit = 1 ;
			}
			if(unit > maxUnit) {
				maxUnit = unit ;
			}
		}
		return maxUnit ;
	}
}
