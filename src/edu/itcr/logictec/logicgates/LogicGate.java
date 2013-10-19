/*
 * LogicGate.java
 *
 * Copyright 2013 Daniel Jenkins <jeukel@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */

package edu.itcr.logictec.logicgates;

import edu.itcr.logictec.trees.binary.BinaryNode;

public class LogicGate<K>{
    protected BinaryNode<K> root;
    
    public LogicGate(){
        this.root = null;
    }

    public LogicGate(BinaryNode<K> pnodeA, BinaryNode<K> pnodeB){
        this.root = new BinaryNode<K>();
        this.root.setLeft(pnodeA);
        this.root.setRight(pnodeB);
    }

	public void setInA(K pdata){
		if (pdata == null){
			return;
		} else {
			if (this.root == null){
				BinaryNode<K> node = new BinaryNode<K>();
				this.root = node;
			}
			this.root.setLeft(pdata);
			//System.out.println(this.root.getLeft().getData());
			setRoot();
		}
	}
	
	public void setInB(K pdata){
		if (pdata == null){
			return;
		} else {
			if (this.root == null){
				BinaryNode<K> node = new BinaryNode<K>();
				this.root = node;
			}
			this.root.setRight(pdata);
			setRoot();
		}
		
	}
	
	public BinaryNode<K> getRoot(){
		return this.root;
	}
	
	public K getExit(){
		return this.root.getData();
	}
	
	protected void setRoot(){
		System.out.println("Nothing here :p");
	}
	
	public void connectGatesA(LogicGate<K> pgate){
		if(pgate.root == null){
			return;
		} else {
			if (this.root == null){
				BinaryNode<K> node = new BinaryNode<K>();
				this.root = node;
			}
			this.root.setLeft(pgate.getRoot());
			setRoot();
		}
	}
	
	public void connectGatesB(LogicGate<K> pgate){
		if(pgate.root == null){
			return;
		} else{
			if (this.root == null){
				BinaryNode<K> node = new BinaryNode<K>();
				this.root = node;
			}
			this.root.setRight(pgate.getRoot());
			setRoot();
		}
	}
}