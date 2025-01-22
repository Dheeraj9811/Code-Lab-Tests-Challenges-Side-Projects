import java.text.NumberFormat;

public class Format {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(12345.2589);
        System.out.println(result);
            
        
    }
    
}
