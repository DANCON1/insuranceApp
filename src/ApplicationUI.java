import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 *  The Console UI class for the application.
 * @Author Mason Seward
 * @Date 2023-02-23
 */
public class ApplicationUI
{
    /**
     * The main method for running the app
     * @param args The Arguments
     * @throws SQLException An exception thrown when something goes wrong with the SQL
     */
    public static void main(String[] args) throws SQLException
    {
        int choice;
        Library library = InsuranceDatabaseManager.loadLibrary();
        do
        {
            choice = determineUserInput();

                if (choice == 1)
                {
                    System.out.print("Enter Name: ");
                    String name = String.valueOf(new Scanner(System.in).nextLine());
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(new Scanner(System.in).next());
                    System.out.print("Enter Number of Accidents: ");
                    int NOA = Integer.parseInt(new Scanner(System.in).next());
                    System.out.print("Enter Address: ");
                    String address = String.valueOf(new Scanner(System.in).nextLine());

                    InsuranceDatabaseManager.addUser(DBConfiguration.establishDBConnection(), library, name, age, NOA, address);
                }
                if (choice == 2)
                {
                    //TODO
                    //editProfile();
                    System.out.println("Not yet implemented");
                }
                if (choice == 3)
                {
                    //TODO
                    //quotePolicy();
                    System.out.println("Not yet implemented");
                }
                if (choice == 4)
                {
                    //TODO
                    //renewPolicy();
                    System.out.println("Not yet implemented");
                }
                if (choice == 5)
                {
                    //TODO
                    //cancelPolicy();
                    System.out.println("Not yet implemented");
                }
                if (choice == 6)
                    System.out.println("An incorrect option has been entered");
                if (choice == 0)
                    System.out.println("Goodbye!");
        }
        while (choice != 0);
    }

    /**
     * Determines what menu option users wish to access
     *
     * @return returns the user choice if it passes validation. If it does not, it returns the value 6 which users cannot enter
     */
    private static int determineUserInput()
    {
        displayMenu();
        System.out.print("Enter Choice: ");
        int userChoice = Integer.parseInt(new Scanner(System.in).next());
        if (userChoice > -1 && userChoice < 6)
            return userChoice;
        else
            return 6;
    }

    /**
     * Displays the options available for the UI
     */
    private static void displayMenu()
    {
        System.out.println("Welcome to Taylor's Insurance. Please choose an option below: ");
        System.out.println("1. Create new user\n2. Edit Profile\n3. Quote a policy\n4. Renew a policy\n" +
                "5. Cancel a policy\n0. Quit");
    }
}