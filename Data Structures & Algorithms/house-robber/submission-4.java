class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        int prev=nums[0];;
        int prev2=0;
       
        for (int i = 1; i < n; i++) {
            int take = nums[i];

            if (i - 2 >= 0)
                take = nums[i] + prev2;

            int ntake = prev;

             int cur = Math.max(take, ntake);
             prev2=prev;
             prev=cur;

        }
        

        return prev;
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