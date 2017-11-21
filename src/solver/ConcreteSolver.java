package solver;

import java.util.LinkedList;
import java.util.Stack;

import data.Cycles;
import data.Graph;

public class ConcreteSolver implements Solver<Graph, Cycles> {

	public void ConcreteSolver(){
		
	}
	
	@Override
	public Cycles solve(Graph input) {
		Cycles cycles = new Cycles();

		//Path currently traveled
		LinkedList<Integer> path = new LinkedList<Integer>();
		
		//Starts to find Hamiltonian cycle from the startingVertex
		FindHamiltonianCycle(0, new boolean[input.getNbVertices()], path, input, cycles);
		
		return cycles;
	}
	
	//Complexity O(V!)
	//Recursive method that find Hamiltonian Cycles in a graph
	public void FindHamiltonianCycle(int currentVertex, boolean[] visitedVertices, LinkedList<Integer> path, Graph graph, Cycles cycles){
		//Clone the visitedVertices array so that each branching get its own array
		boolean[] visitedVerticesCopy = visitedVertices.clone();
		
		if(visitedVertices[currentVertex]){
			//If all the vertex have been visited and we are back to the starting vertex
			if(isAllTrue(visitedVertices) && currentVertex == graph.getStartingVertex()){
				path.push(currentVertex);
				
				//Add the completed Hamiltonian cycle to the cycles list
				cycles.AddCycle((LinkedList<Integer>)path.clone());
				
				path.pop();
			}
		}
		else{
			visitedVerticesCopy[currentVertex] = true;
			path.push(currentVertex);
			
			//Look at the neighbours
			for(int i = 0; i < graph.getNeighbours(currentVertex).size(); i++){
				FindHamiltonianCycle(graph.getNeighbours(currentVertex).get(i).vertex, visitedVerticesCopy, path, graph, cycles);
			}
			
			path.pop();
		}
		
	}
	
	public boolean isAllTrue(boolean[] array){
		boolean isTrue = true;
		
		for(int i = 0; i < array.length; i++){
			if(!array[i])
				isTrue = false;
		}
		return isTrue;
	}

}
