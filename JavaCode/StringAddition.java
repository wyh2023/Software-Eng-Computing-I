
public class StringAddition {

	public static void main(String[] args){
		char[] s = null;
		System.out.println(s.length);
	}

	public static String add(String s1, String s2) {
		int frstnum = Integer.parseInt(s1);
		int scndnum = Integer.parseInt(s2);
		return Long.toString((long)frstnum + (long)scndnum);
    }
	   
}