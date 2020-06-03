import java.util.Random;

public class RunnubleForTransferP2PWithID implements Runnable{
    private String personIBAN_From;
    private String personIBAN_To;
    private int boundOfOperation;
    private Bank bank;

    public RunnubleForTransferP2PWithID(Bank bank, String personIBAN_From, String personIBAN_To, int boundOfOperation) {
        this.bank = bank;
        this.personIBAN_From = personIBAN_From;
        this.personIBAN_To = personIBAN_To;
        this.boundOfOperation = boundOfOperation;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10_000); i++) {
            LockForTransfers.takeLocks(LockForTransfers.lock1, LockForTransfers.lock2); // вызываем метод и прописываем параметры локов в том порядке в котором мы хотим их использовать
                try {
                bank.transferP2PWithID (personIBAN_From, personIBAN_To, random.nextInt(boundOfOperation));
            } finally {
                LockForTransfers.lock1.unlock();
                LockForTransfers.lock2.unlock();
            }
        }
    }
}
