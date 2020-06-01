

public class Main {
    public static void main(String[] args) {
        Bank alfaBank = new Bank("Альфа-Банк");
        Bank belarusbank = new Bank("АСБ Беларусбанк");
        Bank belagroprombank = new Bank("Белагропромбанк");
        Bank belinvestbank = new Bank("Белинвестбанк");
        Bank bpssberbank = new Bank("БПС Сбербанк");

        alfaBank.depositBankAccount(ECurrency.BYN, 1_000_000);
        alfaBank.depositBankAccount(ECurrency.USD, 1_000_000);
        alfaBank.depositBankAccount(ECurrency.EUR, 1_000_000);
        alfaBank.depositBankAccount(ECurrency.RUS, 1_000_000);
        alfaBank.createPersonAccount("Василий Иванович", ECurrency.BYN, "BY06ALFA30140000000000000933");
        alfaBank.createPersonAccount("Георгий Константинович", ECurrency.USD, "BY06ALFA30140000000000000840");
        alfaBank.depositPersonAccount("BY06ALFA30140000000000000933", 1000);
        alfaBank.transferP2PWithID("BY06ALFA30140000000000000933", "BY06ALFA30140000000000000840", 500);
        alfaBank.transferBankToBank(alfaBank.getBankAccountBYN(), belarusbank.getBankAccountEUR(), 500_000);
        System.out.println(alfaBank.getInfoAboutBank());
        System.out.println(belarusbank.getInfoAboutBank());
        System.out.println(alfaBank.getInfoAboutPersonsAccounts());
    }
}
