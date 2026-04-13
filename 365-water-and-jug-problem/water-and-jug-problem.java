class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target>x+y) return false;
        int gcd=gcd(x,y);
        return target%gcd==0;
    }
    int gcd(int x, int y){
        int dividend=x;
        int divisor=y;
        while(dividend % divisor !=0){
            int rem=dividend%divisor;
            dividend=divisor;
            divisor=rem;
        }
        return divisor;
    }
}