class NaiveSpinLock {
    private volatile boolean locked = false;

    public void lock() {
        while (locked) {
            // busy spin, try to acquire lock
        }
        locked = true;
    }

    public void unlock() {
        locked = false;
    }
}
