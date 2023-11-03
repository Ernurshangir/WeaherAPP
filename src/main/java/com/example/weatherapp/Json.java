package com.example.weatherapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Json {
    public static String fetchWeather(String city) throws IOException {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=bb10a01c853814bdc844bf02106099a6";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println("Json weather file");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner reader = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (reader.hasNext()) {
                response.append(reader.nextLine());
            }
            reader.close();
            return response.toString();
        } else {
            throw new IOException("Error fetching weather data. Response code: " + responseCode);
        }
    }
}
