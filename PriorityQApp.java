// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ
{
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;
    //-------------------------------------------------------------
    public PriorityQ(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    //-------------------------------------------------------------
    public void insert(long item)    // insert item
    {
        int j=nItems-1;
        while (j>0 && item>queArray[j]){
            queArray[j+1] = queArray[j];
            j--;
        }
            queArray[j+1] = item;            // insert it
            nItems++;
    }  // end insert()
    //-------------------------------------------------------------
    public long remove()             // remove minimum item
    { return queArray[--nItems]; }
    //-------------------------------------------------------------
    public long peekMin()            // peek at minimum item
    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    { return (nItems == maxSize); }

    public void displayQ(){
        System.out.print("Queue: ");
        for(int i=0;i<nItems;i++){
            System.out.print(queArray[i]+" ");
        }
        System.out.println();
    }
//-------------------------------------------------------------
}  // end class PriorityQ
////////////////////////////////////////////////////////////////
class PriorityQApp
{
    public static void main(String[] args)
    {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        thePQ.displayQ();

        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " ");  // 10, 20, 30, 40, 50
        }  // end while
        System.out.println();
    }  // end main()
//-------------------------------------------------------------
}  // end class PriorityQApp
////////////////////////////////////////////////////////////////
