
public class UglyNumber {
	public static void main(String[] args){
		System.out.println(isUgly(14));
	}

	public static boolean isUgly(int num) {
		int check = 1;
		int ceiling = num;
		for(int i = 2; i < ceiling; i++){
			if(num % i == 0){
				if(check % i != 0){
					check *= i;
				}
				num /= i;
				i--;
			}
		}
		return 30%check==0;
    }

}
