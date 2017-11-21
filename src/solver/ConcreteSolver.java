package solver;

import java.util.LinkedList;
import java.util.Stack;

import data.Cycles;
import data.Network;

public class ConcreteSolver implements Solver<Network, Cycles> {

	public void ConcreteSolver(){
		
	}
	
	@Override
	public Cycles solve(Network input) {
		Cycles cycles = new Cycles();

		LinkedList<Integer> path = new LinkedList<Integer>();
		CreateHamiltonianCycle(input, 0, new boolean[input.getNbVertices()], path, cycles);
		
		return cycles;
	}
	
	public void CreateHamiltonianCycle(Network input, int srcVertex, boolean[] visitedVertices, LinkedList<Integer> path, Cycles cycles){
		boolean[] newVisitedVertices = visitedVertices.clone();
		if(visitedVertices[srcVertex]){
			if(isAllTrue(visitedVertices) && srcVertex == input.getStartingVertex()){
				path.push(srcVertex);
 
				for(int i = 0; i < path.size(); i++){
				//	System.out.println(path.get(i) + 1);
				}
				
				cycles.AddCycle((LinkedList<Integer>)path.clone());
				path.pop();
			}
		}
		else{
			newVisitedVertices[srcVertex] = true;
			path.push(srcVertex);

			newVisitedVertices[srcVertex] = true;
			for(int i = 0; i < input.getNeighbours(srcVertex).size(); i++){
				CreateHamiltonianCycle(input, input.getNeighbours(srcVertex).get(i).vertex, newVisitedVertices, path, cycles);
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
