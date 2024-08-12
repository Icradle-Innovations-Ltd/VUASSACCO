public class Account {
    private String accountId;
    private String memberId;
    private double balance;

    public Account(String accountId, String memberId) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.balance = 0.0;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getMemberId() {
        return memberId;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount, String transactionType) {
        if (transactionType.equals("deposit")) {
            balance += amount;
        } else if (transactionType.equals("withdrawal")) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient balance for withdrawal");
            }
        }
    }
}
