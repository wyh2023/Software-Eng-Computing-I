/*
Exercise ReverseString: Write a program called ReverseString, which prompts user for 
a String, and prints the reverse of the String. 

For a String called inStr, you can use inStr.length() to get the length of the 
String; and inStr.charAt(index) to retrieve the char at the index position, 
where index begins with 0.

Enter a String: abcdef
Ouput:"fedcba".

*/

public class ReverseString {
	/**
	 * 将s倒置
	 * @param s
	 * @return 倒置结果
	 */
	public static String reverseString(String s){
		char[] charlst = s.toCharArray();
		String ans = "";
		for(int i = charlst.length - 1; i>=0; i--){
			ans += charlst[i];
		}
		return ans;
	}
}
