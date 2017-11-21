package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Stack;

import data.Cycles;

public class ConcreteWriter implements Writer<Cycles> {

	public ConcreteWriter(){
	
	}
	
	@Override
	public void write(String filename, Cycles output) {
		
		try{
			FileWriter fileWriter = new FileWriter(new File(filename));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(cycleToString(output.GetCycle(0)));
			for(int i = 1; i < output.GetNbCycles(); i++){
				bufferedWriter.write(System.getProperty("line.separator"));
				bufferedWriter.write(cycleToString(output.GetCycle(i)));
			}

			bufferedWriter.close();
			fileWriter.close();
		}
		catch(Exception e){
			
		}
	}
	
	public String cycleToString(LinkedList<Integer> cycle){
		String cycleString = "";
		
		cycleString += Integer.toString(cycle.get(0)+1);
		for(int i = cycle.size() - 2; i >= 0; i--){
			cycleString += " " + Integer.toString(cycle.get(i)+1);
		}
		
		return cycleString;
	}

}
