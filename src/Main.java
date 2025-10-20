import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        boolean working = true;
        boolean isLoggedIn = false;
        Scanner input = new Scanner(System.in);
        Account account = null;
        boolean isAccountSelected = false;
        String name = "";
        String password = "";

        while (working) {

            System.out.println(":: Starway 1.0.0 bank account system: ");
            System.out.println(":: Type help for actions");

            if (!isLoggedIn) {

                String line = input.nextLine();
                String command = line.split("\\s")[0];

                switch (command) {
                    case "help":
                        System.out.println(":: Available commands: ");
                        System.out.println("- login");
                        System.out.println("- stop");
                        break;
                    case "login":
                        System.out.println(":: Login: ");
                         name = input.nextLine();
                        System.out.println(":: Password: ");
                       password = input.nextLine();
                        account = new SettlementAccount(name, password);
                        if (account.getName().isEmpty()) {
                            System.out.println(":: Error - user not found!");
                        } else {
                            isLoggedIn = true;
                        }
                        break;
                    case "stop":
                        working = false;
                        break;
                    default:
                        System.out.println(":: Command unknown, try again");
                        break;
                }
            }

            if (isLoggedIn && !isAccountSelected) {
                System.out.println(":: Welcome, " + account.getName());
                System.out.println(":: Select account: ");
                System.out.println("1: Settlement account");
                System.out.println("2: Deposit account");
                System.out.println("3: Card account");
                String line = input.nextLine();
                String command = line.split("\\s")[0];

                switch (command) {
                    case "1":
                        isAccountSelected = true;
                        account = null;
                        account = new SettlementAccount(name,password);
                        break;
                    case "3":
                        isAccountSelected = true;

                        account = new DepositAccount(name,password);
                        break;
                    case "2":
                        isAccountSelected = true;
                        System.out.println(name + password);
                        account = new CardAccount(name,password);
                        break;
                }
            }

            if (isLoggedIn && isAccountSelected) {
                System.out.println(":: Welcome, " + account.getName());
                System.out.println(":: Current balance: $" + account.getMoney());

                String line = input.nextLine();
                String command = line.split("\\s")[0];

                switch (command) {
                    case "help":
                        System.out.println(":: Available commands: ");
                        System.out.println("- select");
                        System.out.println("- logout");
                        System.out.println("- put");
                        System.out.println("- take");
                        break;
                    case "select":
                        isAccountSelected = false;
                        break;
                    case "logout":
                        isLoggedIn = false;
                        break;
                    case "put":
                        System.out.println(":: Enter amount:");
                        String amount = input.nextLine();
                        account.put(Double.parseDouble(amount));
                        System.out.println(":: Put +$" + amount + " onto your account.");
                        break;
                    case "take":
                        System.out.println(":: Enter amount:");
                        String take = input.nextLine();
                        account.take(Double.parseDouble(take));
                        System.out.println(":: Taken -$" + take + " onto your account.");
                        break;
                }
            }


        }

    }
}