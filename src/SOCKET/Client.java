package SOCKET;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            Scanner sc = new Scanner(System.in);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            System.out.println("Enter your msg :");
            String msg = sc.next();
            out.println(msg);


            System.out.println("Msg from server: "+ in.readLine());

            socket.close();
            in.close();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
