import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        boolean working = true;
        boolean isLoggedIn = false;
        Scanner input = new Scanner(System.in);
        Account account = null;
        CardAccount cardAccount = null;
        DepositAccount depositAccount = null;

        while (working) {

            System.out.println(":: Starway 1.0.0 bank account system: ");
            System.out.println(":: Type help for actions");

            if (!isLoggedIn) {

                String line = input.nextLine();
                String command = line.split("\\s")[0];

                switch (command) {
                    case "login":

                        System.out.println(":: Login: ");
                        String name = input.nextLine();
                        System.out.println(":: Password: ");
                        String password = input.nextLine();

                        account = new Account(name, password,0);
                        if (account.getName().isEmpty()) {
                            System.out.println(":: Error - user not found!");
                        } else {
                            isLoggedIn = true;
                            cardAccount = new CardAccount(name,password);
                            depositAccount = new DepositAccount(name,password);
                        }
                        break;
                    case "exit":
                        working = false;
                        break;
                    default:
                        System.out.println(":: Command unknown, try again");
                        break;
                }
            }

            if (isLoggedIn) {
                System.out.println(":: Welcome, " + account.getName());
                System.out.println(":: Current balance: $" + account.getMoney());
                System.out.println(":: Current card balance: $" + cardAccount.getMoney());
                System.out.println(":: Current deposit balance: $" + depositAccount.getMoney());

                String line = input.nextLine();
                String command = line.split("\\s")[0];

                switch (command) {
                    case "logout":
                        isLoggedIn = false;
                        break;
                    case "put":
                        System.out.println(":: Enter amount:");
                        String amount = input.nextLine();
                        double put = account.put(Double.parseDouble(amount));
                        System.out.println(":: Put +$" + amount + " onto your account.");
                        break;
                    case "put2":
                        System.out.println(":: Enter amount:");
                        String amount2 = input.nextLine();
                        double put2 = cardAccount.put(Double.parseDouble(amount2));
                        System.out.println(":: Put +$" + amount2 + " onto your account.");
                        break;
                    case "put3":
                        System.out.println(":: Enter amount:");
                        String amount3 = input.nextLine();
                        double put3 = depositAccount.put(Double.parseDouble(amount3));
                        System.out.println(":: Put +$" + amount3 + " onto your account.");
                        break;
                    case "take":
                        System.out.println(":: Enter amount:");
                        String take = input.nextLine();
                        double taken = account.take(Double.parseDouble(take));
                        System.out.println(":: Taken -$" + take + " onto your account.");
                        break;
                    case "take2":
                        System.out.println(":: Enter amount:");
                        String take2 = input.nextLine();
                        double taken2 = cardAccount.take(Double.parseDouble(take2));
                        System.out.println(":: Taken -$" + take2 + " onto your account.");
                        break;
                    case "take3":
                        System.out.println(":: Enter amount:");
                        String take3 = input.nextLine();
                        double taken3 = depositAccount.take(Double.parseDouble(take3));
                        System.out.println(":: Taken -$" + take3 + " onto your account.");
                        break;
                }
            }


        }

    }
}