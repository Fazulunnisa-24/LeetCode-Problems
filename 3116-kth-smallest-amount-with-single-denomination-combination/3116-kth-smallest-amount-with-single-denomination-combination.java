import java.util.*;

class Solution {

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        // Remove redundant coins.
        // If a coin is divisible by another smaller coin,
        // its multiples are already covered.
        Arrays.sort(coins);

        List<Integer> list = new ArrayList<>();

        for (int coin : coins) {
            boolean redundant = false;

            for (int x : list) {
                if (coin % x == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                list.add(coin);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        long low = 1;
        long high = (long) arr[0] * k;

        // Binary search for the smallest x
        // such that count(x) >= k.
        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, arr) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long result = 0;

        // Inclusion-exclusion
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long ways = x / lcm;

            if ((bits & 1) == 1) {
                result += ways;
            } else {
                result -= ways;
            }
        }

        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}