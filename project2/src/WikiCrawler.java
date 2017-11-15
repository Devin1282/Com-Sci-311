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
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WikiCrawler
{
	static final String BASE_URL = "https://en.wikipedia.org";
	private String seed;
	private int max;
	private ArrayList<String> topics;
	private String filename;
	
	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName)
	{
			this.max = max;
			this.seed = seedUrl;
			this.topics = topics;
			this.filename = fileName;
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
		Queue<String> q = new LinkedList<String>();;
		ArrayList<String> v = new ArrayList<String>();
		
		q.add(seed);
		v.add(seed);
		
		extractLinks(fetchPage(BASE_URL + seed));
		
		while(q.size() > 0 && v.size() < this.max)
		{
			if(v.size() % 50 == 0) { pause(4000); }			
		}
	}
	
	private boolean containsTopics(String doc, ArrayList<String> topics)
	{
		return false;
	}
	
	private String fetchPage(String link)
	{
		
		try
		{
			URL url = new URL(link);
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String page = "";
			String line = null;
			while ((line = br.readLine()) != null)
			{
				page = page + line + System.lineSeparator();
			}
			return page;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Suspends the thread for the given number of milliseconds.
	 */
	private void pause(int millis)
	{
		try 
		{
			Thread.sleep(millis);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}