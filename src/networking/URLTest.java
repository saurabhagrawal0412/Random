package networking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLTest {

	public static void main(String[] args) throws Exception {
		
		String path = "http://www.the-associates.co.uk/display/displayTitle.php?id=http://www.tioer.com/css/txt&uid=123321" ;
		//String path = "/impages/filmpics/0000/0029/the_woman_fthump.jpg" ;
		
		/*URL myURL = new URL(path) ;
		System.out.println(myURL.getFile());
		System.out.println(myURL.getQuery()) ;
		
		String file = myURL.getFile() ;
		String query = myURL.getQuery() ;
		
		file = file.replaceAll("[?]"+query, "") ;
		System.out.println("File = " + file) ;*/
		
		String t1 = removeUrl(path) ;
		System.out.println("t1 = " + t1) ;
	}
	
	private static String removeUrl(String commentstr) {
		String urlPattern = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
		Pattern p = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(commentstr);
		int i = 0;
		while (m.find()) {
			commentstr = commentstr.replaceAll(m.group(i), "").trim();
			i++;
		}
		return commentstr;
	}
}
