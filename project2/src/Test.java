
public class Test {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Devin\\Documents\\ComSci311\\Com-Sci-311\\project2\\src\\wikiCC.txt";
		GraphProcessor g = new GraphProcessor(filePath);
		
		String s = g.bfsPath("/wiki/Biological_organisation", "/wiki/Lorenz_system").toString();
		System.out.println(s);
		
		int t = g.outDegree("/wiki/Attractor");
		System.out.println(t);
	}

}
