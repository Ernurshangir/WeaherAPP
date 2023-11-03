package com.example.weatherapp;

import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class AdapterXmltoJSon {
    public static String fetchWeather(String city) throws IOException {
        String apiUrl = "http://api.weatherapi.com/v1/current.xml?key=e20991e61c4c45c9bc454724230211&q="+city+"&aqi=no";
        System.out.println("XML weather file");
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner reader = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (reader.hasNext()) {
                response.append(reader.nextLine());
            }
            reader.close();
            // convert XML file to Json file
            JSONObject json = XML.toJSONObject(response.toString());
            return String.valueOf(json);
        } else {
            throw new IOException("Error fetching weather data. Response code: " + responseCode);
        }
    }
}
