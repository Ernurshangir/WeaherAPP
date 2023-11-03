package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.io.IOException;

public class ControllerXml {
    @FXML
    private TextField cityInput;

    @FXML
    private Text weatherText;

    @FXML
    void getWeatherData() throws IOException {

        JSONObject weather =  new JSONObject(AdapterXmltoJSon.fetchWeather(getWoeid()));
        weatherText.setText("Current temperature: " + weather.getJSONObject("root").getJSONObject("current").getInt("temp_c") + "℃\n"
                            +"Feel like : " + weather.getJSONObject("root").getJSONObject("current").getInt("feelslike_c") + "℃\n"
                            +"Humidity: " + weather.getJSONObject("root").getJSONObject("current").getInt("humidity") + "%\n"
                            +"Pressure: " + weather.getJSONObject("root").getJSONObject("current").getInt("pressure_mb") + "mb");

    }
    public String getWoeid() {
        String jsonData = cityInput.getText();
        return String.valueOf(jsonData);
    }

}