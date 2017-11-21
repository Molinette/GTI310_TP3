package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import data.Graph;

/**
 * The ConcreteParser class parse a text file from which it creates a graph
 * 
 * @author Marc-Alexandre Monette Molina
 * @version 1, 20/11/2017
 * 
 */
public class ConcreteParser implements Parser<Graph> {
	final String FORMAT_EDGE = "^\\d+\\t\\d+\\t\\d+$"; //Regex for each edge format in the text file
	final String FORMAT_VERTEX = "^\\d+$"; //Regex for starting vertex and number of vertex formats
	final String FORMAT_TAB = "\\t"; //Regex for splitting between edge info
	
	/**
	 * Validate a text file format, proceed to parse it and create a Graph from it
	 * 
	 * @param filename		The location and name of the text file to parse
	 * @return				The graph created from the text file
	 * 
	 */
	@Override
	public Graph parse(String filename) 
	{
		Graph graph = null;
		int nbVertices = 0; //number of vertices in the graph
		int startingVertex = 0; //starting vertext of the graph for searching
		
		String[] splitLine;
		try{
			FileReader fileReader = new FileReader(new File(filename));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//Read the number of vertices and verify the format
			String line = bufferedReader.readLine(); 
			if (line.matches(FORMAT_VERTEX))
				nbVertices = Integer.parseInt(line);
			
			//Read the starting vertex and verify the format
			line = bufferedReader.readLine();
			if (line.matches(FORMAT_VERTEX))
				startingVertex = Integer.parseInt(line);
			
			graph = new Graph(nbVertices, startingVertex);
			
			//Verify edges format and add them to the graph
			while(line.compareTo("$") != 0){
				if(line.matches(FORMAT_EDGE)){
					splitLine = line.split(FORMAT_TAB);
					
					int src = Integer.parseInt(splitLine[0]);
					int dest = Integer.parseInt(splitLine[1]);
					int cost = Integer.parseInt(splitLine[2]);
					
					graph.addEdge(src-1, dest-1, cost);
				}
				
				line = bufferedReader.readLine();
			}
			
			bufferedReader.close();
		}
		catch(Exception e){
			
		}
		
		return graph;
	}

}
