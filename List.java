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
       private Node nextNode;
        
       public ListIterator()
       {
           nextNode =head;
       
       }
       
       
        public boolean hasNext() {
            return nextNode!=null; 
        }

        @Override
        public T next() {
            if( !hasNext()){
                
            }
            
            T retval;
            retval = nextNode.getData();
            nextNode=nextNode.getNext();
            return retval;
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
