/*
 * BinaryNode.java
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

package edu.itcr.logictec.trees.binary;

import edu.itcr.startec.datastructs.simplelist.SimpleList;

public class BinaryNode<K>{
    private K data;
    private BinaryNode<K> left, right;
    
    public BinaryNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BinaryNode(K pdata) {
        this.data = pdata;
        this.left = null;
        this.right = null;
    }
    
    public K getData(){
    	return this.data;
    }
    
    public BinaryNode<K> getLeft(){
    	return this.left;
    }
    
    public BinaryNode<K> getRight(){
    	return this.right;
    }
    
    public void setData(K pk){
    	this.data = pk;
    }
    
    public void setLeft(K pk){
    	BinaryNode<K> left = new BinaryNode<K>(pk);
    	this.left = left;
    }
    
    public void setLeft(BinaryNode<K> pk){
    	this.left = pk;
    }
    
    public void setRight(K pk){
    	BinaryNode<K> right = new BinaryNode<K>(pk);
    	this.right = right;
    }
    
    public void setRight(BinaryNode<K> pk){
    	this.right = pk;
    }
    
    /* Recorridos */
    public void preorden (BinaryNode<K> node, SimpleList<K> list){
        
        System.out.println(data);
        list.append(this.data);
        if (node.left != null){
        	left.preorden(node.left, list);
        }
        if (node.right != null){
        	right.preorden(node.right, list);
        }
        
    }
    
    public void inorden(BinaryNode<K> node){
    	if (node.left != null){
        	left.inorden(node.left);
        }
        System.out.println(data);
        if (node.right != null){
        	right.inorden(node.right);
        }
    }

    public void postorden(BinaryNode<K> node){
    	if (node.left != null){
    		left.postorden(node.left);
    	}
    	if (node.right != null){
    		right.postorden(node.right);
    	}
        System.out.println(data);
    }
}
