import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Put all numbers into HashSet
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        // Iterate through unique numbers
        for (int num : set) {

            // Only start if num is the beginning
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}