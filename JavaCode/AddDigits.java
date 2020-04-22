
public class AddDigits {
	public static void main(String[] args){
		System.out.println(addDigits(38));
	}

	 public static int addDigits(int num) {
	 	int ans = num;
		while (num > 10){
			ans = addResult(num);
			num = ans;
		}
		 return ans;
	 }

	 public static int addResult(int num){
	 	int res = 0;
	 	while (num > 0){
			res += num % 10;
			num /= 10;
		}
	 	return res;
	 }
}
