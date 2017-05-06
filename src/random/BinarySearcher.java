package random;

public class BinarySearcher {

	public static void main(String[] args) {
		BinarySearcher searcher = new BinarySearcher() ;
		int[] input = {1, 4, 7, 10, 11, 15, 18, 20, 23, 30} ;
		int index = searcher.performBinarySearch(input, 35, 0, input.length-1) ;
		System.out.println("index = " + index) ;
	}
	
	private int performBinarySearch(int[] input, int num, int low, int high) {
		if(low > high)
			return -1 ;
		int mid = (high + low) / 2 ;
		System.out.println("Mid = " + input[mid]) ;
		if(input[mid] < num)
			return performBinarySearch(input, num, mid+1, high) ;
		else if(input[mid] > num)
			return performBinarySearch(input, num, low, mid+1) ;
		else
			return input[mid] ;
	}
}
