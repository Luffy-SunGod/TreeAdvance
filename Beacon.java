import java.util.*;
import java.math.*;

class Main {
    public static final int MOD = 998244353;
    public static final int N = 5;
    public static final int K = 4;
    public static final int L = 1;
    public static final int R = 3;

    public static void main(String[] args) {
        Main solver = new Main();
        System.out.println(solver.solve());
    }

    public long solve() {
        long[][][] dp = new long[N + 1][N + 1][K + 1];

        dp[0][0][0] = 1;

        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= n; m++) {
                for (int k = 0; k <= K; k++) {
                    dp[n][m][k] = modAdd(dp[n][m][k], dp[n - 1][m][k]);

                    if (n > 0) {
                        dp[n][m][k] = modAdd(dp[n][m][k], modMul(dp[n - 1][m - 1][k], n));
                    }

                    if (m > 0) {
                        dp[n][m][k] = modAdd(dp[n][m][k], modMul(dp[n][m - 1][k], m));
                    }

                    if (k > 0) {
                        dp[n][m][k] = modAdd(dp[n][m][k], modMul(dp[n][m][k - 1], k));
                    }
                }
            }
        }

        long ans = 0;

        for (int n = L; n <= N; n++) {
            for (int m = L; m <= N; m++) {
                for (int k = L; k <= K; k++) {
                    ans = modAdd(ans, modMul(dp[n][m][k], nCrMod(n + m, n)));
                }
            }
        }

        return ans;
    }

    public long modAdd(long a, long b) {
        a += b;
        if (a >= MOD) {
            a -= MOD;
        }
        return a;
    }

    public long modMul(long a, long b) {
        return (a * b) % MOD;
    }

    public long nCrMod(int n, int r) {
        long ans = 1;

        for (int i = 0; i < r; i++) {
            ans = modMul(ans, n - i);
            ans = modDiv(ans, i + 1);
        }

        return ans;
    }

    public long modDiv(long a, long b) {
        return modMul(a, powMod(b, MOD - 2));
    }

    public long powMod(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = modMul(ans, a);
            }

            a = modMul(a, a);
            b >>= 1;
        }

        return ans;
    }
}