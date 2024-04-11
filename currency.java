import java.util.Scanner;
public class CurrencyConverter 
{
    public static void main(String[] args) 
    {
        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a base currency:");
        String baseCurrency = scanner.nextLine();
        System.out.println("Select a target currency:");
        String targetCurrency = scanner.nextLine();
        ExchangeRatesApi api = new ExchangeRatesApi();
        double exchangeRate = api.getExchangeRate(baseCurrency, targetCurrency);
        System.out.println("Enter the amount you want to convert:");
        double amount = scanner.nextDouble();
        double convertedAmount = convertCurrency(amount, exchangeRate);
        System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
    }
    public static double convertCurrency(double amount, double exchangeRate) 
    {
        return amount * exchangeRate;
    }
}
class ExchangeRatesApi 
{
    public double getExchangeRate(String baseCurrency, String targetCurrency) 
    {
        if (baseCurrency.equals("USD") && targetCurrency.equals("JPY")) {
            return 110.0;
        }
        return 1.0;
    }
}