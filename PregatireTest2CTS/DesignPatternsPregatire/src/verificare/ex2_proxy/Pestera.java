package verificare.ex2_proxy;

public class Pestera implements IPestera{
    @Override
    public void viziteaza(String persoana, boolean areTichet) {
        if(areTichet){
            System.out.println(persoana + " viziteaza pestera");
        }else{
            System.out.println(persoana + " n are bilet");
        }
    }
}
