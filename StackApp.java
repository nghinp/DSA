// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
class StackX
{
    private int maxSize;        // size of stack array
    private long[] stackArray;
    private int top;            // top of stack
    //--------------------------------------------------------------
    public StackX(int s)         // constructor
    {
        maxSize = s;             // set array size
        stackArray = new long[maxSize];  // create array
        top = -1;                // no items yet
    }
    //--------------------------------------------------------------
    public void push(long j)    // put item on top of stack
    {
        stackArray[++top] = j;     // increment top, insert item
    }
    //--------------------------------------------------------------
    public long pop()           // take item from top of stack
    {
        if(isEmpty()){
            System.out.println("Stack is empty.Can't pop");
            return -1;
        }
        return stackArray[top--];  // access item, decrement top
    }
    //--------------------------------------------------------------
    public long peek()          // peek at top of stack
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return (top == maxSize-1);
    }

    public void displayStackArray(){
        System.out.print("Stack Array: ");
        for (int i=0; i<=top; i++){
            System.out.print(stackArray[i]+" ");
        }
        System.out.println();
    }

    public void displayStack(){
        System.out.print("Stack : ");
        for (int i=top; i>=0; i--){
            System.out.print(stackArray[i]+" ");
        }
        System.out.println();
    }

//--------------------------------------------------------------
}  // end class StackX
////////////////////////////////////////////////////////////////
class StackApp
{
    public static void main(String[] args)
    {
        StackX theStack = new StackX(10);  // make new stack
        theStack.push(20);               // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        theStack.displayStackArray();
        theStack.displayStack();

        while( !theStack.isEmpty() )     // until it's empty,
        {                             // delete item from stack
            long value = theStack.pop();
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
    }  // end main()
}  // end class StackApp
////////////////////////////////////////////////////////////////
