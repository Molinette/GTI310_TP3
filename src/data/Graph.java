package data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The Graph class creates a graph containing informations about it's vertices and starting vertex. 
 * It also contains basic methods like access to a vertex neighbours and the adding of edges. 
 * 
 * @author Marc-Alexandre Monette Molina
 * @version 1, 20/11/2017
 * 
 */

public class Graph {
	
	private ArrayList<LinkedList<Edge>> vertices; //liste containing every vertices
	private int startingVertex; //the graph starting vertex for searches
	private int nbVertices; //number of vertices in the graph
	
	/**
	 * Constructor
	 * 
	 * @param nbVertices		The number of vertices in the graph
	 * @param starting vertex	The starting vertex of the graph
	 * 
	 */
	public Graph(int nbVertices, int startingVertex){
		this.nbVertices = nbVertices;
		vertices = new ArrayList<LinkedList<Edge>>(nbVertices);
		for(int i = 0; i < nbVertices; i++){
			vertices.add(i, new LinkedList<Edge>());
		}
	}
	
	//Inner class containing informations about edges attached to vertices like the end vertex and the cost of the edge.
	public class Edge{
		public int vertex; //vertex at the end of the edge
		public int cost; //cost of an edge
		
		public Edge(int dest, int cost){
			this.vertex = dest;
			this.cost = cost;
		}
		
		//Getters and setters
		public int getVertex(){
			return vertex;
		}
		
		public int getCost(){
			return cost;
		}
	}
	
	/**
	 * Add an edge to a vertex
	 * 
	 * @param src		The vertex at the start of the edge (which vertex from the vertices list to add the edge to)
	 * @param dest		The vertex at the end of the edge (which vertex is being attached to the start vertex)
	 * @param cost		The edge cost
	 * 
	 */
	public void addEdge(int src, int dest, int cost){
		vertices.get(src).add(new Edge(dest, cost));
	}
	
	/**
	 * Get a vertex's neighbours
	 * 
	 * @param vertex		The vertex from which we want the neighbours 
	 * @return				A list of edges connecting to the neighbours
	 * 
	 */
	public LinkedList<Edge> getNeighbours(int vertex){
		return vertices.get(vertex);
	}
	
	//Getters and Setters
	public int getStartingVertex(){
		return startingVertex;
	}
	
	public int getNbVertices(){
		return nbVertices;
	}
}
