import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {

            for (int i = 0; i < 3; i++) {
                //1 пример
                Printer printer = new Printer();
                executorService.execute(printer);
            }
            System.out.println("А мы уже закончили");

            //2 пример
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Новая задача");
            });

            //3 пример
            Runnable runnable = () -> {
                System.out.println(123);
            };
            executorService.execute(runnable);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}