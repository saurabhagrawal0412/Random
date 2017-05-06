package linkedlist;

import java.util.Stack;

public class LinkedListReverseSum {

	static class LinkedListNode {
		int key ;
		LinkedListNode next ;
		LinkedListNode(int key) {
			this.key = key ;
		}
	}

	private int calculateSum(LinkedListNode head1, LinkedListNode head2) {
		Stack<Integer> stack1 = new Stack<>() ;
		Stack<Integer> stack2 = new Stack<>() ;

		LinkedListNode temp1 = head1 ;
		LinkedListNode temp2 = head2 ;

		while(temp1 != null) {
			stack1.push(temp1.key) ;
			temp1 = temp1.next ;
		}

		while(temp2 != null) {
			stack2.push(temp2.key) ;
			temp2 = temp2.next ;
		}

		int sum = 0, factor = 1 ;
		while(!stack1.isEmpty() || !stack2.isEmpty() ) {
			int val1 = 0, val2 = 0 ;

			if(!stack1.isEmpty()) {
				val1 = stack1.pop() ;
			}
			if(!stack2.isEmpty()) {
				val2 = stack2.pop() ;
			}
			sum += (val1 + val2) * factor ;
			factor *= 10 ;
		}
		return sum ;
	}

	public static void main(String[] args) {
		LinkedListReverseSum obj = new LinkedListReverseSum() ;
		LinkedListNode head1 = new LinkedListNode(5) ;
		head1.next = new LinkedListNode(6) ;
		LinkedListNode head2 = new LinkedListNode(1) ;
		//head2.next = new LinkedListNode(2) ;

		int sum = obj.calculateSum(head1, head2) ;
		System.out.println("Sum = " + sum) ;
	}
}
