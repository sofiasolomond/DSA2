package dsalabsolution;

import java.util.ArrayList;

public class LongestPath {
	// Java program to print Longest Path from root to leaf in a Binary tree

	// Binary tree node
	static class Node {
		Node left;
		Node right;
		int data;
	};

	// Function to create a new Binary node
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	// Recursive function to find and return the longest path
	public static ArrayList<Integer> longestPath(Node root) {

		// If root is null there is no binary tree so
		// return a empty list
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		// Recursive call on root.right
		ArrayList<Integer> rightArrayList = longestPath(root.right);

		// Recursive call on root.left
		ArrayList<Integer> leftArrayList = longestPath(root.left);

		// Compare the size of the two ArrayList
		// and insert current node accordingly
		if (rightArrayList.size() < leftArrayList.size()) {
			leftArrayList.add(root.data);
		} else {
			rightArrayList.add(root.data);
		}

		// Return the appropriate ArrayList
		return (leftArrayList.size() > rightArrayList.size() ? leftArrayList : rightArrayList);
	}

	// Driver Code
	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> outputList = longestPath(root);
		int lengthOfOutput = outputList.size();

		System.out.print("The longest path of the tree is :  ");
		System.out.print(outputList.get(lengthOfOutput - 1));
		for (int i = lengthOfOutput - 2; i >= 0; i--) {
			System.out.print(" -> " + outputList.get(i));
		}
	}
}