package edu.itcr.logictec.logicgates;

public class Xnor extends LogicGate<Integer> {
	
	public Xnor(){
		super();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			if(this.getRoot().getLeft().getData() == this.getRoot().getRight().getData()){
				this.getRoot().setData(1);
			} else{
				this.getRoot().setData(0);
			}
		}
	}
}
