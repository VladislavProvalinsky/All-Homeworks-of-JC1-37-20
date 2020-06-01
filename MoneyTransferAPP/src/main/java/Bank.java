import org.apache.commons.math3.util.Precision;

import java.util.*;

public class Bank implements IAccountOperations{
    private String nameOfBank; // название банка
    private final ECurrency BASIC_BANK_CURRENCY = ECurrency.BYN; // базовая валюта банка
    private int operationsCounter; // счетчик операций банка
    private Account bankAccountComissionBYN = new Account(nameOfBank, BASIC_BANK_CURRENCY); // счет банка в BYN для комиссии по переводам
    private Account bankAccountBYN = new Account(nameOfBank, ECurrency.BYN); // счет банка в BYN
    private Account bankAccountUSD = new Account(nameOfBank, ECurrency.USD); // счет банка в USD
    private Account bankAccountEUR = new Account(nameOfBank, ECurrency.EUR); // счет банка в EUR
    private Account bankAccountRUS = new Account(nameOfBank, ECurrency.RUS); // счет банка в RUS
    private Map <String, Account> clientsAccounts = new LinkedHashMap<>(); // счета клиентов банка с ключем по IBAN счета

    private double bankUSDCourse = 2.45d; // курс доллара
    private double bankEURCourse = 2.65d; // курс евро
    private double bankRURCourse = 0.0034d; // курс росс рубля
    private double transferComission = 0.01d; // комиссия за перевод 1% от суммы минимум 5 BYN

    public Bank(String bankName) { // создаем новый Банк
        this.nameOfBank = bankName;
    }

    public void createPersonAccount (String personName, ECurrency currency, String IBAN) { // создаем счет клиенту
        if (IBAN.matches("BY[\\d]{2}[A-Z]{4}3014[\\d]{16}")){
            clientsAccounts.put(IBAN, new Account(personName, currency));
        } else if (clientsAccounts.containsKey(IBAN)) {
            throw new IllegalAccessError ("Счет клиента с таким IBAN уже существует!");
        } else {
            throw new IllegalArgumentException("IBAN не соответствует стандартам!");
        }
    }

    public String getInfoAboutBank () {
        return new String("Наименование банка: " + nameOfBank + "\n"
                + "Базовая валюта: " + BASIC_BANK_CURRENCY + "\n"
                + "Сумма на счету в BYN: " + Precision.round(bankAccountBYN.getBalance(), 2) + "\n"
                + "Сумма на счету в USD: " + Precision.round(bankAccountUSD.getBalance(), 2) + "\n"
                + "Сумма на счету в EUR: " + Precision.round(bankAccountEUR.getBalance(), 2) + "\n"
                + "Сумма на счету в RUS: " + Precision.round(bankAccountRUS.getBalance(), 2) + "\n"
                + "Сумма на комиссионном счету по межбанковским переводам в BYN: " + Precision.round(bankAccountComissionBYN.getBalance(), 2) + "\n"
                + "Курс доллара США на " + new Date() + " составляет: " + bankUSDCourse + "\n"
                + "Курс Евро на " + new Date() + " составляет: " + bankEURCourse + "\n"
                + "Курс Российского рубля на " + new Date() + " составляет: " + bankRURCourse + "\n"
                + "Колличество совершенный операций на " + new Date() + " составляет: " + operationsCounter + "\n"
                + "Комиссия банка по межбанковским переводам на " + new Date() + " составляет: " + transferComission + " от суммы (минимально 5 USD).");
    }

    public List<String> getInfoAboutPersonsAccounts () {
        List<String> list = new LinkedList<>();
        if (clientsAccounts.isEmpty()) {
            list.add("В банке нет ни одного счета клиента!");
        } else {
            for (Map.Entry<String, Account> entry : clientsAccounts.entrySet()) {
                list.add(entry.getKey() + " : " + entry.getValue());
            }
        }
        return list;
    }

