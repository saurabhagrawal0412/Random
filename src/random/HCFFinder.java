package random;

public class HCFFinder {

	public static void main(String[] args) {
		int hcf = findHCF(22, 40) ;
		System.out.println("hcf = " + hcf) ;
	}

	static int findHCF(int a, int b) {
		
		int bigger = (a>b) ? a : b ;
		int smaller = (a<b) ? a : b ;
		
		int hcf = smaller ;
		
		while(bigger%smaller != 0) {
			hcf = bigger%smaller ;
			bigger = smaller ;
			smaller = hcf ;
		}
		return hcf ;
	}
}
