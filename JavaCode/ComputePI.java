//see more details on http://www.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html
//Write a program called ComputePI to compute the value of π, using the following series expansion.
//You have to decide on the termination criterion used in the computation (such as the number of terms used or the magnitude of an additional term). 
//Is this series suitable for computing π?
public class ComputePI {

	public static double compute(int maxDenominator){
		double each = 1.0;
		double pi = 0;
		int flg = -1;
		for(int i = 1; i <= maxDenominator; i = i + 2){
			flg *= -1;
			pi += (1.0 / i)*flg;
		}
		return 4*pi;
	}

}
