public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();

        // Create a thread for updating the time
        Thread updateThread = new Thread(() -> clock.updateTime());
        
        // Create a display thread with higher priority
        ClockDisplayThread displayThread = new ClockDisplayThread(clock);
        displayThread.setPriority(Thread.MAX_PRIORITY);

        // Start the threads
        updateThread.start();
        displayThread.start();
    }
}
