public class PrimeFactors {
	public static boolean isProductOfPrimeFactors(int posInt) {
		assert posInt > 0;
		int check = 1;
		int ceiling = posInt;
		for(int i = 2; i < ceiling; i++){
			if(posInt % i == 0){
				check = (check%i==0)? check : check*i;
				posInt /= i;
				i--;
			}
		}
		/*
		System.out.print("check: ");
		System.out.println(check);
		System.out.print("ceiling");
		System.out.println(ceiling);
		System.out.print("PosInt: ");
		System.out.println(posInt);
		 */
		return check == ceiling;
	}

	public static void main(String[] args){
		System.out.println(isProductOfPrimeFactors(0));
	}
}
