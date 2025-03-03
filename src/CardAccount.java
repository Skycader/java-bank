import java.io.FileNotFoundException;

public class CardAccount extends Account {


    public CardAccount(String name, String password) throws FileNotFoundException {
        super(name, password, 1);
    }

    @Override
    public double take(double amount) {
        System.out.println("Комиссия составит: 0." + this.getUserCommission() + "%");
        this.editBalance(-(amount + 0.01*amount*this.getUserCommission()));
        updateUser();
        return this.getBalance();
    }

    @Override
    void doNothing(int a) {

    }
}
