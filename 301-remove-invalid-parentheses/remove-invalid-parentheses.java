import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (isValid(str)) {
                result.add(str);
                found = true;
            }

            if (found) {
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = str.substring(0, i)
                        + str.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}