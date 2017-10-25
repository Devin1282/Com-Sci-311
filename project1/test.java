import java.util.Arrays;
import java.util.Random;

public class test extends BinaryST {

	public static void main(String[] args) {
		
		
		int k = 4;
		//String[] s = generate(k);
		String[] s = new String[] {"ACGT", "AGTC", "AAGT", "GCGT", "ACAA", "GTGT", "ACGT", "ACCT", "ACTT", "GTAT", "CCCC", "CTTA", "CGTA", "TGAC", "GTAC", "TACG"};
		//System.out.println(Arrays.toString(s));
		
		
		//testBinaryST(s);
		testWarWithArray(s, k);
		testWarWithBST(s, k);
		testWarWithHash(s, k);
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
				

	}
	
	public static void testWarWithArray(String[] s, int k) {
		WarWithArray war = new WarWithArray(s, k);
		String r = Arrays.toString(war.compute2k().toArray());
		System.out.println(r);
	}
	
	
	public static void testWarWithBST(String[] s, int k) {
		WarWithBST war = new WarWithBST(s, k);
		String r = Arrays.toString(war.compute2k().toArray());
		System.out.println(r);
	}
	
	public static void testWarWithHash(String[] s, int k) {
		WarWithHash war = new WarWithHash(s, k);
		String r = Arrays.toString(war.compute2k().toArray());
		System.out.println(r);
	}
	
	public static void testWarWithRollHash(String[] s, int k) {
		WarWithRollHash war = new WarWithRollHash(s, k);
		String r = Arrays.toString(war.compute2k().toArray());
		System.out.println(r);
	}

}
