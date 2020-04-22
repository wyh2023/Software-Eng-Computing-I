import java.util.Arrays;

public class SingleCharacterI {
	public static void main(String[] args){
		System.out.println(singleNumber(new char[]{'a','b','c','a','b'}));
	}


	public static char singleNumber(char[] characters) {
		if(characters == null || characters.length == 0){
			return '\0';
		}
		char ans = '\0';
		int flg = 0;
		for(int i=0; i<characters.length; i++){
			ans = characters[i];
			for(int j=i+1; j<characters.length; j++){
				if(characters[j]==ans){
					flg = 1;
					break;
				}
			}
			if(flg == 0){
				break;
			}
			flg = 0;
		}
		return ans;
    }
	   
}