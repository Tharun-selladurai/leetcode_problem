import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;

        // Count the frequency of each element in all arrays
        for (int[] arr : nums) {
            for (int num : arr) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        // Filter elements that occur in all arrays
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }
}