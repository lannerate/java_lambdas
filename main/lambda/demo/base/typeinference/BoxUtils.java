package lambda.demo.base.typeinference;


public class BoxUtils {
  
  static Box<String> getBox(){
    return BoxImpl.<String> make();
  }
  
  static <V> void rebox(Box<V> box){
    box.put( box.get() );
  }
  
  public static void main( String[] args ) {
    System.out.println( getBox() );
    
    rebox( getBox() );
  }
}
