package edu.itcr.logictec.logicgates;

public class Or extends LogicGate<Integer> {
	
	public Or(){
		super();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			this.getRoot().setData(this.getRoot().getLeft().getData() + 
					   this.getRoot().getRight().getData());
			//System.out.println("***");
			//System.out.println(this.getRoot().getData());
			//System.out.println("***");
			if (this.getRoot().getData() > 1){
				this.getRoot().setData(1);
			}
		}
	}
}
