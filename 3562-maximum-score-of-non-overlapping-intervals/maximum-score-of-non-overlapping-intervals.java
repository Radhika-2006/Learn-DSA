import java.util.*;

class Solution {

    static class Interval {
        int l, r, weight, index;

        Interval(int l, int r, int weight, int index) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.index = index;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Result[][] dp;
    Interval[] arr;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);
            arr[i] = new Interval(x.get(0), x.get(1), x.get(2), i);
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });

        dp = new Result[n + 1][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    Result solve(int i, int left) {

        if (i == n || left == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][left] != null) {
            return dp[i][left];
        }

        // Option 1: Skip current interval
        Result skip = solve(i + 1, left);

        // Option 2: Take current interval
        int next = findNext(i);

        Result nextResult = solve(next, left - 1);

        List<Integer> takeList = new ArrayList<>();
        takeList.add(arr[i].index);
        takeList.addAll(nextResult.indices);

        Collections.sort(takeList);

        Result take = new Result(
            arr[i].weight + nextResult.score,
            takeList
        );

        // Choose better result
        if (take.score > skip.score) {
            dp[i][left] = take;
        } 
        else if (take.score < skip.score) {
            dp[i][left] = skip;
        } 
        else {
            // Same score -> lexicographically smaller
            if (compare(take.indices, skip.indices) < 0) {
                dp[i][left] = take;
            } else {
                dp[i][left] = skip;
            }
        }

        return dp[i][left];
    }

    // Find first interval whose start > current interval's end
    int findNext(int i) {

        int target = arr[i].r;

        int low = i + 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].l > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Lexicographical comparison
    int compare(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}