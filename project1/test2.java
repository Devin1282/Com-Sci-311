import java.util.ArrayList;
import java.util.Arrays;

public class test2 {

	static String u = "ATGACCATT";
	static int k = 3;
	static String[] s;
	
	public static void main(String[] args) 
	{
		System.out.println("u: " + u);
		s = toArray(subsets(u, k));
		printArray(s, "s: ");
		
		WarWithArray a = new WarWithArray(s, k);
		WarWithBST b = new WarWithBST(s, k);
		WarWithHash c = new WarWithHash(s, k);
		WarWithRollHash d = new WarWithRollHash(s, k);
		
		String[] ra = toArray(a.compute2k()); Arrays.sort(ra);
		String[] rb = toArray(b.compute2k()); Arrays.sort(rb);
		String[] rc = toArray(c.compute2k()); Arrays.sort(rc);
		String[] rd = toArray(d.compute2k()); Arrays.sort(rd);
		
		printArray(ra, "a: ");
		printArray(rb, "b: ");
		printArray(rc, "c: ");
		printArray(rd, "d: ");
	}
	
	private static ArrayList<String> subsets(String s, int k)
	{
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i <= s.length() - k; i++)
		{
			list.add(s.substring(i, i + k));
		}
		return list;
	}
	
	private static String[] toArray(ArrayList<String> list)
	{
		String[] slist = new String[list.size()];
		for(int i = 0; i < list.size(); i++)
		{
			slist[i] = list.get(i);
		}
		return slist;
	}
	
	private static void printArray(String[] arr, String tag)
	{
		System.out.print(tag);
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]);
			if(i < arr.length - 1) { System.out.print(", "); }
		}
		System.out.println();
	}
}
