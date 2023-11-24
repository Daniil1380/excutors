import java.util.concurrent.*;

public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            Thread.sleep(3000);
            System.out.println("callable работает");
            return 5;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(callable);
        long start = System.currentTimeMillis();
        System.out.println(future.state());
        System.out.println(future.isDone());
        System.out.println(future.get());
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        System.out.println("А вот и дождались");

    }
}
