/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ralph
 */
public class List<T extends Comparable> implements Iterable<T> {

    private Node head; //head Node
    
    /***
     * Tests for Empty List
     * @return true if empty 
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Add item to front of list.  Not really used in this homework
     * @param newItem the new item
     * @return the list can be used for chaining
     */
    public List<T> AddItemAtHead(T newItem) {
        if (isEmpty()) {
            head = new Node(newItem);
        } else {
            Node oldHead = head;
            head = new Node(newItem, oldHead);
        }
        return this;
    }
/**
 * Size of List
 * @return the size as a long
 */
    public long size() {
        long retval = 0;
        Node tmp = head;
        while (tmp != null) {
            retval++;
            tmp = tmp.getNext();
        }
        return retval;
    }

    /***
     * Bubble sorts the list
     * @return returns the list so it can be used as a chained call
     */
    public List<T> BubbleSort() {
        boolean swapped = true;
        T tmpSwitch;
        long end = size() - 1;

        //\\for (int i=0; i<input-1;i++)
        for (long j = 0; (j < size() - 1) && swapped; j++) {
            swapped = false;
            Node tmpNode = head;
            for (int i = 0; i < end; i++) {
                if (tmpNode.getData().compareTo(tmpNode.getNext().getData()) > 0) {
                    // do the switcheroo
                    tmpSwitch = tmpNode.getData();
                    tmpNode.setData(tmpNode.getNext().getData());
                    tmpNode.getNext().setData(tmpSwitch);

                    swapped = true;

                }
                tmpNode = tmpNode.getNext();
            }

            end--;

        }
        return this;

    }
    /***
     * Adds item to end of list
     * @param newItem the item to add
     * @return this -- for chained calls
     */
    public List<T> AddItem(T newItem) {
        if (isEmpty()) {
            head = new Node(newItem);
        } else {
            Node tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newItem);

        }

        return this;
    }

    /**
     * Override of toString 
     * @return String representation of ADT
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = head;
        while( tmp!=null )
        {
            sb.append(tmp.getData().toString());
            sb.append("\n");
            tmp=tmp.getNext();
        }
        return sb.toString();
    }
    
    
    
    /**
     * the iterator for using for(:)
     *
     * @return iterator for class
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    
    /**
     * The Iterator class
     */
    private class ListIterator implements Iterator<T> {

        private Node nextNode; // the next node
        
        /**
         * Constructor for Listiterator
         */
        public ListIterator() {
            nextNode = head;

        }
        
        /**
         * tests if iterator has next
         * @return true if has next
         */
        public boolean hasNext() {
            return nextNode != null;
        }
        
        /**
         * returns next item from list using iterator
         * @return the next item in the iterator
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T retval;
            retval = nextNode.getData();
            nextNode = nextNode.getNext();
            return retval;
        }
    }

    private class Node {

        private T data;
        private Node next;

        Node(T Data, Node NextNode) {
            next = NextNode;
            data = Data;
        }

        Node(T Data) {
            this(Data, null);
        }

        Node getNext() {
            return next;
        }

        void setNext(T data) {
            next = new Node(data);
        }

        T getData() {
            return data;
        }

        void setData(T Data) {
            this.data = Data;
        }

    }
}
