package test;

import controller.QuizController;
import model.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QuizControllerTest {

    private QuizController quizController;

    @Before
    public void setUp() {
        quizController = new QuizController();
    }

    @Test
    public void testGetQuestionsByLevel_Beginner() {
        List<Question> questions = quizController.getQuestionsByLevel("Beginner");
        assertNotNull("Beginner questions should not be null", questions);
        assertFalse("Beginner questions list should not be empty", questions.isEmpty());
    }

    @Test
    public void testGetQuestionsByLevel_Intermediate() {
        List<Question> questions = quizController.getQuestionsByLevel("Intermediate");
        assertNotNull("Intermediate questions should not be null", questions);
        assertFalse("Intermediate questions list should not be empty", questions.isEmpty());
    }

    @Test
    public void testGetQuestionsByLevel_Advanced() {
        List<Question> questions = quizController.getQuestionsByLevel("Advanced");
        assertNotNull("Advanced questions should not be null", questions);
        assertFalse("Advanced questions list should not be empty", questions.isEmpty());
    }

    @Test
    public void testGetQuestionsByInvalidLevel() {
        List<Question> questions = quizController.getQuestionsByLevel("InvalidLevel");
        assertNotNull("Questions should not be null", questions);
        assertTrue("Invalid level should return empty list", questions.isEmpty());
    }
}
