package br.com.rw.the_weather.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.rw.the_weather.R;
import br.com.rw.the_weather.model.Location;
import br.com.rw.the_weather.repositories.WeatherRepository;
import br.com.rw.the_weather.service.WeatherApiService;
import br.com.rw.the_weather.viewmodel.main.WeatherViewModel;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView rvLocations;
    private List<Location> listLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createListOfLocation();
        initializeComponents();

    }

    private void createListOfLocation()
    {
        //LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        listLocations = new ArrayList<>();
        listLocations.add(new Location("Lisbon", "38.7071", "-9.13549"));
        listLocations.add(new Location("Madrid", "40.4167754", "-3.7037902"));
        listLocations.add(new Location("Paris", "48.856614", "2.3522219"));
        listLocations.add(new Location("Berlin", "52.5186", "13.4081"));
        listLocations.add(new Location("Copenhagen", "55.6760968", "12.5683371"));
        listLocations.add(new Location("Rome", "41.9027835", "12.4963655"));
        listLocations.add(new Location("London", "51.509093", "-0.094151"));
        listLocations.add(new Location("Dublin", "53.349805", "-6.260310"));
        listLocations.add(new Location("Prague", "50.0755381", "14.4378005"));
        listLocations.add(new Location("Vienna", "48.2081743", "16.3738189"));
    }

    private void initializeComponents()
    {
        rvLocations = findViewById(R.id.rvLocations);
        rvLocations.setAdapter(new LocationsAdapter(getApplicationContext(), listLocations));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
}