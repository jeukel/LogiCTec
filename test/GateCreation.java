import edu.itcr.logictec.logicgates.And;
import edu.itcr.logictec.logicgates.LogicGate;
import edu.itcr.logictec.logicgates.Nand;
import edu.itcr.logictec.logicgates.Or;
import edu.itcr.logictec.logicgates.Xor;

public class GateCreation {

	public static void main(String[] argv) {
		System.out.println("*****************************");
		
		LogicGate<Integer> gateand0 = new And();
		gateand0.setInA(1);
		gateand0.setInB(1);
		System.out.println(gateand0.getExit());
		
		LogicGate<Integer> gateand1 = new And();
		gateand1.setInA(1);
		gateand1.setInB(0);
		System.out.println(gateand1.getExit());
		
		LogicGate<Integer> gateand2 = new And();
		gateand2.connectGatesA(gateand0);
		gateand2.connectGatesB(gateand1);
		System.out.println(gateand2.getExit());
		
		System.out.println("*****************************");
		
		LogicGate<Integer> gateand3 = new Nand();
		gateand3.setInA(1);
		gateand3.setInB(1);
		System.out.println(gateand3.getExit());
		
		LogicGate<Integer> gateand4 = new Nand();
		gateand4.setInA(1);
		gateand4.setInB(0);
		System.out.println(gateand4.getExit());
		
		LogicGate<Integer> gateand5 = new Nand();
		gateand5.connectGatesA(gateand0);
		gateand5.connectGatesB(gateand1);
		System.out.println(gateand5.getExit());
		
		System.out.println("*****************************");
		LogicGate<Integer> gateand6 = new And();
		gateand6.setInA(1);
		gateand6.setInB(1);
		System.out.println(gateand6.getExit());
		
		LogicGate<Integer> gateand7 = new Or();
		gateand7.setInA(1);
		gateand7.setInB(0);
		System.out.println(gateand7.getExit());
		
		LogicGate<Integer> gateand8 = new Xor();
		gateand8.connectGatesA(gateand6);
		gateand8.connectGatesB(gateand7);
		System.out.println(gateand8.getExit());
		
		System.out.println("*****************************");
	}
}
