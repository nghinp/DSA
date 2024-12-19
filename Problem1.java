import java.util.Scanner;
import java.util.Stack;

public class Problem1 {
    public static String decToOct(int n){
        int[] octalNum = new int[100];
        int i = 0;
        while (n!=0){
            octalNum[i] =n%8;
            n = n/8;
            i++;
        }
        StringBuilder octalString = new StringBuilder();
        for(int j =i-1; j>=0;j--){
            octalString.append(octalNum[j]);
        }
        return octalString.toString();
    }

    public static <T> Stack<T> concatenateStacks(Stack<T> stack1, Stack<T> stack2){
        Stack<T> res = new Stack<>();
        Stack<T> tempStack = new Stack<>();
        tempStack.addAll(stack1);

        while (!tempStack.isEmpty()){
            res.push(tempStack.pop());
        }
        tempStack.addAll(stack2);
        while (!tempStack.isEmpty()){
            res.push(tempStack.pop());
        }
        return res;
    }

    public static <T> boolean areStacksIdentical(Stack<T> stack1, Stack<T> stack2){
        if (stack1.size() != stack2.size()){
            return false;
        }
        Stack<T> tempStack1 = new Stack<>();
        tempStack1.addAll(stack1);

        Stack<T> tempStack2 = new Stack<>();
        tempStack1.addAll(stack2);
        while (!tempStack1.isEmpty()){
            if (!tempStack1.pop().equals(tempStack2.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = sc.nextInt();
        System.out.println("Decimal number "+decimalNumber +" in octal is "+decToOct(decimalNumber));
        sc.close();

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<>();
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        Stack<Integer> concatenatedStack = concatenateStacks(stack1, stack2);
        System.out.println("Concatenated stack: "+ concatenatedStack);

        System.out.println("stack1 and stack2 are identical: "+ areStacksIdentical(stack1,stack2));
    }
}
