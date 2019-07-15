/*
 * Marksheet methods is designed for performing several operations on grades of students
 * Operations that can be performed are
 * 		averageCalculator - calculates average grade of all grades
 * 		maximumOfAllGrades - finds maximum grades amongst all grades
 * 		minimumOfAllGrades - finds minimum grades amongst all grades
 * 		percentageOfStudentsPassed - calculates percentage of students passed
 */
package Students;
public class MarksheetMethods {
	/*
	 * @param array (single dimensional) of grades
	 * @return int 1 if grades are in range of 0 and 100 both inclusive 
	 * @return int -1 if grades are not in range
	 * Assumption length of grades array to be greater than 0
	 * Assumption range of valid grades are 0 to 100 both inclusive
	 */
	public static int gradesValidity(int grades[]){
		for(int gradeLoop=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;gradeLoop<grades.length;gradeLoop++){
			//check if grades are not in range
			if((grades[gradeLoop]<MarksheetConstantValues.MINIMUM_ALLOWED_GRADE)||(grades[gradeLoop]>MarksheetConstantValues.MAXIMUM_ALLOWED_GRADE))
				//if so return -1;
				return -1;
		}
		//control will reach here only and only if grades are in range
		return 1;
	}
	/*
	 * @param array (single dimensional) of grades
	 * @return double type of calculated average
	 * Assumption length of grades array to be greater than 0
	 * Assumption range of valid grades are 0 to 100 both inclusive
	 */
	public static double averageCalculator(int grades[]) {
		//check for validity of grades if not so return garbage value
		if(MarksheetMethods.gradesValidity(grades)!=1)
			return MarksheetConstantValues.GARBAGE_VALUE;
		int sumOfGrades=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;
		for(int gradeLoop=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;gradeLoop<grades.length;gradeLoop++){
			//summation of all grades
			sumOfGrades+=grades[gradeLoop];
		}
		//return average by dividing summation of all grades by number of grades
		return (sumOfGrades/grades.length);
	}
	/*
	 * @param array (single dimensional) of grades
	 * @return double type of maximum of all grades
	 * Assumption length of grades array to be greater than 0
	 * Assumption range of valid grades are 0 to 100 both inclusive
	 */
	public static double maximumOfAllGrades(int grades[]) {
		//check for validity of grades if not so return garbage value
		if(MarksheetMethods.gradesValidity(grades)!=1)
			return MarksheetConstantValues.GARBAGE_VALUE;
		//take initial value of maximum grades to be 0
		int maxOfGrades=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;
		for(int gradeLoop=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;gradeLoop<grades.length;gradeLoop++){
			//check for if any grade is bigger than maxOfGrades
			if(maxOfGrades<grades[gradeLoop]) {
				//if so then change the value of maximum of grades to current value of grades
				maxOfGrades=grades[gradeLoop];
			}
		}
		//return maximum of grades
		return (maxOfGrades);
	}
	/*
	 * @param array (single dimensional) of grades
	 * @return double type of minimum of all grades
	 * Assumption length of grades array to be greater than 0
	 * Assumption range of valid grades are 0 to 100 both inclusive
	 */
	public static float minimumOfAllGrades(int grades[]) {
		//check for validity of grades if not so return garbage value
		if(MarksheetMethods.gradesValidity(grades)!=1)
			return MarksheetConstantValues.GARBAGE_VALUE;
		//take initial value of minimum grades to be 0
		int minOfGrades=grades[MarksheetConstantValues.MINIMUM_INITIAL_VALUE];
		for(int gradeLoop=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;gradeLoop<grades.length;gradeLoop++){
			//check for if any grade is smaller than minOfGrades
			if(minOfGrades>grades[gradeLoop]) {
				//if so then change the value of minimum of grades to current value of grades
				minOfGrades=grades[gradeLoop];
			}
		}
		//return minimum of grades
		return (minOfGrades);
	}
	/*
	 * @param array (single dimensional) of grades
	 * @return double type of percentage of students passed
	 * Assumption passing score is 40
	 * Assumption length of grades array to be greater than 0
	 * Assumption range of valid grades are 0 to 100 both inclusive
	 */
	public static double percentageOfStudentsPassed(int grades[]) {
		//check for validity of grades if not so return garbage value
		if(MarksheetMethods.gradesValidity(grades)!=1)
			return MarksheetConstantValues.GARBAGE_VALUE;
		//take initial values of students passed to be 0
		int passedStudents=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;
		for(int gradeLoop=MarksheetConstantValues.MINIMUM_INITIAL_VALUE;gradeLoop<grades.length;gradeLoop++){
			//if grades are more than passing grades 
			if(grades[gradeLoop]>=MarksheetConstantValues.PASSING_SCORE) {
				//then increase the number of passed students
				passedStudents++;
			}
		}
		//return percentage by dividing the passed students by total number of students multiplied by 100
		double percentage=passedStudents*100;
		percentage/=grades.length;
		return (percentage);
	}
}