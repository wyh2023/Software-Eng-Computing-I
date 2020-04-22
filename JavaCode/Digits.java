
public class Digits {
	public String reverseInt(int input){
		String ans = Integer.toString(input);
		return reverseString(ans);
	}

	public static String reverseString(String s){
		char[] charlst = s.toCharArray();
		String ans = "";
		for(int i = charlst.length - 1; i>=0; i--){
			ans += charlst[i];
		}
		return ans;
	}
}
