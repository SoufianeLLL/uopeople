
public class ClockDisplayThread extends Thread {
    private Clock clock;

    // Constructor to initialize the Clock object
    public ClockDisplayThread(Clock clock) {
        this.clock = clock;
    }

    // Override the run method to display the time
    @Override
    public void run() {
        while (true) {

            // Print the current time
            System.out.println(clock.getCurrentTime());
            try {
                // Sleep for one second before printing again
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
