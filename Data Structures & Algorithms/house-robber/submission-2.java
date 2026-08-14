class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return rec(n - 1, nums, n, dp);
    }

    public int rec(int i, int nums[], int n, int dp[]) {

        if (dp[i] != -1)
            return dp[i];

        if (i == 0)
            return dp[i] = nums[0];

        int take = nums[i];

        if (i - 2 >= 0)
            take = nums[i] + rec(i - 2, nums, n, dp);

        int ntake = rec(i - 1, nums, n, dp);

        return dp[i] = Math.max(take, ntake);
    }
}