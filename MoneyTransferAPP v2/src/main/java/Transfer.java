import javax.swing.plaf.BorderUIResource;

public class Transfer {

    public static void transferP2P (Bank bankOfSender, Account sender, Bank bankOfReceiver, Account receiver, double amount) { // метод для клиентских переводов по IBAN клиента
        if (bankOfSender.getBankAccounts().get(sender.getIBAN()).getAccountCurrency() == ECurrency.BYN) { // если списание со счета в белках
            if (amount * bankOfSender.getTransferComission() < 5) { // это конструкция по комиссии за перевод
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(),amount + 5);
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(),5);
            } else {
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + amount * bankOfSender.getTransferComission());
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(), amount * bankOfSender.getTransferComission());
            }
            switch (bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getAccountCurrency()) {
                case USD:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount / bankOfReceiver.getUsdExchangeRate());
                    return;
                case EUR:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount / bankOfReceiver.getEurExchangeRate());
                    return;
                case RUS:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount / bankOfReceiver.getRusExchangeRate());
                    return;
            }
        }
        if (bankOfSender.getBankAccounts().get(sender.getIBAN()).getAccountCurrency() == ECurrency.USD){
            if (amount * bankOfSender.getTransferComission() < 5) { // это конструкция по комиссии за перевод
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + 5);
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(),5 * bankOfSender.getUsdExchangeRate());
            } else {
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + amount * bankOfSender.getTransferComission());
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(), amount * bankOfSender.getTransferComission() * bankOfSender.getUsdExchangeRate());
            }
            switch (bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getAccountCurrency()){
                case BYN:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount* bankOfReceiver.getUsdExchangeRate());
                    return;
                case EUR:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount*bankOfReceiver.getUsdExchangeRate()/bankOfReceiver.getEurExchangeRate());
                    return;
                case RUS:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount*bankOfReceiver.getUsdExchangeRate()/bankOfReceiver.getRusExchangeRate());
                    return;
            }
        }
        if (bankOfSender.getBankAccounts().get(sender.getIBAN()).getAccountCurrency() == ECurrency.EUR) {
            if (amount * bankOfSender.getTransferComission() < 5) { // это конструкция по комиссии за перевод
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + 5);
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(),5 * bankOfSender.getEurExchangeRate());
            } else {
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + amount * bankOfSender.getTransferComission());
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(), amount * bankOfSender.getTransferComission() * bankOfSender.getEurExchangeRate());
            }
            switch (bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getAccountCurrency()) {
                case BYN:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount* bankOfReceiver.getEurExchangeRate());
                    return;
                case USD:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount * bankOfReceiver.getEurExchangeRate() / bankOfReceiver.getUsdExchangeRate());
                    return;
                case RUS:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount*bankOfReceiver.getEurExchangeRate()/bankOfReceiver.getRusExchangeRate());
                    return;
            }
        }
        if (bankOfSender.getBankAccounts().get(sender.getIBAN()).getAccountCurrency() == ECurrency.RUS) {
            if (amount * bankOfSender.getTransferComission() < 5) { // это конструкция по комиссии за перевод
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + 5);
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(),5 * bankOfSender.getRusExchangeRate());
            } else {
                bankOfSender.withdrawAccount(bankOfSender.getBankAccounts().get(sender.getIBAN()).getIBAN(), amount + amount * bankOfSender.getTransferComission());
                bankOfSender.depositAccount(bankOfSender.getSpecialBankAccount().getIBAN(), amount * bankOfSender.getTransferComission() * bankOfSender.getRusExchangeRate());
            }
            switch (bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getAccountCurrency()) {
                case BYN:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount* bankOfReceiver.getRusExchangeRate());
                    return;
                case USD:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount * bankOfReceiver.getRusExchangeRate() / bankOfReceiver.getUsdExchangeRate());
                    return;
                case EUR:
                    bankOfReceiver.depositAccount(bankOfReceiver.getBankAccounts().get(receiver.getIBAN()).getIBAN(),amount * bankOfReceiver.getRusExchangeRate() / bankOfReceiver.getEurExchangeRate());
            }
        }
     else {
            throw new IllegalArgumentException("Проверьте правильность введенных данных. Возможно таких счетов в банке не существует.");
        }
    }
}
