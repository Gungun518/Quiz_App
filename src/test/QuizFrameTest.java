package test;

import view.QuizFrame;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuizFrameTest {

    @Test
    public void testQuizFrameCreation() {
        QuizFrame quizFrame = new QuizFrame(1); // Mock player ID
        assertNotNull("QuizFrame should be created", quizFrame);
    }
}
