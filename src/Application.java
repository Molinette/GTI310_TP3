import java.io.FileNotFoundException;

import data.Cycles;
import data.Graph;
import parser.ConcreteParser;
import solver.ConcreteSolver;
import writer.ConcreteWriter;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is façing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		ConcreteParser parser = new ConcreteParser();
		ConcreteSolver solver = new ConcreteSolver();
		ConcreteWriter writer = new ConcreteWriter();
		
		try{
			Graph network = parser.parse(args[0]);
			Cycles cycles = solver.solve(network);
			writer.write(args[1], cycles);
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			if(e.getMessage() != null)
				System.out.println(e.getMessage());
			else
				System.out.println("An unexpected error occured");
		}
		
	}
}
