

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
    public ParteDeArriba(String nPrenda, Estilo unEstilo) {
        super(nPrenda, unEstilo);
    }

    public String confeccionar(){
        String prendaFinal = this.nombrePrenda;
        prendaFinal = prendaFinal + " " + estilo.aplicarPaletaColores(nombrePrenda);
        prendaFinal = prendaFinal + " de " +estilo.aplicarDetalleTextura(nombrePrenda);

        return prendaFinal;
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
    public ParteDeAbajo(String nombrePrenda, Estilo estilo) {
        super(nombrePrenda, estilo);

    }

    @Override
    public String confeccionar() {
        String prendaFinal = this.nombrePrenda;
        prendaFinal = prendaFinal + " " +estilo.aplicarPaletaColores(nombrePrenda);
        prendaFinal = prendaFinal + " de " + estilo.aplicarDetalleTextura(nombrePrenda);

        return prendaFinal;
    }
}
