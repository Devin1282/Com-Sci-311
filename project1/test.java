public class test extends BinaryST {

	public static void main(String[] args) {
		
		testBinaryST();
		
		String[] s = new String[] {"ACGT", "CCGT", "GGCT", "CAGT", "GTTA", "AAAT", "GTTC"};
		int k = 4;
		
		testWarWithBST(s, k);
		testWarWithHash(s, k);
		testWarWithRollHash(s, k);
		

	}
	
	public static void testBinaryST() {
		BinaryST tree = new BinaryST();
		
		tree.add("AGCT");
		tree.add("ACCC");
		tree.add("ACCC");
		tree.add("TGCT");
		
		System.out.println("Tree Root:" +tree.root.data);
		System.out.println("Tree Left:" +tree.root.left.data);
		System.out.println("Tree Right:" +tree.root.right.data);
		
		String[] inOrder = tree.inOrder();
		
		for (String s : inOrder) {
			System.out.println(s);
		}
	}
	
	public static void testWarWithBST(String[] s, int k) {
		//TODO
	}
	
	public static void testWarWithHash(String[] s, int k) {
		//TODO
	}
	
	public static void testWarWithRollHash(String[] s, int k) {
		//TODO
	}

}
