class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        // Store positions of all 1s
        int[] ones = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones[count++] = i;
            }
        }

        // Not enough 1s
        if (count < k) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        String answer = "";

        // Take every group of k consecutive 1s
        for (int i = 0; i + k - 1 < count; i++) {

            int start = ones[i];
            int end = ones[i + k - 1];

            int len = end - start + 1;

            if (len < minLen) {
                minLen = len;
                answer = s.substring(start, end + 1);
            } 
            else if (len == minLen) {
                String current = s.substring(start, end + 1);

                if (current.compareTo(answer) < 0) {
                    answer = current;
                }
            }
        }

        return answer;
    }
}