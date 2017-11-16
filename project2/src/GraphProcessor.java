// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add additional methods and fields)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;



public class GraphProcessor
{
	// other member fields and methods
	int vertices;
	ArrayList<String> vertexLookup = new ArrayList<String>();
	LinkedList<Integer> adj[];

	// NOTE: graphData should be an absolute file path
	public GraphProcessor(String graphData)
	{
		
		try {
			File file = new File(graphData);
			Scanner input = new Scanner(file);
			vertices = input.nextInt();
			adj = new LinkedList[vertices];
			input.nextLine();
			for (int i = 0; i < vertices; i++) {
				adj[i] = new LinkedList();
			}
			while(input.hasNext()) {
				String s = input.nextLine();
				String[] split = s.split("\\s+");
				
				addEdge(split[0], split[1]);
				
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printGraph() {
		for(int v = 0; v < vertices; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: adj[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
	}
	
	private void addEdge(String src, String dest) {
		// Add an edge from src to dest. 
		if (vertexLookup.indexOf(src) == -1) {
			vertexLookup.add(src);
		}
		if (vertexLookup.indexOf(dest) == -1) {
			vertexLookup.add(dest);
		}
		adj[vertexLookup.indexOf(src)].add(vertexLookup.indexOf(dest));
	}

	public int outDegree(String v)
	{
		int s = vertexLookup.indexOf(v);
		if (s == -1) {
			return -1;
		}
		return adj[s].size();
	}

	public ArrayList<String> bfsPath(String u, String v)
	{
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<String> stringPath = new ArrayList<String>();
        boolean visited[] = new boolean[vertices];
 
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        visited[vertexLookup.indexOf(u)] = true;
        queue.add(vertexLookup.indexOf(u));
        
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            int s = queue.poll();
            path.add(s);
            if (s == vertexLookup.indexOf(v)) {
            	for (int i = 0; i < path.size(); i++) {
                	stringPath.add(vertexLookup.get(path.get(i)));
                }
                return stringPath;
            }
 
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int j = i.next();
                if (!visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        
        stringPath.clear();
		return stringPath;
	}
	


	public int diameter()
	{
		// implementation
		int d = 0;
		for (String s : vertexLookup) {
			for (String t : vertexLookup) {
				ArrayList<String> path = bfsPath(s, t);
					if (path.size() > d) {
						d = path.size();
				}
			}
		}
		return d;
	}

	
	public int centrality(String v)
	{
		// implementation
		int total = 0;
		for (String s : vertexLookup) {
			for (String t : vertexLookup) {
				ArrayList<String> path = bfsPath(s, t);
				if (path.indexOf(v) != -1) {
					total++;
				}
			}
		}
		
		return total;
	}

}