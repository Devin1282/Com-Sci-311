// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;
import java.util.Hashtable;


public class WarWithRollHash
{
	Hashtable s;
	int k;
	
	public WarWithRollHash(String[] s, int k)
	{
		this.s = new Hashtable<Integer, String>();
		this.k = k;
		
		for (String i : s) 
		{
			this.s.put(i.hashCode(), i);
		}
	}
	
	public ArrayList<String> compute2k()
	{
		ArrayList<String> t = new ArrayList<String>();
		return t;
	}
}

