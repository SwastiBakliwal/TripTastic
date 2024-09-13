import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class TripSelector 
{
    //method
     void plan()
    {
        // Create a HashMap to store trip options
        Map<Integer, String> tripOptions = new HashMap<>();
        tripOptions.put(1, "5-day trip");
        tripOptions.put(2, "10-day trip");
        tripOptions.put(3, "15-day trip");

        // Display the available trip options
        System.out.println(ConsoleColors.CYAN_BOLD+"Choose your trip duration:"+ConsoleColors.RESET+"\n");
        for (Map.Entry<Integer, String> entry : tripOptions.entrySet()) 
        {
            System.out.println("(" + entry.getKey() + ") " + entry.getValue());
        }

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean validChoice = false;

        // Get and validate user input
        while (!validChoice) 
        {
            System.out.print("Enter your choice (5, 10, or 15): ");
            try 
            {
                if (sc.hasNextInt()) 
                {
                    choice = sc.nextInt();
                    if (tripOptions.containsKey(choice)) 
                    {
                        validChoice = true;
                    } 
                    else 
                    {
                        System.out.println(ConsoleColors.BLUE_BOLD+"Invalid choice. Please select 1st, 2nd, or 3rd."+ConsoleColors.RESET);
                    }
                } 
                else 
                {
                    System.out.println(ConsoleColors.RED_BOLD+"Invalid input. Please enter a number."+ConsoleColors.RESET);
                    sc.next(); // Clear invalid input
                }
            } 
            catch (InputMismatchException e) 
            {
                System.out.println(ConsoleColors.RED_BOLD+"Invalid input. Please enter a number."+ConsoleColors.RESET);
                sc.next(); // Clear invalid input
            }
        }

        // Display the selected trip option
        System.out.println("You selected a " +ConsoleColors.GREEN+ tripOptions.get(choice) + "."+ConsoleColors.RESET);

        //  Donot close the scanner
    }
}
