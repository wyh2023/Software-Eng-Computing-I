
public class DetectCaptial {

	public static boolean detectCapitalUse(String word) {
		if(word == null){
			return false;
		}
		if(word.length() == 0){
			return true;
		}
		char[] characters = word.toCharArray();
		if(Character.isUpperCase(characters[0])){
			if(Character.isUpperCase(characters[1])){
				for(int i = 2; i<characters.length; i++){
					if(Character.isLowerCase(characters[i])){
						return false;
					}
				}
			}else{
				for(int i = 2; i<characters.length; i++){
					if(Character.isUpperCase(characters[i])){
						return false;
					}
				}
			}
		}else{
			for(int i=1; i<characters.length; i++){
				if(Character.isUpperCase(characters[i])){
					return false;
				}
			}
		}
		return true;
    }
	   
}