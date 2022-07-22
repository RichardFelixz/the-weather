package br.com.rw.the_weather.model;

import java.util.List;

public class WeatherModel
{
    private String base;
    private Clouds clouds;
    private Integer cod;
    private Coord coord;
    private Integer dt;
    private Integer id;
    private Main main;
    private String name;
    private Sys sys;
    private Integer timezone;
    private Integer visibility;
    private List<Weather> weather;
    private Wind wind;



    public WeatherModel(String base, Clouds clouds, Integer cod, Coord coord, Integer dt, Integer id, Main main, String name, Sys sys, Integer timezone, Integer visibility, List<Weather> weather, Wind wind)
    {
        this.base = base;
        this.clouds = clouds;
        this.cod = cod;
        this.coord = coord;
        this.dt = dt;
        this.id = id;
        this.main = main;
        this.name = name;
        this.sys = sys;
        this.timezone = timezone;
        this.visibility = visibility;
        this.weather = weather;
        this.wind = wind;
    }

    public String getBase()
    {
        return base;
    }

    public void setBase(String base)
    {
        this.base = base;
    }

    public Clouds getClouds()
    {
        return clouds;
    }

    public void setClouds(Clouds clouds)
    {
        this.clouds = clouds;
    }

    public Integer getCod()
    {
        return cod;
    }

    public void setCod(Integer cod)
    {
        this.cod = cod;
    }

    public Coord getCoord()
    {
        return coord;
    }

    public void setCoord(Coord coord)
    {
        this.coord = coord;
    }

    public Integer getDt()
    {
        return dt;
    }

    public void setDt(Integer dt)
    {
        this.dt = dt;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Main getMain()
    {
        return main;
    }

    public void setMain(Main main)
    {
        this.main = main;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Sys getSys()
    {
        return sys;
    }

    public void setSys(Sys sys)
    {
        this.sys = sys;
    }

    public Integer getTimezone()
    {
        return timezone;
    }

    public void setTimezone(Integer timezone)
    {
        this.timezone = timezone;
    }

    public Integer getVisibility()
    {
        return visibility;
    }

    public void setVisibility(Integer visibility)
    {
        this.visibility = visibility;
    }

    public List<Weather> getWeather()
    {
        return weather;
    }

    public void setWeather(List<Weather> weather)
    {
        this.weather = weather;
    }

    public Wind getWind()
    {
        return wind;
    }

    public void setWind(Wind wind)
    {
        this.wind = wind;
    }
}
