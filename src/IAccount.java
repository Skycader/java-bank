public interface IAccount {
    void editBalance(double amount);
    double getBalance();
    int getUserCommission();
    void put(double amount);
    void take(double amount);
    double getMoney();
    String getName();
    void updateUser();

}