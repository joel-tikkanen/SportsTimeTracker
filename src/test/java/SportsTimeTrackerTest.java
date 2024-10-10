import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SportsTimeTrackerTest {

    private SportsTimeTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new SportsTimeTracker();
    }

    @Test
    void testLogActivity() {
        tracker.logActivity("Running", 30);
        assertEquals(30, tracker.calculateTotalTime(), "Logging 30 minutes for Running failed.");
    }

    @Test
    void testLogMultipleActivities() {
        tracker.logActivity("Running", 30);
        tracker.logActivity("Swimming", 60);
        assertEquals(90, tracker.calculateTotalTime(), "Total time should be 90 minutes after logging two activities.");
    }

    @Test
    void testViewActivities() {
        tracker.logActivity("Running", 30);
        tracker.logActivity("Swimming", 60);

        String expectedOutput = "Activity: Running, Time: 30 minutes\n" +
                "Activity: Swimming, Time: 60 minutes\n";
        String output = tracker.viewActivitiesOutput();
        assertEquals(expectedOutput, output, "The activity output is not as expected.");
    }

    @Test
    void testTotalTimeWithMultipleLogsOfSameActivity() {
        tracker.logActivity("Running", 30);
        tracker.logActivity("Running", 45);
        assertEquals(75, tracker.calculateTotalTime(), "Total time for repeated activity logging is incorrect.");
    }

    @Test
    void testCalculateTotalTime() {
        tracker.logActivity("Running", 30);
        tracker.logActivity("Swimming", 60);
        tracker.logActivity("Cycling", 45);

        int totalTime = tracker.calculateTotalTime();
        assertEquals(135, totalTime, "The total time calculation is incorrect.");
    }
}
