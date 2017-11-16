import java.util.ArrayList;

public class GraphTest {

	public static void main(String[] args) {
		String filePath = ".\\src\\wikiCC.txt";
		GraphProcessor g = new GraphProcessor(filePath);
		
		String s = g.bfsPath("/wiki/Biological_organisation", "/wiki/Lorenz_system").toString();
		System.out.println(s);
		
		int t = g.outDegree("/wiki/Attractor");
		System.out.println(t);
		
		int j = g.centrality("/wiki/Attractor");
		System.out.println("Centrality of Attractor:"+j);
		
		int r = g.diameter();
		System.out.println("Diameter of Graph: "+r);
	}

	
	public static void reportTest() {
		//Define Crawler parameters
		String s = "/wiki/Computer_Science";
		int m = 200;
		ArrayList<String> t = new ArrayList<String>();
		String o = ".\\src\\WikiCS.txt";
		
		//Construct Crawler
		WikiCrawler c = new WikiCrawler(s, m, t, o);
		
		GraphProcessor g = new GraphProcessor(o);
		String largestOutDegree = g.largestOutDegree();
		System.out.println("Largest OutDegree = "+largestOutDegree);
		
		String largestCentrality = g.largestCentrality();
		System.out.println("Largest Centrality = "+largestCentrality);
		
		System.out.println("Diameter = "+g.diameter());
		
	}
}
