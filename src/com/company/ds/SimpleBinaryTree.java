package com.company.ds;

public class SimpleBinaryTree<E extends Comparable<E>> {
    private class Node<E>{
        E data;
        Node<E> left;
        Node<E> right;
        public Node(E data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    int elementCounter = 0;
    Node<E> root;

    public SimpleBinaryTree(){
        elementCounter =0;
        root = null;
    }


    public boolean add(E obj){
        if(root==null){
            root = new Node<E>(obj);
            elementCounter++;
            return true;
        }

        if(add(obj,root)){
            elementCounter++;
            return true;
        }

        return false;
    }

    private boolean add(E obj,Node<E> node){
        if(node==null){
            return false;
        }

        if(obj.compareTo(node.data)>0){
            if(node.right==null){
                node.right = new Node<E>(obj);
                return true;
            }
            return add(obj,node.right);
        }else{
            if(node.left==null){
                node.left = new Node<E>(obj);
                return true;
            }
            return add(obj,node.left);
        }
    }

    public boolean contains(E obj){
        return contains(obj,root);
    }

    private boolean contains(E obj,Node<E> node){
        if(node == null){
            return false;
        }

        if(obj.compareTo(node.data)==0){
            return true;
        }

        if(obj.compareTo(node.data)>0){
            return contains(obj,node.right);
        }else{
            return contains(obj,node.left);
        }
    }

//    public boolean remove(E obj){
//        if(root==null){
//            //tree is not initailiazed yet
//            return false;
//        }
//
//        Node<E> pointerToCurrent = root;
//        Node<E> pointerToParent = null;
//
//        while (pointerToCurrent!=null){
//            if(pointerToCurrent.data.compareTo(obj) == 0){
//                //we are ready to remove
//                    //node found is leaf element
//                    if(pointerToCurrent.left==null && pointerToCurrent.right==null){
//                        if(pointerToCurrent==root){
//                            root=null;
//                            elementCounter--;
//                            return true;
//                        }
//                        if(pointerToParent.left!=null && obj.compareTo(pointerToParent.left.data) ==0){
//                            pointerToParent.left=null;
//                            elementCounter--;
//                            return true;
//                        }
//                        else if(pointerToParent.right!=null && obj.compareTo(pointerToParent.right.data) ==0){
//                            pointerToParent.right=null;
//                            elementCounter--;
//                            return true;
//                        }
//                    }
//
//                    //node found has only one child
//                    if(pointerToCurrent.left==null && pointerToCurrent.right!=null){
//                        if(pointerToCurrent==root){
//                            root=pointerToCurrent.
//                        }
//                       pointerToParent.left = pointerToCurrent.left;
//                       elementCounter--;
//                       return true;
//                    }else if(pointerToCurrent.right==null && pointerToCurrent.left!=null){
//                        pointerToParent.right = pointerToCurrent.right;
//                        elementCounter--;
//                        return true;
//                    }
//
//                    //node found has both left and right
//                    if(pointerToCurrent.left!=null && pointerToCurrent.right!=null){
//                        Node<E> successor = getSuccessor(pointerToCurrent);
//                        E tmpData = pointerToCurrent.data;
//                        E succTmpData = successor.data;
//
//                        pointerToCurrent.data = succTmpData;
//                        successor.data = tmpData;
//                        remove(successor.data);
//                        elementCounter--;
//                        return true;
//                    }
//
//            }
//
//            pointerToParent = pointerToCurrent;
//            pointerToCurrent = (obj.compareTo(pointerToCurrent.data)>0)
//                    ?pointerToCurrent.right
//                    :pointerToCurrent.left;
//        }
//
//        return false;
//    }

    private Node<E> getSuccessor(Node<E> node){
        if(node==null){
            //node doesn't exist
            return null;
        }

        //go step to the left
        Node<E> nextNode = node.left;
        if(nextNode==null){
            //node doesn't have left element
            return null;
        }

        //go all the way to the right
        while (nextNode.right!=null){
            nextNode = nextNode.right;
        }

        return nextNode;
    }

    public int getCount(){
        return elementCounter;
    }
}
