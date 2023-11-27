public class Taller {
    public static void main(String[] args) {

        Cistella cistella_manigues = new Cistella(Cistella.MAX_MANGAS_JERSEI);
        Cistella cistella_cos = new Cistella(Cistella.MAX_CUERPOS_JERSEI);

        Treballador costurer_manigues = new Treballador(cistella_manigues,"maniga", "Pedro");
        Treballador costurer_cos = new Treballador(cistella_cos,"cos", "Maria");
        Treballador assemblador = new Treballador(cistella_cos, cistella_manigues, "ambdues", "Juan");

        costurer_manigues.start();
        costurer_cos.start();
        assemblador.start();

    }
}
