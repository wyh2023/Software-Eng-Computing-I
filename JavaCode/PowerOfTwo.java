
public class PowerOfTwo {

	public static boolean isPowerOfTwo(int n) {
		if(n == 1){
			return true;
		}
		while ((n % 2 == 0) && n > 1){
			n /= 2;
			if(n == 1) return true;
		}
		return false;
    }
	   
}