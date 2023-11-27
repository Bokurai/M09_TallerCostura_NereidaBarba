public class Cistella {
    //definim les constants amb el màxim d'items per cistella
    public static final int MAX_MANGAS_JERSEI = 20;
    public static final int MAX_CUERPOS_JERSEI = 10;

    private int capacitatCistella;
    //pero comprobar si està plena la cistella
    private int ocupat;

    public Cistella(int capacitatCistella){
        this.capacitatCistella = capacitatCistella;
        this.ocupat = 0;
    }

    public synchronized void replenirCistella() throws InterruptedException {
        while (ocupat == capacitatCistella) {
            wait();
        }
        ocupat++;
        notifyAll();
    }

    public synchronized void retirarCistella() throws InterruptedException {
        while (ocupat == 0) {
            wait();
        }
        ocupat--;
        notifyAll();
    }

}
