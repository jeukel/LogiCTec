package edu.itcr.logictec.logicgates;

public class And extends LogicGate<Integer> {
	
	public And(){
		super();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			//System.out.println(this.root.getLeft().getData());
			//System.out.println(this.root.getRight().getData());
			this.root.setData(this.root.getLeft().getData() * 
							  this.root.getRight().getData());
		}
	}
}
