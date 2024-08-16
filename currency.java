import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class currency 
{
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception 
    {
        String urlString = API_URL + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) 
        {
            response.append(line);
        }
        in.close();
        String responseString = response.toString();
        String targetCurrencyKey = "\"" + targetCurrency + "\":";
        int startIndex = responseString.indexOf(targetCurrencyKey) + targetCurrencyKey.length();
        int endIndex = responseString.indexOf(",", startIndex);
        if (endIndex == -1) endIndex = responseString.indexOf("}", startIndex);
        String rateString = responseString.substring(startIndex, endIndex);
        return Double.parseDouble(rateString);
    }
    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) throws Exception 
    {
        double rate = getExchangeRate(baseCurrency, targetCurrency);
        return amount * rate;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        try 
        {
            System.out.print("Enter base currency (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter target currency (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();

            double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
            System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        } 
        finally 
        {
            scanner.close();
        }
    }
}
