class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + j);
            return;
        }
        if (rear == maxSize - 1) // deal with wraparound
            rear = -1;
        queArray[++rear] = j; // increment rear and insert
        nItems++; // one more item
    }

    public long remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove.");
            return -1;
        }
        long temp = queArray[front++]; // get value and incr front
        if (front == maxSize) // deal with wraparound
            front = 0;
        nItems--; // one less item
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public void displayQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < nItems; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queArray[index] + " ");
        }
        System.out.println();
    }

    public void displayQueueAndIndices() {
        System.out.println("Front: " + front + ", Rear: " + rear);
        displayQueue();
    }
}

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5); // queue holds 5 items

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        theQueue.displayQueueAndIndices(); // Display queue and indices
    }
}
