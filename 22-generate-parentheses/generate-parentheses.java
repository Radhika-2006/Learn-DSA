class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, "", ans);
        return ans;
    }

    public void solve(int n, int open, int close, String str, List<String> ans) {

        // Base case
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        // Open bracket add kar sakte hain
        if (open < n) {
            solve(n, open + 1, close, str + "(", ans);
        }

        // Close bracket tabhi add hoga jab open > close
        if (close < open) {
            solve(n, open, close + 1, str + ")", ans);
        }
    }
}