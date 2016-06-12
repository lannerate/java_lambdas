package lambda.demo.patterns.observer.v2;

import lambda.demo.patterns.observer.DisplayElement;
import lambda.demo.patterns.observer.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * Using java.util.Observer to implement Observer pattern
 */
public class CurrentConditionDisplay implements Observer, DisplayElement{
    private Observable observable;
    private WeatherData data;
    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition display:"+ data.getHumidity() +"/" + data.getTemp() +"/" + data.getPressure());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Weather){
            Weather weather = (Weather) o;
            data = weather.getWeatherData();
            display();
        }
    }
}
