package lt.vtvpc.emc.akademijait;

import lt.itakademija.exam.*;

import java.util.ArrayList;
import java.util.List;

public class GoodBankz implements Bank {

    private final List<Customer> customers;
    private SequenceGenerator cusSeq = new SequenceGenerator();
    private final CurrencyConverter currencyConverter;
    private SequenceGenerator accSeq = new SequenceGenerator();
    private SequenceGenerator opSeq = new SequenceGenerator();


    public GoodBankz(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
        this.customers = new ArrayList<>();
    }

    @Override
    public Customer createCustomer(PersonCode code, PersonName personName) {
        if (code == null || personName==null){
            throw new NullPointerException();
        }
        for (Customer custmr: customers){
            if (custmr.getPersonCode().equals(code)){
                throw new CustomerCreateException("Customer already Exsists");
            }
        }
        final Customer customer = new Customer(cusSeq.getNext(), code, personName);
        customers.add(customer);
        return customer;
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {
        if (customer == null || currency == null){
            throw new NullPointerException();
        }
        if (!customers.contains(customer)){
            throw new AccountCreateException("Customer does not exsist");
        }
        final Account acc = new Account(accSeq.getNext(),customer,currency,new Money(0.0d));
        customer.addAccount(acc);
        return acc;
    }

    @Override
    public Operation transferMoney(Account debit, Account creditAccount, Money debitAmount) {
         if (debit.getBalance().isLessThan(debitAmount)){
             throw new InsufficientFundsException("Not enought mony");
         }
         debit.setBalance(debit.getBalance().substract(debitAmount));
         final Money creditAmount = currencyConverter.convert(debit.getCurrency(), creditAccount.getCurrency(), debitAmount);
         creditAccount.setBalance(creditAccount.getBalance().add(creditAmount));

        return new Operation(opSeq.getNext(), debit, creditAccount,debitAmount);
    }

    @Override
    public Money getBalance(Currency currency) {
        Money balance = new Money (0.0d);
        for (Customer customer :customers){
            for (Account account : customer.getAccounts()){
                if (account.getCurrency().equals(currency)){
                    balance = balance.add(account.getBalance());
                } else {
                    balance = balance.add(currencyConverter.convert(account.getCurrency(),currency,account.getBalance()));
                }
            }
        }
        return balance;
    }
}
