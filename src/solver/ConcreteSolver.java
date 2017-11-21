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
	
	/**
	 * Complexity O(V!)
	 * 
	 * Recursive method that search for a hamiltonian cycle by going deeper into the graph
	 * 
	 * @param currentVertex			The vertex being looked at
	 * @param visitedVertices		The vertices that have been visited once
	 * @param path					The path being traveled from the starting vertex to the current vertex
	 * @param graph					The graph being searched
	 * @param cycles				The and object containing each cycles found
	 * 
	 */
	public void FindHamiltonianCycle(int currentVertex, boolean[] visitedVertices, LinkedList<Integer> path, Graph graph, Cycles cycles){
		//Clone the visitedVertices array so that each branching get its own array
		boolean[] visitedVerticesCopy = visitedVertices.clone();
		
		if(visitedVertices[currentVertex]){
			//If all the vertex have been visited and we are back to the starting vertex
			if(isAllTrue(visitedVertices) && currentVertex == graph.getStartingVertex()){
				
				//Adds the vertex to the path
				path.push(currentVertex);
				
				//Add the completed Hamiltonian cycle to the cycles list
				cycles.AddCycle((LinkedList<Integer>)path.clone());
				
				//Removes the vertex from the path when backtracking
				path.pop();
			}
		}
		else{
			visitedVerticesCopy[currentVertex] = true;
			
			//Adds the vertex to the path
			path.push(currentVertex);
			
			//Look at the neighbours and go deeper
			for(int i = 0; i < graph.getNeighbours(currentVertex).size(); i++){
				FindHamiltonianCycle(graph.getNeighbours(currentVertex).get(i).vertex, visitedVerticesCopy, path, graph, cycles);
			}
			
			//Removes the vertex from the path when backtracking
			path.pop();
		}
		
	}
	
	/**
	 * Complexity O(V)
	 * 
	 * Recursive method that verify if every vertex has been visited
	 * 
	 * @param array		The array representing visited vertices
	 * 
	 */
	public boolean isAllTrue(boolean[] array){
		boolean isTrue = true;
		
		for(int i = 0; i < array.length; i++){
			if(!array[i])
				isTrue = false;
		}
		return isTrue;
	}

}
