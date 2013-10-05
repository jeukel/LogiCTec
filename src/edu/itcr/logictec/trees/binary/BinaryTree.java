/*
 * BinaryTree.java
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

public class BinaryTree {
    private BinaryNode root;   

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(BinaryNode root){
        this.root = root;
    }
    
    //Add data to Tree
    public void insertNode(int data) {
        if (this.root == null){
            BinaryNode node = new BinaryNode(data);
            this.root = node;            
        }else{
            BinaryTree recursivertree = new BinaryTree();
            if(data == this.root.data){
                System.out.println("El elemento ya existe, no se volverá " +
                        "a insertar.");
            }else if (data < this.root.data){
                recursivertree.root = this.root.left;
                insertNode(data, recursivertree);
            }else{
                recursivertree.root = this.root.right; 
                insertNode(data, recursivertree);
            }
        }
    }
    
    //AUX Add data
    private BinaryNode insertNode(int data, BinaryTree tree){
        if (tree.root == null){
            BinaryNode node = new BinaryNode(data);
            tree.root = node;            
        }else{
            if(data == tree.root.data){
                System.out.println("El elemento ya existe, no se volverá " +
                        "a insertar.");
            }else if (data < tree.root.data){
                tree.root = tree.root.left;
                tree.root.left = insertNode(data, tree);
            }else{
                tree.root = tree.root.right; 
                tree.root.right = insertNode(data, tree);
            }
        }
        return tree.root;
    }   
    
    //Goes thru tree and delete node accordin' to childs
    public void deleteNode(int data) {        
        if (this.root == null){
            System.out.println("El elemento no se enuentra en el arbol");            
        }else{
            BinaryTree temp = this;
            if(data == this.root.data){
                temp.root = waysToDelete(temp);
            }else if (data < temp.root.data){
                temp.root = temp.root.left;
                this.root.left = deleteNode(data, temp);
            }else{
                temp.root = temp.root.right; 
                this.root.right = deleteNode(data, temp);
            }
        }
    }
    
    //AUX deleteNode
    private BinaryNode deleteNode(int data, BinaryTree temp) {
        if (temp == null){
            System.out.println("El elemento no se encuentra en el arbol");
        }else{
            if(data == temp.root.data){
                temp.root = waysToDelete(temp);
            }else if (data < this.root.data){
                temp.root = temp.root.left;
                deleteNode(data, temp);
            }else{
                temp.root = temp.root.right; 
                deleteNode(data, temp);
            }
        }
        return temp.root;
    }
    
    //Return new tree after delition
    private BinaryNode waysToDelete(BinaryTree tree){
        BinaryTree temp = new BinaryTree();;
        if (tree.root.left != null && tree.root.right != null){
            temp.root = reArrange(tree);
        }else if (tree.root.left == null && tree.root.right != null){
            temp.root = tree.root.right;
        }else if (tree.root.left != null && tree.root.right == null){
            temp.root = tree.root.left;
        }else{
            temp.root = null;
        }
        return temp.root;
    }
    
    
    private BinaryNode reArrange(BinaryTree TREE){
        BinaryTree temp = new BinaryTree(); //Arbol para la busqueda
        BinaryTree tree = new BinaryTree(); //Nuevo arbol
        
        tree.root = TREE.root.right;
        temp.root = tree.root.left;
        
        while(temp.root != null){  //Mientras rama.izq de nuevo arb no sea 0
            temp.root = temp.root.left;
        }
        temp.root = TREE.root.left;
        return tree.root;
    }
    
    public void setEmpty(){
        this.root = null;
    }
    
    void inOrden() {
        inOrden(this.getRoot());
    }

    void inOrden(BinaryNode root) {
        if (root != null) {
            inOrden(root.left);
            //System.out.println(root.data);
            String hex = Integer.toHexString(root.data);
            System.out.print(hex+" -- ");
            inOrden(root.right);
        }
    }

    void postOrden() {
        postOrden(this.getRoot());
    }

    void postOrden(BinaryNode root) {
        if (root != null) {
            postOrden(root.left);
            postOrden(root.right);
            String hex = Integer.toHexString(root.data);
            System.out.print(hex+" -- ");
            //System.out.println(root.data);
        }
    }

    void preOrden() {
        preOrden(this.getRoot());
    }

    void preOrden(BinaryNode root) {
        if (root != null) {
            String hex = Integer.toHexString(root.data);
            System.out.print(hex + " -- ");
            preOrden(root.left);
            preOrden(root.right);
        }

    }
    
    BinaryNode getRoot(){
        return root;
    }
}