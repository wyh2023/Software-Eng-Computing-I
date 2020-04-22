
public class BinarySearch {

	public static int search(int[] data, int target) {
		int len = data.length;
		int start = 0;
		int end = len-1;
		int mid;
		while (start <= end){
			mid = (start + end) / 2;
			if(target < data[mid]){
				end = mid-1;
			}else if(target > data[mid]){
				start = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
    }
	   
}