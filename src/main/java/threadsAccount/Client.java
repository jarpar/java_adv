package threadsAccount;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class Client implements Runnable {
    private Account account;

    @Override
    public void run() {
        while (account.getAccountSaldo() > 0) {
            try {
                Thread.sleep(500);
                int amount = new Random().nextInt(1000) + 1;
                System.out.println("Wypłacam: " + amount);
                account.getOutcome(amount);
                System.out.printf("Aktualne saldo dla rachunku $s : %.2f zł ",
                        account.getAccountNumber(),
                        account.getAccountSaldo());

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
