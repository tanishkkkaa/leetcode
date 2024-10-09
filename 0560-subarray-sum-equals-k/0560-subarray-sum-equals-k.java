class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int count = 0;

        // Add an initial entry for sum = 0
        prefixSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Check if sum - k has occurred before
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);  // Add the frequency of sum - k
            }

            // Add the current sum to the map (or update its frequency)
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}