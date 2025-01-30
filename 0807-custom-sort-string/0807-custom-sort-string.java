class Solution {
    public String customSortString(String order, String s) {
        // Step 1: Store the priority of characters in a HashMap
        Map<Character, Integer> priorityMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            priorityMap.put(order.charAt(i), i);
        }

        // Step 2: Convert s to character array and sort based on the custom order
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, (a, b) -> priorityMap.getOrDefault(a, Integer.MAX_VALUE) 
                                - priorityMap.getOrDefault(b, Integer.MAX_VALUE));

        // Step 3: Convert character array back to string
        StringBuilder result = new StringBuilder();
        for (char c : arr) {
            result.append(c);
        }
        
        return result.toString();
    }
}