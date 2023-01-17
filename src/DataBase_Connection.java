import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.* ;

public class DataBase_Connection {
    void Connection1 (int AccountNo , int DepositedAmount , int withdrawnAmount , int updatedBalance , int id ) throws SQLException {

        String Url = "jdbc:mysql://localhost:3306/my_database";
        String U_Name = "root";
        String PassWord = "root";

        Connection con = DriverManager.getConnection(Url, U_Name, PassWord);
        Statement st = con.createStatement();

        String query = "INSERT INTO ATM ( Account_No ,Deposited_Amount,Withdrawn_Amount,Updated_Balance, Id )" +
                "VALUES ( ? , ? , ? , ? , ?)" ;

        PreparedStatement preparedStatement = con.prepareStatement(query) ;
        preparedStatement.setInt( 1 , AccountNo);
        preparedStatement.setInt(2 , DepositedAmount);
        preparedStatement.setInt(3,withdrawnAmount);
        preparedStatement.setInt(4,updatedBalance);
        preparedStatement.setInt(5 , id);

        int addedRows = preparedStatement.executeUpdate();
        con.close();
        st.close();

        System.out.println("Database Updated");
    }

    // for fetching the data to database :-->>
    int[] Connection2 () throws SQLException {
        String Url = "jdbc:mysql://localhost:3306/my_database";
        String U_Name = "root";
        String PassWord = "root";
        String Query = "select Updated_Balance , Id from ATM ORDER BY Id DESC LIMIT 1";
        // SELECT * FROM Table ORDER BY ID DESC LIMIT 1
        Connection con = DriverManager.getConnection(Url, U_Name, PassWord);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(Query);

        int[] ans = new int [2] ;

        while (rs.next()) {
            ans[0] = rs.getInt("Updated_Balance");
            ans[1] = rs.getInt("Id");
        }
        con.close();
        st.close();
        return ans ;
    }

    // for All transaction :-->>>
    void Connection3 () throws SQLException {
        String Url = "jdbc:mysql://localhost:3306/my_database";
        String U_Name = "root";
        String PassWord = "root";
        String Query = "select * from ATM";
        Connection con = DriverManager.getConnection(Url, U_Name, PassWord);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(Query);

        while (rs.next()) {
            String user = "AccountNo = "+rs.getInt("Account_No")+" , Deposited_Amount = "+rs.getInt("Deposited_Amount")+
                    " , Withdrawn_Amount = " +rs.getInt("Withdrawn_Amount")+" , Updated_Balance = "
                    +rs.getInt("Updated_Balance")+ " , Id = "+rs.getInt("Id");
            System.out.println(user);
        }


        con.close();
        st.close();
    }

    // for last transaction :-->>
    void Connection4 () throws SQLException {
        String Url = "jdbc:mysql://localhost:3306/my_database";
        String U_Name = "root";
        String PassWord = "root";
        String Query = "select * from ATM ORDER BY Id DESC LIMIT 1";
        // SELECT * FROM Table ORDER BY ID DESC LIMIT 1
        Connection con = DriverManager.getConnection(Url, U_Name, PassWord);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(Query);
        String user = "" ;
        while (rs.next()) {
            user = "AccountNo = "+rs.getInt("Account_No")+" , Deposited_Amount = "+rs.getInt("Deposited_Amount")+
                    " , Withdrawn_Amount = " +rs.getInt("Withdrawn_Amount")+" , Updated_Balance = "
                    +rs.getInt("Updated_Balance")+ " , Id = "+rs.getInt("Id");
        }
        System.out.println(user);
        con.close();
        st.close();

    }
}



//               while ( rs.next()) {
//               String Userdata = rs.getInt("age")+" : "+ rs.getString("Name");
//               System.out.println(Userdata);
//               }
