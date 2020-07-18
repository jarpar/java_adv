package threadsAccount;

public class Main {
    public static void main(String[] args) {

        Account account1 = new Account("1", 1_000);
        Client client1 = new Client(account1);
//
//        Account account2 = new Account("2", 20_000);
//        Client client2 = new Client(account2);

        Thread thread1 = new Thread(client1);
        thread1.start();
    }
}
