public class NaiveReentrantLock {
    private Thread owner;
    private int count = 0;

    public synchronized void lock() {
        while (owner != null && owner != Thread.currentThread()) {
            // Cannot spin
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        owner = Thread.currentThread();
        count++;
    }

    public synchronized void unlock() {
        if (owner != Thread.currentThread()) {
            throw new IllegalMonitorStateException(
                    "Current thread does not own the lock"
            );
        }

        count--;

        if (count == 0) {
            owner = null;
            notify(); // 或 notifyAll()
        }
    }

    public static void main(String[] args) {
        NaiveReentrantLock lock = new NaiveReentrantLock();

        lock.lock();
        System.out.println("first lock");

        lock.lock();
        System.out.println("reentered");

        lock.unlock();
        lock.unlock();

    }

}
