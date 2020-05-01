
public class HappyNumber {

    public static void main(String[] args){
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
    	int count = 0;
    	while (count < 1000){
    		count++;
    		if(n == 1) return true;
    		int tmp = n;
    		int sum = 0;
    		while (tmp > 0){
    			sum += (tmp % 10) * (tmp % 10);
    			tmp /= 10;
			}
    		n = sum;
		}
    	return false;
    }

}
