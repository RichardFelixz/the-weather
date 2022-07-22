package br.com.rw.the_weather.model;

public class Location
{
    private String country;
    private String latitude;
    private String longitude;

    public Location()
    {
    }

    public Location(String country, String latitude, String longitude)
    {
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }
}
