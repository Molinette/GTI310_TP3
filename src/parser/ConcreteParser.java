package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import data.Network;

public class ConcreteParser implements Parser<Network> {
	final String FORMAT_REGEX = "^\\d+\\t\\d+\\t\\d+$";
	final String FORMAT_NUMBER = "^\\d+$";
	final String FORMAT_TAB = "\\t";
	
	public ConcreteParser() {

	}

	@Override
	public Network parse(String filename) {
		Network network = null;
		int nbVertices = 0;
		int startingVertice = 0;
		int src;
		int dest;
		int cost;
		
		String[] splitLine;
		try{
			FileReader fileReader = new FileReader(new File(filename));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = bufferedReader.readLine(); 
			if (line.matches(FORMAT_NUMBER))
				nbVertices = Integer.parseInt(line);
			
			line = bufferedReader.readLine();
			if (line.matches(FORMAT_NUMBER))
				startingVertice = Integer.parseInt(line);
			
			network = new Network(nbVertices, startingVertice);
			
			while(line.compareTo("$") != 0){
				if(line.matches(FORMAT_REGEX)){
					splitLine = line.split(FORMAT_TAB);
					
					src = Integer.parseInt(splitLine[0]);
					dest = Integer.parseInt(splitLine[1]);
					cost = Integer.parseInt(splitLine[2]);
					
					network.addEdge(src-1, dest-1, cost);
				}
				
				line = bufferedReader.readLine();
			}
			
			bufferedReader.close();
		}
		catch(Exception e){
			
		}
		
		return network;
	}

}
