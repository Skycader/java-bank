import java.io.FileNotFoundException;

public class DepositAccount extends Account {

    private int lastTake = 0;
    public DepositAccount(String name, String password) throws FileNotFoundException {
        super(name, password, 2);
    }

    @Override
    public double take(double amount) {

        if (System.currentTimeMillis() / 1000 - lastTake > 5000) {
            money -= (amount + 0.01 * amount);
            System.out.println("TAKE" + money);
            updateUser();
        } else {
            System.out.println(":: Warning, try again in a few seconds");
        }
        lastTake = (int) (System.currentTimeMillis()/1000L);
        return money;
    }
}
