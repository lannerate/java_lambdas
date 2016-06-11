package lambda.demo.patterns.observer;

/**
 * Created by zh on 16-6-11.
 */
public class ForecastDisplay implements Observer, DisplayElement{
    private WeatherData data ;
    private Weather weather;

    public ForecastDisplay(Weather weather) {
        this.weather = weather;
        weather.registerObserver(this);
    }

    @Override
    public void display() {
        if(data != null)
            System.out.println("Forecast display:" + data.getTemp() + "/" + data.getHumidity() +"/" + data.getPressure());
    }

    @Override
    public void update(Object obj) {
        if(obj instanceof  WeatherData)
            data = (WeatherData) obj;
        display();
    }
}
