package data;

public class Network {
	
	private int[][] matrix;
	private int startingVertice;
	

	public Network(int nbVertices, int startingVertice){
		matrix = new int[nbVertices][nbVertices];
		this.startingVertice = startingVertice;
	}
	
	public void addEdge(int src, int dest, int cost){
		matrix[src][dest] = cost;
	}
	
	public void printMatrix(){
		String arrayString = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				arrayString += "[" + matrix[i][j] + "]";
			}
			arrayString += "\n";
		}
		
		System.out.println(arrayString);
	}
	
}
