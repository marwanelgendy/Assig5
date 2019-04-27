package eg.edu.alexu.csd.datastructure.stack.cs65;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ImpStack stack =new ImpStack();
        int ch=0;
        String x=new String();
        Scanner scan=new Scanner(System.in);
        System.out.printf("   Hello In My Program \n# Choose One Of Operator On your Stack\n");
        System.out.printf("1-Push\n2-Pop\n3-Peek\n4-Get size\n5-Check if empty\nTo Exit Enter -1\n");
        while (ch!=-1)
        {
            ch = scan.nextInt();
            if (ch == 1)
            {
                x = scan.next();
                stack.push(x);
            }
            else if (ch == 2)
            {
                try {
                    System.out.println(stack.pop());
                } catch (Exception e) {
                    System.out.println("Stack Is Empty");
                }
            }
            else if (ch == 3)
            {
                try {
                    System.out.println(stack.peek());
                } catch (Exception e) {
                    System.out.println("Stack Is Empty");
                }
            }
            else if (ch == 4)
            {
                int Size = stack.size();
                System.out.println(Size);
            }
            else if (ch == 5)
            {
                boolean w = stack.isEmpty();
                System.out.println(w);
            }
            System.out.println("------------------");
        }
    }
}
