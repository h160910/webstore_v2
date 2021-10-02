package hvl.dat152.utils;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class CurrencyConverter {

    private final static double GBP_RATE = 0.85;
    private final static double NOK_RATE = 10.01;

    public static String convertToCurrency(ResourceBundle rb, double priceInEuros) {

        Locale locale = rb.getLocale();
        NumberFormat numberFormat = NumberFormat.getInstance(locale);

        switch (locale.toString()) {
            case "en":
                return "£" + numberFormat.format(priceInEuros*GBP_RATE);
            case "nn":
                return numberFormat.format(priceInEuros*NOK_RATE) + "kr";
            default :
                return "€" + numberFormat.format(priceInEuros);
        }
    }

}
