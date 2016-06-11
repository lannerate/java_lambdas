package lambda.demo.patterns.observer;

/**
 * Created by zh on 16-6-11.
 */
public class WeatherData {
    private double  temp;

    private double  humidity;

    private double pressure;

    public WeatherData(double temp, double humidity, double pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
