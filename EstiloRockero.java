
/***
 * Implementador concreto
 * EstiloRockero
 */
public class EstiloRockero implements Estilo{
    @Override
    public String aplicarPaletaColores(String tipoPrenda){
        return "Paleta: ";
    }
    public String aplicarDetalleTextura(String tipoPrenda){
        return "textura";
    }
    
}
