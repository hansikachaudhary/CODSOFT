

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("INR", 73.94);
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("JPY", 110.13);
        exchangeRates.put("CAD", 1.21);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Currency Selection
        System.out.println("Welcome to the Unique Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP, JPY, CAD, INR");
        System.out.print("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == -1) {
            System.out.println("Invalid currencies selected. Exiting...");
            return;
        }

        System.out.print("Enter the amount to convert from " + baseCurrency + " to " + targetCurrency + ": ");
        double amountToConvert;
        try {
            amountToConvert = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered. Please enter a valid number.");
            return;
        }

      
        double convertedAmount = amountToConvert * exchangeRate;

        
        System.out.printf("%.2f %s = %.2f %s\n", amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return targetRate / baseRate;
        } else {
            return -1; 
        }
    }
}
