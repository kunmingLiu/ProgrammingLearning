package com.liu.programminglearning.datastructure.linkedlist.doubly;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class DoublyLinkedList {
    private Node head;
    public void add(int key , int value){
        Node lastNode = getLastNode();
        if(lastNode == null){
            head = new Node(key,value);
        }else{
            lastNode.next = new Node(key,value);
            lastNode.next.prev = lastNode;
        }
    }
    public void delete(int key){
        if(head == null){
            return;
        }
        else{
            Node tempNode = head;
            while (tempNode != null && tempNode.key != key){
                tempNode = tempNode.next;
            }
            if(tempNode.key == key){
                if(tempNode.prev == null){
                    head = tempNode.next;
                }else if(tempNode.next == null){
                    tempNode.prev.next = null;
                }else{
                    tempNode.prev.next = tempNode.next;
                    tempNode.next.prev = tempNode.prev;
                }
            }
        }
    }
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private Node getLastNode(){
        if(head == null){
            return head;
        }else{
            Node tempNode = head;
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }
            return tempNode;
        }
    }
    public void printAsc(){
        Node node = head;
        while (node != null){
            node = node.next;
        }
    }
    public void printDesc(){
        Node node = getLastNode();
        while (node != null){
            node = node.prev;
        }
    }
}
