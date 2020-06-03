import java.util.Random;

public class RunnubleForTransferBankToBank implements Runnable{
    private Account acc1;
    private Account acc2;
    private int boundOfOperation;
    private Bank bank;

    public RunnubleForTransferBankToBank(Bank bank, Account acc1, Account acc2, int boundOfOperation) {
        this.bank = bank;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.boundOfOperation = boundOfOperation;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10_000); i++) {
            LockForTransfers.takeLocks(LockForTransfers.lock1, LockForTransfers.lock2); // вызываем метод и прописываем параметры локов в том порядке в котором мы хотим их использовать
                try {
                bank.transferBankToBank (acc1, acc2, random.nextInt(boundOfOperation));
            } finally {
                LockForTransfers.lock1.unlock();
                LockForTransfers.lock2.unlock();
            }
        }
    }
}
