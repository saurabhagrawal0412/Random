package linkedlist;

public class LinkedListMerger {
	
	static class LinkedListNode {
		int key ;
		LinkedListNode next ;
		
		LinkedListNode(int key) {
			this.key = key ;
		}
	}
	
	private LinkedListNode convertArrayToLinkedList(int[] arr) {
		if(arr.length < 1) {
			return null ;
		}
		LinkedListNode head = new LinkedListNode(arr[0]) ;
		LinkedListNode temp = head ;
		
		for(int i=1 ; i<arr.length ; i++) {
			temp.next = new LinkedListNode(arr[i]) ;
			temp = temp.next ;
		}
		return head ;
	}
	
	private void printLinkedList(LinkedListNode head) throws InterruptedException {
		while(head != null) {
			Thread.sleep(1000) ;
			System.out.println("Inside while of printLinkedList") ;
			System.out.print(head.key + " ") ;
			head = head.next ;
		}
	}
	
	private LinkedListNode mergeLinkedLists(LinkedListNode head1, LinkedListNode head2, int size) throws InterruptedException {
		if(size < 1) {
			System.out.println("Size cannot be less than 1") ;
			return null ;
		}
		
		int inc1 = 1, inc2 = 1 ;
		LinkedListNode head = null ; 
		LinkedListNode node = null ;
		while(inc1 <= size && inc2 <= size) {
			Thread.sleep(1000) ;
			System.out.println("While 1") ;
			System.out.println("Inc1 = " + inc1) ;
			System.out.println("Inc2 = " + inc2) ;
			if(inc1 > size) {
				System.out.println("If 1") ;
				node.next = head2 ;
				head2 = head2.next ;
				inc2 ++ ;
				node = node.next ;
			}
			else if(inc2 > size) {
				System.out.println("If 2") ;
				node.next = head1 ;
				head1 = head1.next ;
				inc1 ++ ;
				node = node.next ;
			}
			else {
				System.out.println("If 3") ;
				LinkedListNode nextNode = null ;

				if(head1.key <= head2.key) {
					System.out.println("If 3_1") ;
					nextNode = head1 ;
					head1 = head1.next ;
					inc1 ++ ;
				}
				else {
					System.out.println("If 3_2") ;
					nextNode = head2 ;
					head2 = head2.next ;
					inc2 ++ ;
				}

				if(head == null) {
					System.out.println("If 3_3") ;
					head = nextNode ;
					node = nextNode ;
					System.out.println("Assigning node and head to be: " + node.key) ;
				}
				else {
					System.out.println("If 3_4") ;
					System.out.println("Node's key = " + node.key) ;
					System.out.println("Next Node's key = " + nextNode.key) ;
					node.next = nextNode ;
					node = node.next ;
				}
			}
		}
		return head ;
	}
	
	public static void main(String[] args) throws InterruptedException {
		LinkedListMerger obj = new LinkedListMerger() ;
		LinkedListNode head1 = obj.convertArrayToLinkedList(new int[] {1, 3, 5}) ;
		LinkedListNode head2 = obj.convertArrayToLinkedList(new int[] {2, 4, 6}) ;
		
		LinkedListNode newHead = obj.mergeLinkedLists(head1, head2, 3) ;
		obj.printLinkedList(newHead) ;
	}

}
