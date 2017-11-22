/**
 * 
 */
package parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kerby
 *
 */
public class ConcreteParserTest {
	/**
	 * Test method for {@link parser.ConcreteParser#parse(java.lang.String)}.
	 */
	@Test
	public void testParse() {
		ConcreteParser cp = new ConcreteParser();
		assertNotNull(cp.parse("MuseeTest.txt"));
	}

}
