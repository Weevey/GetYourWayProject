package com.sky.getYourWayLGs.weatherRequest;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class weatherRequest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a city name: ");
        String cityName = scanner.nextLine();
        scanner.close();

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=f34536cfb20e6a85cadc9fadd3671867&units=metric");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                System.out.println("Error: " + responseCode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                StringBuilder sb = new StringBuilder();
                while (sc.hasNext()) {
                    sb.append(sc.nextLine());
                }
                sc.close();

                String jsonString = sb.toString();
                JSONObject json = new JSONObject(jsonString);
                double temperature = json.getJSONObject("main").getDouble("temp");
                System.out.println("The temperature in " + cityName + " is " + temperature + "°C");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
