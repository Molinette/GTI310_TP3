/**
 * 
 */
package data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kerby
 *
 */
public class GraphTest {

	/**
	 * Test method for {@link data.Network#getStartingVertex()}.
	 */
	@Test
	public void testGetStartingVertex() {
		Graph graph = new Graph(3, 1);
		assertEquals(1, graph.getStartingVertex());
	}

	/**
	 * Test method for {@link data.Network#getNbVertices()}.
	 */
	@Test
	public void testGetNbVertices() {
		Graph graph = new Graph(3, 1);
		assertEquals(3, graph.getNbVertices());
	}

	/**
	 * Test method for {@link data.Network#addEdge(int, int, int)}.
	 */
	@Test
	public void testAddEdgeVertex() {
		Graph graph = new Graph(3, 1);
		graph.addEdge(0, 1, 2);
		assertEquals(1, graph.getNeighbours(0).get(0).getVertex());
	}
	/**
	 * Test method for {@link data.Network#addEdge(int, int, int)}.
	 */
	@Test
	public void testAddEdgeCost() {
		Graph graph = new Graph(3, 1);
		graph.addEdge(0, 1, 2);
		assertEquals(2, graph.getNeighbours(0).get(0).getCost());
	}
	/**
	 * Test method for {@link data.Network#getNeighbours(int)}.
	 */
	@Test
	public void testGetNeighboursVertex() {
		Graph graph = new Graph(3, 1);
		graph.addEdge(0, 1, 2);
		assertEquals(1, graph.getNeighbours(0).get(0).getVertex());
	}
	/**
	 * Test method for {@link data.Network#getNeighbours(int)}.
	 */
	@Test
	public void testGetNeighboursCost() {
		Graph graph = new Graph(3, 1);
		graph.addEdge(0, 1, 2);
		assertEquals(1, graph.getNeighbours(0).get(0).getVertex());
	}
}
