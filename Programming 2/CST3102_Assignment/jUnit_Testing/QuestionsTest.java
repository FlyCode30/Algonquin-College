package jUnit_testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import models.MxQuestion;
import models.ShortQuestion;
import models.TorFQuestion;
import models.Questions;
import models.FillQuestion;

public class QuestionsTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Tests the Constructor and Getters from the Multiple Choice Question class (MxQuestion).
	 */

	@Test
    public void MxQuestionConstructorsAndGetters() {
        
        MxQuestion question = new MxQuestion("Introduction to Programming", "Multiple Choice", "What Language are we currently using ?", "Java", true, "Python", false, "HTML", false, "C++", false);
        
        assertEquals("Introduction to Programming", question.getCourseInfo());
        assertEquals("Multiple Choice", question.getType());
        assertEquals("What Language are we currently using ?", question.getBody());
        
        assertEquals("Java", question.getOptionA());
        assertEquals("Python", question.getOptionB());
        assertEquals("HTML", question.getOptionC());
        assertEquals("C++", question.getOptionD());
        
        assertEquals(true, question.getAnswerA());
        assertEquals(false, question.getAnswerB());
        assertEquals(false, question.getAnswerC());
        assertEquals(false, question.getAnswerD());
    }
	
	/**
	 * Tests the Constructor and Getters from the Short Question class (ShortQuestion).
	 */
    
    @Test
    public void ShortQuestionConstructorsAndGetters() {
        
        ShortQuestion question = new ShortQuestion("Healthcare", "Short Answer", "When is our next Healthcare quiz ?", "April 10");      
        assertEquals("Healthcare", question.getCourseInfo());
        assertEquals("Short Answer", question.getType());
        assertEquals("When is our next Healthcare quiz ?", question.getBody());
        assertEquals("April 10", question.getOptionA());
    }
	
	/**
	 * Tests the setters in the Fill Question class (FillQuestion).
	 */
	
    @Test
    public void FillQuestionSetters() {
        
        Questions question = new FillQuestion("", "", "", "", "", "", "");
        
        question.setCourseInfo("Database and Networking");
        question.setType("Fill Questions");
        question.setBody("What is the first layer of the OSI Model ? ");
        
        assertEquals("Database and Networking", question.getCourseInfo());
        assertEquals("Fill Questions", question.getType());
        assertEquals("What is the first layer of the OSI Model ? ", question.getBody());
    }

    /**
     * Tests the toString method in the True of False Question class (TorFQuestion).
     */
    
    @Test
    public void TOrFQuestionsToString() {

        
        TorFQuestion question = new TorFQuestion("Philosophy", "True/False", "Metaphysics is still relevent in today's society.", "True", true, "False", false);
        
        assertEquals("\n" + "Philosophy" + " - " + "True/False" + "\n" + "Metaphysics is still relevent in today's society." + "\n   A: True   B: False\n", question.toString());
    }
    

}