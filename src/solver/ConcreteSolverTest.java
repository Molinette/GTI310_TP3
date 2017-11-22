/**
 * 
 */
package solver;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import data.Cycles;
import data.Graph;

/**
 * @author Kerby
 *
 */
public class ConcreteSolverTest {
	
	@Test
	public void testSolve() {
		Graph graph = new Graph(4, 45);
		ConcreteSolver concreteSolver = new ConcreteSolver();
		Cycles cycles = concreteSolver.solve(graph);
		assertEquals(0, cycles.GetNbCycles());
	}

	/**
	 * Test method for {@link solver.ConcreteSolver#FindHamiltonianCycle(int, boolean[], java.util.LinkedList, data.Network, data.Cycles)}.
	 */
	@Test
	public void testFindHamiltonianCycle() {
		Graph graph = new Graph(4, 45);
		ConcreteSolver concreteSolver = new ConcreteSolver();
		Cycles cycles = new Cycles();
		LinkedList<Integer> test = new LinkedList<>();
		for(int i = 0; i < 5; i++){
			test.add(i);
			cycles.AddCycle(test);
		}
		LinkedList<Integer> path = new LinkedList<Integer>();
		concreteSolver.FindHamiltonianCycle(0, new boolean[graph.getNbVertices()], path, graph, cycles);
		String testString = "" + path;
		assertEquals("[]", testString);
	}

	/**
	 * Test method for {@link solver.ConcreteSolver#isAllTrue(boolean[])}.
	 */
	@Test
	public void testIsAllTrue() {
		ConcreteSolver concreteSolver = new ConcreteSolver();
		boolean[] test = new boolean[3];
		assertEquals(false, concreteSolver.isAllTrue(test));
	}

}
