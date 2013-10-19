package edu.itcr.logictec.logicgates;

public class Nand extends LogicGate<Integer> {
	
	public Nand(){
		super();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			this.getRoot().setData(this.getRoot().getLeft().getData() * 
								   this.getRoot().getRight().getData());
			if(this.getRoot().getData() == 0){
				this.getRoot().setData(1);
			} else{
				this.getRoot().setData(0);
			}
		}
	}
}
