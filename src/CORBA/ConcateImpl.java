package CORBA;

public class ConcateImpl extends ConcateModule.ConcatePOA {
    public ConcateImpl(){
        super();
        System.out.println("Concate obj created");
    }

    @Override
    public String concatString(String s1, String s2) {
        String res = s1 + s2;
        return res;
    }
}
