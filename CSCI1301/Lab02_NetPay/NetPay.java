
/*
 * NetPay.java
 * Author:  Cedric Amponsem 
 * Submission Date:  1/30/2025
 *
 * Purpose: 
 * When the user enters their hourly working period, the program 
 * is able to calculate the user's wages and net income by the 
 * estimated tax deduction, which includes: 
 * federal, state, social security, and Medicare tax percentage. 
 *
 */
import java.util.Scanner;

public class NetPay {
	public final static Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		// Constants
		final double FEDERAL_TAX_PERCENT = 10.00;
		final double STATE_TAX_PERCENT = 4.5;
		final double SS_PERCENT = 6.2;
		final double MEDICARE_PERCENT = 1.45;
		final double PAY_PER_HOUR = 7.25;

		// Hourly Pay
		System.out.printf("Hours per Week:   \t");
		double hoursPerWeek = INPUT.nextDouble();
		double grossPay = hoursPerWeek * PAY_PER_HOUR;

		// Deductions Section
		double federalTax = grossPay / FEDERAL_TAX_PERCENT;

		// (Federal Tax * %) / federal tax %
		double stateTax = (federalTax * STATE_TAX_PERCENT) / FEDERAL_TAX_PERCENT;
		double socialSecurity = (federalTax * SS_PERCENT) / FEDERAL_TAX_PERCENT;
		double medicare = (federalTax * MEDICARE_PERCENT) / FEDERAL_TAX_PERCENT;

		// Total Deduction
		double totalDeduction = federalTax + stateTax + socialSecurity + medicare;

		// netPay = grossPay - totalDeduction
		double netPay = grossPay - totalDeduction;

		// Displaying results
		System.out.println("Gross Pay:        \t" + grossPay);
		System.out.println("Net Pay:          \t" + netPay);

		System.out.println();

		System.out.println("Deductions");
		System.out.println("Federal:          \t" + federalTax);
		System.out.printf("State:            \t%.4f\n", stateTax);
		System.out.printf("Social Security:  \t%.4f\n", socialSecurity);
        System.out.printf("Medicare:         \t%.4f\n", medicare);

    }
}
