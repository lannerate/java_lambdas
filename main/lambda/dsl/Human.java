package lambda.dsl;


public class Human {
  private int age;
  
  private String name;
  
  private boolean female;
  
  public Human(int age, String name, boolean female) {
    this.age = age;
    this.name = name;
    this.female = female;
  }
  public int getAge() {
    return age;
  }
  
  public String getName() {
    return name;
  }
  
  public boolean female() {
    return female;
  }
  
}
