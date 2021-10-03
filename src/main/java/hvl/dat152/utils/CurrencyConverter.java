package hvl.dat152.utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyConverter {

    private final static double GBP_RATE = 0.85;
    private final static double NOK_RATE = 10.01;

    public static double convertToCurrency(Locale locale, double priceInEuros) {

        switch (locale.getCountry()) {
            case "GB":
                return (priceInEuros*GBP_RATE);
            case "NO":
                return (priceInEuros*NOK_RATE);
            default :
                return (priceInEuros);
        }
    }

    public static String convertToCurrencyString(Locale locale, double priceInEuros) {

        Currency currency = Currency.getInstance(locale);

        NumberFormat nf = NumberFormat.getInstance(locale);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        String str = currency.getCurrencyCode() + " ";

        switch (locale.getCountry()) {
            case "GB":
                str += nf.format(priceInEuros*GBP_RATE);
                break;
            case "NO":
                str += nf.format(priceInEuros*NOK_RATE);
                break;
            default :
                str += nf.format(priceInEuros);
                break;
        }

        return str;
    }

}
