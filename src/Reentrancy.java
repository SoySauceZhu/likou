import java.util.concurrent.Semaphore;

public class Reentrancy {
    Semaphore mutex = new Semaphore(2);
    static final Object lock = new Object();

    public void service() throws InterruptedException {
        mutex.acquire();
        helper();
        mutex.release();
    }

    private void helper() throws InterruptedException {
        mutex.acquire();   // 很隐蔽的死锁
        helper2();
        mutex.release();
    }

    private void helper2() throws InterruptedException {
        mutex.acquire();   // 很隐蔽的死锁
        mutex.release();
    }

//    public static void main(String[] args) throws InterruptedException {
//        Reentrancy r = new Reentrancy();
//        r.service();
//    }


    /**
     * ReentrantLock 可重入。但是他的 ReentrantReadWriteLock 的读写混用是不可重入的
     */
}
