package com.londonappbrewery.climapm;

import android.media.Image;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    // TODO: Declare the member variables here
    // 133 first declare member variables
    // remember, type then the name of variable
    private String mTemperature;
    private int mCondition;
    private String mCity;
    private String mIconName;
    private int tempResult;


    // TODO: Create a WeatherDataModel from a JSON:
    //133-2 create WeatherDataModel from JSON (Method)
    //when there is "()" on method, you have to return something
    public static WeatherDataModel fromJson(JSONObject jsonObject){

        try {
            WeatherDataModel weatherData = new WeatherDataModel();
            weatherData.mCity = jsonObject.getString("name");
            weatherData.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mIconName = updateWeatherIcon(weatherData.mCondition);

            double tempResult = jsonObject.getJSONObject("name").getDouble("temp")-273.15;
            int roundedValue = (int) Math.rint(tempResult);

            //133-8 fetch temperature to textvalue
            // can i say: call weatherData as mTemperature using integer the parameter is roundedvalue?
            weatherData.mTemperature = Integer.toString(roundedValue);

            return weatherData;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;

        }

    }
    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {
        //133-6 uncomment this
        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";

    }

    // TODO: Create getter methods for temperature, city, and icon name:


    public String getmTemperature() {


        return mTemperature + "°";
    }

    public String getmCity() {
        return mCity;
    }

    public String getmIconName() {
        return mIconName;
    }
}
