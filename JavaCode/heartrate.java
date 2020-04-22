import java.util.*;


public class HeartRateCalculation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("RestingHR:");
		String restingHR = input.nextLine();
		int hr = Integer.parseInt(restingHR);
		System.out.println("Age:");
		String ag = input.nextLine();
		int age = Integer.parseInt(ag);
		System.out.println("Intensity|TargetHeartRate");
		System.out.println("---------|---------------");
		for(int per = 55; per < 100; per=per+5){
			double intensity = ((double) per) / 100;
			double heartrt = (((220 - age) - hr) * intensity) + hr;
			System.out.printf("%d%% |%dbpm\n", per, Math.round(heartrt));
		}
        
	}

}
