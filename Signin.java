import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class SignIn 
{
    private static final String url = "jdbc:mysql://localhost:3306/user_db";
    private static final String username ="root";
    private static final String password = "12345"; 
    public void get() 
    {
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
       }
       catch(ClassNotFoundException e)
       {
          System.out.println(e.getMessage());
       }
       try
       {
         Connection connection = DriverManager.getConnection(url,username,password);
         String query ="select * from users where username = ? and password = ?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the Username: ");
         String username = sc.nextLine();
         System.out.println();
         System.out.print("Enter the password: ");
         String password = sc.nextLine();
         preparedStatement.setString(1,username);
         preparedStatement.setString(2,password);
         ResultSet resultSet = preparedStatement.executeQuery();
         if(resultSet.next())
         {
           System.out.println("Sign In Successfull");
         }
         else
         {
           System.out.println("User not exist!");
         }
         sc.close();
       } 
       catch(SQLException e)
       {
         System.out.println(e.getMessage());
       }
    }
}

