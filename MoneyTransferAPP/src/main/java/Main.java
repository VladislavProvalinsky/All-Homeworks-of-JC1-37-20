
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Bank alfaBank = new Bank("Альфа-Банк");
        Bank belarusbank = new Bank("АСБ Беларусбанк");
        Bank belagroprombank = new Bank("Белагропромбанк");
        Bank belinvestbank = new Bank("Белинвестбанк");
        Bank bpssberbank = new Bank("БПС Сбербанк");

        alfaBank.depositBankAccount(ECurrency.BYN, 1_000_000);
        belarusbank.depositBankAccount(ECurrency.BYN, 1_000_000);
        belagroprombank.depositBankAccount(ECurrency.USD, 1_000_000);
        belinvestbank.depositBankAccount(ECurrency.EUR, 1_000_000);
        bpssberbank.depositBankAccount(ECurrency.RUS, 1_000_000);
        alfaBank.createPersonAccount("Василий Иванович", ECurrency.BYN, "BY06ALFA30140000000000000933");
        alfaBank.createPersonAccount("Георгий Константинович", ECurrency.USD, "BY06ALFA30140000000000000840");
        alfaBank.depositPersonAccount("BY06ALFA30140000000000000933", 1_000_000);
        belarusbank.createPersonAccount("Георгий Константинович", ECurrency.USD, "BY06ASPB30140000000000000840");
        belarusbank.createPersonAccount("Василий Иванович", ECurrency.BYN, "BY06ASPB30140000000000000933");
        belarusbank.depositPersonAccount("BY06ASPB30140000000000000840", 1_000_000);

        // даем рандомно задания каждому банку
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new RunnubleForTransferBankToBank(alfaBank, alfaBank.getBankAccountBYN(), belarusbank.getBankAccountEUR(), 100));
        executorService.submit(new RunnubleForTransferBankToBank(belarusbank, belarusbank.getBankAccountBYN(), alfaBank.getBankAccountBYN(), 100));
        executorService.submit(new RunnubleForTransferBankToBank(belagroprombank, belagroprombank.getBankAccountUSD(), alfaBank.getBankAccountEUR(), 100));
        executorService.submit(new RunnubleForTransferBankToBank(belinvestbank, belinvestbank.getBankAccountEUR(), belagroprombank.getBankAccountRUS(), 100));
        executorService.submit(new RunnubleForTransferBankToBank(bpssberbank, bpssberbank.getBankAccountRUS(), belinvestbank.getBankAccountUSD(), 100));
        executorService.submit(new RunnubleForTransferP2PWithID(alfaBank, "BY06ALFA30140000000000000933", "BY06ALFA30140000000000000840", 100));
        executorService.submit(new RunnubleForTransferP2PWithID(belarusbank, "BY06ASPB30140000000000000840", "BY06ASPB30140000000000000933", 100));

        executorService.shutdown();

        // печатаем инфу для проверки что все ок
        System.out.println(alfaBank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(belarusbank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(belagroprombank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(belinvestbank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(bpssberbank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(alfaBank.getInfoAboutPersonsAccounts());
        System.out.println("-----------------------");
        System.out.println(belarusbank.getInfoAboutPersonsAccounts());

        // выводим рандомный топ банков по количеству операций.
        List<Bank> list = new ArrayList<>();
        list.add(alfaBank);
        list.add(belarusbank);
        list.add(belagroprombank);
        list.add(belinvestbank);
        list.add(bpssberbank);

        list.sort(new Comparator<Bank>() {
            @Override
            public int compare(Bank o1, Bank o2) {
                return Integer.compare(o2.getOperationsCounter(), o1.getOperationsCounter());
            }
        });

        System.out.println("\nТоп банков по количеству операций:");
        for (Bank bank: list) {
            System.out.println(bank.getNameOfBank() + " - операций совершено: " + bank.getOperationsCounter());
        }
    }
}
