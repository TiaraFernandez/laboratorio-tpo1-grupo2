import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * Implementador concreto
 * EstiloRockero
 */
public class EstiloRockero implements Estilo{
    private Random random = new Random();
    private List<String> listColores = new ArrayList<>();
    private List<String> listTexturas = new ArrayList<>();

    public EstiloRockero(){
        /* Defino la paleta de colores */
        listColores.add("Negro");
        listColores.add("Gris carbon");
        listColores.add("Gris Malange");
        listColores.add("Blanco Optico");
        listColores.add("Guinda");
        listColores.add("Azul noche");
        /* Defino las posibles texturas del estilo */
        listTexturas.add("Animal Print");
        listTexturas.add("Plata cruda");
        listTexturas.add("Tartán rojo");
        listTexturas.add("Cuadricula");
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
