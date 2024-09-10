package jUnit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.CourseInfo;

class CourseInfoTest {

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
	 * Tests the Constructor and Getters of the Course Info class (CourseInfo).
	 */
	
    @Test
    public void CourseInfoConstructorsAndGetters() {
        
        CourseInfo courseInfo = new CourseInfo("Accounting", "2000", "Fall", "Bachelor of Technology : Digital Health");
        
        assertEquals("Accounting", courseInfo.getProgramName());
        assertEquals("2000", courseInfo.getProgramYear());
        assertEquals("Fall", courseInfo.getSemester());
        assertEquals("Bachelor of Technology : Digital Health", courseInfo.getCourseName());
    }

}
