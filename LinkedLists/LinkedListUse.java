package LinkedLists;

public class LinkedListUse {

	public static void main(String[] args) {
		Linked_List_Class ll = new Linked_List_Class();
		Node<Integer> head = ll.takeinput();
//		System.out.println("List Length : " + ll.listLength(head));
//		Node<Integer> deletedNode = ll.deleteNode(head, 2);
//		ll.print(head);
//		System.out.println("Deleted node has the data : "  + deletedNode.data);
//		System.out.println("List Length : " + ll.listLength(head));
		//Node<Integer> deleteDuplicateHead = ll.deleteDuplicate(head);
		//ll.print(deleteDuplicateHead);
//		int findNode = ll.findNode(head, 2);
//		System.out.println(findNode);
		//ll.reverseLL(head);
		ll.print(ll.appendLastNtoHead(head, 3));
	}

}
