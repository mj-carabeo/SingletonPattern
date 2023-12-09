package singletonPattern;

public class UserApp {
    public static void main(String[] args) {
        Application app = Application.getInstance();

        app.loginUser("Juan");

        app.loginUser("Maria");

        app.logoutUser();

        app.loginUser("Maria");

        System.out.println("Next queue number: " + app.getNextQueueNumber());

        app.resetQueueNumber(10);
        System.out.println("Queue number after reset: " + app.getCurrentQueueNumber());
    }
}
