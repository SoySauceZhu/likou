class NaiveLock {
    private boolean locked = false;

    public synchronized void lock() {
        while (locked) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }
}
