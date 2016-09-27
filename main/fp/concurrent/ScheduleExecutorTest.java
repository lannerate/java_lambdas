package fp.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by hzhang3 on 9/27/2016.
 */
public class ScheduleExecutorTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        testDelyForScheduleExecutor();
//        testFixedRate();
//        testFixedDely();
//        testInvokeAny();
        testInvokeAll();
    }

    static void testInvokeAll() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList( callable("task1",1), callable("task2", 0), callable("task3",0) );

        service.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        service.shutdown();

    }

    static void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList( callable("task1",10), callable("task2", 2 ), callable("task3",3) );

        String result = service.invokeAny(callables);
        System.out.println(result);

        service.shutdown();

    }

    private static Callable<String> callable(String result, long sleep) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleep);
            return result;
        };
    }

    static void testFixedDely(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("scheduling: " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        scheduledExecutorService.scheduleWithFixedDelay(task,0,1,TimeUnit.SECONDS);
    }


    static void testFixedRate(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate( ()->{
            System.out.println("Scheduling: " + System.currentTimeMillis());
        }, 0, 1, TimeUnit.SECONDS);
    }

    static void testDelyForScheduleExecutor() throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.currentTimeMillis());

        ScheduledFuture<?> future = executorService.schedule(task,3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1246);

        System.out.printf("Remaining dely:%sms \n",future.getDelay(TimeUnit.MILLISECONDS));

//        executorService.shutdownNow();
    }


}
