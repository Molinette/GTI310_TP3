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
public class NetworkTest {

	/**
	 * Test method for {@link data.Network#getStartingVertex()}.
	 */
	@Test
	public void testGetStartingVertex() {
		Network network = new Network(3, 1);
		assertEquals(1, network.getStartingVertex());
	}

	/**
	 * Test method for {@link data.Network#getNbVertices()}.
	 */
	@Test
	public void testGetNbVertices() {
		Network network = new Network(3, 1);
		assertEquals(3, network.getNbVertices());
	}

	/**
	 * Test method for {@link data.Network#addEdge(int, int, int)}.
	 */
	@Test
	public void testAddEdge() {
		Network network = new Network(3, 1);
		network.addEdge(0, 1, 2);
		assertEquals(6, network.getNeighbours(0).get(0).getCost());
		assertEquals(8, network.getNeighbours(0).get(0).getVertex());
		
		
	}

	/**
	 * Test method for {@link data.Network#getNeighbours(int)}.
	 */
	@Test
	public void testGetNeighbours() {
		Network network = new Network(3, 1);
		network.addEdge(0, 1, 2);
	}

}
