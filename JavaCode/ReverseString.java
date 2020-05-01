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
		char[] string = s.toCharArray();
		StringBuilder ans = new StringBuilder();
		for(int i = string.length-1; i >= 0; i--){
			ans.append(string[i]);
		}
		return ans.toString();
	}
}
