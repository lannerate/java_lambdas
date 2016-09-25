package lambda.demo.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {

    private List<Observer> observers;

    private WeatherData data;

    public Weather() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        if(observers.contains(ob))
            observers.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.update(data);
        }
    }

    private void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurement(WeatherData data){
        this.data = data;
        measurementChanged();
    }
}
