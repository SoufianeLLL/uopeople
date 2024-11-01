import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONObject;
import java.util.List;



public class WeatherApp extends Application {

    private TextField locationField;
    private Label temperatureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private Label conditionLabel;
    private ImageView weatherIcon;
    private WeatherService weatherService;
    private WeatherHistory weatherHistory;
    private ListView<String> historyList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Information App");

        // Initialize GUI components
        locationField = new TextField();
        locationField.setPromptText("Enter city name");

        Button getWeatherButton = new Button("Get Weather");

        temperatureLabel = new Label("Temperature:");
        humidityLabel    = new Label("Humidity:");
        windSpeedLabel   = new Label("Wind Speed:");
        conditionLabel   = new Label("Condition:");
        weatherIcon      = new ImageView();
        historyList      = new ListView<>();
        weatherService   = new WeatherService();
        weatherHistory   = new WeatherHistory();

        // Button action
        getWeatherButton.setOnAction(event -> {
            String location = locationField.getText();
            if (!location.isEmpty()) {
                displayWeather(location);
            }
            else {
                showAlert("Please enter a location.");
            }
        });

        // Layout setup
        VBox root = new VBox(10, locationField, getWeatherButton, temperatureLabel, humidityLabel, windSpeedLabel, conditionLabel, weatherIcon, new Label("Search History:"), historyList);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void displayWeather(String location) {
        try {
            JSONObject weatherData = weatherService.getWeatherData(location);
            if (weatherData != null) {
                double temp = weatherData.getJSONObject("main").getDouble("temp");
                int humidity = weatherData.getJSONObject("main").getInt("humidity");
                double windSpeed = weatherData.getJSONObject("wind").getDouble("speed");
                String condition = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");

                temperatureLabel.setText("Temperature: " + temp + " °C");
                humidityLabel.setText("Humidity: " + humidity + " %");
                windSpeedLabel.setText("Wind Speed: " + windSpeed + " m/s");
                conditionLabel.setText("Condition: " + condition);

                String iconCode = weatherData.getJSONArray("weather").getJSONObject(0).getString("icon");
                Image icon = new Image("file:resources/icons/" + iconCode + ".png");
                weatherIcon.setImage(icon);

                weatherHistory.addSearch(location);
                updateHistoryList();
            }
        }
        catch (Exception e) {
            showAlert("Failed to retrieve weather data.");
            e.printStackTrace();
        }
    }


    private void updateHistoryList() {
        historyList.getItems().clear();
        List<String> recentSearches = weatherHistory.getRecentSearches();
        historyList.getItems().addAll(recentSearches);
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}
