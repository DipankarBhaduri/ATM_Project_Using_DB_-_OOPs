import java.sql.SQLException;
import java.util.*;
public class Atm_All_Functions implements Menu {
    Scanner sc = new Scanner ( System.in) ;
    private int pinCode;
    private int AccountNo;
    private String PhoneNo;
    private int Balance ;



    // Constructor :-->>
    public Atm_All_Functions(int pinCode, int accountNo , int openingBalance) throws SQLException {
        this.pinCode = pinCode;
        this.AccountNo = accountNo;
        this.Balance = openingBalance ;
        DataBase_Connection DBC = new DataBase_Connection();
        int [] ans = DBC.Connection2();
        if ( ans [1] == 0 ) {
            DBC.Connection1(this.AccountNo, this.Balance, 0, getBalance(), 1);
//        } else {
//            DBC.Connection1(this.AccountNo , this.Balance , 0 , ans[0]+this.Balance, ans[1]+1 );
//        }
        }
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    // Getter & Setter :-->>
    public int getPinCode() {
        return pinCode;
    }

    // Getter & Setter :-->>
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    // Getter & Setter :-->>
    public int getAccountNo() {
        return AccountNo;
    }

    // Getter & Setter :-->>
    public void setAccountNo(int accountNo) {
        AccountNo = accountNo;
    }


    // Change Pin Method Implementation :-->>
    @Override
    public boolean changePin(int newPin) {
        String pin = Integer.toString(newPin) ;
        if ( pin.length() == 4 ){
            pinCode = newPin;
            System.out.println("Your pin code has been updated and Updated pin is " + newPin);
            return true ;
        } else {
            System.out.println("Please enter a 4 digit pin :");
            return false ;
        }
    }

    // Add Phone Number Method Implementation :-->>
    @Override
    public boolean addPhoneNo(String newPhoneNo) {
        if (newPhoneNo.length() == 10 ) {
            PhoneNo = newPhoneNo;
            System.out.println("Your new Ph number " + PhoneNo + " has been updated");
            return true ;
        } else {
            System.out.println("Invalid Phone Number! Please ReEnter your Phone number : ");
            return false ;
        }
    }

    // Credit Amount Method Implementation :-->>
    @Override
    public boolean creditAmount(int Money) throws SQLException {
        System.out.println("Your Account No : "+AccountNo+" your balance is : "+Balance ) ;
        System.out.println("Press 'Y' to confirm : ") ;
        System.out.println("Press 'N' to Cancel : ") ;
        String str = sc.next() ;
        if ( str.equals("Y") || str.equals("y")){
            DataBase_Connection con = new DataBase_Connection() ;
            int[] ans = con.Connection2();
            ans[0] += Money ;
            System.out.println(Money + " is added & Updated balance is : "+ ans[0]);
            con.Connection1(getAccountNo() , Money , 0 , ans[0] , ans[1]+1 );
            return true ;
        } else {
            System.out.println("Transaction Cancel");
            return false ;
        }
    }

    // withdraw Amount Method Implementation :-->>
    @Override
    public boolean withdrawAmount(int Money , int passcode) throws SQLException {
        if ( passcode == pinCode ){
            DataBase_Connection con = new DataBase_Connection() ;
            int[] ans = con.Connection2();
            if ( Money <= ans[0] ){
                ans[0] -= Money ;
                System.out.println("Withdraw successful & Collect your Money");
                con.Connection1(getAccountNo() , 0 , Money , ans[0] , ans[1]+1 );
                return true ;
            } else {
                System.out.println("Your balance is Low");
                return false;
            }
        } else {
            System.out.println("Wrong PinCode! ");
            return false ;
        }
    }

    @Override
    public void lastTransaction( int pin ) throws SQLException {
        if ( pin == pinCode ){
            DataBase_Connection DBC = new DataBase_Connection() ;
            DBC.Connection4();
        } else {
            System.out.println("Your pin is not matching! ");
        }
    }

    @Override
    public void allTransaction(int pin) throws SQLException {
        if ( pin == pinCode ){
            DataBase_Connection DBC = new DataBase_Connection() ;
            DBC.Connection3();
        } else {
            System.out.println("Your pin is not matching! ");
        }
    }
}
