
public class KthLargestElement {

	 public static int findKthLargest(int[] nums, int k) {
	 	for(int j = 0; j < nums.length-1; j++){
			for(int i = 0; i < nums.length-1; i++){
				if(nums[i]<nums[i+1]){
					int tmp = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = tmp;
				}
			}
		}
	    return nums[k-1];
	 }


}
