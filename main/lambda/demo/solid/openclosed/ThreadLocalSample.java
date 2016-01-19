package lambda.demo.solid.openclosed;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadLocalSample {
  
  public static void main( String[] args ) {
    
    ThreadLocal<DateFormat> localDateFormat = ThreadLocal.withInitial( SimpleDateFormat::new );
    DateFormat dateFormat = localDateFormat.get();
    
    AtomicInteger threadId = new AtomicInteger();
    ThreadLocal<Integer> localID = ThreadLocal.withInitial( () -> threadId.getAndIncrement() );
    
  }
}
