class Solution {
    public int stoneGameII(int[] piles) {
       int n= piles.length;
       int[][] dp = new int[n+1][n+1];
       int[] suffix = new int[n+1];
       for(int i= n-1;i>=0;i--){
        suffix[i] = suffix[i+1] + piles[i];
       } 
       for(int i=n-1;i>=0;i--){
        for(int M =1;M <= n;M++){
            if(2 * M >= n-i){
                dp[i][M] = suffix[i];
            }else{
                int opponent = Integer.MAX_VALUE;
                for(int x=1;x<= 2*M;x++){
                    opponent = Math.min(opponent,dp[i+x][Math.max(M,x)]);
                }
                dp[i][M]=suffix[i] - opponent;
            }
        }
       }
       return dp[0][1];
    }
}