package lt.vtvpc.emc.akademijait;

import lt.itakademija.exam.Bank;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.CurrencyRatesProvider;
import lt.itakademija.exam.test.BaseTest;

public class Test extends BaseTest{
    @Override
    protected Bank createBank(CurrencyConverter currencyConverter) {
        return new GoodBankz(currencyConverter);
    }

    @Override
    protected CurrencyConverter createCurrencyConverter(CurrencyRatesProvider ratesProvider) {
        return new GoodBankzCurrencyConverter(ratesProvider);
    }
}
