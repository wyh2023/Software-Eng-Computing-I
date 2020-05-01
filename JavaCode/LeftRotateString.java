package nju.edu.software.Exercise060_LeftRotateString;

public class LeftRotateString {
	public static void main(String[] args){
		LeftRotateString test = new LeftRotateString();
		System.out.println(test.leftrotate("fanofaria", 3));
	}

	public String leftrotate(String str, int k){
		if(str==null || str.length() == 0){
			return "";
		}
		k = k%str.length();
		String str2 = str.substring(k);
		String str1 = str.substring(0, k);
		System.out.println(str);
		System.out.println(k);
		return str2+str1;
	}
}
