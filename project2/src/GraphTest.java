
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

}
