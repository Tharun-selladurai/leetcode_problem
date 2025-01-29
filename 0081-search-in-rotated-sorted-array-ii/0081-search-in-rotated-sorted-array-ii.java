class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If target is found, return true
            if (nums[mid] == target) {
                return true;
            }
            
            // When we can't decide which side is sorted
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left part is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // Target lies in the left part
                } else {
                    left = mid + 1;  // Target lies in the right part
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target lies in the right part
                } else {
                    right = mid - 1;  // Target lies in the left part
                }
            }
        }
        
        return false;  // Target not found
    }
}
