import java.io.FileNotFoundException;

public class DepositAccount extends Account {

    private int lastTake = 0;
    public DepositAccount(String name, String password) throws FileNotFoundException {
        super(name, password, 2);
    }

    @Override
    public void take(double amount) {

        if (System.currentTimeMillis() / 1000 - lastTake > 5000) {
            this.editBalance(-amount);
            updateUser();
        } else {
            System.out.println(":: Warning, try again in a few seconds");
        }
        lastTake = (int) (System.currentTimeMillis()/1000L);
    }
}
