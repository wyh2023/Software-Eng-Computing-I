
public class ReverseInteger {
	 public static int reverseInteger(int n) {
	 	int flg;
	 	if(n > 0){
	 		flg = 1;
		}else if(n < 0){
	 		flg = -1;
		}else{
	 		flg = 0;
		}
	 	n = Math.abs(n);
	 	int ans = 0;
	 	while(n > 0){
	 		ans *= 10;
	 		ans += n % 10;
	 		n /= 10;
		}
	 	return ans*flg;
	 }
}
