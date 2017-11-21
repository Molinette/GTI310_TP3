package data;

import java.util.LinkedList;
import java.util.Stack;

public class Cycles {
	private LinkedList<LinkedList<Integer>> cycles = new LinkedList<LinkedList<Integer>>();
	
	public void Cycles(){
		
	}
	
	public void AddCycle(LinkedList<Integer> cycle){
		cycles.add(cycle);
	}
	
	public LinkedList<Integer> GetCycle(int index){
		return cycles.get(index);
	}
	
	public int GetNbCycles(){
		return cycles.size();
	}
	
	
}
