import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Available currencies: USD, EUR, INR");

        System.out.println("Enter the currency you have: ");
        String fromCurrency = userInput.nextLine().toUpperCase();

        System.out.println("Enter the currency you want to convert to: ");
        String toCurrency = userInput.nextLine().toUpperCase();

        System.out.println("Enter the amount: ");
        double originalAmount = userInput.nextDouble();

        double conversionRate = getConversionRate(fromCurrency, toCurrency);

        if (conversionRate == 0.0) {
            System.out.println("Sorry! This currency conversion is not supported.");
        } else {
            double finalAmount = originalAmount * conversionRate;
            System.out.printf("%.2f %s = %.2f %s%n", originalAmount, fromCurrency, finalAmount, toCurrency);
        }

        userInput.close();
    }

    public static double getConversionRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) return 83.0;
        if (from.equals("USD") && to.equals("EUR")) return 0.85;
        if (from.equals("EUR") && to.equals("USD")) return 1.18;
        if (from.equals("EUR") && to.equals("INR")) return 97.0;
        if (from.equals("INR") && to.equals("USD")) return 0.012;
        if (from.equals("INR") && to.equals("EUR")) return 0.010;

        return 0;
    }
}