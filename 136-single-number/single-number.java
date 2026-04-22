class Solution {
    public int singleNumber(int[] nums) {
    //   Map<Integer,Integer>map = new HashMap<>();
    //   for(int i:nums){
    //     int c=map.getOrDefault(i,0);
    //     map.put(i,c+1);
    //   }
    //   for(int k:map.keySet()){
    //     int fr=map.get(k);
    //     if(fr==1) return k;
    //   }
    //   return -1;  
    int result=0;
    for(int i=0;i<nums.length;i++){
        result = result ^ nums[i];
    }
    return result;
    }
}