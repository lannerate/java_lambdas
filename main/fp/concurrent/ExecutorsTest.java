package fp.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 9/26/16.
 */
public class ExecutorsTest {

    public static void main(String[] args) {
//       testScheduledExecutorService();
//        testSingleThreadExecutor(3);
        testSingleThreadExecutor(7);
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
