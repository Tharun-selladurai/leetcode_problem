import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int length = nums.length;
        int arr[] = new int[length];
        
        List<int[]> list = new ArrayList<>();
        for (int l = 0; l < length; l++) {
            int a = nums[l];
            int reverse = 0;
            int z = 1;
            if (a == 0) {
                 reverse=mapping[0];
            }
            while (a > 0) {
                int x = a % 10;
                int y = mapping[x];
                reverse = reverse + y * z;
                z = z * 10;
                a = a / 10;
            }
            list.add(new int[] { reverse, nums[l] });
          
        }
            Collections.sort(list, Comparator.comparingInt(w -> w[0]));
      
        for (int s = 0; s < list.size(); s++) {
            arr[s] = list.get(s)[1];
        }
        return arr;
    }
}