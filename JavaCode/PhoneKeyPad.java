
public class PhoneKeyPad{
	public static void main(String[] args){
		System.out.println(convert("ABC"));
	}

	public static String convert(String s){
		if(s == null || s.equals("")){
			return "";
		}
		s = s.toUpperCase();
		StringBuilder str = new StringBuilder();
		char[] characters = s.toCharArray();
		for (char character : characters) {
			switch (character) {
				case 'A':
				case 'B':
				case 'C':
					str.append("2,");
					break;
				case 'D':
				case 'E':
				case 'F':
					str.append("3,");
					break;
				case 'G':
				case 'H':
				case 'I':
					str.append("4,");
					break;
				case 'J':
				case 'K':
				case 'L':
					str.append("5,");
					break;
				case 'M':
				case 'N':
				case 'O':
					str.append("6,");
					break;
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
					str.append("7,");
					break;
				case 'T':
				case 'U':
				case 'V':
					str.append("8,");
					break;
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					str.append("9,");
					break;
			}
		}
		str.delete(2*characters.length-1, 2*characters.length);
		return str.toString();
	}
}