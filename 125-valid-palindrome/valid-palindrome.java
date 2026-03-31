// class Solution {
//     public boolean isPalindrome(String s) {
//         s= s.toLowerCase();
//         StringBuilder clean = new StringBuilder();
//         for(char ch: s.toCharArray()){
//             if(Character.isLetterOrDigit(ch)){
//                 clean.append(ch);
//             }
//         } 
//         String original = clean.toString();
//         String reversed = clean.reverse().toString();

//         return original.equals(reversed);
        
//     }
// }
class Solution {
public boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;

    while (l < r) {
        while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
        while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
            return false;

        l++;
        r--;
    }
    return true;
}
}