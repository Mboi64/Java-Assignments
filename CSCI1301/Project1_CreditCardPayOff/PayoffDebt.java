
/*
 * PayoffDebt.java
 * Author:  Cedric Amponsem
 * Submission Date:  2/5/2026
 *
 * Purpose: 
 * This program calculates the user's input of their financial data
 * (such as principal, annual interest rate, and monthly payments) 
 * to determine the estimated amount of months, total interest rate, and total amount 
 * paid needed to pay off their credit card. The program also 
 * computes the overabundance of money that may exceeds the specified total amount 
 * within the given months.
 */
import java.util.Scanner;

public class PayoffDebt {

	public final static Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {
		// User's input
		System.out.print("Principal:          	\t");
		double principal = INPUT.nextDouble();

		System.out.print("Annual Interest Rate (%): \t");
		double annualInterestRate = INPUT.nextDouble();

		System.out.print("Monthly Payment:   	\t");
		double monthlyPay = INPUT.nextDouble();

		// ----- Months Needed to Pay Off Calculations ----- //
		// Split into parts to simplification
		double firstEquation = Math.log(monthlyPay) - Math.log(monthlyPay - (annualInterestRate / 1200.00) * principal);
		double secondEquation = Math.log((annualInterestRate / 1200.00) + 1.0);
		double floatingMonthsNeeded = firstEquation / secondEquation;

		// ----- Months Needed To Pay Off (rounded) ----- //
		int simplifiedMonthsNeeded = (int) Math.ceil(floatingMonthsNeeded);

		// ----- Total Amount Paid Calculation ----- //
		double totalAmountPaid = monthlyPay * simplifiedMonthsNeeded;

		// Total Interest Paid Calculation
		double totalInterestPaid = totalAmountPaid - principal;

		// ----- Overpayment = ((floating-point)Months_Needed subtracted by the ----- //
		// (simplified)Months_Needed) multiplied by the Monthly_Payment
		double overpayment = (simplifiedMonthsNeeded - floatingMonthsNeeded) * monthlyPay;

		// -----User's Output ----- //
		System.out.println();

		System.out.println("Months Needed To Pay Off: \t" + simplifiedMonthsNeeded);
		System.out.printf("Total Amount Paid:         \t$%.2f\n", totalAmountPaid);
		System.out.printf("Total Interest Paid:       \t$%.2f\n", totalInterestPaid);
        System.out.printf("Overpayment:               \t$%.2f", overpayment);

    }
}
