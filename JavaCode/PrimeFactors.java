public class PrimeFactors {
	public static boolean isProductOfPrimeFactors(int posInt) {
		assert posInt > 0;
		int check = 1;
		for(int i = 2; i <= Math.sqrt(posInt); i++){
			if(posInt % i == 0){
				check *= i;
			}
		}
		return check == posInt;
	}

}
