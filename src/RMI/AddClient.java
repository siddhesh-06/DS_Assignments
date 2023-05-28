package RMI;

import java.rmi.Naming;

public class AddClient {
    public static void main(String[] args) {
        try {
            String addServerUrl = "rmi://" + args[0] + "/AddServer";
            AddServerInter addServerInter = (AddServerInter) Naming.lookup(addServerUrl);

            System.out.println("First number: ");
            double d1 = Double.parseDouble(args[1]);

            System.out.println("Second number: ");
            double d2 = Double.parseDouble(args[2]);

            System.out.println("Ans is: "+ addServerInter.add(d1, d2));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
