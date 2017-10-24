import java.util.Arrays;
import java.util.Random;

public class test extends BinaryST {

	public static void main(String[] args) {
		
		
		int k = 4;
		String[] s = generate(k);
		System.out.println(Arrays.toString(s));
		
		
		testBinaryST(s);
		//testWarWithBST(s, k);
		//testWarWithHash(s, k);
		//testWarWithRollHash(s, k);
		

	}
	
	public static String[] generate(int k) {
		String[] letters = new String[] {"A", "T", "G", "C"};
		String[] s = new String[100];
		
		Random rand = new Random();		
		for (int i = 0; i < s.length; i++) {
			String t = "";
			for (int j = 0; j < k; j++) {
				t = t.concat(letters[rand.nextInt(4)]);
			}
			s[i] = t;
		}
		
		return s;
	}
	
	public static void testBinaryST(String[] s) {
		BinaryST tree = new BinaryST();
		
		for (String t : s) {
			tree.add(t);
		}
		
		
		String[] inOrder = tree.inOrder();
		
//		for (String r : inOrder) {
//			System.out.println(r);
//		}
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
