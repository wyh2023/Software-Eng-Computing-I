
import java.io.*;
import java.util.Scanner;

public class CurrencyCalculation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many euros are you exchanging?");
		String eu_str = input.nextLine();
		double euros = Double.parseDouble(eu_str);
		System.out.println("What is the exchange rate?");
		String rate_str = input.nextLine();
		double rate = Double.parseDouble(rate_str);
		System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.", euros, rate, euros*rate/100);
	}

}
