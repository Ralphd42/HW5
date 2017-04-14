/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.util.Iterator;

/**
 *
 * @author ralph
 */
public class List<T extends Comparable>  implements Iterable<T>{
    private Node head;

    /**
     * the iterator for using for(:)
     * @return iterator for class
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<T>{
       private Node<T> nextNode;
        
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    
    
    
    private class Node {
        private T data;
        private Node next;
        
        Node(T Data, Node NextNode)
        {
            next = NextNode;
            data = Data;
        }
        Node getNext()
        {
            return next;
        }
        T getData()
        {
            return data;
        }
        
        void setData(T Data)
        {
            this.data =Data;
        }
        
        
    
    }
}
