package Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeNode<T> {
public T data;
public ArrayList<TreeNode<T>> children;
public TreeNode(T data) {
	children = new ArrayList<TreeNode<T>>();
}
public TreeNode<Integer> takeinput(Scanner s){
	int n;
	System.out.println("Enter next node data");
	n = s.nextInt();
	TreeNode<Integer> root = new TreeNode<Integer>(n);
	System.out.println("Enter the number of children of " + n);
	int childCount = s.nextInt();
	for(int i = 0;i<childCount;i++) {
		TreeNode<Integer> child = takeinput(s);
		root.children.add(child);
		
	}
	
	return root;
	
}

}
