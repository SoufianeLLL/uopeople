# Weather Information App
This Weather Information App is a Java application that provides real-time weather updates using a graphical user interface (GUI). 

![Weather App](https://i.ibb.co/rMB1Rqv/Screen-Shot-2024-11-01-at-01-31-26.png)

## Features
- **Real-Time Weather Data:** Fetches weather data using the OpenWeatherMap API.
- **JavaFX GUI:** User-friendly GUI for entering locations and displaying weather information.
- **Weather Icons:** Displays icons based on weather conditions.
- **History:** Keeps track of recent searches.
- **Error Handling:** Handles invalid inputs and failed API requests gracefully.

## Requirements
- **Java Development Kit (JDK):** Make sure you have JDK 8 or above installed.
- **JavaFX:** Ensure JavaFX is set up in your environment.
- **OpenWeatherMap API Key:** Sign up at OpenWeatherMap to get your API key.


## Compile the Java files using the following command:

```bash
cd /path/to/WeatherApp/src
```

#### Compile with Classpath:
```bash
javac --module-path /path/to/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -cp .:json.jar *.java
```

#### Run the Program with Classpath:
```bash
java --module-path /path/to/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -cp .:json.jar WeatherApp
```


## Links
- Download org.json JAR files with all dependencies: https://jar-download.com/artifacts/org.json
- JavaFX: https://gluonhq.com/products/javafx
