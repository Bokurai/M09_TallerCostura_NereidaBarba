public class Treballador extends Thread {

    //definim tres instàncies de la classe cistella (per ajudar a definir els tipus de rols) i un String per determinar el tipus de part del jersei, si és un cos o una maniga

    private Cistella cistella;
    private Cistella cistella_manigues;
    private Cistella cistella_cos;
    private String nom_treballador;
    //aquesta part serveix per a quan definim les instàncies de treballador al main, es pugui assignar un dels tres rols
    private String tipus_jersei;

    //constructor de la classe per als costurers de les parts
    public Treballador(Cistella cistella, String tipus_jersei, String nom_treballador) {
        this.cistella = cistella;
        this.tipus_jersei = tipus_jersei;
        this.nom_treballador = nom_treballador;
    }

    //constructor de la classe per al assemblador del jersei
    public Treballador(Cistella cistella_manigues, Cistella cistella_cos, String tipus_jersei,String nom_treballador){
        this.cistella_manigues = cistella_manigues;
        this.cistella_cos = cistella_cos;
        this.tipus_jersei = tipus_jersei;
        this.nom_treballador = nom_treballador;
    }
    @Override
    public void run(){
        for(;;){
            try {
                if (tipus_jersei.equals("ambdues")) {
                    cosirJersei();
                } else {
                    cistella.replenirCistella();
                    System.out.println("El treballador " + nom_treballador + " ha depositat " + tipus_jersei + " en la cistella");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void cosirJersei() throws InterruptedException {
        cistella_manigues.retirarCistella();
        cistella_manigues.retirarCistella();
        cistella_cos.retirarCistella();
        System.out.println("El treballador " + nom_treballador + " ha retirat dues manigues i un cos de la cistella");
        Thread.sleep(3000);
        System.out.println("El treballador " + nom_treballador + " ha cosit un jersei");
    }
}
