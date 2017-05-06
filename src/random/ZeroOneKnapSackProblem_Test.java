package random;

public class ZeroOneKnapSackProblem_Test {

	public static void main(String[] args) {
		ZeroOneKnapSackProblem_Test obj = new ZeroOneKnapSackProblem_Test() ;
		Item[] items = obj.fillInputValues() ;
		ZeroOneKnapSackProblemSolver solver = new ZeroOneKnapSackProblemSolver() ;
		int maxValue = solver.findMaxValue(items, 10) ;
		System.out.println(maxValue) ;
	}
	
	private Item[] fillInputValues() {
		Item[] items = new Item[6] ;
		items[0] = new Item(4,6) ;
		items[1] = new Item(2,4) ;
		items[2] = new Item(3,5) ;
		items[3] = new Item(1,3) ;
		items[4] = new Item(6,9) ;
		items[5] = new Item(4,7) ;
		return items ;
	}
}

class ZeroOneKnapSackProblemSolver {
	int findMaxValue(Item[] items, int maxWeight) {
		int itemCount = items.length ;
		int[][] table = new int[itemCount][maxWeight+1] ;
		
		int currWt, currVal, totVal, prevVal ;
		for(int row=0 ; row<table.length ; row++) {
			currWt = items[row].weight ;
			currVal = items[row].value ;
			
			for(int col=0 ; col<table[0].length ; col++) {
				if(row == 0) {
					if(col >= currWt)
						table[0][col] = currVal ;
				}
				else {
					prevVal = table[row-1][col] ;
					if(col < currWt)
						table[row][col] = prevVal ;
					else {
						totVal = currVal + table[row-1][col-currWt] ;
						if(totVal > prevVal)
							table[row][col] = totVal ;
						else
							table[row][col] = prevVal ;
					}
				}
			}
		}
		displayTable(table) ;
		return table[itemCount-1][maxWeight] ;
	}

	private void displayTable(int[][] table) {
		StringBuffer buff = new StringBuffer() ;
		for(int row=0 ; row<table.length ; row++) {
			for(int col=0 ; col<table[0].length ; col++) {
				buff.append(table[row][col]) ;
				buff.append("\t") ;
			}
			System.out.println(buff) ;
			buff = new StringBuffer() ;
		}
	}
}

class Item {
	int weight ;
	int value ;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}