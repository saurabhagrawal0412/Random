package linkedlist;

public class LinkedListLoopFinder {

	public static void main(String[] args) {
		LinkedListLoopFinder obj = new LinkedListLoopFinder() ;
		LinkedListNode head = obj.constructInput() ;
		LinkedListNode loopStart = obj.findLoopStart(head) ;
		
		if(loopStart == null) {
			System.out.println("No loop") ;
		}
		else {
			System.out.println("Loop starts at " + loopStart.key) ;
		}
	}

	private LinkedListNode constructInput() {
		LinkedListNode head = new LinkedListNode(1) ;
		LinkedListNode node1 = head ;
		
		for(int i=2 ; i<=10 ; i++) {
			System.out.println(node1.key) ;
			node1.next = new LinkedListNode(i) ;
			node1 = node1.next ;
		}
		
		LinkedListNode node2 = node1 ;
		for(int i=11 ; i<=14 ; i++) {
			System.out.println(node2.key) ;
			node2.next = new LinkedListNode(i) ;
			node2 = node2.next ;
		}
		node2.next = node1 ;
		
		return head ;
	}

	private LinkedListNode findLoopStart(LinkedListNode head) {
		LinkedListNode fast = head ;
		LinkedListNode slow = null ;
		
		while(slow != fast) {
			if(slow == null) {
				slow = head ;
			}
			slow = slow.next ;
			fast = fast.next ;
			if(fast != null) {
				fast = fast.next ;
			}
			if(fast == null) {
				//Reached the end, there is no loop. Returning null
				return null ;
			}
		}
		LinkedListNode slow2 = head ;
		while(slow2 != slow) {
			slow2 = slow2.next ;
			slow = slow.next ;
		}
		return slow ;
	}
}
