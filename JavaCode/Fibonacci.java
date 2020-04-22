
public class Fibonacci {
	public int FibonacciN(int input){
		int first = 0;
		int second = 1;
		int n = input;
		while(n > 0){
			int tmp = first;
			first = second;
			second = second + tmp;
			n--;
		}
		return first;
	}
}
