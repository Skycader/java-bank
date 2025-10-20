import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

abstract class Account extends AccountInterface {
    private int userId = -1;
    private String userName = "";
    private double money = 0;
    private int accountType = 0;
    private String userType = "";

    public Account(String name, String password, int accountType) throws FileNotFoundException {
        this.accountType = accountType;
        String file = "src/users.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String userName = line.split(" ")[0];
                String userPassword = line.split(" ")[1];
                this.userType = line.split(" ")[2];
                String userMoney = line.split(" ")[3+accountType];
                if (userName.equals(name) && userPassword.equals(password)) {
                    money = Double.parseDouble(userMoney);
                    this.userName = userName;
                    this.userId = lineNumber;
                    break;
                }
                lineNumber++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void editBalance(double amount) {
        this.money += amount;
    }

    public double getBalance() {
        return this.money;
    }

    public int getUserCommission() {
        String[] userTypes = {"", "premium", "client"};
        return  Arrays.asList(userTypes).indexOf(this.userType);
    }

    public void put(double amount) {
        money+=amount;
        updateUser();
    }

    public void take(double amount) {
        money-=amount;
        updateUser();
    }

    public double getMoney() {
            return this.money;
    }

    public String getName() {
        return this.userName;
    }

    public void updateUser() {
        switch(accountType) {
            case 0:
                EditFileLine.edit(this.money +" $2 $3",this.userId);
                break;
            case 1:
                EditFileLine.edit("$1 "+this.money +" $3",this.userId);
                break;
            case 2:
                EditFileLine.edit("$1 $2 " + this.money,this.userId);
                break;
        }

    }
}
