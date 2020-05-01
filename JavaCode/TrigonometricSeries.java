
/**
 * <p><br />
 * <span class="line-heading">Exercise <span class="font-code">TrigonometricSeries</span>:</span> Write a method to compute <code>sin(x)</code> and <code>cos(x)</code> using the following series expansion, in a class called <strong><code>TrigonometricSeries</code></strong>. The headers of the methods are:</p>
 * <pre class="color-syntax">
 * public static double sin(double x, int numTerms)   <span class="color-comment">// x in radians</span>
 * public static double cos(double x, int numTerms)</pre>
 * <img class="image-left" src="https://www3.ntu.edu.sg/home/ehchua/programming/java/images/ExerciseBasics_TrigonometricSeries.png" alt="ExerciseBasics_TrigonometricSeries.png" />
 * <p/>
 * <p>Compare the values computed using the series with the JDK methods <code>Math.sin()</code>, <code>Math.cos()</code> at <code>x=0</code>, <code>&pi;/6</code>, <code>&pi;/4</code>, <code>&pi;/3</code>, <code>&pi;/2</code> using various numbers of terms.</p>
 * <p/>
 * <p>Hints: Avoid generating large numerator and denominator (which may cause arithmetic overflow, e.g., <code>13!</code> is out of <code>int</code> range). Compute the terms as:</p>
 * <img class="image-left" src="https://www3.ntu.edu.sg/home/ehchua/programming/java/images/ExerciseBasics_TrigonometricSeriesHint.png" alt="ExerciseBasics_TrigonometricSeriesHint.png" />
 * <p/>
 * <p><br />
 */
public class TrigonometricSeries {
	public static void main(String[] args){
		System.out.println(sin(Math.PI, 100));
	}

	public static double sin(double x, int numTerms) {
		double res = 0;
		int flg = -1;
		for(int i = 1; i <= numTerms; i++){
			flg *= -1;
			res += flg * factorial(x, 2*i-1);
		}
		return res;
	}

	public static double cos(double x, int numTerms) {
		double res = 1.0;
		int flg = 1;
		for(int i = 1; i <= numTerms; i++){
			flg *= -1;
			res += flg*factorial(x, 2*i);
		}
		return res;
	}

	public static double factorial(double x, int num){
		double res = x / num;
		while (num > 1){
			num--;
			res *= x / num;
		}
		return res;
	}

}
