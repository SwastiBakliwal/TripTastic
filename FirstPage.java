import java.util.Scanner;

class FirstPage 
{
    
  public static void main(String[] args) 
  {
    System.out.println("------------------------------------------------------------------------------------WELCOME TO TRIPTASTIC--------------------------------------------------------------------------------------------------"+"\n");
    System.out.println("------------------------------------------------------------------------------Find your travel rhythm with us----------------------------------------------------------------------------------------------");
    while (true) 
    {
     System.out.println("Choose from.......");
     System.out.println("(1)Sign Up ------------>");
     System.out.println("(2)Sign In ------------>");
     Scanner sc = new Scanner(System.in);
     int choice = 0;
            
        try {
            if (sc.hasNextInt()) 
            {
                choice = sc.nextInt();
            } 
            else 
            {
               System.out.println("Invalid input. Please enter a number."); 
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Error: No input provided.");
        } catch (java.lang.IllegalStateException e) {
            System.out.println("Error: Scanner is closed.");
        }

        // Your existing logic based on the choice
        switch (choice) {
            case 1:
                 SignUp ob = new SignUp();
                 ob.set();
                // Add sign-up logic here
                break;
            case 2:
                SignIn obj = new SignIn();
                obj.get();
                // Add sign-in logic here
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
                break;
        }

        //sc.close();
    }
}

}