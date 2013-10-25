import java.io.IOException;

import edu.itcr.logictec.save.Toxml;


public class XMLCreation {

	public static <K> void main(String[] argv) throws IOException {
		System.out.println("*****************************");
		
		int[] array = {7,3,6,9,3};
		Toxml xml = new Toxml(array);
		xml.save();
		
		System.out.println("*****************************");

	}
}
