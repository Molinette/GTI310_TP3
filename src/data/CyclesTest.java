/**
 * 
 */
package data;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * @author Kerby
 *
 */
public class CyclesTest {
	@Test
	public void testAddCycle() {
		Cycles cycles = new Cycles();
		LinkedList<Integer> test = new LinkedList<>();
		test.add(45);
		cycles.AddCycle(test);
		String reponse ="" + cycles.GetCycle(0);
		assertEquals("[45]",reponse);
	}
	/**
	 * Test method for {@link data.Cycles#GetNbCycles()}.
	 */
	@Test
	public void testGetNbCycles() {
		Cycles cycles = new Cycles();
		LinkedList<Integer> test = new LinkedList<>();
		for(int i = 0; i < 5; i++){
			test.add(i);
			cycles.AddCycle(test);
		}
		assertEquals(5, cycles.GetNbCycles());
	}

}
