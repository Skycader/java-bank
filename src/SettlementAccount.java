import java.io.FileNotFoundException;

public class SettlementAccount extends Account {

    public SettlementAccount(String name, String password) throws FileNotFoundException {
        super(name, password, 0);
    }

    @Override
    void doNothing(int a) {

    }
}
