package fp.concurrent;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * Created by apple on 9/26/16.
 */
public class ExecutorsTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//       testScheduledExecutorService();
//        testSingleThreadExecutor(3);
//        testSingleThreadExecutor(7);
          testFutureWithExecutor1();
    }
    public static void testFutureWithExecutor1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 122;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted",e);
            }
        });
        executorService.shutdownNow();
        Integer result = future.get();
    }
    public static void testFutureWithExecutor3() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 122;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted",e);
            }
        });
        System.out.print( future.get(3,TimeUnit.SECONDS) );

    }

    public static void testFutureWithExecutor2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 122;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted",e);
            }
        });

        System.out.println("Future done: " + future.isDone());
        Integer result = future.get();
        System.out.println("Future done: " + future.isDone());

        System.out.println("result:" + result);

        executorService.shutdownNow();
    }

    public static void testScheduledExecutorService(){
        ScheduledExecutorService executorService = java.util.concurrent.Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling:" + System.currentTimeMillis()/1000);
            }
            catch (InterruptedException e){
                System.err.println("task interrupted");
            }
        };

        executorService.scheduleWithFixedDelay(task,0,1, TimeUnit.SECONDS);

    }


    public static void testSingleThreadExecutor(long sleep){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(sleep);
                System.out.println("task finished: " + Thread.currentThread().getName() );
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });

        stop(executorService);
    }

    public static void stop(ExecutorService service){
        try {
            System.out.println("attempt to shutdown executor");
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if(!service.isTerminated()){
                System.err.println("killing non-finished tasks");
            }
            service.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
