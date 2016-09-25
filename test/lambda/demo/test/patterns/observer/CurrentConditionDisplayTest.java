package lambda.demo.test.patterns.observer;

import lambda.demo.patterns.observer.WeatherData;
import lambda.demo.patterns.observer.v2.CurrentConditionDisplay;
import lambda.demo.patterns.observer.v2.Weather;
import org.junit.Test;

/**
 * Created by zh on 16-6-12.
 */
public class CurrentConditionDisplayTest {

    @Test
    public void displayCurrentCondition(){
        Weather weather = new Weather();
        CurrentConditionDisplay display = new CurrentConditionDisplay(weather);
        weather.setWeatherData(new WeatherData(23.3,89.3,77.9));
        weather.setWeatherData(new WeatherData(24.3,90.3,97.9));
        weather.deleteObservers();

        weather.addObserver(display);
        weather.setWeatherData(new WeatherData(34.9,233.9,22.9));
    }
}
