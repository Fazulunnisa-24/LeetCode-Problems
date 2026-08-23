class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int sumDiff = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                sumDiff += num.charAt(i) - '0';
            }
        }

        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                sumDiff -= num.charAt(i) - '0';
            }
        }

        int qDiff = leftQ - rightQ;

        if (qDiff % 2 != 0) {
            return true;
        }

        return sumDiff != -9 * (qDiff / 2);
    }
}