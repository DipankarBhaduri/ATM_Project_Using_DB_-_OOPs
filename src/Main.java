import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        // Scanner class to take input from user :-->>
        Scanner sc = new Scanner( System.in) ;

        // Created class object :-->>
        Atm_All_Functions aaf = new Atm_All_Functions( 1234 , 3959 , 500 ) ;

        //Some pop-up message :-->>
        System.out.println("Press 1 for --> Change your pin ");
        System.out.println("Press 2 for --> Add your new contact detail ");
        System.out.println("Press 3 for --> Add Money to your Account ");
        System.out.println("Press 4 for --> Withdraw Money from your Account ");
        System.out.println("Press 5 for --> Last Transaction ");
        System.out.println("Press 6 for --> All Transaction ");
        System.out.println("Press 0 for --> exit ");

        // Input for further process :-->>
        System.out.println("Enter the number : ");
        int input = sc.nextInt();

            // If input 1 then we have to change the pin :-->>
            if (input == 1) {
                System.out.println("Enter your new Pin : ");
                int newPin = sc.nextInt();
                while (!aaf.changePin(newPin)) {
                    newPin = sc.nextInt();
                }
            }

            // If input 2 then we have to change or add phone number :-->>
            if (input == 2) {
                System.out.println("Enter your new Phone_Number : ");
                String phoneNo = sc.next();
                while (!aaf.addPhoneNo(phoneNo)) {
                    phoneNo = sc.next();
                }
            }

            // If input 3 then we have to add balance into the account :-->>
            if (input == 3) {
                System.out.println("Enter your Amount : ");
                int amount = sc.nextInt();
                aaf.creditAmount(amount);
            }

            // If input 4 then we have to withdraw balance from the account :-->>
            if ( input == 4 ){
                System.out.println("Enter amount : ");
                int amount = sc.nextInt() ;
                System.out.println("Enter your Pin : ");
                int pin = sc.nextInt() ;
                aaf.withdrawAmount(amount , pin ) ;
            }

            // if Input == 5 , we have to show the last transaction from My database :-->>
            if ( input == 5 ){
                System.out.println("Enter your pin : ");
                int pin = sc.nextInt();
                System.out.println("Your last Transaction details : ");
                aaf.lastTransaction(pin);
            }

            // if input == 6 , then we have to show the all transaction to the user :-->>
            if ( input == 6 ){
                System.out.println("Enter your pin : ");
                int pin = sc.nextInt();
                System.out.println("Your all Transaction details here : ");
                aaf.allTransaction(pin);
            }

            // If input == 0 then we want to show popUp message :-->>
            if ( input >= 0 ){
                System.out.println("Thank you for using ATM & Wish you a great day");
            }

    }
}