import java.util.concurrent.locks.Lock;

public class Concurrency {
    //    public static volatile int sharedInt = 0;     // volatile doesn't ensure atomicity

    public final static Object lock = new Object();        // Always make the lock `final`
    public static Integer sharedInt = 0;

    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                sharedInt++;
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                sharedInt++;
//            }
//        });


//        Thread thread1 = new Thread(() -> {
//            // Wrong!!!! shareInt is an Integer object, the reference is changing during `sharedInt++`
//            synchronized (sharedInt) {
//                for (int i = 0; i < 100000; i++) {
//                    sharedInt++;
//                }
//            }
//
//        });

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 100000; i++) {
                    sharedInt++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 100000; i++) {
                    sharedInt++;
                }
                System.out.println("Thread1 finish");
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();     // Block the current thread until thread 1 finishes execution
        thread2.join();


        System.out.println(sharedInt);

    }
}
