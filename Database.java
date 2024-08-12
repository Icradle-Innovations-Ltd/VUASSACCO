import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection conn;

    public Database(String dbPath) throws SQLException {
        String url = "jdbc:ucanaccess://" + dbPath;
        conn = DriverManager.getConnection(url);
    }

    public void createMember(Member member) throws SQLException {
        String sql = "INSERT INTO Members (MemberID, Name, Address, Phone, Email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getAddress());
            pstmt.setString(4, member.getPhone());
            pstmt.setString(5, member.getEmail());
            pstmt.executeUpdate();
        }
    }

    public Member getMember(String memberId) throws SQLException {
        String sql = "SELECT * FROM Members WHERE MemberID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Member(rs.getString("MemberID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Email"));
            } else {
                return null;
            }
        }
    }

    public void createTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO Transactions (TransactionID, MemberID, Type, Amount, Date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getTransactionId());
            pstmt.setString(2, transaction.getMemberId());
            pstmt.setString(3, transaction.getTransactionType());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setDate(5, new java.sql.Date(transaction.getDate().getTime()));
            pstmt.executeUpdate();
        }
    }

    public void updateAccountBalance(String accountId, double newBalance) throws SQLException {
        String sql = "UPDATE Accounts SET Balance=? WHERE AccountID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBalance);
            pstmt.setString(2, accountId);
            pstmt.executeUpdate();
        }
    }

    public double getAccountBalance(String accountId) throws SQLException {
        String sql = "SELECT Balance FROM Accounts WHERE AccountID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("Balance");
            } else {
                return 0.0;
            }
        }
    }
}
