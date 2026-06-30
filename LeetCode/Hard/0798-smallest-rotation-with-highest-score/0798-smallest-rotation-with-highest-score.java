class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] dif = new int[n];

        for (int i = 0; i < n; i++) {
            int left = (i - nums[i] + 1 + n) % n;
            int right = (i + 1) % n;

            dif[left]--;
            dif[right]++;

            if (left > right) {
                dif[0]--;
            }
        }

        int best = 0;
        int score = 0;
        int maxScore = 0;

        for (int k = 1; k < n; k++) {
            score += dif[k];
            if (score > maxScore) {
                maxScore = score;
                best = k;
            }
        }

        return best;
    }
}