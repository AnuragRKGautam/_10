package configuration;

public class constants {
    public String WEATHER_API_APP_KEY="&appid=f8833b852530dffbd6352d7cd9e41b00";
    public   String OWM_WEATHER_2_5 = "http://api.openweathermap.org/data/2.5/weather";
    public   String OWM_BOX_2_5 = "http://api.openweathermap.org/data/2.5/box";


private constants(){}

private static class SingletonHelper{
    private static final constants INSTANCE = new constants();
}
public static constants getInstance(){
    return  SingletonHelper.INSTANCE;
}
}
