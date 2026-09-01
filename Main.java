import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<Indumentaria> prendasList = new ArrayList<>();

        EstiloRockero rockera = new EstiloRockero();
        EstiloPreppy preppy= new EstiloPreppy();

        ExecutorService ejecutor = Executors.newFixedThreadPool(2);

        /* Se crean los callables con las tareas a realizar */
        Callable<String> generarPrendas = () ->{
            int indumentaria;
            int estilo;
            Random random = new Random();

            for (int i = 0; i < 20; i++) {
                indumentaria = random.nextInt(3);
                estilo = random.nextInt(2);

                switch (indumentaria) {
                    case 1:
                        if (estilo == 0) {
                            prendasList.add(new ParteDeArriba("Remera", preppy));
                        }else{
                            prendasList.add(new ParteDeArriba("Remera", rockera));
                        }
                        break;
                    case 2:
                        if (estilo == 0) {
                            prendasList.add(new ParteDeAbajo("Pantalon", preppy));
                        }else{
                            prendasList.add(new ParteDeAbajo("Pantalon", rockera));
                        }
                        break;
                    default:
                        if (estilo == 0) {
                            prendasList.add(new Vestido(preppy));
                        }else{
                            prendasList.add(new Vestido(rockera));
                        }
                        break;
                }
            }
            return "Prendas generadas con exito.";
        };

        Callable<String> mostrarPrendas = () ->{ /* Imprimo la lista de las prendas */
            System.out.println("La lista de prendas de moda generada es: ");
            for (Indumentaria prenda : prendasList) {
                System.out.println("\t"+prenda.confeccionar());
            }
            return "Se mostraron todas las prendas con exito.";
        };

        /* Se envian las tareas el executor y recibimos los futures correspondientes */
        Future<String> futureGenerar = ejecutor.submit(generarPrendas);
        Future<String> futureMostrar = ejecutor.submit(mostrarPrendas);

        try {
            String resultado;
            resultado = futureGenerar.get();
            System.out.println(resultado);
            resultado = futureMostrar.get();
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally{
            ejecutor.shutdown();
        }
    }
}
