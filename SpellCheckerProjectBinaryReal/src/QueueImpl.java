
public class QueueImpl {

    private int capacity;
    String queueArr[];
    int front = 0;
    int rear = -1;
    int currentSize = 0;

    public QueueImpl(int queueSize) {
        this.capacity = queueSize;
        queueArr = new String[this.capacity];
    }

    /**
     * this method adds element at the end of the queue.
     *
     * @param item
     */
    public void enqueue(String item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            rear++;     // enqueue('apple') rear = 0
            queueArr[rear] = item; // queueArr[0] = 'apple'
            currentSize++; // currentsize = 1
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }
    /**
     * This method removes the front entry and returns it. 
     *
     * @return
     */
    public String dequeue()
    {
        {
            String word = queueArr[front];  // front = 0
            queueArr[front] = null;
            front = (front + 1) % queueArr.length;
            currentSize--;
            return word;
        } // end if
    } // end dequeue

    /**
     * This method checks whether the queue is full or not
     *
     * @return boolean
     */
    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    /**
     * This method checks whether the queue is empty or not
     *
     * @return
     */
    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }
}