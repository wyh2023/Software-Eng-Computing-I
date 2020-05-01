
public class ThreeSum {

	public static int[] threeSum(int[] nums, int target) {
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == target){
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return null;
    }
}