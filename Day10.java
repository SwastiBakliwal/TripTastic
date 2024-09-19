import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Scanner;

class Day10 
{
        private static final String URL = "jdbc:mysql://localhost:3306/triptastic";
        private static final String USER = "root";
        private static final String PASSWORD = "12345";
    
        public static Connection getConnection() throws SQLException 
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }


         static Connection conn;

         void Dayplan_10() 
        {
            try 
            {
                conn = Day10.getConnection();
                Scanner sc = new Scanner(System.in);
                
                while (true) 
                {
                    System.out.println(ConsoleColors.YELLOW_BOLD+"Choose an operation: 1. Create 2. Read 3. Update 4. Delete 5. Exit"+ConsoleColors.RESET);
                    int choice = sc.nextInt();
                    switch (choice) 
                    {
                        case 1:
                            create10_daysplan(sc);
                            break;
                        case 2:
                            read10_daysplan();
                            break;
                        case 3:
                            update10_daysplan(sc);
                            break;
                        case 4:
                            delete10_daysplan(sc);
                            break;
                        case 5:
                            System.out.println(ConsoleColors.BLUE_BOLD+"Changes completed....."+ConsoleColors.RESET);
                            conn.close();
                            
                            return;
                        default:
                            System.out.println(ConsoleColors.RED_BOLD+"Invalid choice. Try again."+ConsoleColors.RESET);
                    }
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }

    
        private  void create10_daysplan(Scanner scanner) throws SQLException 
        {
            String query = "INSERT INTO 10_daysplan (sno,day,location,activity,time_of_day) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            System.out.println("Enter the serial number: ");
            int sno = scanner.nextInt();
            stmt.setInt(1,sno);
            System.out.println("Enter day to insert: ");
            int day = scanner.nextInt();
            stmt.setInt(2, day);
            System.out.println("Enter new location: ");
            String location = scanner.nextLine();
            scanner.next();
            stmt.setString(3, location);
            System.out.println("Enter new Activity: ");
            String activity = scanner.nextLine();
            stmt.setString(4, activity);
            System.out.println("Enter the time of day: ");
            String time = scanner.next();
            stmt.setString(5, time); 
                  
            stmt.executeUpdate();
            System.out.println(ConsoleColors.GREEN_BOLD+"plan created successfully."+ConsoleColors.RESET);
        }
    
        private  void read10_daysplan() throws SQLException 
        {
            try
            {
            String query = "SELECT * FROM 10_daysplan";
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery();         
           Formatter fmt = new Formatter();
           fmt.format("%-15s %-15s %-15s %-15s %-15s\n", "Sno", "Day", "Location", "Time_of_day", "Activity");

           while (rs.next()) 
           {
               fmt.format("%-15d %-15d %-15s %-15s %-15s\n", rs.getInt(5),rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
           }

           System.out.println(fmt);
          } 
          catch (Exception e) 
          {
           e.printStackTrace();
          }
        }
    
        private  void update10_daysplan(Scanner scanner) throws SQLException 
        {
            System.out.print("Enter sno to update:");
            int sno = scanner.nextInt();
            // System.out.print("Enter day to update:");
            // int day = scanner.nextInt();
            // System.out.print("Enter new location:");
            // String location = scanner.nextLine();
            System.out.print("Enter new Activity:");
            String activity = scanner.nextLine();
            System.out.print("Enter new time:");
            String time = scanner.next();


    
            String query = "UPDATE 10_daysplan SET activity = ?, time = ?, WHERE sno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, sno);
           // stmt.setInt(2, day);
           // stmt.setString(3, location);
            stmt.setString(4, activity);
            stmt.setString(5, time);

            stmt.executeUpdate();
            System.out.println(ConsoleColors.GREEN_BOLD+"Place updated successfully."+ConsoleColors.RESET);
        }
    
        private  void delete10_daysplan(Scanner scanner) throws SQLException 
        {
            System.out.println("Enter sno to delete:");
            int sno = scanner.nextInt();
    
            String query = "DELETE FROM 10_daysplan WHERE sno = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, sno);
            stmt.executeUpdate();
            System.out.println(ConsoleColors.GREEN_BOLD+"Dayplan deleted successfully."+ConsoleColors.RESET);
        }    
}
