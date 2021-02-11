package BinaryTrees;

import java.util.Scanner;

public class TreeUse {
	public static TreeNode takeInputRecursive(Scanner s) {
		int rootData;
		System.out.println("Enter Root Data : ");
		rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		TreeNode root = new TreeNode(rootData);
		root.left = takeInputRecursive(s);
		root.right = takeInputRecursive(s);
		return root;

	}

	public static TreeNode takeInputIteratively() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root node data : ");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		TreeNode root = new TreeNode(rootData);
		QueueUsingLL<TreeNode> pendingNodes = new QueueUsingLL<TreeNode>();
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			TreeNode frontNode = null;
			try {
				frontNode = pendingNodes.dequeue();

			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Enter the left child of : " + frontNode.data);
			int leftData = s.nextInt();
			if (leftData != -1) {
				TreeNode leftChild = new TreeNode(leftData);
				pendingNodes.enqueue(leftChild);
				frontNode.left = leftChild;
			}
			System.out.println("Enter the right child of  : " + frontNode.data);
			int rightData = s.nextInt();
			if (rightData != -1) {
				TreeNode rightChild = new TreeNode(rightData);
				pendingNodes.enqueue(rightChild);
				frontNode.right = rightChild;
			}

		}
		return root;
	}

	public static void printIteratively(TreeNode root) {
		if (root == null) {
			return;
		}
		QueueUsingLL<TreeNode> pendingNodes = new QueueUsingLL<TreeNode>();
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			TreeNode front = null;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				return;
			}
			System.out.print(front.data + " ");
			if (front.left != null) {
				System.out.println(" L:" + front.left.data + " ");
				pendingNodes.enqueue(front.left);
			} else {
				System.out.println(" L: -1");
			}
			if (front.right != null) {
				System.out.println(" R:" + front.right.data + " ");
				pendingNodes.enqueue(front.right);

			}else {
				System.out.println(" R:-1");
			}
		}
	}

	public static void printBinaryTree(TreeNode root) {
		if (root == null) {
			return;
		}
		String ans = root.data + "";
		if (root.left != null) {
			ans += " L:" + root.left.data + " ";
		}
		if (root.right != null) {
			ans += " R:" + root.right.data + " ";
		}
		System.out.println(ans);
		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}
	
	public static int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int leftNodes = countNodes(root.left);
		int rightNodes = countNodes(root.right);
		return 1 + leftNodes + rightNodes;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		TreeNode root = takeInputRecursive(s);
		TreeNode root = takeInputIteratively();
//		printBinaryTree(root);
		printIteratively(root);
		System.out.println("Number of nodes : " + countNodes(root));
		s.close();
	}

}
