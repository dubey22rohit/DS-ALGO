package LinkedLists;
import java.util.Scanner;
public class Linked_List_Class {
public static void print(Node<Integer> head) {
	while(head!=null) {
		System.out.print(head.data);
		head = head.next;
	}
}
public static Node<Integer> takeinput() {
	Node<Integer> head = null,tail = null;
	Scanner s = new Scanner(System.in);
	int data = s.nextInt();
	while(data != -1) {
		Node<Integer> newNode = new Node<Integer>(data);
		if(head  == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = tail.next;
		}
		data = s.nextInt();
	}
	return head;
	
}
public static int listLength(Node<Integer> head) {
	int length = 0;
	while(head.next != null) {
		head = head.next;
		length++;
	}
	return length + 1;
}
public static void addNode(Node<Integer> prevNode , int data) {
	if(prevNode == null) {
		System.out.println("cannot be null");
	}
	Node<Integer> newNode = new Node<Integer>(data);
	newNode.next = prevNode.next;
	prevNode.next = newNode;
	
}
public static Node<Integer> deleteNode(Node<Integer> head , int pos){
	//Assumes that linked list start with index 0.
	if(head == null) {
		return null;
	}
	Node<Integer> temp = head;
	for(int i = 1;i<pos;i++) {
		temp = temp.next;
	}
	Node<Integer> deletedNode = new Node<Integer>(temp.next.data);
	temp.next = temp.next.next;
	return deletedNode;
	
}
public static Node<Integer> deleteDuplicate(Node<Integer> head){
	//Assumes LL to be sorted
	if(head == null) {
		return null;
	}
	Node<Integer> t1 = head;
	Node<Integer> t2 = head.next;
	while(t2 != null) {
		if(t1.data.equals(t2.data)) {
			t1.next = t2.next;
			t2 = t2.next;
		}else {
			t2 = t2.next;
			t1 = t1.next;
		}
	}
	return head;
}
public static int findNode(Node<Integer> head,int n) {
	//Returns the number of node which contains the data 'n'
	//Assumes LL to start from 0
	if(head == null) {
		return -1;
	}
	int count = 0;
	while(head.data != n) {
		head = head.next;
		count++;
	}
	return count;
}
public static void reverseLL(Node<Integer> head){
	if(head == null) {
		return;
	}
	reverseLL(head.next);
	System.out.print(head.data + " ");
}
public static Node<Integer> appendLastNtoHead(Node<Integer> head,int n) {
	if(n==0 || head == null){
        return head;
    }
	int length = listLength(head);
	Node<Integer> temp = head;
	for(int i = 1;i<length - n;i++) {
		temp = temp.next;
	}
	
	Node<Integer> newHead = temp.next;
	Node<Integer> tempNewHead = newHead;
	temp.next = null;
	while(tempNewHead.next != null) {  
		tempNewHead = tempNewHead.next;
	}
	tempNewHead.next = head;
	return newHead;
			
}
public static Node<Integer> midPoint(Node<Integer> head){
	if(head == null) {
		return head;
	}
	Node<Integer> temp = head;
	Node<Integer> ans = null;
	int len = listLength(head);
	if(len % 2 == 0) {
		for(int i = 0 ; i< len/2;i++) {
			temp = temp.next;
		}
		ans = temp;

	}else {
		for (int i = 0; i < (len/2 + 1); i++) {
			temp = temp.next;
			
		}
		ans = temp;
	}
	return ans;
}

}
