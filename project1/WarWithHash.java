// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;
import java.util.Hashtable;


public class WarWithHash
{
	String[] s;
	int k;
	Hashtable<Integer, String> table;
	
	public WarWithHash(String[] s, int k)
	{
		this.s = s;
		this.k = k;
		this.table = new Hashtable<Integer, String>();
		
		for (String t: s) {
			table.put(hash(t), t);
		}
	}
	
	public ArrayList<String> compute2k()
	{
		ArrayList<String> t = new ArrayList<String>();
		
		for(String e : s)
		{
			for(String f : s)
			{
				if(isValid(e + f))
				{
					t.add(e + f);
				}
			}
		}
		return t;
	}
	
	private boolean isValid(String s) {
		return table.get(hash(s)) != null;
	}
	
	private int hash(String t) {
		return s.hashCode()%(s.length/2);
	}
}

