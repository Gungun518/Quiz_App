package test;

import db.PlayerDAO;
import model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerDAOTest {

    private PlayerDAO playerDAO;

    @Before
    public void setUp() {
        playerDAO = new PlayerDAO();
    }

    @Test
    public void testLoginPlayer_ValidCredentials() {
        int playerId = playerDAO.loginPlayer("hello@gmail.com", "12345678"); // Provide mock credentials
        assertTrue("Player login should return a valid ID", playerId > 0);
    }

    @Test
    public void testLoginPlayer_InvalidCredentials() {
        int playerId = playerDAO.loginPlayer("wronguser", "wrongpassword");
        assertEquals("Invalid login should return -1", -1, playerId);
    }

    @Test
    public void testGetPlayerDifficulty() {
        String difficulty = playerDAO.getPlayerDifficulty(1); // Assuming player ID 1 exists
        assertNotNull("Difficulty level should not be null", difficulty);
        assertTrue("Difficulty should be Beginner, Intermediate, or Advanced",
                difficulty.equals("Beginner") || difficulty.equals("Intermediate") || difficulty.equals("Advanced"));
    }

    @Test
    public void testRegisterNewPlayer() {
        Player newPlayer = new Player("testing@gmail.com", "password123", "Gungun", "Intermediate"); // Create Player object
        boolean isRegistered = playerDAO.registerPlayer(newPlayer); // Pass the object
        assertTrue("New player should be registered successfully", isRegistered);
    }

}
