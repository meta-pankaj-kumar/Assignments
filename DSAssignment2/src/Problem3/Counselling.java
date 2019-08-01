/*
 * This class contain method for college course allocation
 * Method
 * 		allocateCourses - This method allocate course to students as their ranks and available seats
 * 		getAvailableCoursesAndCapacity - This method read the excel file containing details of courses and seats and create a HashMap in which key is course name and value is available seats
 */
package Problem3;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Counselling {

	/*
	 * @param excel file containing details of available courses and seats
	 * @param excel file containing details of students and their five course choices
	 * @param excel file to store Allocation Result
	 * @return true if courses is allocated else false
	 */
	public boolean allocateCourses(String coursesAndTotalSeats,String studentChoices,String counsellingResult){
		HashMap<String,Integer> courseAvailable = coursesAndTotalSeatsAllocation(coursesAndTotalSeats);
		try{
			
			WritableWorkbook courseAllocationExcelSheet= Workbook.createWorkbook(new File(counsellingResult));
			WritableSheet courseAllocationSheet = courseAllocationExcelSheet.createSheet("Sheet 1", 0);

			Label label = new Label(0,0,"Student Name");
			courseAllocationSheet.addCell(label);
			label = new Label(1,0,"Allocated Course");
			courseAllocationSheet.addCell(label);

			Workbook studentDetailsExcelSheet = Workbook.getWorkbook(new File(studentChoices));
			Sheet studentSheet = studentDetailsExcelSheet.getSheet(0);
			
			int numberOfStudent = studentSheet.getColumn(0).length-1;
			int totalCourse = studentSheet.getColumns()-1;

			for(int studentIndex =1; studentIndex <=numberOfStudent; studentIndex++){
				boolean isCourseAllocated = false;
				Label studentName = new Label(0,studentIndex,studentSheet.getCell(0,studentIndex).getContents());
				for(int courseIndex =1; courseIndex <= totalCourse; courseIndex++){
					String preferredCourse= studentSheet.getCell(courseIndex, studentIndex).getContents();
					if(courseAvailable.get(preferredCourse) > 0){
						Label courseAllocated = new Label(1,studentIndex,preferredCourse);
						courseAllocationSheet.addCell(studentName);
						courseAllocationSheet.addCell(courseAllocated);
						isCourseAllocated = true;
						courseAvailable.put(preferredCourse, courseAvailable.get(preferredCourse)-1);
						break;
					}
				}
				if(!isCourseAllocated){
					courseAllocationSheet.addCell(studentName);
					Label courseAllocated = new Label(1,studentIndex,"Not Allocated");
					courseAllocationSheet.addCell(courseAllocated);
				}
			}
			courseAllocationExcelSheet.write();
			studentDetailsExcelSheet.close();
			courseAllocationExcelSheet.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * @param excel file containing details of courses available and their seats
	 * @return HashMap<String,Integer> where key is course name and value is available total seats
	 */
	private HashMap<String,Integer> coursesAndTotalSeatsAllocation (String coursesAndTotalSeats){
		HashMap<String,Integer> courseAvailable = new HashMap<String,Integer>();
		try {
			Workbook coursesAvailable = Workbook.getWorkbook(new File(coursesAndTotalSeats));
			Sheet courseSheet = coursesAvailable.getSheet(0);
			int totalCourses = courseSheet.getColumn(0).length-1;
			Cell courseName;
			Cell availableCapacity;
			int courseNamecolIndex =0;
			int availableCapacityColIndex = 1;
			int courseRowIndex =1;
			while(courseRowIndex <= totalCourses){

				courseName = courseSheet.getCell(courseNamecolIndex,courseRowIndex);
				availableCapacity = courseSheet.getCell(availableCapacityColIndex, courseRowIndex);
				courseAvailable.put(courseName.getContents(), Integer.parseInt(availableCapacity.getContents()));
				courseRowIndex++;
			}
			coursesAvailable.close();
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return courseAvailable;
	}
}