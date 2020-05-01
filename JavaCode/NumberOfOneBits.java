
public class NumberOfOneBits {
	public static int hammingWeight(int n) {
		String Bin = Integer.toBinaryString(n);
		char[] Binchar = Bin.toCharArray();
		int num = 0;
		for( char x : Binchar){
			if(x == '1') num++;
		}
		return num;
	}
}