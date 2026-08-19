import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        // Store reserved seats for only the rows that have reservations
        Map<Integer, Integer> map = new HashMap<>();

        // Seats that matter:
        // 2,3,4,5,6,7,8,9
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int s = seat[1];

            if (s >= 2 && s <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << s));
            }
        }

        // Initially, all rows without reservations can fit 2 groups
        long answer = (long) (n - map.size()) * 2;

        // Process rows containing relevant reserved seats
        for (int mask : map.values()) {

            // Left block: 2,3,4,5
            boolean left = (mask & (1 << 2)) == 0 &&
                           (mask & (1 << 3)) == 0 &&
                           (mask & (1 << 4)) == 0 &&
                           (mask & (1 << 5)) == 0;

            // Right block: 6,7,8,9
            boolean right = (mask & (1 << 6)) == 0 &&
                            (mask & (1 << 7)) == 0 &&
                            (mask & (1 << 8)) == 0 &&
                            (mask & (1 << 9)) == 0;

            // Middle block: 4,5,6,7
            boolean middle = (mask & (1 << 4)) == 0 &&
                             (mask & (1 << 5)) == 0 &&
                             (mask & (1 << 6)) == 0 &&
                             (mask & (1 << 7)) == 0;

            if (left && right) {
                // Can place two groups
                answer += 2;
            } else if (left || right || middle) {
                // Can place one group
                answer += 1;
            }
        }

        return (int) answer;
    }
}