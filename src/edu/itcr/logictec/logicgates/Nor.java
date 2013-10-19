package edu.itcr.logictec.logicgates;

public class Nor extends LogicGate<Integer> {
	
	public Nor(){
		super();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			this.getRoot().setData(this.getRoot().getLeft().getData() + 
								   this.getRoot().getRight().getData());
			if (this.getRoot().getData() >= 1){
				this.getRoot().setData(0);
			}
			if(this.getRoot().getData() == 0){
				this.getRoot().setData(1);
			}
		}
	}
}
