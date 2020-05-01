
public class RepeatedSubstringPattern {
	public static void main(String[] args){
		System.out.println(repeatedSubstringPattern("abcd"));
	}

	public static boolean repeatedSubstringPattern(String str) {
		int n = 0;
		for(int i=1; i<str.length(); i++){
			String flg = str.substring(0, i);
			for(int j=i; j<str.length(); j=j+i){
				if(str.substring(j).length() < flg.length() || !flg.equals(str.substring(j, j+i))){
					n = 1;
					break;
				}
			}
			if(n == 0){
				return true;
			}
			n = 0;
		}
    	return false;
    }
}