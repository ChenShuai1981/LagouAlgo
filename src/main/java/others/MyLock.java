package others;

import java.util.concurrent.CountDownLatch;

public class MyLock {
    public static void main(String[] args) throws Exception {
        Account src = new Account(10000);
        Account target = new Account(10000);
        CountDownLatch cdl = new CountDownLatch(9999);
        for (int i=0; i<9999; i++) {
            new Thread(() -> {
                src.transactionToTarget(1, target);
                cdl.countDown();
            }).start();
        }
        cdl.await();
        System.out.println("src=" + src.getBalance());
        System.out.println("target=" + target.getBalance());
    }
}