    @Override
    public void depositBankAccount (ECurrency currency, double amount) { // метод пополнения счета
        operationsCounter++;
        switch (currency) {
            case BYN:
                bankAccountBYN.deposit(amount);
                break;
            case USD:
                bankAccountUSD.deposit(amount);
                break;
            case EUR:
                bankAccountEUR.deposit(amount);
                break;
            case RUS:
                bankAccountRUS.deposit(amount);
                break;
        }
    }

    @Override
    public void withdrawBankAccount (ECurrency currency, double amount) { // метод списания со счета
        operationsCounter++;
        switch (currency) {
            case BYN:
                bankAccountBYN.withdraw(amount);
                break;
            case USD:
                bankAccountUSD.withdraw(amount);
                break;
            case EUR:
                bankAccountEUR.withdraw(amount);
                break;
            case RUS:
                bankAccountRUS.withdraw(amount);
                break;
        }
    }

    @Override
    public void depositPersonAccount(String IBAN, double amount) {
       operationsCounter++;
       if (clientsAccounts.containsKey(IBAN)){
           clientsAccounts.get(IBAN).deposit(amount);
       } else {
           throw new IllegalArgumentException ("Счет клиента с таким IBAN отсутствует!");
       }
    }

    @Override
    public void withdrawPersonAccount(String IBAN, double amount){
        operationsCounter++;
        if (clientsAccounts.containsKey(IBAN)){
            clientsAccounts.get(IBAN).withdraw(amount);
        } else {
            throw new IllegalArgumentException("Счет клиента с таким IBAN отсутствует!");
        }
    }

    public void transferBankToBank(Account from, Account to, double amount) { // метод перевода со счета на счет для межбанковских переводоа
        operationsCounter++;
        if (from.getCurrencyCode() == 933) { // если списание со счета в белках
            if (amount * transferComission < 5) { // это конструкция по комиссии за перевод
                from.withdraw(amount + 5);
                bankAccountComissionBYN.deposit(5);
            } else {
                from.withdraw(amount + amount * transferComission);
                bankAccountComissionBYN.deposit(amount * transferComission);
            }
            switch (to.getCurrencyCode()) {
                case 840:
                    to.deposit(amount / bankUSDCourse);
                    return;
                case 978:
                    to.deposit(amount / bankEURCourse);
                    return;
                case 643:
                    to.deposit(amount / bankRURCourse);
                    return;
            }
        }
        if (from.getCurrencyCode() == 840){
            if (amount * transferComission < 5 * bankUSDCourse) { // это конструкция по комиссии за перевод
                from.withdraw(amount + 5 * bankUSDCourse);
                bankAccountComissionBYN.deposit(5);
            } else {
                from.withdraw(amount + amount * transferComission);
                bankAccountComissionBYN.deposit(amount * transferComission * bankUSDCourse);
            }
            switch (to.getCurrencyCode()){
                case 933:
                    to.deposit(amount*bankUSDCourse);
                    return;
                case 978:
                    to.deposit(amount*bankUSDCourse/bankEURCourse);
                    return;
                case 643:
                    to.deposit(amount*bankUSDCourse/bankRURCourse);
                    return;
            }
        }
        if (from.getCurrencyCode() == 978) {
            if (amount * transferComission < 5 * bankEURCourse) { // это конструкция по комиссии за перевод
                from.withdraw(amount + 5 * bankEURCourse);
                bankAccountComissionBYN.deposit(5);
            } else {
                from.withdraw(amount + amount * transferComission);
                bankAccountComissionBYN.deposit(amount * transferComission * bankEURCourse);
            }
            switch (to.getCurrencyCode()) {
                case 933:
                    to.deposit(amount * bankEURCourse);
                    return;
                case 840:
                    to.deposit(amount * bankEURCourse / bankUSDCourse);
                    return;
                case 643:
                    to.deposit(amount * bankEURCourse / bankRURCourse);
                    return;
            }
        }
        if (from.getCurrencyCode() == 643) {
            if (amount * transferComission < 5 * bankRURCourse) { // это конструкция по комиссии за перевод
                from.withdraw(amount + 5 * bankRURCourse);
                bankAccountComissionBYN.deposit(5);
            } else {
                from.withdraw(amount + amount * transferComission * bankRURCourse);
                bankAccountComissionBYN.deposit(amount * transferComission * bankRURCourse);
            }
            switch (to.getCurrencyCode()) {
                case 933:
                    to.deposit(amount * bankRURCourse);
                    return;
                case 840:
                    to.deposit(amount * bankRURCourse / bankUSDCourse);
                    return;
                case 978:
                    to.deposit(amount * bankRURCourse / bankEURCourse);
            }
        }
    }

