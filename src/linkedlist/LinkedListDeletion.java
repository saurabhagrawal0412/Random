package linkedlist;
import java.util.* ;
public class LinkedListDeletion {
	public static void main(String[] args) {
		LinkedListDeletion lld = new LinkedListDeletion() ;
		MyLinkedList head = lld.insertData() ;
		lld.traverseList(head) ;
		head = lld.deleteNum(head, 1) ;
		lld.traverseList(head) ;
	}
	
	MyLinkedList insertData() {
		MyLinkedList head = new MyLinkedList(1) ;
		MyLinkedList curr = head ;
		Random rand = new Random() ;
		for(int i=0 ; i<50 ; i++) {
			MyLinkedList temp = new MyLinkedList(rand.nextInt(3)) ;
			curr.next = temp ;
			curr = curr.next ;
		}
		return head ;
	}
	
	void traverseList(MyLinkedList head) {
		System.out.println("Printing list") ;
		while(head != null) {
			System.out.println(head.data) ;
			head = head.next ;
		}
	}
	
	MyLinkedList deleteNum(MyLinkedList head, int num) {
		MyLinkedList curr = head, prev = null ;
		while(curr != null) {
			if(curr.data == num) {
				if(curr == head) {
					head = head.next ;
				}
				else {
					prev.next = curr.next ;
					curr = curr.next ;
					continue ;
				}
			}
			prev = curr ;
			curr = curr.next ;
		}
		return head ;
	}
}

class MyLinkedList {
	int data ;
	MyLinkedList next ;
	
	MyLinkedList(int data) {
		this.data = data ;
	}
}