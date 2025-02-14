import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        
        int n = envelopes.length;
        int[] minEndingElementForLen = new int[n + 2];
        Arrays.fill(minEndingElementForLen, (int) 1e9);
        minEndingElementForLen[0] = (int) -1e9;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int firstValue = envelopes[i][0];
            int st = i;
            List<int[]> updates = new ArrayList<>();
            
            while (st < n && envelopes[st][0] == envelopes[i][0]) {
                int secondValue = envelopes[st][1];
                int maxLen = Arrays.binarySearch(minEndingElementForLen, secondValue);
                if (maxLen < 0) maxLen = -maxLen - 1;
                
                ans = Math.max(ans, maxLen);
                updates.add(new int[]{maxLen, secondValue});
                st++;
            }
            
            for (int[] elem : updates) {
                minEndingElementForLen[elem[0]] = Math.min(minEndingElementForLen[elem[0]], elem[1]);
            }
            i = st - 1;
        }
        return ans;
    }
}
