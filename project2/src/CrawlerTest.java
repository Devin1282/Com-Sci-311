import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CrawlerTest 
{

	public static void main(String[] args) 
	{
		//Define Crawler parameters
		String s = "/wiki/Iowa_State_University";
		int m = 100;
		ArrayList<String> t = new ArrayList<String>();
		String o = "output.txt";
		
		//Construct Crawler
		WikiCrawler c = new WikiCrawler(s, m, t, o);
		
		//Run Tests
		System.out.println(loadFile("./src/test.txt"));
		
	}
	
	/*
	 * Attempts to load the given file into a string and return it.
	 */
	public static String loadFile(String filename)
	{
		String file = "";
		try
		{
			File f = new File(filename);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = null;
			while ((line = br.readLine()) != null)
			{
				file = file + line + System.lineSeparator();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return file;
	}
}
