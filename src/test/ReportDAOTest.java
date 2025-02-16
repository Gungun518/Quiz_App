package test;

import db.ReportDAO;
import model.Report;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReportDAOTest {

    private ReportDAO reportDAO;

    @Before
    public void setUp() {
        reportDAO = new ReportDAO();
    }

    @Test
    public void testAddReport() {
        Report report = new Report(1, 6, 4, 60, "Intermediate"); // Mock data
        boolean result = reportDAO.addReport(report);
        assertTrue("Report should be added successfully", result);
    }

    @Test
    public void testGetReportsForPlayer() {
        List<Report> reports = reportDAO.getReportsForPlayer(1); // Assuming player ID 1 exists
        assertNotNull("Report list should not be null", reports);
        assertFalse("Reports list should not be empty", reports.isEmpty());
    }

    @Test
    public void testReportValues() {
        List<Report> reports = reportDAO.getReportsForPlayer(1);
        assertTrue("Player should have at least one report", reports.size() > 0);
        Report report = reports.get(0);
        assertTrue("Correct answers should be between 0 and totalQuestions", report.getCorrectAnswers() >= 0);
        assertTrue("Wrong answers should be between 0 and totalQuestions", report.getWrongAnswers() >= 0);
        assertTrue("Score should not be negative", report.getScore() >= 0);
    }
}
