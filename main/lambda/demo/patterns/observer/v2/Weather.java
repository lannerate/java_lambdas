package lambda.demo.patterns.observer.v2;

import lambda.demo.patterns.observer.WeatherData;

import java.util.Observable;

/**
 * Created by zh on 16-6-12.
 */
public class Weather extends Observable {
    private WeatherData data;

    public Weather() {
    }

    private void measurementChanged(){
        setChanged();
        notifyObservers(data);
    }

    public void setWeatherData(WeatherData data){
        this.data = data;
        measurementChanged();
    }

    public WeatherData getWeatherData(){
        return data;
    }

}
