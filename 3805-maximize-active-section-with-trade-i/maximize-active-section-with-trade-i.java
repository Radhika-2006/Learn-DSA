class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t="1"+s+"1";
        int ones=0;
        for(char ch:s.toCharArray()){
            if(ch == '1') ones++;
        }
        ArrayList<Character> chars =new ArrayList<>();
        ArrayList<Integer> len=new ArrayList<>();
        int i=0;
        while(i < t.length()){
            char ch=t.charAt(i);
            int j=i;
            while(j<t.length() && t.charAt(j)==ch){
                j++;
            }
            chars.add(ch);
            len.add(j-i);
            i=j;
        }
        int ans=ones;
        for(i=1;i<chars.size()-1;i++){
            if(chars.get(i)=='1' && chars.get(i-1)=='0' && chars.get(i+1)=='0'){
                ans=Math.max(ans,ones + len.get(i-1)+len.get(i+1));
              }
        }
        return ans;
        
    }
}