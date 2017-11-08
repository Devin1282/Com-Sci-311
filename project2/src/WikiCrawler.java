// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add additional methods and fields)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class WikiCrawler
{
	static final String BASE_URL = "https://en.wikipedia.org";
	
	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName)
	{
		try 
		{
			URL url = new URL(BASE_URL + seedUrl);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<String> extractLinks(String doc)
	{
		// implementation
		return null;
	}

	public void crawl()
	{
		// implementation
	}
}



