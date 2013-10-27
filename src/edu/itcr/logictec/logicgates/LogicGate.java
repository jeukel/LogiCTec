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
import edu.itcr.startec.datastructs.simplelist.SimpleList;

public class LogicGate<K>{
    protected BinaryNode<K> root;
    public SimpleList<K> list;
    
    public LogicGate(){
        this.root = null;
        this.list = new SimpleList<K>();
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
	
	public int[] printGate(){
		preorden();
		int[] array = new int[list.length()];
		for(int i = 0 ; i > list.length() ; i++){ 
			array[i] = (Integer) list.getRootData();
			list.delete();
		}
		return array;
	}
	
	public void preorden (){
        System.out.println(this.root.getData());
        list.append(this.root.getData());
        if (this.root.getLeft() != null){
        	preorden_extended(this.root.getLeft());
        }
        if (this.root.getRight() != null){
        	preorden_extended(this.root.getRight());
        }
    }
	
	private void preorden_extended(BinaryNode<K> pnode){
		System.out.println(pnode.getData());
        list.append(pnode.getData());
        if (pnode.getLeft() != null){
        	preorden_extended(this.root.getLeft());
        }
        if (pnode.getRight() != null){
        	preorden_extended(this.root.getRight());
        }
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