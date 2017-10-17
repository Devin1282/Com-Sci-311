/**This class will implement a (variant of) binary search tree that can store a multi-set of strings 
*and supports the queries described below. 
*Recall that a string may appear more than once in a multi-set.
*
*Runtime of all you methods must be O(h) (except inOrder and preOrder), where h is the height of the tree.
**/

public class BinaryST {
	private Node root;
	int size;
	int distinctSize;

	class Node {
		Node parent, left, right;
		String data;
		int quantity;
		int size;       //number of nodes in its subtrees
		
		public Node(String s, int size) {
            this.data = s;
            this.size = size;
            this.quantity = 1;
        }
	}

	/*Creates an empty Binary Search Tree*/
	public BinaryST() {
	}
	
	
	/**Creates a Binary Search Tree obtained by adding the elements in the order they appear in the array 's'
	 * You must NOT balance the tree.  If a string appears L times in the array, your BST must store this information*/
	public BinaryST(String[] s) {
		this.size = s.length;
		for (String insert : s) {
			add(insert);
		}
	}
	
	/**
     * Returns the value associated with the given key.
     */
    public Node get(String s) {
        return get(root, s);
    }

    private Node get(Node n, String s) {
        if (s == null) throw new IllegalArgumentException("calls get() with a null key");
        if (n == null) return null;
        int cmp = s.compareTo(n.data);
        if (cmp < 0) {
        	return get(n.left, s);
        } else if (cmp > 0) {
        	return get(n.right, s);
        } else {
        	return n;
        }
    }
	
	/**Returns the number of distinct strings stored in the Tree.  
	 * If you have added "AB", "CD", "AB". then this method returns 2*/
	public int distinctSize() {
		return distinctSize;
	}
	
	/**Returns the total number of elements stored in the tree.
	 *If you have added "AB", "CD", "AB". then this method returns 3 */
	public int size() {
		return size(root);
	}

    
    private int size(Node n) {
        if (n == null) return 0;
        else return n.size;
    }
	
	/**Returns the current height of the tree.  Height of a tree with a single node is one.
	 * Height of an empty tree is zero*/
    public int height() {
        return height(root);
    }
    private int height(Node n) {
        if (n == null) {
        	return 0;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }
	
	/**Adds the string s to the BST. Even if s already appears in the tree, it must add s.*/
    public void add(String s) {
        if (s == null) throw new IllegalArgumentException("called put() with a null parameter");
        size++;
		if (get(s) != null) {
			distinctSize++;
		}
        root = add(root, s);
    }

    private Node add(Node n, String s) {
        if (n == null) return new Node(s, 1);
        int cmp = s.compareTo(n.data);
        if (cmp < 0) {
        	n.left  = add(n.left,  s);
        } else if (cmp > 0) {
        	n.right = add(n.right, s);
        } else {
        	n.quantity++;
        }
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }
	
	/**Returns true is s appears in the tree; otherwise returns false*/
	public boolean search(String s) {
		if (get(s) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**Returns the number of times s appears in the tree.*/
	public int frequency(String s) {
		if (get(s) != null) {
			return get(s).quantity;
		} else {
			return 0;
		}
	}
	
	/**If s appears in the tree, then removes the string s from the tree and returns 
	 * true. If s does not appear in the tree, then returns false. If s appears, more than once then 
	 * remove only one occurrence*/	
	public boolean remove(String s) {
        if (s == null) {
        	throw new IllegalArgumentException("calls delete() with a null key");
        }
        if (!search(s)) {
        	return false; 
        } else {
        	root = remove(root, s);
        	return true;
        }
        

    }

    private Node remove(Node n, String s) {
        if (n == null) {
        	return null;
        }

        int cmp = s.compareTo(n.data);
        if (cmp < 0) {
        	n.left  = remove(n.left,  s);
        } else if (cmp > 0) {
        	n.right = remove(n.right, s);
        } else { 
            if (n.right == null) {
            	return n.left;
            }
            if (n.left  == null) {
            	return n.right;
            }
            Node t = n;
            n = min(t.right);
            n.right = removeMin(t.right);
            n.left = t.left;
        } 
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }
    
    private Node removeMin(Node n) {
        if (n.left == null) return n.right;
        n.left = removeMin(n.left);
        n.size = size(n.left) + size(n.right) + 1;
        return n;
    }
    
    private Node min(Node n) { 
        if (n.left == null) {
        	return n; 
        } else {
        	return min(n.left); 
        }
    }
	
	/**Returns an array of Strings obtained by doing an in-order traversal of the tree*/
	public String[] inOrder() {
		String[] s = new String[size];
		inOrder(root, s, 0);
		return s;
	}
	
	public void inOrder(Node n, String[] s, int index) {
		if(n == null) {
			return;
		}
	    inOrder(n.left, s, index);   
	    s[index++]= n.data;          
	    inOrder(n.right, s, index);  
	}
	
	/**Returns an array of Strings obtained by doing an pre-order traversal of the tree.*/
	public String[] preOrder() {
		String[] s = new String[size];
		inOrder(root, s, 0);
		return s;
	}
	
	public void preOrder(Node n, String[] s, int index) {
		if(n == null) {
			return;
		}
		s[index++]= n.data;         
	    preOrder(n.left, s, index);   
	    preOrder(n.right, s, index);  
	}
	
	/**Returns number of strings that are smaller than s.*/
    public int rankOf(String s) {
        if (s == null) throw new IllegalArgumentException("argument to rank() is null");
        return rankOf(s, root);
    } 

    private int rankOf(String s, Node n) {
        if (n == null) return 0; 
        int cmp = s.compareTo(n.data); 
        if      (cmp < 0) return rankOf(s, n.left); 
        else if (cmp > 0) return 1 + size(n.left) + rankOf(s, n.right); 
        else              return size(n.left); 
    } 
	
}