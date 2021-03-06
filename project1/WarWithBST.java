// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.util.ArrayList;

/**
 * 
 * @author mewray, devinj (Mason Wray, Devin Johnson)
 *
 */
public class WarWithBST extends BinaryST
{
	String[] s;
	int k;
	BinaryST b;
	
	public WarWithBST(String[] s, int k)
	{
		this.s = s;
		this.k = k;
		this.b = new BinaryST();
		
		for (String s1 : s) {
			b.add(s1);
		}
	}
	
	/**
	 * Computes all 2k-length possible substring combinations of the elements in s
	 * @return An ArrayList containing the 2k-length strings.
	 */
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
	
	/**
	 * Iterates through the given string, checking if each k-length substring is in s.
	 * @param a The string to check
	 * @return True if all k-length substrings are in the BST b, false otherwise.
	 */
	private boolean isValid(String a)
	{
		for(int i = 0; i <= k; i++)
		{
			if(!b.search(a.substring(i, i+k)))
			{
				return false;
			}
		}
		return true;
	}
	
	
}

