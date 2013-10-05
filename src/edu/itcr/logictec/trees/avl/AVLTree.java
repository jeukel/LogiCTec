/*
 * AVLTree.java
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

public class AVLTree {

    private AVLNode root;
    boolean aux = true;

    public AVLTree() {
        root = null;
    }

    public AVLTree(AVLNode root) {
        this.root = root;
    }

    public Boolean isEmpty(AVLNode root) {
        return root == null;
    }

    void add(int data) {
        // Si existe el dato no hace nada, de lo contraio lo inserta balanceado 
        if ((!exist(data, root))) {
            AVLNode info = new AVLNode(data);
            this.root = balanceInsert(getRoot(), info);
        } else {
            System.out.println("El elemento ya existe");
        }
    }

    AVLNode balanceInsert(AVLNode root, AVLNode node) {
        AVLNode node1;
        AVLNode info = node;
        if (isEmpty(root)) {
            root = info;
            aux = true;
        } else {
            if (node.data < root.data) {
                root.left = balanceInsert(root.left, node);
                if (aux) {
                    switch (root.balance) {
                        case 1:
                            root.balance = 0;
                            aux = false;
                            break;
                        case 0:
                            root.balance = -1;
                            break;
                        //se reestructura ya que pasaria a valer-2 y se desequilibra a la izq
                        case -1:
                            node1 = root.left;
                            if (node1.balance == -1) {
                                root = leftLeftRotation(root, node1);
                            } else {
                                root = leftRightRotation(root, node1);
                            }
                            aux = false;
                            break;
                    }
                }
            } else {
                if (node.data > root.data) {
                    root.right = balanceInsert(root.right, node);
                    if (aux) {
                        switch (root.balance) {
                            case -1:
                                root.balance = 0;
                                aux = false;
                                break;
                            case 0:
                                root.balance = 1;
                                break;
                            //se reestructura ya que pasaria a valer 2 y se desequilibra a la derecha
                            case 1:
                                node1 = root.right;
                                if (node1.balance == 1) {
                                    root = rightRightRotation(root, node1);
                                } else {
                                    root = rightLeftRotation(root, node1);
                                }
                                aux = false;
                                break;
                        }
                    }
                }
            }
        }
        return root;
    }

    boolean exist(int data, AVLNode root) {
        AVLNode temp = root;
        boolean exist = false;
        while (temp != null) {
            if (data == temp.data) {
                exist = true;
                return exist;
            } else {
                if (data > temp.data) {
                    temp = temp.right;
                }else {
                    temp = temp.left;
                    if (temp == null) {
                        return exist;
                    }
                }
            }
        }
        return exist;
    }
    
    // el mayor de los menores, para la hora de eliminar
    public AVLNode greaterThanUnder(AVLNode nodo) {
        AVLNode dad = nodo;
        AVLNode aux = nodo.left;
        try {
            while (aux.right != null) {
                dad = aux;
                aux = aux.right;
            }
            dad.right = aux.left;

        } catch (Exception e) {
        }
        return aux;
    }

    void remove(int data) {
        if ((!exist(data, root))) {
            System.out.println("El elemento no existe");
        } else {
            eliminates(data);
        }
    }

    void eliminates(int data) {
        if (data == getRoot().data && getRoot().right == null && getRoot().left == null) {
                root = null;
        } else {
            AVLNode nodetoremover = nodeToRemover(data, getRoot());
            System.out.println("Nodo a eliminar " + nodetoremover.data);
            if (nodetoremover.data == data && nodetoremover.right == null && nodetoremover.left == null) {
                System.out.println("Nodo eliminar " + getRoot().left.data);
                root.left = null;
            }
            if (nodetoremover.left != null) {
                AVLNode greaterthanunder = greaterThanUnder(nodetoremover);
                System.out.println("el mayor de menores es " + greaterthanunder.data);
                if (greaterthanunder.data == data) {
                    System.out.println("Se eliminara el " + getRoot().left.data);
                    root.left = null;
                }
            } else {
            }
        }
    }

    private AVLNode nodeToRemover(int data, AVLNode root) {
        AVLNode raiz = root;
        while (data != raiz.data) {
            if (data > raiz.data) {
                raiz = raiz.right;
            } else {
                raiz = raiz.left;
            }
        }
        return raiz;
    }

    //   Desequilibrio Interno
    //   Rotacion Derecha - Izquierda
    private AVLNode rightLeftRotation(AVLNode root, AVLNode node1) {
        AVLNode node2;
        node2 = node1.left;
        root.right = node2.left;
        node2.left = root;
        node1.left = node2.right;
        node2.right = node1;
        if (node2.balance == 1) {
            root.balance = -1;
        } else {
            root.balance = 0;
        }
        if (node2.balance == -1) {
            node1.balance = 1;
        } else {
            node1.balance = 0;
        }
        node2.balance = 0;
        root = node2;
        return root;
    }
    
    // Rotacion Izquierda - Derecha
    private AVLNode leftRightRotation(AVLNode root, AVLNode node1) {
        AVLNode node2;
        node2 = node1.right;
        root.left = node2.right;
        node2.right = root;
        node1.right = node2.left;
        node2.left = node1;
        if (node2.balance == 1) {
            node1.balance = -1;
        } else {
            node1.balance = 0;
        }
        if (node2.balance == -1) {
            root.balance = 1;
        } else {
            root.balance = 0;
        }
        node2.balance = 0;
        root = node2;
        return root;
    }

    // Desequilibrio Externo
    // Rotacion Izquierda -Izquierda
    private AVLNode leftLeftRotation(AVLNode root, AVLNode node1) {
        root.left = node1.right;
        node1.right = root;
        if (node1.balance == -1) {

            root.balance = 0;
            node1.balance = 0;
        } else {

            root.balance = -1;
            node1.balance = 1;
        }
        root = node1;
        return root;
    }
    // Rotacion Derecha - Derecha

    private AVLNode rightRightRotation(AVLNode root, AVLNode node1) {
        root.right = node1.left;
        node1.left = root;
        if (node1.balance == 1) {
            root.balance = 0;
            node1.balance = 0;
        } else {
            root.balance = 1;
            node1.balance = -1;
        }
        root = node1;
        return root;
    }

    int size() {
        return AVLNode.size(getRoot());
    }

    void inOrden() {
        inOrden(this.getRoot());
    }

    void inOrden(AVLNode root) {
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

    void postOrden(AVLNode root) {
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

    void preOrden(AVLNode root) {
        if (root != null) {
            String hex = Integer.toHexString(root.data);
            System.out.print(hex + " -- ");
            preOrden(root.left);
            preOrden(root.right);
        }

    }

    private SLL nvo = new SLL();
    void nodes() {
        nodes_(this.getRoot());
    }

   SLL nodes_(AVLNode root) {
        if (root != null) {
            nodes_(root.left);
            SLLNode temp = new SLLNode(root.data, null);
            nvo.addNode(temp);
            nodes_(root.right);
        }
        return nvo;
    }
    public AVLNode getRoot() {
        return root;
    }
}
