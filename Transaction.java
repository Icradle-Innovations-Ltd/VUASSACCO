import java.util.Date;

public class Transaction {
    private String transactionId;
    private String memberId;
    private String transactionType;
    private double amount;
    private Date date;

    public Transaction(String transactionId, String memberId, String transactionType, double amount, Date date) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
