class Solution {
    public List<String> braceExpansionII(String expression) {
        return new ArrayList<>(solve(expression, 0, expression.length() - 1));
    }

    private Set<String> solve(String s, int l, int r) {
        Set<String> result = new TreeSet<>();

        // Find top-level comma
        int balance = 0;
        List<int[]> parts = new ArrayList<>();
        int start = l;

        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                balance++;
            } else if (ch == '}') {
                balance--;
            } else if (ch == ',' && balance == 0) {
                parts.add(new int[]{start, i - 1});
                start = i + 1;
            }
        }

        // If comma found -> UNION
        if (!parts.isEmpty()) {
            parts.add(new int[]{start, r});

            for (int[] part : parts) {
                result.addAll(solve(s, part[0], part[1]));
            }

            return result;
        }

        // No top-level comma -> CONCATENATION
        Set<String> current = new TreeSet<>();
        current.add("");

        int i = l;

        while (i <= r) {
            Set<String> next;

            if (s.charAt(i) == '{') {
                int balance2 = 1;
                int j = i + 1;

                while (balance2 > 0) {
                    if (s.charAt(j) == '{') {
                        balance2++;
                    } else if (s.charAt(j) == '}') {
                        balance2--;
                    }
                    j++;
                }

                // Solve inside braces
                next = solve(s, i + 1, j - 2);
                i = j;
            } else {
                next = new TreeSet<>();
                next.add(String.valueOf(s.charAt(i)));
                i++;
            }

            Set<String> temp = new TreeSet<>();

            for (String a : current) {
                for (String b : next) {
                    temp.add(a + b);
                }
            }

            current = temp;
        }

        return current;
    }
}