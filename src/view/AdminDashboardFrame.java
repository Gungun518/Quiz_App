package view;

import javax.swing.*;
import java.awt.*;

public class AdminDashboardFrame extends JFrame {

    public AdminDashboardFrame() {
        setTitle("Admin Dashboard");
        setSize(550, 550); // Increased size to fit the additional button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10)); // 6 rows to fit new button
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        add(mainPanel, BorderLayout.CENTER);

        // Create a top panel for the logout button
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); // Padding at the top
        add(topPanel, BorderLayout.NORTH);

        // Create the logout button
        JButton logoutButton = new JButton("Logout");
        styleLogoutButton(logoutButton);
        topPanel.add(logoutButton, BorderLayout.EAST); // Align the button to the right

        // Create buttons for different actions
        JButton addQuestionButton = new JButton("Add Question");
        JButton updateQuestionButton = new JButton("Update Question");
        JButton deleteQuestionButton = new JButton("Delete Question");
        JButton viewReportsButton = new JButton("View Reports");
        JButton viewStudentsButton = new JButton("View Students");
        JButton viewHighScoresButton = new JButton("View High Scores"); // New Button

        // Style the buttons
        styleButton(addQuestionButton, new Color(102, 178, 255));  // Light blue
        styleButton(updateQuestionButton, new Color(102, 255, 178)); // Light green
        styleButton(deleteQuestionButton, new Color(255, 153, 153)); // Light red
        styleButton(viewReportsButton, new Color(255, 255, 153)); // Light yellow
        styleButton(viewStudentsButton, new Color(204, 153, 255)); // Light purple
        styleButton(viewHighScoresButton, new Color(255, 204, 102)); // Orange

        // Add buttons to the panel
        mainPanel.add(addQuestionButton);
        mainPanel.add(updateQuestionButton);
        mainPanel.add(deleteQuestionButton);
        mainPanel.add(viewReportsButton);
        mainPanel.add(viewStudentsButton);
        mainPanel.add(viewHighScoresButton);

        // Action listeners for buttons
        addQuestionButton.addActionListener(_ -> new AddQuestionFrame().setVisible(true));
        updateQuestionButton.addActionListener(_ -> new UpdateQuestionFrame().setVisible(true));
        deleteQuestionButton.addActionListener(_ -> new DeleteQuestionFrame().setVisible(true));
        viewReportsButton.addActionListener(_ -> new ViewReportsFrame().setVisible(true));
        viewStudentsButton.addActionListener(_ -> new ViewStudentsFrame().setVisible(true));
        viewHighScoresButton.addActionListener(_ -> new ViewHighScoreFrame().setVisible(true)); // New functionality

        // Action listener for the logout button
        logoutButton.addActionListener(_ -> {
            App.main(null); // Go back to the first page
            dispose(); // Close the current frame
        });
    }

    // Method to style buttons
    private void styleButton(JButton button, Color backgroundColor) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(backgroundColor);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    }

    // Method to style the logout button
    private void styleLogoutButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setBackground(new Color(255, 102, 102));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    }
}
