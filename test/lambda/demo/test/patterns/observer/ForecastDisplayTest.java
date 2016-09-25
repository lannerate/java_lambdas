package lambda.demo.test.patterns.observer;

import lambda.demo.patterns.observer.ForecastDisplay;
import lambda.demo.patterns.observer.Weather;
import lambda.demo.patterns.observer.WeatherData;
import org.junit.Test;

/**
 * Created by zh on 16-6-11.
 */
public class ForecastDisplayTest {

    @Test
    public void testForecastDisplay(){
        Weather weather = new Weather();
        ForecastDisplay display = new ForecastDisplay(weather);
        weather.setMeasurement(new WeatherData(32.6, 89.4, 400.2));
        weather.setMeasurement(new WeatherData(34.6, 90.3, 499.2));

        weather.removeObserver(display);
    }


}
