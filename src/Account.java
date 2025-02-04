import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Account {
    private int userId = -1;
    private String userPassword = "";
    private String userName = "";
    private double money = 0;

    public Account(String name, String password, int accountType) throws FileNotFoundException {

        String file = "src/users.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String userName = line.split(" ")[0];
                String userPassword = line.split(" ")[1];
                String userMoney = line.split(" ")[2+accountType];
                if (userName.equals(name) && userPassword.equals(password)) {
                    money = Double.parseDouble(userMoney);
                    this.userName = userName;
                    this.userId = lineNumber;
                    this.userPassword = userPassword;
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

    public double put(double amount) {
        money+=amount;
        updateUser();
        return money;
    }

    public double take(double amount) {
        money-=amount;
        updateUser();
        return money;
    }

    public double getMoney() {
            return this.money;
    }

    public String getName() {
        return this.userName;
    }

    public void updateUser() {
        EditFileLine.edit(this.userName + " " + this.userPassword + " " + this.money,this.userId);
    }
}
