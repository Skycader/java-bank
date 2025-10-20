import java.io.FileNotFoundException;

public abstract class AccountInterface implements IAccount {

    public abstract void editBalance(double amount);

    public abstract double getBalance();

    public abstract int getUserCommission();

    public abstract void put(double amount);

    public abstract void take(double amount);

    public abstract double getMoney();

    public abstract String getName();

    public abstract void updateUser();
}