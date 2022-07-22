package br.com.rw.the_weather.viewmodel.main;

import androidx.lifecycle.MutableLiveData;

import br.com.rw.the_weather.model.WeatherModel;
import br.com.rw.the_weather.repositories.WeatherRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel
{

    private WeatherRepository weatherRepository;

    private MutableLiveData<WeatherModel> weatherModel;
    private MutableLiveData<String> errorMessage;

    public WeatherViewModel(WeatherRepository weatherRepository)
    {
        this.weatherRepository = weatherRepository;
        this.weatherModel = new MutableLiveData<>();
        this.errorMessage = new MutableLiveData<>();
    }

    public void getWeatherModel(String lat, String lon)
    {
        Call<WeatherModel> request = weatherRepository.getWeatherByLatLon(lat, lon);
        request.enqueue(new Callback<WeatherModel>()
        {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response)
            {
                if(response.code() == 200)
                {
                    weatherModel.postValue(response.body());
                }
                else
                {
                    errorMessage.postValue("Erro ao recuperar o clima");
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t)
            {
                errorMessage.postValue(t.getMessage());
            }
        });
    }

    public MutableLiveData<WeatherModel> getWeatherModel()
    {
        return weatherModel;
    }

    public void setWeatherModel(MutableLiveData<WeatherModel> weatherModel)
    {
        this.weatherModel = weatherModel;
    }

    public MutableLiveData<String> getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(MutableLiveData<String> errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}
