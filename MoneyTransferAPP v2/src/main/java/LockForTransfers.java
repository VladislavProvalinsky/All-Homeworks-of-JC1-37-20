/*
Класс используется в том случае если одновременно 2 или более банков переводят друг другу деньги использование счетов
друг у друга находятся в так называемом Race condition
 */

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockForTransfers implements Runnable {
    private Bank bankOfSender;
    private Account sender;
    private Bank bankOfReceiver;
    private Account receiver;
    private double boundOfOperation;

    public LockForTransfers(Bank bankOfSender, Account sender, Bank bankOfReceiver, Account receiver, double boundOfOperation) {
        this.bankOfSender = bankOfSender;
        this.sender = sender;
        this.bankOfReceiver = bankOfReceiver;
        this.receiver = receiver;
        this.boundOfOperation = boundOfOperation;
    }

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void takeLocks(Lock lock1, Lock lock2) { // создаем отдельный метод для решения проблемы DeadLock -а
        boolean firstLockTaken = false; // вводим будевсские переменные для идентификации, взят ли лок или нет
        boolean secondLockTaken = false;

        while (1 == 1) { // оборачиваем в бесконечный цикл чтобы проворачивать его пока не произойдет ситуация что 2 лока успешно забарлись каким-то потоком
            try {
                firstLockTaken = lock1.tryLock(); // метод пытается забрать лок, если это успешно тк другой поток его не держит,
                // то возвращает true. А если не успешно - то вернет false
                secondLockTaken = lock2.tryLock();
            } finally { // задаем finally блок тк unlock() всегда должен быть инициализирован в этом блоке
                if (firstLockTaken && secondLockTaken) { // проверяем, если оба лока мы забрали, возвращаемся успешно из метода
                    return;
                }
                if (firstLockTaken) { //если только первый лок забран, то делаем его разблокировку для чтобы другой поток
                    // его мог забрать тк этот поток 100% держит второй лок
                    lock1.unlock();
                }
                if (secondLockTaken) { // если только второй лок забран, то делаем его разблокировку для чтобы другой поток
                    // его мог забрать тк этот поток 100% держит первый лок
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1); // делаем сон, чтобы добавить хаотичность в очередь за локами для потоков и дать
                // возможность отдать другим потоком свои локи
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        LockForTransfers.takeLocks(LockForTransfers.lock1, LockForTransfers.lock2); // вызываем метод и прописываем параметры локов в том порядке в котором мы хотим их использовать
        try {
            Transfer.transferP2P(bankOfSender, sender, bankOfReceiver, receiver, boundOfOperation);
        } finally {
            LockForTransfers.lock1.unlock();
            LockForTransfers.lock2.unlock();
        }
    }
}
