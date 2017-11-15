// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;


/**
 * 
 * @author mewray, devinj (Mason Wray, Devin Johnson)
 *
 */
public class WarWithRollHash
{
	Hashtable<Integer, String> s;
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
	
	/**
	 * Iterates through the given string, checking if each k-length substring is in s.
	 * @param a The string to check
	 * @return True if all k-length substrings are in s, false otherwise.
	 */
	public ArrayList<String> compute2k()
	{
		ArrayList<String> t = new ArrayList<String>();
		
		Set<Integer> keys = s.keySet();
		for(Integer e : keys)
		{
			for(Integer f : keys)
			{
				if(isValid(s.get(e) + s.get(f)))
				{
					t.add(s.get(e) + s.get(f));
				}
			}
		}
		return t;
	}
	
	/**
	 * Iterates through the given string, checking if each k-length substring is in s.
	 * @param a The string to check
	 * @return True if all k-length substrings are in s, false otherwise.
	 */
	private boolean isValid(String a) 
	{
		int hash = a.substring(0, k).hashCode();
		for(int i = 0; i < k; i++)
		{
			Character toRem = a.charAt(i);
			Character toAdd = a.charAt(i + k);
			hash = (int) ((hash - (toRem.hashCode() * Math.pow(31, k - 1))) * 31) + toAdd.hashCode();
			if(s.get(hash) == null)
			{
				return false;
			}
		}
		return true;
	}
}

