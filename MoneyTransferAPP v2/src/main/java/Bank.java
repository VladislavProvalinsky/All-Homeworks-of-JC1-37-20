import org.apache.commons.math3.util.Precision;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private String nameOfBank; // название банка
    private ECurrency BASIC_BANK_CURRENCY; // базовая валюта банка
    private int transferCounter; // счетчик переводов банка
    private int takingCounter; // счетчик получений от переводов

    private Map<String, Account> bankAccounts = new LinkedHashMap<>(); // счета Банка
    private Account specialBankAccount; // специальный счет банка (для комиссии)

    private double UsdExchangeRate; // курс доллара к бел рублю
    private double EurExchangeRate; // курс доллара к бел рублю
    private double RusExchangeRate; // курс рос рубля к бел рублю
    private double transferComission; // комиссия за перевод 1% от суммы минимум 5 BYN
    private String personalBankIBAN; //содержит уникальный банковский IBAN идентификатор

    public Bank(String nameOfBank, ECurrency BASIC_BANK_CURRENCY, double usdExchangeRate, double eurExchangeRate, double rusExchangeRate, double transferComission, String personalBankIBAN) {
        this.nameOfBank = nameOfBank;
        this.BASIC_BANK_CURRENCY = BASIC_BANK_CURRENCY;
        UsdExchangeRate = usdExchangeRate;
        EurExchangeRate = eurExchangeRate;
        RusExchangeRate = rusExchangeRate;
        this.transferComission = transferComission;
        this.personalBankIBAN = personalBankIBAN;
        this.specialBankAccount = new Account(nameOfBank,BASIC_BANK_CURRENCY, personalBankIBAN);
    }

    public Account createAccount(Person person, ECurrency accountCurrency, double balance) { // создаем счет банка
        Account account = new Account(this.nameOfBank, person, accountCurrency, balance, this.personalBankIBAN);
        if (account.getIBAN().matches("BY[\\d]{2}[A-Z]{4}[\\d]{20}") || this.bankAccounts.containsKey(account.getIBAN()))
            createAccount(person,accountCurrency,balance);
        else
            this.bankAccounts.put(account.getIBAN(), account);
        return account;
    }

    public void depositAccount (String IBAN, double amount) {// метод пополнения счета
        if (!bankAccounts.containsKey(IBAN))
            throw new IllegalArgumentException("Такого счета в банке нет, или счет введен неверно!");
        takingCounter++;
        bankAccounts.get(IBAN).setBalance(amount);
    }

    public void withdrawAccount (String IBAN, double amount) { // метод списания денег со счета (с проверкой наличия достаточной суммы)
        if (!bankAccounts.containsKey(IBAN))
            throw new IllegalArgumentException("Такого счета в банке нет, или счет введен неверно!");
        if (bankAccounts.get(IBAN).getBalance() < amount) {
            throw new IllegalArgumentException("На счету нет такой суммы для снятия! Остаток по счету составляет: " + bankAccounts.get(IBAN).getBalance() + " " + bankAccounts.get(IBAN).getAccountCurrency());
        } else {
            transferCounter++;
            bankAccounts.get(IBAN).setBalance(bankAccounts.get(IBAN).getBalance() - amount);
        }
    }

