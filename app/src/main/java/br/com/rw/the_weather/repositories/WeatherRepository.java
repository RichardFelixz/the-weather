package br.com.rw.the_weather.repositories;

import br.com.rw.the_weather.model.WeatherModel;
import br.com.rw.the_weather.service.WeatherApiService;
import retrofit2.Call;

public class WeatherRepository
{

    private WeatherApiService weatherApiService;

    public WeatherRepository(WeatherApiService weatherApiService)
    {
        this.weatherApiService = weatherApiService;
    }

    public Call<WeatherModel> getWeatherByLatLon(String lat, String lon)
    {
        return weatherApiService.getWeatherModelByLatLon(lat, lon);
    }

}

