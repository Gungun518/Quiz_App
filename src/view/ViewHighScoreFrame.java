package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import db.HighScoreDAO;
import model.Player;
import java.awt.*;
import java.util.List;

public class ViewHighScoreFrame extends JFrame {

    public ViewHighScoreFrame() {
        setTitle("View High Scores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        // Table to display high scores
        String[] columnNames = {"Level", "Player Name", "Score"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable highScoreTable = new JTable(tableModel);

        HighScoreDAO highScoreDAO = new HighScoreDAO();

        // Fetch high scores for each level
        String[] levels = {"Beginner", "Intermediate", "Advanced"};
        for (String level : levels) {
            List<Player> highScores = highScoreDAO.getHighScoresByLevel(level);
            for (Player player : highScores) {
                Object[] row = {level, player.getName(), player.getScore()};
                tableModel.addRow(row);
            }
        }

        JScrollPane scrollPane = new JScrollPane(highScoreTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(255, 153, 153));
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        backButton.addActionListener(e -> dispose()); // Close the current frame
        mainPanel.add(backButton, BorderLayout.SOUTH);
    }
}
