package CORBA;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class ConcateServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            ConcateImpl con = new ConcateImpl();
            Object ref = rootPOA.servant_to_reference(con);
            ConcateModule.Concate h_ref = ConcateModule.ConcateHelper.narrow(ref);

            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Concate";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, h_ref);

            orb.run();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
