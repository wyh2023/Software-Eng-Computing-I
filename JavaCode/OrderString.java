package nju.edu.software.Exercise048_OrderString;

public class OrderString {
	public String order(String str){
		if(str.length()==0) return "";
		char[] chars = str.toCharArray();
		String copy = str;
		copy = copy.toLowerCase();
		char[] chars1 = copy.toCharArray();
		for(int i=0; i<chars.length-1; i++){
			for(int j=0; j<chars.length-1-i; j++){
				if(chars1[j]>chars1[j+1]){
					char tmp = chars[j];
					char tmp1 = chars1[j];
					chars[j] = chars[j+1];
					chars[j+1] = tmp;
					chars1[j] = chars1[j+1];
					chars1[j+1] = tmp1;
				}
			}
		}
		return String.valueOf(chars).replace(" ", "");
	}
}
