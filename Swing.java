import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginPage extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/triptastic";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345";

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginPage() {
        setTitle("Login Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Username Label and Field
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        // Password Label and Field
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonActionListener());
        add(loginButton);

        // Message Label
        messageLabel = new JLabel();
        add(messageLabel);

        setVisible(true);
    }

    private class LoginButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticateUser(username, password)) {
                messageLabel.setText("Login Successful");
                messageLabel.setForeground(Color.GREEN);
            } else {
                messageLabel.setText("Invalid Username or Password");
                messageLabel.setForeground(Color.RED);
            }
        }
    }

    private boolean authenticateUser(String username, String password) {
        boolean isAuthenticated = false;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare SQL query
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            isAuthenticated = resultSet.next();

            // Clean up
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return isAuthenticated;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}
