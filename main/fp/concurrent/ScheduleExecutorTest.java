package fp.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzhang3 on 9/27/2016.
 */
public class ScheduleExecutorTest {

    public static void main(String[] args) throws InterruptedException {
//        testDelyForScheduleExecutor();
        testFixedRate();
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
