import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherService {

    private final String API_KEY = "757e52294937ee3e30cfeef96234f66a";  // OpenWeatherMap API key

    public JSONObject getWeatherData(String location) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&units=metric&appid=" + API_KEY;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            return new JSONObject(content.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
