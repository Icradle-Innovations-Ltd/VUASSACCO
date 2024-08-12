import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            Database db = new Database("E:\\balexCompany\\database.accdb");

            // Register a new member
            Member newMember = new Member("001", "John Doe", "123 Main St", "555-1234", "john@example.com");
            db.createMember(newMember);

            // Create a new account for the member
            Account newAccount = new Account("A001", "001");
            db.updateAccountBalance(newAccount.getAccountId(), newAccount.getBalance());

            // Perform a transaction
            Transaction transaction = new Transaction("T001", "001", "deposit", 1000, new Date());
            db.createTransaction(transaction);
            newAccount.updateBalance(transaction.getAmount(), transaction.getTransactionType());
            db.updateAccountBalance(newAccount.getAccountId(), newAccount.getBalance());

            // Check account balance
            double balance = db.getAccountBalance(newAccount.getAccountId());
            System.out.println("Account Balance: " + balance);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
