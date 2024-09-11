import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

 class SignUp 
 {
    private static final String url = "jdbc:mysql://localhost:3306/user_db";
    private static final String user ="root";
    private static final String pass = "12345"; 
    public void set() 
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
        Connection connection = DriverManager.getConnection(url,user,pass);
        String query ="insert into users(username, password) values(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Username: ");
        String username = sc.nextLine();
        System.out.println();
        System.out.print("Enter the password: ");
        String password = sc.nextLine();
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        int rowsAffected = preparedStatement.executeUpdate();
        if(rowsAffected>0)
        {
         System.out.println("SignUp Successfull");
        }
        else
        {
         System.out.println("SignUp Failed");
        }
        sc.close();
    }
        catch(SQLException e)
        {
          System.out.println(e.getMessage());
        }
     }   
    }