import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class AdminLogin 
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/triptastic";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345";

    public boolean authenticateUser(String adminname, String password) 
    {
        boolean isAuthenticated = false;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) 
            {
                // Prepare SQL query
                String query = "SELECT * FROM admin WHERE adminname = ? AND password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) 
                {
                    preparedStatement.setString(1, adminname);
                    preparedStatement.setString(2, password);

                    // Execute query
                    try (ResultSet resultSet = preparedStatement.executeQuery()) 
                    {
                        isAuthenticated = resultSet.next();
                    }
                }
            }
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            ex.printStackTrace();
        }

        return isAuthenticated;
    }
   //final driver class of login
    void run() 
    {
        Scanner sj = new Scanner(System.in);
        AdminLogin loginD = new AdminLogin();
        boolean signedIn = false;

        while (!signedIn) 
        {
            System.out.print("\n"+"Enter Adminname: ");
            String adminname = sj.nextLine();

            System.out.print("Enter Password: ");
            String password = sj.nextLine();

            if (loginD.authenticateUser(adminname, password)) 
            {
                System.out.println("\n"+ConsoleColors.GREEN_BOLD+"Admin Authentication is Successful"+ConsoleColors.RESET+"\n");
                signedIn = true; // Exit the loop on successful login
            } 
            else 
            {
                System.out.println("\n"+ConsoleColors.RED_BOLD+"Invalid Adminname or Password. Please try again."+ConsoleColors.RESET+"\n");
            }
        }

       // Donot close the scanner
    }
}
      

