package hilos;

public class ContadorTrhead {
    private Contador contador;
    public ContadorTrhead(Contador contador){
        this.contador = contador;
    }
    @Override public void run(){
        System.out.println();
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}
