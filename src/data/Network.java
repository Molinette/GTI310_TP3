package data;

public class Network {
	
	private int[][] matrix;
	private int startingVertice;
	

	public Network(int nbVertice, int startingVertice){
		matrix = new int[nbVertice][nbVertice];
		this.startingVertice = startingVertice;
	}
	
	public void addEdge(int src, int dest, int cost){
		matrix[src][dest] = cost;
	}
	
}
