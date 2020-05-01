
public class HammingDistance {
	public static void main(String[] args){
		System.out.println(hammingDistance(2, -4));
	}

	public static int hammingDistance(int x, int y){
		int hamming = x ^ y;
		int sum = 0;
		int count = 0;
		while (count < 32){
			sum += hamming & 1;
			hamming >>= 1;
			count++;
		}
		return sum;
	}
	   
}