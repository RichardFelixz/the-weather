package br.com.rw.the_weather.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.DefaultLifecycleObserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import br.com.rw.the_weather.model.WeatherModel;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiService
{
    private static String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static String API_KEY = "05b0e7217d362b952b0c373a5f57bb0a";
    protected static int TIME_OUT = 120;

    private Context context;

    public WeatherApiService(Context context)
    {
        this.context = context;
    }

    protected Retrofit getNoneApiInstance()
    {
        return new Retrofit
                .Builder().client(getOkHttpClientInstance())
                .baseUrl(BASE_URL)
                .build();
    }

    protected Retrofit getJsonApiInstance()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit
                .Builder().client(getOkHttpClientInstance())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public synchronized static OkHttpClient getOkHttpClientInstance()
    {
         return new OkHttpClient.Builder().connectTimeout(TIME_OUT,
                                        TimeUnit.SECONDS).readTimeout(TIME_OUT,
                                        TimeUnit.SECONDS).writeTimeout(TIME_OUT,
                                        TimeUnit.SECONDS).build();
    }

    public Call<WeatherModel> getWeatherModelByLatLon(String lat, String lon){
        return getJsonApiInstance().create(WeatherApi.class).getWeather(lat, lon, API_KEY);
    }
}
