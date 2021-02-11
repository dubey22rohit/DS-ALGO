package Trees;

import java.util.Scanner;

public class Tree {
	public static TreeNode<Integer> takeInputRecursive(Scanner s) {
		int n;
		System.out.println("Enter Next Node Data : ");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter The Number of Children of : " + n);
		int childCount = s.nextInt();
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> childNode = takeInputRecursive(s);
			root.children.add(childNode);
		}
		return root;
	}

	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Root Node Data : ");
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter the number of children of : " + frontNode.data);
				int numChild = s.nextInt();
				for (int i = 0; i < numChild; i++) {
					System.out.println("Enter the " + (i + 1) + " th child of " + frontNode.data);
					int childData = s.nextInt();
					TreeNode<Integer> child = new TreeNode<Integer>(childData);
					frontNode.children.add(child);
					pendingNodes.enqueue(child);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		return root;
	}

	public static void printRecursive(TreeNode<Integer> root) {
		String s = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			s += root.children.get(i).data + ",";
		}
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++) {
			printRecursive(root.children.get(i));
		}
	}

	public static int nodeCount(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < root.children.size(); i++) {
			count += nodeCount(root.children.get(i));
		}
		return count + 1;
	}

	public static int sumOfNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < root.children.size(); i++) {
			sum += sumOfNodes(root.children.get(i));
		}
		return sum + root.data;
	}

	public static int nodeWithLargestData(TreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int ans = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			int childLargest = nodeWithLargestData(root.children.get(i));
			if (childLargest > ans) {
				ans = childLargest;
			}
		}
		return ans;

	}

	public static int height(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int height = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int childHeight = height(root.children.get(i));
			if (childHeight > height) {
				height = childHeight;
			}
		}
		return height + 1;
	}

	public static void preorder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + "->");
		for (int i = 0; i < root.children.size(); i++) {
			preorder(root.children.get(i));
		}
	}

	public static void postorder(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			postorder(root.children.get(i));
		}
		System.out.print(root.data + "->");
	}

	public static void printAtK(TreeNode<Integer> root, int k) {
		if (k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}

	public static int countLeadNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.children.size() == 0) {
			return 1;
		}
		int ans = 0;
		for (int i = 0; i < root.children.size(); i++) {
			ans += countLeadNodes(root.children.get(i));
		}
		return ans;
	}

	public static boolean checkIfTreeContainsX(TreeNode<Integer> root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data == x) {
			return true;
		}
		boolean smallAns = false;
		for (int i = 0; i < root.children.size(); i++) {
			smallAns = smallAns || checkIfTreeContainsX(root.children.get(i), x);
		}
		return smallAns;
	}

	public static int numNodeGreater(TreeNode<Integer> root, int x) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		if (root.data > x) {
			count++;
		}
		for (int i = 0; i < root.children.size(); i++) {
			count += numNodeGreater(root.children.get(i), x);
		}
		return count;
	}
	
	public static boolean checkIdentical(TreeNode<Integer> root1 ,TreeNode<Integer> root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.children.size() != root2.children.size()) {
			return false;
		}
		if(root1.data.equals(root2.data)) {
			return true;
		}
		for(int i = 0;i<root1.children.size();i++) {
			if(!checkIdentical(root1.children.get(i), root2.children.get(i))) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		TreeNode<Integer> root = takeInputRecursive(s);
		TreeNode<Integer> root = takeInputLevelWise();
		printRecursive(root);
		System.out.println("Number of Nodes : " + nodeCount(root));
		System.out.println("Sum of Nodes : " + sumOfNodes(root));
		System.out.println("Largest Node : " + nodeWithLargestData(root));
		System.out.println("Height : " + height(root));
		System.out.println("Depth : ");
		printAtK(root, 2);
		System.out.println("Leaf Nodes : " + countLeadNodes(root));
		System.out.print("Preorder Traversal : ");
		preorder(root);
		System.out.println();
		System.out.print("Postorder Traversal : ");
		postorder(root);
		System.out.println();
		System.out.println("Tree Contains X : " + checkIfTreeContainsX(root, 4));
		System.out.println("Num Nodes > X : " + numNodeGreater(root, 1));
	}
}
