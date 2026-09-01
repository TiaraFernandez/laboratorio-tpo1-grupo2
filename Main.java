import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<Indumentaria> parteArribaList = new ArrayList<>();
        List<Indumentaria> parteAbajoList = new ArrayList<>();
        List<Indumentaria> vestidoList = new ArrayList<>();

        EstiloRockero rockera = new EstiloRockero();
        EstiloPreppy preppy = new EstiloPreppy();
        Estilo[] arrayEstilo = { preppy, rockera };

        ExecutorService ejecutor = Executors.newFixedThreadPool(4);
        CountDownLatch pestillo = new CountDownLatch(3);

        /* Se crean los callables con las tareas a realizar */
        Callable<String> generarPrendasArriba = () -> {
            int estilo;
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                estilo = random.nextInt(2);
                parteArribaList.add(new ParteDeArriba(arrayEstilo[estilo]));
            }

            pestillo.countDown();

            return "Se generó la lista de partes de arriba con exito.";
        };

        Callable<String> generarPrendasAbajo = () -> {
            int estilo;
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                estilo = random.nextInt(2);
                parteAbajoList.add(new ParteDeAbajo(arrayEstilo[estilo]));
            }

            pestillo.countDown();

            return "Se generó la lista de prendas de abajo con exito";
        };

        Callable<String> generarPrendasVestido = () -> {
            int estilo;
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                estilo = random.nextInt(2);

                vestidoList.add(new Vestido(arrayEstilo[estilo]));

            }
            pestillo.countDown();
            return "Se generó la lista de vestidos con exito.";
        };

        Callable<String> mostrarPrendas = () -> {
            pestillo.await(); // espera hasta que terminen de armarse las sublistas
            
            System.out.println("La lista de prendas de moda generada es: ");
            /* Imprime cada una de las listas */
            for (Indumentaria prenda : parteAbajoList) {
                System.out.println("\t" + prenda.confeccionar());
            }
            for (Indumentaria prenda : parteArribaList) {
                System.out.println("\t" + prenda.confeccionar());
            }
            for (Indumentaria prenda : vestidoList) {
                System.out.println("\t" + prenda.confeccionar());
            }
            return "Se mostraron todas las prendas con exito.";
        };

        /* Se envian las tareas el executor y recibimos los futures correspondientes */
        Future<String> fArriba = ejecutor.submit(generarPrendasArriba);
        Future<String> fAbajo = ejecutor.submit(generarPrendasAbajo);
        Future<String> fVestidos = ejecutor.submit(generarPrendasVestido);
        Future<String> futureMostrar = ejecutor.submit(mostrarPrendas);

        try {
            System.out.println("Mensajes de control: "
                + "\n\t"+fArriba.get()
                + "\n\t"+fAbajo.get()
                + "\n\t"+fVestidos.get()
                + "\n\t"+futureMostrar.get()
            );
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            ejecutor.shutdown();
        }
    }
}
