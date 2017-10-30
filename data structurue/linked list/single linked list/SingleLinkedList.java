package com.liu.programminglearning.datastructure.linkedlist.single;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class SingleLinkedList {
    Node head = null;
    public void append(int value){
        Node lastNode = getLastNode();
        if(lastNode == null){
            head = new Node(value);
        }else{
            lastNode.next = new Node(value);
        }
    }
    public void delete(int value){
        if(head == null){
            return;
        }
        Node prevNode = null;
        Node currNode = head;
        while (currNode != null && currNode.value != value){
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(prevNode == null){
            head = head.next;
            return;
        }
        if(currNode == null){
            return;
        }
        prevNode.next = currNode.next;
    }
    public void print(){
        if(head == null){
            return;
        }
        Node tempNode = head;
        while(tempNode != null ){
            tempNode = tempNode.next;
        }
    }
    private Node getLastNode(){
        if(head == null){
            return null;
        }else{
            Node tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            return tempNode;
        }
    }
}

