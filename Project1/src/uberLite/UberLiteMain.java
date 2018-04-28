package uberLite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class UberLiteMain.
 */
public class UberLiteMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		String infile, outfile, log;
		
		File inputFile = null;
		
		FileOutputStream outputFile = null;
		UberMap map = null;
		
		FileOutputStream logFile = null;
		
		try {
			
			infile = args[0];
			inputFile = new File(infile);
		
			map = UberMap.readMapFile(inputFile);
			
		} catch (ArrayIndexOutOfBoundsException e){ 
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			log = args[2];
			logFile = new FileOutputStream(log);	
						
			map.operate();
			map.finalizeLog(logFile);
			
		} catch (ArrayIndexOutOfBoundsException | FileNotFoundException e){ 
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			
			outfile = args[1];
			outputFile = new FileOutputStream(outfile);	
			map.finalizeMap(outputFile);
			
		} catch (ArrayIndexOutOfBoundsException | FileNotFoundException e){ 
			e.printStackTrace();
			System.exit(0);
		}
	}
}
