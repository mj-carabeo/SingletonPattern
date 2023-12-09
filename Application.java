package singletonPattern;

import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    private static Application instance;
    private String user;
    private boolean isUserLoggedIn;
    private AtomicInteger currentQueueNumber;
    private static final int INITIAL_QUEUE_NUMBER = 1;

    private Application() {
        this.currentQueueNumber = new AtomicInteger(INITIAL_QUEUE_NUMBER);
    }

    public static synchronized Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public synchronized boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public synchronized void loginUser(String user) {
        if (!isUserLoggedIn) {
            isUserLoggedIn = true;
            this.user = user;
            System.out.println(user + " is logged in!");
        } else {
            System.out.println("Another user already logged in!");
        }
    }

    public synchronized void logoutUser() {
        isUserLoggedIn = false;
        System.out.println(user + " is logged out!");
    }

    public synchronized int getNextQueueNumber() {
        return currentQueueNumber.getAndIncrement();
    }

    public synchronized void resetQueueNumber(int newQueueNumber) {
        currentQueueNumber.set(newQueueNumber);
    }

    public synchronized int getCurrentQueueNumber() {
        return currentQueueNumber.get();
    }
}
