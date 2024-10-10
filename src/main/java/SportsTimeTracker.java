import java.util.HashMap;
import java.util.Map;

public class SportsTimeTracker {
    private final Map<String, Integer> activities = new HashMap<>();

    public void logActivity(String activityName, int timeInMinutes) {
        activities.put(activityName, activities.getOrDefault(activityName, 0) + timeInMinutes);
    }

    public void viewActivities() {
        activities.forEach((activity, time) ->
                System.out.println("Activity: " + activity + ", Time: " + time + " minutes"));
    }

    // New method for testing purposes
    public String viewActivitiesOutput() {
        StringBuilder output = new StringBuilder();
        activities.forEach((activity, time) ->
                output.append("Activity: ").append(activity).append(", Time: ").append(time).append(" minutes\n"));
        return output.toString();
    }

    public int calculateTotalTime() {
        return activities.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        SportsTimeTracker tracker = new SportsTimeTracker();
        tracker.logActivity("Running", 30);
        tracker.logActivity("Swimming", 60);
        tracker.viewActivities();
        System.out.println("Total Time: " + tracker.calculateTotalTime() + " minutes");
    }
}
