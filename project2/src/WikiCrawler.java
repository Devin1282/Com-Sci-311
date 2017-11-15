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
		ArrayList<String> g = new ArrayList<String>();
		int pages = 0;
		
		q.add(seed);
		
		while(q.size() > 0 && pages < this.max)
		{
			if(v.size() % 50 == 0) { pause(4000); }		
			String current_link = q.poll();
			String current_content = fetchPage(BASE_URL + current_link);
			ArrayList<String> current_links = extractLinks(current_content);
			v.add(current_link);
			
			if(containsTopics(current_content, topics))
			{
				//Increment number of vertices in graph
				pages = pages + 1;
				
				//Add edges to graph, and links to queue
				for(int i = 0; i < current_links.size(); i++)
				{
					
				}				
			}
		}
	}
	
	/*
	 * Takes a filename and Arraylist of lines of text as input and attempts to write the list to the file.
	 */
	public void writeList(String filename, ArrayList<String> contents)
	{
		try
		{
			File f = new File(filename);
			BufferedWriter b = new BufferedWriter(new FileWriter(f));
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
		return false;
	}
	
	/*
	 * Fetches the HTML of the page at the given URL as a string.
	 */
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