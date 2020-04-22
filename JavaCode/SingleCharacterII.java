import java.util.HashMap;
import java.util.Map;

public class SingleCharacterII {

	public static char singleNumber(char[] characters) {
		if(characters == null){
			return '\0';
		}
		char ans = '\0';
		int[] Hashmap = new int[26];
		for(char element : characters){
			Hashmap[element - 97]++;
		}
		for(int i = 0; i<Hashmap.length; i++){
			if(Hashmap[i] == 1){
				ans = (char)(i + 97);
			}
		}
		return ans;
	}

}