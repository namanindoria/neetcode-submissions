class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0];
        return Math.max(
            robRange(nums, n-2, 0),
            robRange(nums, n-1, 1)
        );
    }
    private int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return rec( start,nums,dp, end);
    }
    public int rec(int i, int nums[], int dp[],int k) {
        if (dp[i] != -1)
            return dp[i];

        if (i == k)
            return dp[i] = nums[k];

        int take = nums[i];

        if (i - 2 >= k)
            take = nums[i] + rec(i - 2, nums, dp,k);
        int ntake=0;
        if(i-1>=k)ntake = rec(i - 1, nums, dp,k);

        return dp[i] = Math.max(take, ntake);
    }
}
