package data;

import java.util.ArrayList;
import java.util.LinkedList;

public class Network {
	
	private ArrayList<LinkedList<Edge>> graph;
	private int startingVertex;
	private int nbVertices;
	
	public class Edge{
		public int vertex;
		public int cost;
		
		public Edge(int dest, int cost){
			this.vertex = dest;
			this.cost = cost;
		}
		
		public int getVertex(){
			return vertex;
		}
		
		public int getCost(){
			return cost;
		}
	}

	public Network(int nbVertices, int startingVertex){
		this.nbVertices = nbVertices;
		graph = new ArrayList<LinkedList<Edge>>(nbVertices);
		for(int i = 0; i < nbVertices; i++){
			graph.add(i, new LinkedList<Edge>());
		}
	}
	
	public int getStartingVertex(){
		return startingVertex;
	}
	
	public int getNbVertices(){
		return nbVertices;
	}
	
	public void addEdge(int src, int dest, int cost){
		graph.get(src).add(new Edge(dest, cost));
	}
	
	public LinkedList<Edge> getNeighbours(int vertex){
		return graph.get(vertex);
	}
	
	public void printMatrix(){
		/*String arrayString = "";
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				arrayString += "[" + (graph.get(i).get(j).endVertex+1) + " , " + graph.get(i).get(j).cost + "]";
			}
			arrayString += "\n";
		}*/
		
		//System.out.println(arrayString);
		//System.out.println(getNeighbours(0).get(0).endVertex);
	}
}
