package solver;

import data.Cycles;
import data.Network;

public class ConcreteSolver implements Solver<Network, Cycles> {

	public void ConcreteSolver(){
		
	}
	
	@Override
	public Cycles solve(Network input) {
		Cycles cycles = new Cycles();
		return cycles;
	}

}
