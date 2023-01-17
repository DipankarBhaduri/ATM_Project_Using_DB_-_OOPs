import java.sql.SQLException;

public interface Menu {
    boolean changePin ( int newPin) ;
    boolean addPhoneNo ( String phoneNo) ;
    boolean creditAmount ( int Money ) throws SQLException;
    boolean withdrawAmount ( int Money , int password ) throws SQLException;
    void lastTransaction (int pin) throws SQLException;
    void allTransaction (int pin) throws SQLException;
}
