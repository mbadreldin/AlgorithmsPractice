package leetcode;

public class SearchRotatedSortedArray {

	// https://leetcode.com/problems/search-in-rotated-sorted-array/
	public static void main(String[] args) {
		SearchRotatedSortedArray s = new SearchRotatedSortedArray();
		int[] arr0 = {};
		System.err.println(s.search(arr0,1)); // -1
		int[] arr1 = {4};
		System.err.println(s.search(arr1,1)); // -1
		System.err.println(s.search(arr1,4)); // 0
		int[] arr2 = {0, 4};
		System.err.println(s.search(arr2,1)); // -1
		System.err.println(s.search(arr2,0)); // 0
		System.err.println(s.search(arr2,4)); // 1
		int[] arr3 = {4, 0};
		System.err.println(s.search(arr3,1)); // -1
		System.err.println(s.search(arr3,4)); // 0
		System.err.println(s.search(arr3,0)); // 1
		int[] arr9 = {7, 8, 9, 0, 1, 2, 3, 4, 5, 6};
		System.err.println(s.search(arr9,10)); // -1
		System.err.println(s.search(arr9,-2)); // -1
		System.err.println(s.search(arr9,7)); // 0
		System.err.println(s.search(arr9,8)); // 1
		System.err.println(s.search(arr9,6)); // 9

		int [] arr10 = {3,4,5,6,1,2};
		System.err.println(s.search(arr10, 2)); //5
	}
	
	private static boolean mayContain(int target, int[] nums, int low, int high)
	{
		if(low > high)
			return false;
		
		// normal range case
		if(nums[low] <= target && nums[high]>= target)
			return true;
		
		// test if contains pivot
		// given: You may assume no duplicate exists in the array
		if (nums[low] > nums[high])
		{
			if (target >= nums[low])
				return true;
			
			if (target <= nums[high])
				return true;
		}
		
		return false;
	}

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while(low <= high)
		{
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			
			if (mayContain(target, nums, mid+1, high))
			{
				low = mid + 1;
			}
			else 
			{
				high = mid - 1;
			}
		}
		return -1;
	}
}
