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

    public boolean remove(E obj){
        if(root == null){
            return false;
        }

        if(obj.compareTo(root.data) == 0){
            if(applyRemoveRoot()){
                elementCounter--;
                return true;
            }
            return false;
        }

        if(remove(obj,root)){
            elementCounter--;
            return true;
        }

        return false;
    }

    private boolean remove(E obj,Node<E> node){
        if(node==null){
            return false;
        }
        if(obj.compareTo(node.data)>0){
            if(node.right !=null){
                if(obj.compareTo(node.right.data) == 0){
                    //apply remove logic
                    return applyRemoveRightChildOf(node);
                }
                return remove(obj,node.right);
            }
        }else {
            if(node.left != null) {
                if (obj.compareTo(node.left.data) == 0) {
                    //apply remove logic
                    return applyRemoveLeftChildOf(node);
                }
                return remove(obj,node.left);
            }
        }

        return false;
    }

    private boolean applyRemoveRoot(){
        if(isNodeIsLeaf(root)){
            root=null;
            return true;
        }

        if(isNodeHasOnlyLeftChild(root)){
            root=root.left;
            return true;
        }

        if(isNodeHasOnlyRightChild(root)){
            root=root.right;
            return true;
        }

        if(isNodeHasBothLeftAndRightChild(root)){
            E rootData = root.data;
            Node<E> successor = getSuccessor(root);
            swapTwoNodes(root,successor);
            return remove(rootData,getSuccessorParent(root));
        }

        return false;
    }

    private boolean applyRemoveLeftChildOf(Node<E> parentNode){
        if(!validateLeftChildNodeIsLegalToBeRemoved(parentNode)){
            return false;
        }

        Node<E> childNodeToBeRemoved = parentNode.left;

        if(isNodeIsLeaf(childNodeToBeRemoved)){
            parentNode.left=null;
        }

        if(isNodeHasOnlyLeftChild(childNodeToBeRemoved)){
            parentNode.left = childNodeToBeRemoved.left;
            return true;
        }else if(isNodeHasOnlyRightChild(childNodeToBeRemoved)){
            parentNode.left = childNodeToBeRemoved.right;
            return true;
        }

        if(isNodeHasBothLeftAndRightChild(childNodeToBeRemoved)){
            Node<E> successor = getSuccessor(childNodeToBeRemoved);
            swapTwoNodes(childNodeToBeRemoved,successor);
            return remove(childNodeToBeRemoved.data,getSuccessorParent(childNodeToBeRemoved));
        }

        return false;
    }

    private boolean applyRemoveRightChildOf(Node<E> parentNode){
        if(!validateRightChildNodeIsLegalToBeRemoved(parentNode)){
            return false;
        }

        Node<E> childNodeToBeRemoved = parentNode.right;

        if(isNodeIsLeaf(childNodeToBeRemoved)){
            parentNode.right=null;
            return true ;
        }

        if(isNodeHasOnlyLeftChild(childNodeToBeRemoved)){
            parentNode.right = childNodeToBeRemoved.left;
            return true;
        }else if(isNodeHasOnlyRightChild(childNodeToBeRemoved)){
            parentNode.right = childNodeToBeRemoved.right;
            return true;
        }

        if(isNodeHasBothLeftAndRightChild(childNodeToBeRemoved)){
            Node<E> successor = getSuccessor(childNodeToBeRemoved);
            swapTwoNodes(childNodeToBeRemoved,successor);
            return remove(successor.data,getSuccessorParent(childNodeToBeRemoved));
        }

        return false;
    }

    private boolean validateLeftChildNodeIsLegalToBeRemoved(Node<E> parentNode){
        return (parentNode != null && parentNode.left !=null);
    }

    private boolean validateRightChildNodeIsLegalToBeRemoved(Node<E> parentNode){
        return (parentNode != null && parentNode.right !=null);
    }

    private boolean isNodeIsLeaf(Node<E> node){
        return (node.left == null && node.right == null);
    }

    private boolean isNodeHasOnlyLeftChild(Node<E> node){
        return (node.left != null && node.right == null);
    }

    private boolean isNodeHasOnlyRightChild(Node<E> node){
        return (node.left == null && node.right != null);
    }

    private boolean isNodeHasBothLeftAndRightChild(Node<E> node){
        return (node.left != null && node.right != null);
    }

    private void swapTwoNodes(Node<E> node1,Node<E> node2){
        E tmpData = node1.data;
        node1.data = node2.data;
        node2.data = tmpData;
    }

    private Node<E> getSuccessorParent(Node<E> node){
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
            node = nextNode;
            nextNode = nextNode.right;
        }

        return node;
    }

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
