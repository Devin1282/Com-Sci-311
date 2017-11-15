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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WikiCrawler
{
	static final String BASE_URL = "https://en.wikipedia.org";
	private URL seed;
	private int max;
	
	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName)
	{
		try
		{
			
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		this.max = max;
		this.seed = new URL(BASE_URL + seedUrl);
	}

	public ArrayList<String> extractLinks(String doc)
	{
		ArrayList<String> links = new ArrayList<String>();
		if(doc.split("<[pP]>").length > 1)
		{
			doc = doc.split("<[pP]>")[1];
		}
		
		Pattern p = Pattern.compile("\"/wiki/.+?\"");
		Matcher m = p.matcher(doc);
		while(m.find())
		{
			String link = doc.substring(m.start() + 1, m.end() - 1);
			if(!link.contains(":") && !link.contains("#"))
			{
				links.add(link);
			}
		}
		return links;
	}

	public void crawl()
	{
		// implementation
	}
	
	private boolean containsTopics(String doc, ArrayList<String> topics)
	{
		return false;
	}
	
	private String fetchPage(String link)
	{
		return null;
	}
}