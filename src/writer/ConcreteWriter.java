package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Stack;

import data.Cycles;

/**
 * The ConcreteWriter class write the cycles in a text file in a particular format
 * 
 * @author Marc-Alexandre Monette Molina
 * @version 1, 20/11/2017
 * 
 */
public class ConcreteWriter implements Writer<Cycles> {
	
	/**
	 * 
	 * Writes the cycles in a text files
	 * 
	 * @param filename		The file destination and file name to be written in
	 * @param output		The cycle set to be written in the text file 
	 * 
	 */
	@Override
	public void write(String filename, Cycles output) {
		
		try{
			FileWriter fileWriter = new FileWriter(new File(filename));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//Writes the first cycles
			bufferedWriter.write(cycleToString(output.GetCycle(0)));
			
			//Writes the other cycles and create a new line for each cycles
			for(int i = 1; i < output.GetNbCycles(); i++){
				bufferedWriter.write(System.getProperty("line.separator"));
				bufferedWriter.write(cycleToString(output.GetCycle(i)));
			}
			
			//Close the stream
			bufferedWriter.close();
			fileWriter.close();
		}
		catch(Exception e){
			
		}
	}
	
	/**
	 * 
	 * Turns a cycle to the right string format to be written in the text file
	 * 
	 * @param cycle		The cycle to be turned into a string
	 * @return			The cycle as a String
	 * 
	 */
	public String cycleToString(LinkedList<Integer> cycle){
		String cycleString = "";
		
		cycleString += Integer.toString(cycle.get(0)+1);
		
		for(int i = cycle.size() - 2; i >= 0; i--){
			cycleString += " " + Integer.toString(cycle.get(i)+1);
		}
		
		return cycleString;
	}

}
