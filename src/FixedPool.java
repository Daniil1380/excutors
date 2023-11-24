import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPool {

    public static void main(String[] args) {
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(4);
        ExecutorService cachedExecutorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            //singleExecutorService.execute(new Printer());
            fixedExecutorService.execute(new Printer());
            //cachedExecutorService.execute(new Printer());
        }

    }
}
