/*
 * This test class test methods and operates on JUnit 4
 */
package Problem3;
import static org.junit.Assert.*;
import org.junit.Test;

public class AddmissionManagementTest {

	@Test
	public void allocateCoursesPositiveCasesTest() {
		
		String availableCoursesExcelFile = "College_Courses.xls";
		String studentDetailsExcelFile = "Student_Details.xls";
		String allocatedCoursesExcelFile = "Course_Allocation.xls";
		
		Counselling addmissionManagement = new Counselling();
		assertTrue(addmissionManagement.allocateCourses(availableCoursesExcelFile, studentDetailsExcelFile, allocatedCoursesExcelFile));
	}
}