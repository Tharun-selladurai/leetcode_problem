class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is at the start of a pair
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1; // Unique element is in right half
            } else {
                right = mid; // Unique element is in left half (including mid)
            }
        }
        return nums[left]; // Left points to the single element
    }
}