import java.util.Random;
import java.util.concurrent.*;

public class SecondExampleCallable {

    public static void main(String[] args) {
        Callable<Boolean> callable = () -> {
            Random random = new Random();
            int number = random.nextInt(0, 1000);

            if (number != 0) {
                System.out.println("Все очень плохо");
                return false;
            } else {
                System.out.println("Все очень хорошо");
                return true;
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Boolean> future;

        try {
            //Boolean result = future.get();
            //if (result) {
            //    System.out.println("Супер");
            //}
            //else {
            //    future = executorService.submit(callable);
            //    System.out.println(future.get());
            //}

            do {
                future = executorService.submit(callable);
            } while (!future.get());




        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
