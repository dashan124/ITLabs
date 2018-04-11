import java.util.*;
class Test {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<Integer>();
       
        System.out.println("enter a choice what you want");
        System.out.println("1.push in stack 2. pop the stack 3. isempty 4.peek 5 .search");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        if (c == 1) {
            System.out.println("enter a integer to push");
            int x = sc.nextInt();
            s.push(x);
        } else if (c == 2) {
            if (s.isEmpty()) {
                System.out.println("Stack is empty ");
            } else {
                System.out.println("the poped element" + s.pop());
            }
        } else if (c == 3) {
            if (s.isEmpty()) {
                System.out.println("Stack is empty");
            } else {
                System.out.println("Stack is not empty");
            }
        } else if (c == 4) {
            if (s.isEmpty()) {
                System.out.println("No Peek Since stack is empty");
            } else {
                System.out.println("the top element is " + s.peek());
            }
        } else if (c == 5) {
            System.out.println("Enter a element to search in stack");
            int r = sc.nextInt();
            if (s.isEmpty()) {
                System.out.println(" Not found stack is empty");
            } else {

                Integer pos = (Integer) s.search(r);

                if (pos == -1)
                    System.out.println("Element not found");
                else
                    System.out.println("Element is found at position " + pos);
            }

        }
        for (Iterator<Integer> iterator = s.iterator(); iterator.hasNext(); )
        {
            Integer each = iterator.next();
            System.out.println(each);
        }
    }
}

