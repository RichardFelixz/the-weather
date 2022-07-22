package br.com.rw.the_weather.repositories;

import android.content.Context;

import br.com.rw.the_weather.service.WeatherApiService;

public class RepositoryInstance
{
    private Context context;

    public RepositoryInstance(Context context)
    {
        this.context = context;
    }

    public WeatherRepository getWeatherRepository()
    {
        WeatherApiService weatherApiService = new WeatherApiService(context);
        return new WeatherRepository(weatherApiService);
    }
}
