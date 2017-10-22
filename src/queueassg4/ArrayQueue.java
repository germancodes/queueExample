/* CSCI 3343 Analysis of Algorithms Spring 2017
 * Queue implementation using an object array Chapter 4
 * ArrayQueue.java
 */ 

package queueassg4;

public class ArrayQueue {
    private int first, last, size, intCurrSize;
    private Object[] storage;
   
    public ArrayQueue() {
        size = 10;
        storage = new Object[size];
        first = last = -1;
        intCurrSize = 0;
        
    }
    //Created by German
    public int getSize() {
        return intCurrSize;
    }
    public boolean isFull()  {
        return first == 0 && last == size-1 || first == last + 1;
    }
    public boolean isEmpty() {
        return first == -1;
    }
    public void enqueue(Object el) {
        if (!isFull()) {
            intCurrSize++;
            if (last == size-1 || last == -1) {
                 storage[0] = el;
                 last = 0;
                 if (first == -1)
                 first = 0;
                 
            }
        else storage[++last] = el;
        }
    }
    public Object dequeue() {
        if ( !isEmpty()) {
            intCurrSize--;
            Object tmp = storage[first];
            if (first == last)
                 last = first = -1;
            else if (first == size-1)
                 first = 0;
            else first++;
            return tmp;
        }
        else return null;
        
    }
	
    public void printAll() {
        if ( !isEmpty()) {
            if ( first <= last)
            { 
                for (int i = first; i <= last; i++)
                    System.out.print(storage[i] + " "); 
                    }
            else {
                for (int i = first; i <= size -1; i++)
                    System.out.print(storage[i] + " ");

                for (int i = 0; i <= last; i++)
                    System.out.print(storage[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Line is empty!");
        }
    }
}

