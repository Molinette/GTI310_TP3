package data;

import java.util.LinkedList;
import java.util.Stack;

/**
 * The Cycles class contains multiple cycles and methods to access them
 * 
 * @author Marc-Alexandre Monette Molina
 * @version 1, 20/11/2017
 * 
 */

public class Cycles {
	private LinkedList<LinkedList<Integer>> cycles = new LinkedList<LinkedList<Integer>>();
	
	/**
	 * Adds a new cycle
	 * 
	 * @param cycle		The cycle to add
	 * 
	 */
	public void AddCycle(LinkedList<Integer> cycle){
		cycles.add(cycle);
	}
	
	/**
	 * Gets a cycles at a certain index
	 * 
	 * @param index		The index of the cycle requested
	 * 
	 */
	public LinkedList<Integer> GetCycle(int index){
		return cycles.get(index);
	}
	
	/**
	 * Gets the number of cycles
	 * 
	 * @return		The number of cycles
	 * 
	 */
	public int GetNbCycles(){
		return cycles.size();
	}
	
	
}
