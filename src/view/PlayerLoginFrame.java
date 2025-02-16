package view;

import javax.swing.*;
import controller.PlayerController;
import java.awt.*;

public class PlayerLoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public PlayerLoginFrame() {
        setTitle("Player Login");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        // Create a top panel for the Back button
        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("← Back");
        styleBackButton(backButton);
        topPanel.add(backButton, BorderLayout.EAST);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Title label
        JLabel titleLabel = new JLabel("Player Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 102, 255)); // Light blue
        mainPanel.add(titleLabel, BorderLayout.CENTER);

        // Form panel for username and password
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Button panel for Login and Register buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // Style the buttons
        styleButton(loginButton, new Color(102, 178, 255)); // Light blue
        styleButton(registerButton, new Color(102, 255, 178)); // Light green

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Back button action listener (Navigate to App.java)
        backButton.addActionListener(_ -> {
            new App().main(null); // Return to the main selection page
            dispose();
        });

        // Action listener for login button
        loginButton.addActionListener(_ -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            PlayerController playerController = new PlayerController();
            int playerId = playerController.loginPlayer(username, password);

            if (playerId != -1) { // If login is successful
                new CustomDialog(this, "Message", "Login Successful");
                new PlayerDashboardFrame(playerId).setVisible(true); // Navigate to Player Dashboard
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });

        // Action listener for register button
        registerButton.addActionListener(_ -> {
            new RegisterPlayerFrame().setVisible(true);
            dispose();
        });
    }

    // Method to style buttons
    private void styleButton(JButton button, Color backgroundColor) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
    }

    // Method to style the back button
    private void styleBackButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setBackground(new Color(255, 102, 102)); // Light red
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    }
}
