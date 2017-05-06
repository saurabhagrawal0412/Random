package regex ;

import java.util.regex.Matcher ;
import java.util.regex.Pattern ;

public class RegexTest {

	public static void main(String[] args) {
		RegexTest obj = new RegexTest() ;
		
		String pair = "(-4989898,997989)" ;
		System.out.println(pair + " matches integer pair : " + obj.matchIntegerPair(pair)) ;
		
		String number = "-0.456*10poer4" ;
		System.out.println(number + " matches decimal : " + obj.matchDecimal(number)) ;
		
		String ip = "1.1.1.1" ;
		System.out.println(ip + " matches IP : " + obj.matchIPv4(ip)) ;
		//obj.matchCharacter() ;
		
		//System.out.println("123".matches("[0-9]{2,4}"));
	}

	public void matchCharacter() {
		/*String text = "This is the text which is to be searched " + "for occurrences of the word 'is'.";
		String patternString = "is";
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);

		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
		}*/

		/*String text = "This is the text to be searched for occurrences of the http:// pattern.";

		String patternString = ".*(is the)";

		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);

		System.out.println("lookingAt = " + matcher.lookingAt());
		System.out.println("matches   = " + matcher.matches());*/
		
		String pattern = "http://www.the-associates.co.uk" ;
		String url = "http://www.the-associates.co.uk/dir1/dir2/file3.php?username=1&filename=6.sh" ;
		
		System.out.println("Url = " + url) ;
		
		int index = url.indexOf('?') ;
		if(index > -1) {
			url = url.substring(0, index) ;
		}
		System.out.println("Url without query string = " + url) ;

		String second = url.replace(pattern, "") ;
		System.out.println("Second = " + second) ;
	}
	
	public boolean matchIntegerPair(String number) {
		String integerPair = "[(][-]?[0-9]+,[-]?[0-9]+[)]" ;
		Pattern r = Pattern.compile(integerPair) ;
		Matcher m = r.matcher(number) ; 
		return m.matches() ;
	}
	
	public boolean matchDecimal(String number) {
		String decimal = "[-]?[0-9]+([.][0-9]+)?([*]10power[0-9]+)?" ;
		Pattern r = Pattern.compile(decimal) ;
		Matcher m = r.matcher(number) ; 
		return m.matches() ;
	}
	
	public boolean matchIPv4(String ipAddress) {
		String octetPattern = "(25[0-5])|(2[0-4][0-9])|(1[0-9][0-9])|([1-9][0-9])|([1-9])" ;
		StringBuffer ipPattern = new StringBuffer(octetPattern) ;
		ipPattern.append("[.]").append(octetPattern) ;
		ipPattern.append("[.]").append(octetPattern) ;
		ipPattern.append("[.]").append(octetPattern) ;
		
		System.out.println(ipPattern) ;
		Pattern r = Pattern.compile(ipPattern.toString()) ;
		Matcher m = r.matcher(ipAddress) ;
		return m.matches() ;
	}
	
	//public boolean 
}
