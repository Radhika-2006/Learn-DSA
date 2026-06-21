class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
         int[] merged=new int[n1 + n2];
         int i=0,j=0, k=0;
         while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i++];
            }else{
                merged[k++] = nums2[j++];
            }
         }
         while(i<n1){
            merged[k++] = nums1[i++];
         }
         while(j<n2){
            merged[k++] = nums2[j++];
         }
           int n = merged.length;
        
        
        if (n % 2 == 0) {
            return (merged[n/2 - 1] + merged[n/2]) / 2.0;
        } else {
            return merged[n/2];
        }
        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 0; i < nums1.length; i++) {
        //     list.add(nums1[i]);
        // }
        // for (int j = 0; j < nums2.length; j++) {
        //     list.add(nums2[j]);
        // }
        // Collections.sort(list);
        // int n = list.size();
        // if (n % 2 == 0) {
        //     return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        // } else {
        //     return list.get(n / 2);
        

    }
}