package geeks.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

/**
 * Time complexity - O(NlogN)
 * Space complexity - O(N)
 * <p>
 * Prefer geeks solution as it is doing in O(1) space complexity
 * by sorting individual array and then processing in merge sort way.
 */
public class MinPlatform {
    static class Event {
        int time;
        char type;

        Event(int time, char type) {
            this.time = time;
            this.type = type;
        }
    }

    static int findPlatform(int[] ar, int[] dep, int n) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new Event(ar[i], 'A'));
        }
        for (int i = 0; i < n; i++) {
            events.add(new Event(dep[i], 'D'));
        }
        events.sort(Comparator.comparingInt(o -> o.time));
        int maxPlatform = 0;
        int platform = 0;
        for (Event e : events) {
            if (e.type == 'A') {
                platform++;
                maxPlatform = Math.max(maxPlatform, platform);
            } else {
                platform--;
            }
        }
        return maxPlatform;
    }
}
