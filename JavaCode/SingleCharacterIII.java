
public class SingleCharacterIII {
	public static void main(String[] args){
		System.out.println(singleNumber(new char[]{'a','b','c','a','b'}));
	}

	public static char singleNumber(char[] characters) {
		if(characters == null){
			return '\0';
		}
		int[] map = new int[26];
		for (char character : characters) {
			map[character - 97] ^= 1;
		}
		for(int i=0; i<map.length; i++){
			if(map[i] == 1){
				return (char)(i+97);
			}
		}
		return '\0';
    }
	   
}