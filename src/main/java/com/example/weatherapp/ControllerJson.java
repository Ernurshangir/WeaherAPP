package com.example.weatherapp;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.io.IOException;

public class ControllerJson {
    @FXML
    private TextField cityInput;

    @FXML
    private Text weatherText;

    @FXML
    void getWeatherData() throws IOException {

        JSONObject todaysWeather =  new JSONObject(Json.fetchWeather(getWoeid()));
        weatherText.setText("Current temperature: "+ (todaysWeather.getJSONObject("main").getInt("temp") - 273) + "℃\n"
                        +"Feel like: " + (todaysWeather.getJSONObject("main").getInt("feels_like") - 273) + "℃\n"
                        +"Humidity: " + todaysWeather.getJSONObject("main").getInt("humidity") + "%\n"
                        +"Pressure: " + todaysWeather.getJSONObject("main").getInt("pressure"));

    }
    public String getWoeid() {
        String jsonData = cityInput.getText();
        return String.valueOf(jsonData);
    }

}