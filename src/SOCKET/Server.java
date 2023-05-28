package SOCKET;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("SERVER listening on 1234");
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clienMsg = in.readLine();
            System.out.println("Client msg: "+ clienMsg);

            out.println("Server received");

            serverSocket.close();
            in.close();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
