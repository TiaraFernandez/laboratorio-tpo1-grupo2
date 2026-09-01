import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<Indumentaria> prendasList = new ArrayList<>();

        EstiloRockero rockera = new EstiloRockero();
        EstiloPreppy preppy = new EstiloPreppy();
        Estilo[] arrayEstilo = { preppy, rockera };

        ExecutorService ejecutor = Executors.newFixedThreadPool(4);
        CountDownLatch pestillo = new CountDownLatch(3);

        /* Se crean los callables con las tareas a realizar */
        Callable<List<Indumentaria>> generarPrendasArriba = () -> {
            List<Indumentaria> parteArribaList = new ArrayList<>();
            int estilo, prenda;
            String[] tipoPrenda = { "Remera", "Abrigo", "Musculosa" };

            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                estilo = random.nextInt(2);
                prenda = random.nextInt(3);

                parteArribaList.add(new ParteDeArriba(tipoPrenda[prenda], arrayEstilo[estilo]));
            }
            pestillo.countDown();
            return parteArribaList;
        };

        Callable<List<Indumentaria>> generarPrendasAbajo = () -> {
            List<Indumentaria> parteAbajoList = new ArrayList<>();
            int estilo, prenda;
            String[] tipoPrenda = { "Pantalon", "Short", "Pollera" };
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                estilo = random.nextInt(2);
                prenda = random.nextInt(3);

                parteAbajoList.add(new ParteDeAbajo(tipoPrenda[prenda], arrayEstilo[estilo]));

            }
            pestillo.countDown();
            return parteAbajoList;
        };

        Callable<List<Indumentaria>> generarPrendasVestido = () -> {
            List<Indumentaria> vestidoList = new ArrayList<>();
            int estilo;
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                estilo = random.nextInt(2);

                vestidoList.add(new Vestido(arrayEstilo[estilo]));

            }
            pestillo.countDown();
            return vestidoList;
        };

        Future<List<Indumentaria>> fArriba = ejecutor.submit(generarPrendasArriba);
        Future<List<Indumentaria>> fAbajo = ejecutor.submit(generarPrendasAbajo);
        Future<List<Indumentaria>> fVestidos = ejecutor.submit(generarPrendasVestido);

        Callable<String> mostrarPrendas = () -> { /* Imprimo la lista de las prendas */
            pestillo.await(); // espera hasta que terminen de armarse las sublistas
            prendasList.addAll(fAbajo.get());
            prendasList.addAll(fArriba.get());
            prendasList.addAll(fVestidos.get());

            System.out.println("La lista de prendas de moda generada es: ");
            for (Indumentaria prenda : prendasList) {
                System.out.println("\t" + prenda.confeccionar());
            }
            return "Se mostraron todas las prendas con exito.";
        };

        /* Se envian las tareas el executor y recibimos los futures correspondientes */

        Future<String> futureMostrar = ejecutor.submit(mostrarPrendas);

        try {
            String resultado;
            // resultado = futureGenerar.get();
            // System.out.println(resultado);
            resultado = futureMostrar.get();
            System.out.println(resultado);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            ejecutor.shutdown();
        }
    }
}
