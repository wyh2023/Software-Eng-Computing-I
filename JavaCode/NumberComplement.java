
public class NumberComplement {
	public static void main(String[] args){
		System.out.println(findComplement(2));
	}

	public static int findComplement(int num) {
		if(num < 0) return ~num;
		else if (num == 0) return -1;
		else{
			int sum = 0;
			int flg = 1;
			while (num > 0){
				if((num & 1) == 0){
					sum += flg;
				}
				flg <<= 1;
				num >>= 1;
			};
			return sum;
		}
    }
	   
}