package lt.vtvpc.emc.akademijait;

import lt.itakademija.exam.*;

public class GoodBankzCurrencyConverter implements CurrencyConverter {
    private final CurrencyRatesProvider ratesProvider;
    public GoodBankzCurrencyConverter(CurrencyRatesProvider ratesProvider) {
        this.ratesProvider = ratesProvider;
    }

    @Override
    public Money convert(Currency from, Currency to, Money money) {
        Money rate = ratesProvider.getRate(from, to);
        if (rate == null){
            throw new CurrencyConversionException("Could not convert");
        }

        return money.multiply(rate);
    }
}
