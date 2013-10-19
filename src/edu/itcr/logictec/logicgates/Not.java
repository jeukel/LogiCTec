package edu.itcr.logictec.logicgates;

import edu.itcr.logictec.trees.binary.BinaryNode;

public class Not extends LogicGate<Integer> {
	
	public Not(){
		super();
	}
	
	public void setInA(int pdata){
		if (this.root == null){
			BinaryNode<Integer> node = new BinaryNode<Integer>();
			this.root = node;
		}
		this.root.setLeft(pdata);
		this.root.setRight(pdata);
		setRoot();
	}
	
	public void setInB(int pdata){
		if (this.root == null){
			BinaryNode<Integer> node = new BinaryNode<Integer>();
			this.root = node;
		}
		this.root.setRight(pdata);
		this.root.setLeft(pdata);
		setRoot();
	}

	protected void setRoot(){
		if(this.root.getRight() == null || this.root.getLeft() == null){
			return;
		} else{
			if(this.getRoot().getData() == 0){
				this.getRoot().setData(1);
			} else{
				this.getRoot().setData(0);
			}
		}
	}
}
