import java.util.Random;

/***
 * Indumentaria - Clase abstracta
 */

public abstract class Indumentaria {
    protected String nombrePrenda;
    protected Estilo estilo;

    public Indumentaria(String prenda, Estilo unEst) {
        this.nombrePrenda = prenda;
        this.estilo = unEst;
    }

    public abstract String confeccionar();
}

class ParteDeArriba extends Indumentaria {
    private static String[] tipoPrenda = { "Remera", "Abrigo", "Musculosa" };
    private static Random random = new Random();

    public ParteDeArriba(Estilo unEstilo) {
        super(obtenerPrendaAleatoria(), unEstilo);
    }

    public String confeccionar(){
        String prendaFinal = this.nombrePrenda;
        prendaFinal = prendaFinal + " " + estilo.aplicarPaletaColores(nombrePrenda);
        prendaFinal = prendaFinal + " de " +estilo.aplicarDetalleTextura(nombrePrenda);

        return prendaFinal;
    }

    private static String obtenerPrendaAleatoria(){
        int index = random.nextInt(tipoPrenda.length);
        String prenda = tipoPrenda[index];
        return prenda;
    }
}

class Vestido extends Indumentaria {
    public Vestido(Estilo estilo) {
        super("Vestido", estilo);
    }

    @Override
    public String confeccionar() {
        String prendaFinal = this.nombrePrenda;
        prendaFinal = prendaFinal + " " + estilo.aplicarPaletaColores(nombrePrenda);
        prendaFinal = prendaFinal + " de " + estilo.aplicarDetalleTextura(nombrePrenda);

        return prendaFinal;
    }
}

class ParteDeAbajo extends Indumentaria {
    private static String[] tipoPrenda = { "Pantalon", "Short", "Pollera" };
    private static Random random = new Random();

    public ParteDeAbajo(Estilo estilo) {
        super(obtenerPrendaAleatoria(), estilo);
    }

    @Override
    public String confeccionar() {
        String prendaFinal = this.nombrePrenda;
        prendaFinal = prendaFinal + " " +estilo.aplicarPaletaColores(nombrePrenda);
        prendaFinal = prendaFinal + " de " + estilo.aplicarDetalleTextura(nombrePrenda);

        return prendaFinal;
    }

    private static String obtenerPrendaAleatoria(){
        int index = random.nextInt(tipoPrenda.length);
        String prenda = tipoPrenda[index];
        return prenda;
    }
}
