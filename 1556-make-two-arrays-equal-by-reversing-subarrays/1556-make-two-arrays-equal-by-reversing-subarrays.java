class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int t : target) {
            hm.put(t, hm.getOrDefault(t, 0) + 1);
        }
        for (int i : arr) {
            if (!hm.containsKey(i)) {
                return false; 
            }
            hm.put(i, hm.get(i) - 1);
            if (hm.get(i) == 0) {
                hm.remove(i); 
            }
        }
    return hm.isEmpty();
    }
}