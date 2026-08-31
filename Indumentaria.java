

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
        estilo.aplicarPaletaColores(nombrePrenda);
        estilo.aplicarDetalleTextura(nombrePrenda);

        return "";
    }
}

 class Vestido extends Indumentaria {
    public Vestido(String nombrePrenda, Estilo estilo) {
        super(nombrePrenda, estilo);
    }

    @Override
     public String confeccionar() {
                estilo.aplicarPaletaColores(nombrePrenda);
                estilo.aplicarDetalleTextura(nombrePrenda);

                return "";
    }

     class ParteDeAbajo extends Indumentaria {
        public ParteDeAbajo(String nombrePrenda, Estilo estilo) {
            super(nombrePrenda, estilo);

        }

    @Override
    public String confeccionar() {
                estilo.aplicarPaletaColores(nombrePrenda);
                estilo.aplicarDetalleTextura(nombrePrenda);

                return "";
    }
    }
}
