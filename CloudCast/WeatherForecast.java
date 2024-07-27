// Cloud Cast
// Tharul-J

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherForecast {
    private static final String API_KEY = "YOUR_API_KEY_HERE";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter city name: ");
            String city = reader.readLine();

            String urlString = String.format(API_URL, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            JSONObject json = new JSONObject(content.toString());
            JSONObject main = json.getJSONObject("main");
            JSONObject weather = json.getJSONArray("weather").getJSONObject(0);

            System.out.println("Weather forecast for " + city + ":");
            System.out.println("Temperature: " + main.getDouble("temp") + "°C");
            System.out.println("Humidity: " + main.getInt("humidity") + "%");
            System.out.println("Description: " + weather.getString("description"));

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}