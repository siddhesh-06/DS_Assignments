package RMI;

import java.rmi.RemoteException;

public interface AddServerInter {
    double add(double d1, double d2) throws RemoteException;
}
