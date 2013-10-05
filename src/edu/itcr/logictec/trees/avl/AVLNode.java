/*
 * AVLNode.java
 *
 * Copyright 2013 Anibal Alvarez <aaalvarez94@gmail.com>
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
 */

package edu.itcr.logictec.trees.AVL;

public class AVLNode{
    int data;
    int balance;
    AVLNode left, right;

    public AVLNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.balance = 0;
    }
    public AVLNode(int data, AVLNode left, AVLNode rigth) {
        this.data = data;
        this.left = left;
        this.right = rigth;
    }
    static int size (AVLNode node){
        if (node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}
