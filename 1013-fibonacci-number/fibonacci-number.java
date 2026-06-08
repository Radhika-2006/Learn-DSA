class Solution {
    public int fib(int n){
        int dp[]=new int[n+1];
        return f(n,dp);
    }
    int f(int n,int dp[]){
        if(n<=1) return n;
        if(dp[n]!=0)return dp[n];
        return dp[n]=f(n-1,dp)+f(n-2,dp);
    }
}