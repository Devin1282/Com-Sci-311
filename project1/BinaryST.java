/*This class will implement a (variant of) binary search tree that can store a multi-set of strings 
*and supports the queries described below. 
*Recall that a string may appear more than once in a multi-set.
*
*Runtime of all you methods must be O(h) (except inOrder and preOrder), where h is the height of the tree.
**/

public class BinaryST {
	int size;
	int distinctSize;

	class Node {
		Node parent, left, right;
		String data;
		int quantity;
	}

	/*Creates an empty Binary Search Tree*/
	public BinaryST() {
	}
	
	
	/*Creates a Binary Search Tree obtained by adding the elements in the order they appear in the array 's'
	 * You must NOT balance the tree.  IF a string appears L times in the array, your BST must store this information*/
	public BinaryST(String[] s) {
		for (String insert : s) {
			add(insert);
		}
	}
	
	/*Returns the number of distinct strings stored in the Tree.  
	 * If you have added "AB", "CD", "AB". then this method returns 2*/
	public int distinctSize() {
		return distinctSize;
	}
	
	/*Returns the total number of elements stored in the tree.
	 *If you have added "AB", "CD", "AB". then this method returns 3 */
	public int size() {
		return size;
	}
	
	/*Returns the current height of the tree.  Height of a tree with a single node is one.
	 * Height of an empty tree is zero*/
	public int height() {
		//TODO
		return 0;
	}
	
	/*Adds the string s to the BST. Even if s already appears in the tree, it must add s.*/
	public void add(String s) {
		//TODO
	}
	
	/*Returns true is s appears in the tree; otherwise returns false*/
	public boolean search(String s) {
		//TODO
		return false;
	}
	
	/*Returns the number of times s appears in the tree.*/
	public int frequency(String s) {
		//TODO
		return 0;
	}
	
	/*If s appears in the tree, then removes the string s from the tree and returns 
	 * true. If s does not appear in the tree, then returns false. If s appears, more than once then 
	 * remove only one occurrence*/
	public boolean remove(String s) {
		//TODO
		return false;
	}
	
	/*Returns an array of Strings obtained by doing an in-order traversal of the tree*/
	public String[] inOrder() {
		//TODO
		String[] s = new String[size];
		
		return s;
	}
	
	/*Returns an array of Strings obtained by doing an pre-order traversal of the tree.*/
	public String[] preOrder() {
		//TODO
		String[] s = new String[size];
		
		return s;
	}
	
	/*Returns number of strings that are smaller than s.*/
	public int rankOf(String s) {
		//TODO
		return 0;
	}
}