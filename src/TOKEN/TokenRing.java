package TOKEN;

import java.util.*;

public class TokenRing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of node: ");
        int n = sc.nextInt();

        int token = 0;

        while (true){
            try {
                System.out.println("Enter sender: ");
                int s = sc.nextInt();

                System.out.println("Enter receiver: ");
                int r = sc.nextInt();

                System.out.println("Enter data: ");
                String d = sc.next();


                System.out.println("Token Passing");
                for(int i=token; i!=s; i=(i+1)%n){
                    System.out.print(" " + i + "->");
                }
                System.out.println(" "+ s);

                // 1 - 2 - 3 - 4 - 5

                System.out.println("Sender "+ s + " sending data: "+ d);

                for(int i=s+1; i!=r; i=(i+1)%n){
                    System.out.println("Data " + d + " forwarded by " + i);
                }
                System.out.println("Receiver "+ r + " received data: " + d);
                token = s;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}