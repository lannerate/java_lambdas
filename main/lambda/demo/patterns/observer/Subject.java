package lambda.demo.patterns.observer;
public interface Subject{
  void registerObserver(Observer ob);
  void removeObserver(Observer ob);
  void notifyObservers();
}
