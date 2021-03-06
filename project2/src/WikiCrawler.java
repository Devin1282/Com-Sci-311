// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add additional methods and fields)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	private HashMap<String, String> cache;
	
	static int requests = 0;
	
	public WikiCrawler(String seedUrl, int max, ArrayList<String> topics, String fileName)
	{
			this.max = max;
			this.seed = seedUrl;
			this.topics = topics;
			this.filename = fileName;
			this.cache = new HashMap<String, String>();
	}

	public ArrayList<String> extractLinks(String doc)
	{
		ArrayList<String> links = new ArrayList<String>();
		String[] paragraphs = doc.split("<[pP]>");
		if(paragraphs.length > 1)
		{
			doc = doc.substring(paragraphs[0].length(), doc.length() - 1);
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
		ArrayList<String> p = new ArrayList<String>();
		ArrayList<String> e = new ArrayList<String>();
		
		if(containsTopics(fetchPage(BASE_URL + seed), topics))
		{
			q.add(seed);
			p.add(seed);
		}
		
		//Get list of valid pages
		while(q.size() > 0 && p.size() < max)
		{	
			String current = q.poll();
			v.add(current);
			ArrayList<String> links = extractLinks(fetchPage(BASE_URL + current));
			for(int i = 0; i < links.size(); i++)
			{
				if(p.size() < max)
				{
					String link = links.get(i);										
					if(containsTopics(fetchPage(BASE_URL + link), topics) && !link.equals(current) && !p.contains(link))	//If each link is valid
					{
						p.add(link);
						System.out.println("Located " + p.size() + " valid links.");
					}
				}
			}			
		}
		
		//Build graph over valid pages
		for(int i = 0; i < p.size(); i++)
		{
			String link = p.get(i);
			ArrayList<String> links = extractLinks(fetchPage(BASE_URL + link));
			for(int j = 0; j < links.size(); j++)
			{
				if(p.contains(links.get(j)))
				{
					if(!e.contains(link + " " + links.get(j)))
					{
						e.add(link + " " + links.get(j));
					}
				}
			}
		}
		
		
		writeList(filename, e, p.size());
		System.out.println("Done.");
	}
	
	/*
	 * Takes a filename and Arraylist of lines of text as input and attempts to write the list to the file.
	 */
	public void writeList(String filename, ArrayList<String> contents, int vertices)
	{
		try
		{
			File f = new File(filename);
			BufferedWriter b = new BufferedWriter(new FileWriter(f));
			b.write(vertices + "");
			b.newLine();
			for(int i = 0; i < contents.size(); i++)
			{
				b.write(contents.get(i));
				b.newLine();
			}
			b.flush();
			b.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Takes an HTML page as a String and a list of topics as input. Returns true iff the page contains all topics after the first paragraph tag.
	 */
	private boolean containsTopics(String doc, ArrayList<String> topics)
	{
		String[] paragraphs = doc.split("<[pP]>");
		if(paragraphs.length > 1)
		{
			doc = doc.substring(paragraphs[0].length(), doc.length() - 1);
		}
		
		for(int i = 0; i < topics.size(); i++)
		{
			if(!doc.contains(topics.get(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Fetches the HTML of the page at the given URL as a string.
	 */
	private String fetchPage(String link)
	{
		
		
		if(cache.containsKey(link))
		{
			System.out.println("Fetching (cache) " + link);
			return cache.get(link);
		}
		else
		{
			System.out.println("Fetching (web) " + link);
			requests = requests + 1;
			if(requests % 50 == 0) { System.out.println("Pausing after " + requests + " requests."); pause(4000); }
			
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
				cache.put(link, page);
				return page;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return null;
			}
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