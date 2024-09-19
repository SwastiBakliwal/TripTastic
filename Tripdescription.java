import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Formatter;


class Tripdescription 
{
    
        String url = "jdbc:mysql://localhost:3306/triptastic";
        String user = "root";
        String password = "12345";

    void day5()
    { 

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM 5_daysplan")) 
        {

            Formatter fmt = new Formatter();
            fmt.format("%-15s %-15s %-15s %-15s\n", "day", "location", " time_of_day" , " activity");

            while (rs.next()) 
            {
                fmt.format("%-15d %-15s %-15s %-15s\n", rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
            }

            System.out.println(fmt);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    void day10()
    {

        try (Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM 10_daysplan")) 
        {

       Formatter fmt = new Formatter();
       fmt.format("%-15s %-15s %-15s %-15s\n", "day", "location", " time_of_day" , " activity");

       while (rs.next()) 
       {
           fmt.format("%-15d %-15s %-15s %-15s\n", rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
       }

       System.out.println(fmt);
       } 
       catch (Exception e) 
       {
           e.printStackTrace();
       }
    }  
    
    void day15()
    {

       try (Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM 15_daysplan")) 
        {

       Formatter fmt = new Formatter();
       fmt.format("%-15s %15s %-15s %-15s\n", "day", "location", " time_of_day" , " activity");

       while (rs.next()) 
       {
           fmt.format("%-15d %-15s %-15s %-15s\n", rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
       }

       System.out.println(fmt);
       } 
       catch (Exception e) 
       {
           e.printStackTrace();
       }
    }
}