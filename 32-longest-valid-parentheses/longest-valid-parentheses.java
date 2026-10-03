class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> str=new Stack<>();
        int ans=0;
        str.push(-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch =='(')
              str.push(i);
            else{
                str.pop();
                if(str.isEmpty()){
                    str.push(i);
                }
                else{
                    int len=i-str.peek();
                    ans=Math.max(len,ans);
                }
            }   
            

        }
        return ans;


        }

}
