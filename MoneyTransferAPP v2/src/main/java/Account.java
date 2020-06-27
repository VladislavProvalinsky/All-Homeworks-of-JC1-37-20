import org.apache.commons.math3.util.Precision;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String bankName; // банк в котором счет
    private String holderName; // владелец счета, человек
    private ECurrency accountCurrency; // валюта счета
    private double balance; // баланс счета
    private String IBAN; // ID счета

    public Account (String bankName, ECurrency currency, String IBAN) {
        this.bankName = bankName;
        this.holderName = bankName;
        this.accountCurrency = currency;
        this.IBAN = IBAN+IBAN_Generator();
    }

    public Account(String bankName, Person person, ECurrency accountCurrency, double balance, String IBAN) {
        this.bankName = bankName;
        this.holderName = person.getName();
        this.accountCurrency = accountCurrency;
        this.balance = balance;
        this.IBAN = IBAN+IBAN_Generator();
    }

    private String IBAN_Generator () { // генератор IBAN
        Random random = new Random();
        long longTemp = random.nextLong();
        int longLength =  String.valueOf(longTemp).length();
        if (longLength < 19){
            IBAN_Generator();
        }
        if (longTemp < 0){
            longTemp = -longTemp;
        }
        return String.valueOf(longTemp) + String.valueOf(random.nextInt(9));
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public ECurrency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(ECurrency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankName='" + bankName + '\'' +
                ", holderName='" + holderName + '\'' +
                ", accountCurrency=" + accountCurrency +
                ", balance=" + balance +
                ", IBAN='" + IBAN + '\'' +
                '}';
    }
}
