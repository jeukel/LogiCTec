import java.io.IOException;

import edu.itcr.logictec.logicgates.And;
import edu.itcr.logictec.logicgates.LogicGate;
import edu.itcr.logictec.save.Toxml;


public class XMLCreation {

	public static <K> void main(String[] argv) throws IOException {
		System.out.println("*****************************");
		
		LogicGate<Integer> gateand0 = new And();
		gateand0.setInA(1);
		gateand0.setInB(1);
		System.out.println(gateand0.getExit());		
		
		Toxml xml = new Toxml(gateand0.printGate());
		xml.save();
		
		System.out.println("*****************************");

	}
}
