import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch != '(') {
                ans.append(ch);
                i++;
            } else {
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                String key = s.substring(i + 1, j);
                ans.append(map.getOrDefault(key, "?"));

                i = j + 1;
            }
        }

        return ans.toString();
    }
}