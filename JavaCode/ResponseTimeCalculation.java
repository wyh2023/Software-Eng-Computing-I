import java.util.Scanner;

public class ResponseTimeCalculation {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Number:");
		String input = in.nextLine();
		int[] totalArray = new int[100];
		int j = 0;
		while (!input.equals("done")){
			int num = Integer.parseInt(input);
			totalArray[j++] = num;
			System.out.println("Enter a Number:");
			input = in.nextLine();
		}
		int sum = 0;
		System.out.print("Numbers:");
		for (int i=0; i<j; i++) {
			System.out.printf("%d", totalArray[i]);
			if(i != j-1){
				System.out.print(",");
			}
			sum = sum + totalArray[i];
		}
		System.out.println();
		double average = ((double) sum)/j;
		System.out.printf("The average is %.2f.", average);
		System.out.println();
		System.out.printf("The minimum is %d.", SelectMin(totalArray, j));
		System.out.println();
		System.out.printf("The maximum is %d.", SelectMax(totalArray, j));
		System.out.println();
		System.out.printf("The standard deviation is %.2f.", StandardDiviation(totalArray, j, average));

	}

	public static double StandardDiviation(int[] x, int len, double average) {
		double dVar = 0;
		for (int i=0; i<len; i++) {//求方差
			dVar += ((double)x[i] - average) * ((double) x[i] - average);
		}
		return Math.sqrt(dVar / len);
	}

	public static int SelectMax(int[] x, int len){
		int max = x[0];
		for(int i=0; i<len; i++){
			if(max < x[i]){
				max = x[i];
			}
		}
		return max;
	}

	public static int SelectMin(int[] x, int len){
		int min = x[0];
		for(int i=0; i<len; i++){
			if(min > x[i]){
				min = x[i];
			}
		}
		return min;
	}
}
