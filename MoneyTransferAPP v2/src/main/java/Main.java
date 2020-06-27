
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // создаем банки
        Bank alfaBank = new Bank.BankBuilder()
                .setBankName("Альфа-Банк")
                .setBASIC_BANK_CURRENCY(ECurrency.BYN)
                .setUsdExchangeRate(2.45d)
                .setEurExchangeRate(2.65d)
                .setRusExchangeRate(0.0034d)
                .setTransferComission(0.01d)
                .setPersonalBankIBAN("BY00ALFA")
                .build();

        Bank belarusbank = new Bank.BankBuilder()
                .setBankName("АСБ Беларусбанк")
                .setBASIC_BANK_CURRENCY(ECurrency.BYN)
                .setUsdExchangeRate(2.30d)
                .setEurExchangeRate(2.55d)
                .setRusExchangeRate(0.0029d)
                .setTransferComission(0.01d)
                .setPersonalBankIBAN("BY00AKBB")
                .build();

        Bank belagroprombank = new Bank.BankBuilder()
                .setBankName("Белагропромбанк")
                .setBASIC_BANK_CURRENCY(ECurrency.BYN)
                .setUsdExchangeRate(2.50d)
                .setEurExchangeRate(2.70d)
                .setRusExchangeRate(0.0040d)
                .setTransferComission(0.01d)
                .setPersonalBankIBAN("BY00BAPB")
                .build();

        // создаем клиентов
        Person vlad = new Person("Владислав Провалинский", 1964168);
        Person vasia = new Person("Василий Петрович", 1111111);
        Person galina = new Person("Галина Николаевна", 2222222);
        Person anzhela = new Person("Анжела Викторовна", 3333333);
        Person tolik = new Person("Анатолий Петрович", 4444444);
        Person roma = new Person("Роман Юрьевич", 5555555);

        //создаем счета
        List<Account> accountsAlfa = new ArrayList<>();
        List<Account> accountsASB = new ArrayList<>();
        List<Account> accountsBelagra = new ArrayList<>();
        accountsAlfa.add(alfaBank.createAccount(vlad,ECurrency.BYN, 1000));
        accountsAlfa.add(alfaBank.createAccount(vasia,ECurrency.USD, 450));
        accountsAlfa.add(alfaBank.createAccount(galina,ECurrency.EUR, 600));
        accountsAlfa.add(alfaBank.createAccount(anzhela,ECurrency.RUS, 7000));
        accountsASB.add(belarusbank.createAccount(tolik,ECurrency.BYN, 4200));
        accountsASB.add(belarusbank.createAccount(roma,ECurrency.USD, 1400));
        accountsASB.add(belarusbank.createAccount(vlad,ECurrency.EUR, 780));
        accountsASB.add(belarusbank.createAccount(vasia,ECurrency.RUS, 6000));
        accountsBelagra.add(belagroprombank.createAccount(galina,ECurrency.BYN, 9000));
        accountsBelagra.add(belagroprombank.createAccount(anzhela,ECurrency.USD, 4200));
        accountsBelagra.add(belagroprombank.createAccount(tolik,ECurrency.EUR, 1460));
        accountsBelagra.add(belagroprombank.createAccount(roma,ECurrency.RUS, 7500));

        // производим переводы средств
        Random rnd = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < rnd.nextInt(100); i++) {
            executorService.submit(new LockForTransfers(alfaBank, accountsAlfa.get(rnd.nextInt(3)), belarusbank, accountsASB.get(rnd.nextInt(3)), rnd.nextInt(10)));
            executorService.submit(new LockForTransfers(belarusbank,accountsASB.get(rnd.nextInt(3)), alfaBank,accountsAlfa.get(rnd.nextInt(3)), rnd.nextInt(10)));
            executorService.submit(new LockForTransfers(belagroprombank,accountsBelagra.get(rnd.nextInt(3)), belarusbank,accountsASB.get(rnd.nextInt(3)), rnd.nextInt(10)));
        }

        executorService.shutdown();

        // даем рандомно задания каждому банку


        // печатаем инфу для проверки что все ок
        System.out.println(alfaBank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(belarusbank.getInfoAboutBank());
        System.out.println("-----------------------");
        System.out.println(belagroprombank.getInfoAboutBank());

        // выводим рандомный топ банков по количеству переводов.
        List<Bank> list = new ArrayList<>();
        list.add(alfaBank);
        list.add(belarusbank);
        list.add(belagroprombank);

        list.sort(new Comparator<Bank>() {
            @Override
            public int compare(Bank o1, Bank o2) {
                return Integer.compare(o2.getTransferCounter(), o1.getTransferCounter());
            }
        });

        System.out.println("\nТоп банков по количеству операций:");
        for (Bank bank: list) {
            System.out.println(bank.getNameOfBank() + " - переводов совершено: " + bank.getTransferCounter());
        }
    }
}
