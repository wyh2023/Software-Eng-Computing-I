
public class Bin2Dec {
	public static void main(String[] args){
		System.out.println(bin2dec("111000"));
	}

	public static String bin2dec(String input){
		char[] bin = input.toCharArray();
		int ans = 0;
		for(int i=bin.length - 1; i>=0; i--){
			if(bin[i] == '1'){
				ans += (int)Math.pow(2, bin.length-i-1);
			}
		}
		return Integer.toString(ans);
	}

}
