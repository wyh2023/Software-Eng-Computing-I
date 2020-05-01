
public class ReOrderArray {
	
	/**
	 * 将所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分。
	 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * @param array
	 * @return
	 */
	public int[] reOrder(int[] array){
		for(int j = 0; j < array.length-1; j++){
			for(int i = 0; i < array.length-1; i++){
				if(array[i+1]%2==1 && array[i]%2==0){
					int tmp = array[i+1];
					array[i+1] = array[i];
					array[i] = tmp;
				}
			}
		}
		return array;
	}
	
}
