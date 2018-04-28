package queue2;

import java.util.concurrent.locks.*;

/** 
    A first-in, first-out bounded collection of objects. 
*/ 
public class BoundedQueue<E>
{ 
	 private Object[] elements; 
	   private int head; 
	   private int tail; 
	   private int size;
	   private boolean debug;

	   private Lock queueLock = new ReentrantLock();
	   private Condition spaceAvailableCondition  = queueLock.newCondition();
	   private Condition valueAvailableCondition  = queueLock.newCondition();
	/** 
       Constructs an empty queue. 
       @param capacity the maximum capacity of the queue 
   */ 
   public BoundedQueue(int capacity) 
   { 
      elements = new Object[capacity]; 
      head = 0; 
      tail = 0; 
      size = 0;
   } 

   /** 
       Removes the object at the head. 
       @return the object that has been removed from the queue
   */ 
   public E remove() throws InterruptedException
   { 
      queueLock.lock();
      try
      {         
         while (size == 0) 
            valueAvailableCondition.await();
         E r = (E) elements[head]; 
         head++;
         size--;
         if (head == elements.length) 
            head = 0; 
         spaceAvailableCondition.signalAll();
         return r; 
      }
      finally
      {
         queueLock.unlock();
      }
   } 

   /** 
       Appends an object at the tail. 
       @param newValue the object to be appended 
   */ 
   public void add(E newValue) throws InterruptedException
   { 
      queueLock.lock();
      try
      {         
         while (size == elements.length) 
            spaceAvailableCondition.await();
         if (debug) System.out.print("addToTail");
         elements[tail] = newValue; 
         if (debug) System.out.print(".");
         tail++;
         size++;
         if (tail == elements.length) 
            tail = 0; 
         if (debug) System.out.print(".");
         valueAvailableCondition.signalAll();
      }
      finally
      {
         queueLock.unlock();
      }
   } 

   public int getSize() 
   {
	   return size;
   }
   public void setDebug(boolean newValue)
   {
      debug = newValue;
   }

}
