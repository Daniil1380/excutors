import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Difference {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(123);
        });


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println(123);
        });
    }
}
