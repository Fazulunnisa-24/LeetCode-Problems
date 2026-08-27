class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        // Try to construct a string equal to target
        // and find the first opportunity to make it greater.
        for (int i = 0; i < n; i++) {

            int targetChar = target.charAt(i) - 'a';

            // Try to keep the prefix equal to target
            if (freq[targetChar] > 0) {
                ans[i] = target.charAt(i);
                freq[targetChar]--;
            } else {
                // Cannot match target[i].
                // Find the smallest character greater than target[i].
                int bigger = findBigger(freq, targetChar);

                if (bigger != -1) {
                    ans[i] = (char) ('a' + bigger);
                    freq[bigger]--;

                    fillRemaining(ans, i + 1, freq);

                    return new String(ans);
                }

                // Cannot continue, so we must backtrack.
                break;
            }
        }

        /*
         * Backtrack.
         *
         * At this point ans[0 ... i-1] may match target.
         * We restore characters that were actually placed.
         */
        int lastValid = 0;

        while (lastValid < n && ans[lastValid] != '\0') {
            lastValid++;
        }

        for (int i = lastValid - 1; i >= 0; i--) {

            // Restore the character at ans[i]
            freq[ans[i] - 'a']++;

            int current = target.charAt(i) - 'a';

            int bigger = findBigger(freq, current);

            if (bigger != -1) {

                ans[i] = (char) ('a' + bigger);
                freq[bigger]--;

                fillRemaining(ans, i + 1, freq);

                return new String(ans);
            }
        }

        return "";
    }

    private int findBigger(int[] freq, int c) {
        for (int i = c + 1; i < 26; i++) {
            if (freq[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    private void fillRemaining(char[] ans, int start, int[] freq) {
        int index = start;

        for (int c = 0; c < 26; c++) {
            while (freq[c] > 0) {
                ans[index++] = (char) ('a' + c);
                freq[c]--;
            }
        }
    }
}