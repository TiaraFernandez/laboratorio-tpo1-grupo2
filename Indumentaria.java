package laboratorio-tpo1-grupo2;

public abstract class Indumentaria {
    private String nombrePrenda;
    private Estilo estilo;

    public Indumentaria(String prenda, Estilo unEst) {
        this.nombrePrenda = prenda;
        this.estilo = unEst;
    }

    public abstract String confeccionar();

}

public class ParteDeArriba extends Indumentaria {
    public ParteDeArriba(String nPrenda, Estilo unEstilo) {
        super(nPrenda, unEstilo);
    }

    public String confeccionar(){
        estilo.aplicarPaletaColores(nombrePrenda),
        estilo.aplicarDetallesTextura(nombrePrenda);
    }
}

public class Vestido extends Indumentaria {
    public Vestido(String nombrePrenda, Estilo estilo) {
        super(nombrePrenda, estilo);
    }

    @Override
    public String confeccionar() {
                estilo.aplicarPaletaColores(nombrePrenda),
                estilo.aplicarDetallesTextura(nombrePrenda);
    }

    public class ParteDeAbajo extends Indumentaria {
        public ParteDeAbajo(String nombrePrenda, Estilo estilo) {
            super(nombrePrenda, estilo);
        }

    @Override
    public String confeccionar() {
                estilo.aplicarPaletaColores(nombrePrenda),
                estilo.aplicarDetallesTextura(nombrePrenda);
    }
    }
}
