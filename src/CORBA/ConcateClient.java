package CORBA;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Scanner;

public class ConcateClient {
    public static void main(String[] args) {
        ConcateModule.Concate concateImpl = null;
        try {
            ORB orb = ORB.init(args, null);
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Concate";
            concateImpl = ConcateModule.ConcateHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter string: ");
            Scanner sc = new Scanner(System.in);
            String str1 = sc.next();
            String str2 = sc.next();

            System.out.println("Concate string: "+ concateImpl.concatString(str1, str2));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
