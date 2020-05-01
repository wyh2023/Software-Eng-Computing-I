
public class Arithmetic {

	public static String arithmetic(String s) {
		if(s == null){
			return "wrong";
		}
		StringBuilder str = new StringBuilder();
		String[] arith = s.split(" ");
		str.append(arith[0]);
		str.append(arith[2]);
		str.append(arith[1]);
		str.append("=");
		if ("+".equals(arith[2])) {
			str.append(Long.parseLong(arith[0]) + Long.parseLong(arith[1]));
		}else if("-".equals(arith[2])) {
			str.append(Integer.parseInt(arith[0]) - Integer.parseInt(arith[1]));
		}else if("/".equals(arith[2]) && !arith[1].equals("0")) {
			str.append(Integer.parseInt(arith[0]) / Integer.parseInt(arith[1]));
		}else if("*".equals(arith[2])) {
			str.append(Integer.parseInt(arith[0]) * Integer.parseInt(arith[1]));
		}else {
			return "wrong";
		}
		return str.toString() ;
	}

}