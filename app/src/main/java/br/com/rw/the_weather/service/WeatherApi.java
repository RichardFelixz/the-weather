package br.com.rw.the_weather.service;

import br.com.rw.the_weather.model.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi
{
    @GET("weather")
    Call<WeatherModel> getWeather(@Query("lat") String lat, @Query("lon") String lon, @Query("appid") String appid);
}
