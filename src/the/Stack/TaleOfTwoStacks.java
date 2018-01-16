package the.Stack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;




public class TaleOfTwoStacks 
{
    public static class MyQueue<T> 
    {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) 
        { // Push onto newest stack
            stackNewestOnTop.push(value);
            
        }

        public T peek() 
        {
        		if(stackOldestOnTop.isEmpty()) loadOldestOnTop();
        		return stackOldestOnTop.peek();
        }

        public T dequeue() 
        {
        		if(stackOldestOnTop.isEmpty()) loadOldestOnTop();
            return stackOldestOnTop.pop();
        }
        
        
        /*
         * This moves all the elements 
         * from the NewestOnTop 
         * to the OldestOnTop stack
         */
        public void loadOldestOnTop()
        {
        		while(!stackNewestOnTop.isEmpty() ) // while the stack is not empty
        		{
        			T val = stackNewestOnTop.pop();
        			stackOldestOnTop.push(val);
        		}
        }
    }

    
    public static void main(String[] args)
    {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}