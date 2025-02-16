package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import db.HighScoreDAO;
import model.Player;
import java.awt.*;
import java.util.List;

public class HighScoreFrame extends JFrame {

    public HighScoreFrame() {
        setTitle("View High Scores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        String[] columnNames = {"Level", "Player Name", "Score"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable highScoreTable = new JTable(tableModel);

        HighScoreDAO highScoreDAO = new HighScoreDAO();
        String[] levels = {"Beginner", "Intermediate", "Advanced"};

        for (String level : levels) {
            List<Player> highScores = highScoreDAO.getHighScoresByLevel(level);
            if (highScores.isEmpty()) {
                tableModel.addRow(new Object[]{level, "No Scores Yet", "0"});
            } else {
                for (Player player : highScores) {
                    String playerName = player.getName(); // Fetch name from Player model
                    int playerScore = player.getScore();

                    // Debugging log
                    System.out.println("Adding to table: Level=" + level + ", Name=" + playerName + ", Score=" + playerScore);

                    tableModel.addRow(new Object[]{level, playerName, playerScore});
                }
            }
        }

        JScrollPane scrollPane = new JScrollPane(highScoreTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(255, 153, 153));
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        backButton.addActionListener(e -> dispose());
        mainPanel.add(backButton, BorderLayout.SOUTH);
    }
}
