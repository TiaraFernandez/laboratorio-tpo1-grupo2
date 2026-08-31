import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        EstiloRockero rockera = new EstiloRockero();
        EstiloPreppy preppy= new EstiloPreppy();

        try (ExecutorService ejecutor = Executors.newFixedThreadPool(2)) {

        //un hilo para hacer la lista de indumentaria y otro para imprimirla.

        }

        List<Indumentaria> outfitList = new ArrayList<>();
        int indumentaria;
        int estilo;
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            indumentaria = random.nextInt(1, 3);
            estilo = random.nextInt(1, 2);

            switch (indumentaria) {
                case 1:
                        if (estilo == 1) {
                            outfitList.add(new ParteDeArriba("Remera", preppy));
                        }
                    break;
            
                default:
                    break;
            }
        }
        

    }


}
