
import java.util.Arrays;

public class StackArray<T> implements StackInterface<T>
{

        private T[] stack;
        private int topIndex; // keeps track of the top of the stack
        private static final int DEFAULT_CAPACITY = 50;
        
        // constructors for initializing the stacks
        public StackArray()
        {
                this(DEFAULT_CAPACITY);
        }
        
        public StackArray(int initialCapacity)
        {
                @SuppressWarnings("unchecked")
                T[] tempStack = (T[])new Object[initialCapacity];
                stack = tempStack;
                topIndex = -1;
        } // end constructor
        
        // when adding stuff to the stuck
        public void push(T newEntry) 
        {
                ensureCapacity();
                topIndex++;
                stack[topIndex] = newEntry;
        } // end push

        private void ensureCapacity()
        {
                if (topIndex == stack.length - 1) // if array is full
                        //double size of array
                        stack = Arrays.copyOf(stack, 2 * stack.length);
        } // end ensureCapacity
        
        // when looking at top of the stack
        public T peek()
        {
                T top = null;
                
                if (!isEmpty())
                        top = stack[topIndex];
                
                return top;
        } // end peek
        
        // when returning and removing at the top of the stack
        public T pop()
        {
                T top = null;
                
                if(!isEmpty())
                {
                        top = stack[topIndex];
                        stack[topIndex] = null;
                        topIndex--;
                } // end if
                
                return top;
        } // end pop
        
        public boolean isEmpty()
        {
                return topIndex < 0;
        }
        
        public void clear()
        {
                for (; topIndex > -1; topIndex--)
                        stack[topIndex] = null;
        }
        
        @Override
        public String toString()
        {
                return String.format("Stack: %d\n", stack);
        }
        
        public void display()
        {
                for(int i = topIndex; i >= 0; i--) 
                {
                        System.out.println(stack[i]);
                }
                
                System.out.println();
        }
                       
} // end StackArray