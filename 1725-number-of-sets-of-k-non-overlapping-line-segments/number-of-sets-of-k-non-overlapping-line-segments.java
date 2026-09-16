class Solution {
    public int numberOfSets(int n, int k) {
      long[][] dp =new long[n+k][2*k+1];
      for(int i=0;i<n+k;i++){
        dp[i][0]=1;
      }  
      for(int i=1;i<n+k;i++){

    for(int j=1;j<=2*k;j++){
     dp[i][j] = dp[i-1][j];
     if(i>=j){
        dp[i][j] += dp[i-1][j-1];
        dp[i][j] %= 1000000007;
     }
    }
}    
return(int) dp[n+k-1][2*k];
}
}