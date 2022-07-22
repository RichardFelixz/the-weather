package br.com.rw.the_weather.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import java.text.DecimalFormat;

import br.com.rw.the_weather.R;
import br.com.rw.the_weather.model.WeatherModel;
import br.com.rw.the_weather.repositories.RepositoryInstance;
import br.com.rw.the_weather.repositories.WeatherRepository;
import br.com.rw.the_weather.service.WeatherApiService;
import br.com.rw.the_weather.viewmodel.main.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity
{

    private AppCompatTextView tvcity;
    private AppCompatTextView tvtemperature;
    private AppCompatTextView tvhumidity;
    private AppCompatTextView tvvisibility;
    private AppCompatTextView tvwind;
    LottieAnimationView lottieLoading;

    private WeatherViewModel viewModel;

    private String lat;
    private String lon;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        loadparameters();
        initializeComponents();
        checkPermissionsApp();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeComponents()
    {
        tvcity = findViewById(R.id.tvcity);
        tvtemperature = findViewById(R.id.tvtemperature);
        tvhumidity = findViewById(R.id.tvhumidity);
        tvvisibility = findViewById(R.id.tvvisibility);
        tvwind = findViewById(R.id.tvwind);
        lottieLoading = findViewById(R.id.lottieloading);
        //
        RepositoryInstance repositoryInstance = new RepositoryInstance(getApplicationContext());
        viewModel = new WeatherViewModel(repositoryInstance.getWeatherRepository());
    }

    private void loadparameters()
    {
        lat = (String) getIntent().getSerializableExtra("LAT");
        lon = (String) getIntent().getSerializableExtra("LON");
    }

    private void checkPermissionsApp()
    {
        try
        {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        lottieLoading.setVisibility(View.VISIBLE);
        lottieLoading.animate();

        viewModel.getWeatherModel().observe(this, this::updateWeather);

        viewModel.getWeatherModel().observe(this, this::updateWeather);

        viewModel.getWeatherModel(this.lat, this.lon);
    }

    private void updateWeather(WeatherModel weatherModel)
    {
        tvcity.setText(String.format(getString(R.string.location), weatherModel.getName(), weatherModel.getSys().getCountry()));
        tvtemperature.setText(String.format(getString(R.string.grade_celsius), getTemperatureCelsius(weatherModel.getMain().getTemp())));
        tvhumidity.setText(weatherModel.getMain().getHumidity().toString() + "%");
        tvvisibility.setText(String.format(getString(R.string.km), convertMetersToKilometers(weatherModel.getVisibility())));
        tvwind.setText(String.format(getString(R.string.km), weatherModel.getWind().getSpeed().toString()));
        lottieLoading.setVisibility(View.GONE);
        lottieLoading.pauseAnimation();
    }

    private String getTemperatureCelsius(Double temp)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(Double.valueOf((temp - 273.15)));
    }

    private String convertMetersToKilometers(Integer meters)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(meters / 1000);
    }

}