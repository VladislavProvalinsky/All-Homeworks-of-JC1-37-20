import org.apache.commons.math3.util.Precision;

public class Account {
    private String user; // владелец счета
    private ECurrency accountCurrency; // валюта счета
    private double balance; // баланс счета
    private int currencyCode; // код валюты счета

    public Account (String user, ECurrency accountCurrency) { // конструктор создания счета
        this.user = user;
        this.accountCurrency = accountCurrency;
        this.currencyCode = accountCurrency.getCurrencyCode();
    }

    public void deposit (double amount) {
        this.balance += amount;
    } // метод пополнения счета

    public void withdraw (double amount) { // метод списания денег со счета (с проверкой наличия достаточной суммы)
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("На счету нет такой суммы для снятия! Остаток по счету составляет: " + balance + " " + accountCurrency);
        }
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public String getUser() {
        return user;
    }

    public ECurrency getAccountCurrency() {
        return accountCurrency;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", accountCurrency=" + accountCurrency +
                ", balance=" + Precision.round(balance, 2) +
                ", currencyCode=" + currencyCode +
                '}';
    }
}
