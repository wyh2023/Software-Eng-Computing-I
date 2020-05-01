
public class Polynomial {

	public static double calculatePolynomial(double x, int[] coefficients) {
	    double sum = 0.0;
        for(int i=0; i<coefficients.length; i++){
            sum += coefficients[i]*Math.pow(x, coefficients.length-1-i);
        }
        return sum;
    }   
}