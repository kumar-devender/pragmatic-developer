package info.pragmaticdeveloper.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class DominatorFinder {
    public int findDominator(int[] arr) {
        if (arr.length < 1) {
            return -1;
        }

        Map<Integer, Integer> presenceCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            if (!presenceCount.containsKey(e)) {
                presenceCount.put(e, 1);
            } else {
                presenceCount.put(e, presenceCount.get(e) + 1);
            }

            if (presenceCount.get(e) > arr.length / 2) {
                return i;
            }
        }
        return -1;
    }

    public int equiLeaderCount(int[] arr) {
        Map<Integer, Integer> presenceCount = new HashMap<>();
        int leader = Integer.MIN_VALUE;
        for (int e : arr) {
            if (!presenceCount.containsKey(e)) {
                presenceCount.put(e, 1);
            } else {
                presenceCount.put(e, presenceCount.get(e) + 1);
            }

            if (presenceCount.get(e) > arr.length / 2) {
                leader = e;
            }
        }

        if (leader == Integer.MIN_VALUE) {
            return 0;
        }

        var leaderPresenceCount = presenceCount.get(leader);
        int leftSubArrayElementCount = 0;
        int rightSubArrayElementCount = arr.length;
        int leftleaderCount = 0;
        int equiLeaderCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == leader) {
                leftleaderCount++;
                leaderPresenceCount--;
            }
            leftSubArrayElementCount++;
            rightSubArrayElementCount--;

            if (leftleaderCount > (leftSubArrayElementCount / 2) && leaderPresenceCount > (rightSubArrayElementCount / 2)) {
                equiLeaderCount++;
            }
        }
        return equiLeaderCount;
    }

}