    @Override
    public void transferP2PWithID(String personIBAN_From, String personIBAN_To, double amount) { // метод для клиентских переводов по IBAN клиента
        operationsCounter++;
        if (clientsAccounts.containsKey(personIBAN_From) && clientsAccounts.containsKey(personIBAN_To)) {
            clientsAccounts.get(personIBAN_From).withdraw(amount);
            if (clientsAccounts.get(personIBAN_From).getCurrencyCode() == 933) {
                switch (clientsAccounts.get(personIBAN_To).getCurrencyCode()) {
                    case 840:
                        clientsAccounts.get(personIBAN_To).deposit(amount / bankUSDCourse);
                        return;
                    case 978:
                        clientsAccounts.get(personIBAN_To).deposit(amount / bankEURCourse);
                        return;
                    case 643:
                        clientsAccounts.get(personIBAN_To).deposit(amount / bankRURCourse);
                        return;
                }
            }
            if (clientsAccounts.get(personIBAN_From).getCurrencyCode() == 840) {
                switch (clientsAccounts.get(personIBAN_To).getCurrencyCode()) {
                    case 933:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankUSDCourse);
                        return;
                    case 978:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankUSDCourse / bankEURCourse);
                        return;
                    case 643:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankUSDCourse / bankRURCourse);
                        return;
                }
            }
            if (clientsAccounts.get(personIBAN_From).getCurrencyCode() == 978) {
                switch (clientsAccounts.get(personIBAN_To).getCurrencyCode()) {
                    case 933:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankEURCourse);
                        return;
                    case 840:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankEURCourse / bankUSDCourse);
                        return;
                    case 643:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankEURCourse / bankRURCourse);
                        return;
                }
            }
            if (clientsAccounts.get(personIBAN_From).getCurrencyCode() == 643) {
                switch (clientsAccounts.get(personIBAN_To).getCurrencyCode()) {
                    case 933:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankRURCourse);
                        return;
                    case 840:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankRURCourse / bankUSDCourse);
                        return;
                    case 978:
                        clientsAccounts.get(personIBAN_To).deposit(amount * bankRURCourse / bankEURCourse);
                }
            }
        } else {
            throw new IllegalArgumentException("Проверьте правильность введенных данных. Возможно таких счетов банке не существует.");
        }
    }

    public void setBankUSDCourse(double bankUSDCourse) {
        this.bankUSDCourse = bankUSDCourse;
    }

    public void setBankEURCourse(double bankEURCourse) {
        this.bankEURCourse = bankEURCourse;
    }

    public void setBankRURCourse(double bankRURCourse) {
        this.bankRURCourse = bankRURCourse;
    }

    public void setTransferComission(double transferComission) {
        this.transferComission = transferComission;
    }

    public Account getBankAccountComissionBYN() {
        return bankAccountComissionBYN;
    }

    public Account getBankAccountBYN() {
        return bankAccountBYN;
    }

    public Account getBankAccountUSD() {
        return bankAccountUSD;
    }

    public Account getBankAccountEUR() {
        return bankAccountEUR;
    }

    public Account getBankAccountRUS() {
        return bankAccountRUS;
    }
}
