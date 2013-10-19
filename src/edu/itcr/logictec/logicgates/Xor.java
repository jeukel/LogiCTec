package edu.itcr.logictec.logicgates;

public class Xor extends LogicGate<Integer> {
	
	public Xor(){
		super();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{			
			//System.out.println("*************");
			//System.out.println(this.getRoot().getLeft().getData());
			//System.out.println(this.getRoot().getRight().getData());
			//System.out.println("*************");
			if(this.getRoot().getLeft().getData() == this.getRoot().getRight().getData()){
				this.getRoot().setData(0);
			} else{
				this.getRoot().setData(1);
			}
		}
	}
}
