
public class ArrayToInteger {

	public static int getInteger(int[] numbers) {
		int ans = 0;
		for(int i=0; i<numbers.length; i++){
			ans += numbers[i]*Math.pow(10, numbers.length-i-1);
			if(ans < 0){
				ans = 2147483647;
				break;
			}
		}
		return ans;
    }
	   
}