import java.text.SimpleDateFormat;
import java.util.Date;


public class Clock {
    private String currentTime;

    // Method to continuously update the current time
    public void updateTime() {
        while (true) {

            // Get the current time and date
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            currentTime = formatter.format(new Date());
            try {
                // Sleep for one second before updating
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Method to get the current time
    public String getCurrentTime() {
        return currentTime;
    }
}
