import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * Clase concreta de la clase Estilo
 */

public class EstiloPreppy implements Estilo{
    private Random random = new Random();
    private List<String> listColores = new ArrayList<>();
    private List<String> listTexturas = new ArrayList<>();

    public EstiloPreppy(){
        /* Defino la paleta de colores del estilo */
        listColores.add("Azul marino");
        listColores.add("Crema");
        listColores.add("Blanco");
        listColores.add("Beige");
        listColores.add("Caqui");
        listColores.add("Gris Oxford");
        listColores.add("Vino tinto");
        listColores.add("Verde bosque");
        /* Defino las texturas del estilo */
        listTexturas.add("Houdstooth");
        listTexturas.add("Tartán");
        listTexturas.add("Argyle");
        listTexturas.add("Rayas diplomaticas");
        listTexturas.add("Lino");
        listTexturas.add("Piqué");
        listTexturas.add("Seersucker");
        listTexturas.add("Corduroy");
    }

    @Override
    public String aplicarPaletaColores(String tipoPrenda){
        int numColor = random.nextInt(listColores.size());
        String color = listColores.get(numColor);
        return color;
    }
    public String aplicarDetalleTextura(String tipoPrenda){
        int numTextura = random.nextInt(listTexturas.size());
        String textura = listTexturas.get(numTextura);
        return textura;
    }
}
