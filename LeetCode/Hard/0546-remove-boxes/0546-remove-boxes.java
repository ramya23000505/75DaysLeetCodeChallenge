class Solution {

    private int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];
        return solve(boxes, 0, n - 1, 0);
    }

    private int solve(int[] boxes, int l, int r, int k) {

        if (l > r)
            return 0;
        while (l < r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        }

        if (dp[l][r][k] != 0)
            return dp[l][r][k];

        int ans = (k + 1) * (k + 1) + solve(boxes, l + 1, r, 0);

        for (int i = l + 1; i <= r; i++) {
            if (boxes[i] == boxes[l]) {
                ans = Math.max(ans,
                        solve(boxes, l + 1, i - 1, 0)
                        + solve(boxes, i, r, k + 1));
            }
        }

        dp[l][r][k] = ans;
        return ans;
    }
}