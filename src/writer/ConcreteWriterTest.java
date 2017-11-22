/**
 * 
 */
package writer;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import data.Cycles;
import junit.framework.Assert;

/**
 * @author Kerby
 *
 */
public class ConcreteWriterTest {
	/**
	 * Test method for {@link writer.ConcreteWriter#write(java.lang.String, data.Cycles)}.
	 */
	@Test
	public void testWrite() throws IOException {
		Cycles cycles = new Cycles();
		LinkedList<Integer> test = new LinkedList<>();
		for(int i = 0; i < 6; i++){
			test.add(i);
			cycles.AddCycle(test);
		}
		ConcreteWriter concreteWriter = new ConcreteWriter();
		concreteWriter.write("test.txt", cycles);
		FileReader fileReader = new FileReader(new File("test.txt"));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		bufferedReader.close();
		Assert.assertEquals("1 5 4 3 2 1", line);

	}
}
