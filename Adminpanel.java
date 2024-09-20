
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
    
class Adminpanel 
{

        private static final String URL = "jdbc:mysql://localhost:3306/triptastic";
        private static final String USER = "root";
        private static final String PASSWORD = "12345";
    
        public static Connection getConnection() throws SQLException 
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
         static Connection conn;

         void panel() 
        {
            try 
            {
                conn = Adminpanel.getConnection();
                Scanner sc = new Scanner(System.in);
                
                while (true) 
                {
                    System.out.println("\n"+ConsoleColors.PURPLE+"Choose a Daysplan: (1) 5 DaysPlan (2) 10 DaysPlan (3) 15 DaysPlan (4) Sign Out "+ConsoleColors.RESET);
                    int choice = sc.nextInt();
                    switch (choice) 
                    {
                        case 1:
                            Day5 ob = new Day5();
                            ob.Dayplan_5();
                            break;
                        case 2:
                            Day10 obj = new Day10();
                            obj.Dayplan_10();
                            break;
                        case 3:
                            Day15 obt = new Day15();
                            obt.Dayplan_15();
                            break;
                        case 4:
                            System.out.println(ConsoleColors.PURPLE_BOLD+"Have a great day....."+ConsoleColors.RESET);
                            System.out.println("\n");
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
}