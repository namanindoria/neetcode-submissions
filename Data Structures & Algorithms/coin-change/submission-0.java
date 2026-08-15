class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        long ans= rec(n-1,amount,coins,amount,n);
        if(ans>=Integer.MAX_VALUE) return -1;
        else return (int)ans;
    }
    public long rec(int i ,int k,int[] coins, int amount,int n){
        if(k==0) return 0;
        if(i==0){
             if(k%coins[i]==0){
                return k/coins[i];
             }
             return Integer.MAX_VALUE;

        }
        long stay=Integer.MAX_VALUE;
        if(coins[i]<=k){
            stay=1+Math.min(stay,rec(i,k-coins[i],coins,amount,n));
        }
        long move=rec(i-1,k,coins,amount,n);
        return Math.min(stay,move);
         
    }
}
