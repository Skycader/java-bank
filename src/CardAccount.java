import java.io.FileNotFoundException;

public class CardAccount extends Account {


    public CardAccount(String name, String password) throws FileNotFoundException {
        super(name, password, 1);
    }

    @Override
    public double take(double amount) {
        this.editBalance(-(amount + 0.01*amount));
        updateUser();
        return this.getBalance();
    }
}
