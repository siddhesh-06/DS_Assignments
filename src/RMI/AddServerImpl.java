package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddServerImpl extends UnicastRemoteObject implements AddServerInter {
    AddServerImpl() throws RemoteException{

    }
    @Override
    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }
}
