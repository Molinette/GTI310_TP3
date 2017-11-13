package parser;

import data.Network;

public class ConcreteParser implements Parser<Network> {

	public void ConcreteParser(){
		
	}
	
	@Override
	public Network parse(String filename) {
		Network network = new Network();
		return network;
	}

	
}
