package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import data.Network;

public class ConcreteParser implements Parser<Network> {

	public void ConcreteParser() {

	}

	@Override
	public Network parse(String filename) {
		Network network = null;
		try{
			FileReader fileReader = new FileReader(new File(filename));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine(); 
			network = new Network(Integer.parseInt(line));
			
			while(line.compareTo("$") != 0){
				System.out.println(line);
				line = bufferedReader.readLine();
			}
			

		}
		catch(Exception e){
			
		}
		
		return network;
	}

}
