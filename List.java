package hw5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * List class with sort function
 *
 * @author ralph
 */
public class List<T extends Comparable> implements Iterable<T> {

    private Node head; //head Node

    /**
     * *
     * Tests for Empty List
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Add item to front of list. Not really used in this homework
     *
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
 * Remove and return top item from list
 * @return top item of list
 */
    public T RemoveTop() {
        T retval = null;
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is Empty");
        }
        retval = head.getData();

        head = head.getNext();
        return retval;

    }
    
    /**
     * Removed and returns end of list
     * @return Item at end of list
     */
    public T RemoveTail() {
        T retval = null;
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is Empty");
        }
        Node tmp = head;
        Node lasttmp = null;
        while (tmp.getNext() != null) {
            lasttmp = tmp;
            tmp = tmp.getNext();
        }

        if (lasttmp != null) {
            lasttmp.setNext();
        }
        retval = tmp.getData();
        return retval;

    }

    /**
     * Size of List
     *
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

    /**
     * *
     * Bubble sorts the list
     * added a swapped variable to keep from running longer than needed
     * @return returns the list so it can be used as a chained call
     */
    public List<T> BubbleSort() {
        boolean swapped = true;
        T tmpSwitch;
        long end = size() - 1;

        
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

    /**
     * *
     * Adds item to end of list
     *
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
     *
     * @return String representation of ADT
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            sb.append(tmp.getData().toString());
            sb.append("\n");
            tmp = tmp.getNext();
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
     * iteraror so that for : can be used to iterate list
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
         *
         * @return true if has next
         */
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * returns next item from list using iterator
         *
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

    /**
     * Node  this is the node class to be used internally by the list
     */
    private class Node {

        private T data; // the data stored in a Node
        private Node next; // the next node

        /***
         * Constructor
         * @param Data data to store in the node
         * @param NextNode  the next node
         */
        Node(T Data, Node NextNode) {
            next = NextNode;
            data = Data;
        }
        /***
         *   Node Constructor overload
         * @param Data the data this node will hold
         */
        Node(T Data) {
            this(Data, null);
        }
        
        /***
         *  the next node
         * @return next
         */
        Node getNext() {
            return next;
        }

        /***
         * Sets next node
         * @param data  date to be stored in next node
         */
        void setNext(T data) {
            next = new Node(data);
        }

        /***
         * sets next to null
         */
        void setNext() {
            next = null;
        }
        
        /***
         * getter for data
         * @return data
         */
        T getData() {
            return data;
        }
        
        /***
         * Sets data
         * @param Data 
         */
        void setData(T Data) {
            this.data = Data;
        }

    }
}
