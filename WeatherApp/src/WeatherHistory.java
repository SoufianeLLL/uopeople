import java.util.LinkedList;
import java.util.List;



public class WeatherHistory {
    private static final int MAX_HISTORY_SIZE = 10;
    private LinkedList<String> recentSearches = new LinkedList<>();

    public void addSearch(String location) {
        if (recentSearches.size() >= MAX_HISTORY_SIZE) {
            recentSearches.removeFirst();
        }
        recentSearches.add(location);
    }

    public List<String> getRecentSearches() {
        return recentSearches;
    }
}
