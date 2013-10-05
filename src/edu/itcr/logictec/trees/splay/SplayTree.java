/*
 * SplayTree.java
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

package edu.itcr.logictec.trees.Splay;

public class SplayTree {

    int cont;
    private SplayNode root;
    SplayNode dad_node;
    SplayNode son_node;
    int last;       //removed or inserted
    boolean flag = true;
    //private SLL list = new SLL();
    
    public SplayNode Search(int data, SplayNode raiz) {
        root = raiz;
        if (data == getRoot().data) {
        } else {
            SplayNode padre = null;
            SplayNode hijo = getRoot();
            while ((hijo != null) && (hijo.data != data)) {
                if (data < hijo.data) {
                    padre = hijo;
                    hijo = hijo.left;
                } else {
                    padre = hijo;
                    hijo = hijo.right;
                }
            }
            if (hijo == null) {
                SplayNode aux = gotGrandPa(padre);
                if (padre != getRoot()) {
                    Splay(aux, padre);
                }
            } else {
                Splay(padre, hijo);
            }
        }
        return getRoot();
    }

    //Inserta un elemento en un arbol splay
    public void add(int data) {
        if (!existBool(data)) {
            insert(data);
            last = data;
        } else {
            System.out.println("El elemento ya existe");
        }
    }

    public SplayNode insert(int data) {
        if (getRoot() == null) {
            root = new SplayNode(data);
        } else {
            dad_node = null;
            son_node = getRoot();
            while (son_node != null) {
                if(data == son_node.data){
                    System.out.println("El nodo ya existe");
                }else if (data < son_node.data) {
                    dad_node = son_node;
                    son_node = son_node.left;
                }else {
                    dad_node = son_node;
                    son_node = son_node.right;
                }
            }
            SplayNode splaynode = new SplayNode(data);
            if (data > dad_node.data) {
                dad_node.right = splaynode;
                Splay(dad_node, splaynode);
            } else {
               dad_node.left = splaynode;
                Splay(dad_node, splaynode);
            }
        }
        return getRoot();
    }

    public SplayTree() {
        root = null;
    }

    public SplayTree(SplayNode root) {
        this.root = root;
    }
 
    public void zagzag(SplayNode grandPa) {
        if (cont < 2) {
            System.out.println("zag zag");
            cont++;
            SplayNode temp = new SplayNode(grandPa.data);
            temp.left = grandPa.left;
            temp.right = grandPa.left;
            temp.right = dad_node.left;
            grandPa.left = temp;
            grandPa.right = dad_node.right;
            grandPa.data = dad_node.data;

            if (grandPa == getRoot()) {
                flag = false;
            }
            dad_node = grandPa;
        } else {
            cont = 0;
        }
    }

    //rotacion zag zig
    public void zagzig(SplayNode grandPa) {
        if (cont == 1 || cont == 2) {
            System.out.println("zag zig");
        }
        cont = 0;
        SplayNode temp = new SplayNode(grandPa.data);
        temp.left = grandPa.left;
        temp.right = grandPa.right;
        grandPa.data = son_node.data;
        temp.right = son_node.left;
        grandPa.left = temp;
        dad_node.left = son_node.right;
        grandPa.right = dad_node;
        if (grandPa == getRoot()) {
            root = grandPa;
            flag = false;
        }
        son_node = grandPa;
        dad_node = gotGrandPa(son_node);
    }

    //rotacion zig zig
    public void zigzig(SplayNode grandPa) {
        if (cont < 2) {
            System.out.print("zig zig");
            cont++;
            SplayNode temp = new SplayNode(grandPa.data);
            temp.left = grandPa.left;
            temp.right = grandPa.right;
            temp.left = dad_node.right;
            grandPa.right = temp;
            grandPa.left = dad_node.left;
            grandPa.data = dad_node.data;
            if (grandPa == getRoot()) {
                flag = false;
            }
            dad_node = grandPa;
        } else {
            cont = 0;
        }
    }

    //rotacion zig zag
    public void zigzag(SplayNode grandPa) {
        if (cont == 1 || cont == 2) {
            System.out.println("zig zag");
        }
        cont = 0;
        SplayNode temp = new SplayNode(grandPa.data);
        temp.left = grandPa.left;
        temp.right = grandPa.right;
        grandPa.data = son_node.data;
        temp.left = son_node.right;
        grandPa.right = temp;
        dad_node.right = son_node.left;
        grandPa.left = dad_node;
        if (grandPa == getRoot()) {
            root = grandPa;
            flag = false;
        }
        son_node = grandPa;
        dad_node = gotGrandPa(son_node);
    }

    //rotacion zig
    public void zig() {
        if (cont == 2) {
            System.out.println("zig ");
        }
        root.left = son_node.right;
        son_node.right = getRoot();
        root = son_node;
        cont = 0;
    }

    //rotacion zag
    public void zag() {
        if (cont == 2) {
            System.out.println("zag");
        }
        root.right = son_node.left;
        son_node.left = getRoot();
        root = son_node;
        cont = 0;
    }

    //sube el recien insertado a la root
    public void Splay(SplayNode dad, SplayNode son) {
        flag = true;
        dad_node = dad;
        son_node = son;
        while ((flag == true) && (gotGrandPa(dad_node) != null)) {
            SplayNode grandPa = gotGrandPa(dad_node);
            //zag zag
            if ((grandPa.right == dad_node) && (dad_node.right == son_node)) {
                zagzag(grandPa);
            } else {
                //zag zig
                if ((grandPa.right == dad_node) && (dad_node.left == son_node)) {
                    zagzig(grandPa);
                } else {
                    //zig zig
                    if ((grandPa.left == dad_node) && (dad_node.left == son_node)) {
                        zigzig(grandPa);
                    } //zig zag
                    else {
                        zigzag(grandPa);
                    }
                }
            }
        }
        if (son_node != getRoot()) {
            //zag
            if (getRoot().right == son_node) {
                zag();
            } //zig
            else {
                zig();
            }
        }
    }

    //grandPa de un nieto
    public SplayNode gotGrandPa(SplayNode node) {
        if (node == getRoot()) {
            return null;
        } else {
            SplayNode dad = null;
            SplayNode son = getRoot();
            while (son != node) {
                if (node.data < son.data) {
                    dad = son;
                    son = son.left;
                } else {
                    dad = son;
                    son = son.right;
                }
            }
            return dad;
        }
    }

    public void delete(int data) {
        if (!existBool(data)) {
            System.out.println("El elemento no existe");
            System.out.println("Se bisela = " + lastVisited(data, getRoot()));
            int splay = lastVisited(data, getRoot());
            Search(splay, getRoot());
        } else {
            delete_aux(data);
        }
    }

    private SplayNode delete_aux(int data) {
        if (data == getRoot().data) {
            SplayNode to_erase = getRoot();
            if ((getRoot().left == null) && (getRoot().right == null)) {
                root = null;
                return to_erase;
            } else {
                if ((getRoot().left != null) && (getRoot().right != null)) {
                    SplayNode aux = getRoot();
                    root = BigSmall(getRoot());
                    root.left = aux.left;
                    root.right = aux.right;
                    return to_erase;
                } else {
                    if (getRoot().right != null) {
                        root = getRoot().right;
                        return to_erase;
                    } else {
                        root = getRoot().left;
                        return to_erase;
                    }
                }
            }
        } else {
            SplayNode dad = null;
            SplayNode son = getRoot();
            while (son.data != data) {
                if (data < son.data) {
                    dad = son;
                    son = son.left;
                } else {
                    dad = son;
                    son = son.right;
                }
            }
            Splay(dad, son);
            SplayNode raiz = getRoot();
            delete_aux(getRoot().data);
            return raiz;
        }
    }

    //buscar el mayor de los menores
    public SplayNode BigSmall(SplayNode nodo) {
        SplayNode dad = nodo;
        SplayNode aux = nodo.left;
        while (aux.right != null) {
            dad = aux;
            aux = aux.right;
        }
        dad.right = aux.left;
        return aux;
    }    

    //retorna si el elemento existe un elemento
    boolean existBool(int data) {
        SplayNode temp = this.root;
        boolean exist = false;
        while (temp != null) {
            if (data == temp.data) {
                exist = true;
            } else {
                if (data > temp.data) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }
        }
        return exist;
    }

    int lastVisited(int data, SplayNode root) {
        SplayNode nodoAuxiliar = root;
        int last_int = 0;
        while (nodoAuxiliar != null) {
            last_int = nodoAuxiliar.data;
            if (data == nodoAuxiliar.data) {
                nodoAuxiliar = null;
            } else {
                if (data > nodoAuxiliar.data) {
                    nodoAuxiliar = nodoAuxiliar.right;
                } else {
                    nodoAuxiliar = nodoAuxiliar.left;
                }
            }
        }
        return last_int;
    }

    void inOrden() {
        inOrden(this.getRoot());
    }

    void inOrden(SplayNode root) {
        if (root != null) {
            inOrden(root.left);
            String hex = Integer.toHexString(root.data);
            System.out.print(hex + " -- ");
            inOrden(root.right);
        }
    }

    void postOrden() {
        postOrden(this.getRoot());
    }

    void postOrden(SplayNode root) {
        if (root != null) {
            postOrden(root.left);
            postOrden(root.right);
            String hex = Integer.toHexString(root.data);
            System.out.print(hex + " -- ");
        }
    }

    void preOrden() {
        preOrden(this.getRoot());
    }

    void preOrden(SplayNode root) {
        if (root != null) {
            String hex = Integer.toHexString(root.data);
            System.out.print(hex + " -- ");
            preOrden(root.left);
            preOrden(root.right);
        }
    }   
   
    public SplayNode getRoot() {
        return root;
    }
}
