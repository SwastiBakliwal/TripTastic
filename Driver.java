import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Driver 
{
    public static void main(String[] args) 
    {
        
        System.out.println(ConsoleColors.PURPLE_BOLD + "------------------------------------------------------------------------------------WELCOME TO TRIPTASTIC--------------------------------------------------------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "------------------------------------------------------------------------------Find your travel rhythm with us----------------------------------------------------------------------------------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD + "Choose from......."+ ConsoleColors.RESET+"\n");
        System.out.println("(1)Sign Up ------------>"+"\n");
        System.out.println("(2)Sign In ------------>"+"\n");

        Driver Dob = new Driver();
        Dob.get();
    }

    void get()
    {
       
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean validChoice = false;

        // Keep prompting until a valid choice is made
        while (!validChoice) 
        {
            try 
            {
                if (sc.hasNextInt()) 
                {
                    choice = sc.nextInt();
                    if (choice == 1 || choice == 2) 
                    {
                        validChoice = true;
                    } 
                    else 
                    {
                        System.out.println(ConsoleColors.BLUE_BOLD + "Invalid choice. Please select 1 or 2." + ConsoleColors.RESET);
                    }
                } 
                else 
                {
                    System.out.println(ConsoleColors.RED_BOLD + "Invalid input. Please enter a number." + ConsoleColors.RESET);
                    sc.next(); // Clear the invalid input
                }
            } 
            catch (InputMismatchException e) 
            {
                System.out.println(ConsoleColors.RED_BOLD + "Invalid input. Please enter a number." + ConsoleColors.RESET);
                sc.next(); // Clear the invalid input
            } 
            catch (NoSuchElementException e) 
            {
                System.out.println("Error: No input provided.");
                sc.next(); // Clear the invalid input
            } 
            catch (IllegalStateException e) 
            {
                System.out.println("Error: Scanner is closed.");
                break;
            }
        }

        // Process based on the valid choice
        switch (choice) 
        {
            case 1:
                SignUp ob = new SignUp();
                ob.set();
                // Add sign-up logic here
                break;
            case 2:
                SignIn oc = new SignIn();
                oc.run();
                // Add sign-in logic here
                break;
            default:
                System.out.println(ConsoleColors.YELLOW_BOLD + "Unexpected error occurred." + ConsoleColors.RESET);
                break;
        }
       TripSelector tob = new TripSelector();
       tob.plan();
    }

}  

