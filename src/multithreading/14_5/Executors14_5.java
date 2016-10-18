package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by max on 10/18/16.
 */
public class Executors14_5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newFixedThreadPool(1);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new MyRunnuble());
        System.out.println(executorService.submit(new MyCallble()).get());
        executorService.shutdown();
    }
    static class MyRunnuble implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
    static class MyCallble<T> implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