//    private Map <ECurrency, Double> infoBankFunds (){
//        Map <ECurrency, Double> bankFunds =  new LinkedHashMap<>();
//        for (Map.Entry<String, Account> entry : bankAccounts.entrySet()) {
//            bankFunds.put(entry.getValue().getAccountCurrency(), entry.getValue().getBalance());
//        }
//    }


    public String getInfoAboutBank() {
        return new String("Наименование банка: " + nameOfBank + "\n"
                + "Базовая валюта: " + BASIC_BANK_CURRENCY + "\n"
                + "Сумма на комиссионном счету по межбанковским переводам в BYN: " + Precision.round(specialBankAccount.getBalance(), 2) + "\n"
                + "Курс доллара США на " + new Date() + " составляет: " + UsdExchangeRate + "\n"
                + "Курс Евро на " + new Date() + " составляет: " + EurExchangeRate + "\n"
                + "Курс Российского рубля на " + new Date() + " составляет: " + RusExchangeRate + "\n"
                + "Колличество совершенный переводов на " + new Date() + " составляет: " + transferCounter + "\n"
                + "Колличество полученных переводов на " + new Date() + " составляет: " + takingCounter + "\n"
                + "Комиссия банка по межбанковским переводам на " + new Date() + " составляет: " + transferComission + " от суммы (минимально 5 у.е.).");
    }

    public List<String> getInfoAboutBankAccounts() {
        List<String> list = new LinkedList<>();
        if (bankAccounts.isEmpty()) {
            list.add("В банке нет ни одного счета клиента!");
        } else {
            for (Map.Entry<String, Account> entry : bankAccounts.entrySet()) {
                list.add(entry.getKey() + " : " + entry.getValue());
            }
        }
        return list;
    }


    public String getNameOfBank() {
        return nameOfBank;
    }

    public String getPersonalBankIBAN() {
        return personalBankIBAN;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public ECurrency getBASIC_BANK_CURRENCY() {
        return BASIC_BANK_CURRENCY;
    }

    public void setBASIC_BANK_CURRENCY(ECurrency BASIC_BANK_CURRENCY) {
        this.BASIC_BANK_CURRENCY = BASIC_BANK_CURRENCY;
    }

    public Map<String, Account> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Map<String, Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public double getUsdExchangeRate() {
        return UsdExchangeRate;
    }

    public void setUsdExchangeRate(double usdExchangeRate) {
        UsdExchangeRate = usdExchangeRate;
    }

    public double getEurExchangeRate() {
        return EurExchangeRate;
    }

    public void setEurExchangeRate(double eurExchangeRate) {
        EurExchangeRate = eurExchangeRate;
    }

    public double getRusExchangeRate() {
        return RusExchangeRate;
    }

    public void setRusExchangeRate(double rusExchangeRate) {
        RusExchangeRate = rusExchangeRate;
    }

    public double getTransferComission() {
        return transferComission;
    }

    public void setTransferComission(double transferComission) {
        this.transferComission = transferComission;
    }

    public void setPersonalBankIBAN(String personalBankIBAN) {
        this.personalBankIBAN = personalBankIBAN;
    }

    public Account getSpecialBankAccount() {
        return specialBankAccount;
    }

    public void setSpecialBankAccount(Account specialBankAccount) {
        this.specialBankAccount = specialBankAccount;
    }

    public int getTransferCounter() {
        return transferCounter;
    }

    public void setTransferCounter(int transferCounter) {
        this.transferCounter = transferCounter;
    }

    public int getTakingCounter() {
        return takingCounter;
    }

    public void setTakingCounter(int takingCounter) {
        this.takingCounter = takingCounter;
    }

    // Банк билдер для создания нового банка
    public static class BankBuilder {
        String bankName;
        ECurrency BASIC_BANK_CURRENCY;
        double UsdExchangeRate;
        double EurExchangeRate;
        double RusExchangeRate;
        double transferComission;
        String personalBankIBAN;

        public BankBuilder() {
        }

        public BankBuilder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public BankBuilder setBASIC_BANK_CURRENCY(ECurrency BASIC_BANK_CURRENCY) {
            this.BASIC_BANK_CURRENCY = BASIC_BANK_CURRENCY;
            return this;
        }

        public BankBuilder setUsdExchangeRate(double usdExchangeRate) {
            UsdExchangeRate = usdExchangeRate;
            return this;
        }

        public BankBuilder setEurExchangeRate(double eurExchangeRate) {
            EurExchangeRate = eurExchangeRate;
            return this;
        }

        public BankBuilder setRusExchangeRate(double rusExchangeRate) {
            RusExchangeRate = rusExchangeRate;
            return this;
        }

        public BankBuilder setTransferComission(double transferComission) {
            this.transferComission = transferComission;
            return this;
        }

        public BankBuilder setPersonalBankIBAN(String personalBankIBAN) {
            this.personalBankIBAN = personalBankIBAN;
            return this;
        }


    public Bank build() {
            if (bankName == null) {
                throw new IllegalArgumentException("Банк должен содержать имя!");
            }
            return new Bank(bankName, BASIC_BANK_CURRENCY, UsdExchangeRate, EurExchangeRate,
                    RusExchangeRate, transferComission, personalBankIBAN);
        }
    }
}