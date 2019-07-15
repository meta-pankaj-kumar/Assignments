/*
 * AreaMethods calculates area of several geometrical Figures
 * AreaMethods consist of following methods
 * areaOfRectangle - computes area of rectangle
 * areaOfSquare - computes area of square
 * areaOfTriangle - computes area of triangle
 * areaOfCircle - computes area of circle
 */
package AreaCalculator;
public class AreaMethods {
	static double garbageValue=-999999.9999;
	/*
	 * @param double type width of rectangle
	 * @param double type height of rectangle
	 * @return double type area of rectangle
	 * Assumption width is greater than zero
	 * Assumption height is greater than zero
	 */
	public static double areaOfRectangle(double width, double height) {
		try {
			//returns area of rectangle as area = width * height
			return (width*height);
		} 
		catch (ArithmeticException e) {
			//if an Arithmetic exception is caught return garbage value
			return garbageValue;
		}
	}
	/*
	 * @param double type width of square
	 * @return double type area of square
	 * Assumption width is greater than zero
	 */
	public static double areaOfSquare(double width) {
		try {
			//returns area of rectangle as area = width * width
			return (width*width);
		} 
		catch (ArithmeticException e) {
			//if an Arithmetic exception is caught return garbage value
			return garbageValue;
		}
	}
	/*
	 * @param double type radius of circle
	 * @return double type area of circle
	 * Assumption radius is greater than zero
	 */
	public static double areaOfCircle(double radius) {
		try {
			//returns area of circle as area = pi * radius * radius
			return (Math.PI*radius*radius);
		} 
		catch (ArithmeticException e) {
			//if an Arithmetic exception is caught return garbage value
			return garbageValue;
		}
	}
	/*
	 * @param double type width of triangle
	 * @param double type height of triangle
	 * @return double type area of triangle
	 * Assumption width is greater than zero
	 * Assumption height is greater than zero
	 */
	public static double areaOfTriangle(double width, double height) {
		try {
			//returns area of triangle as area = (width * height) / 2
			return (width*height/2);
		} 
		catch (ArithmeticException e) {
			//if an Arithmetic exception is caught return garbage value
			return garbageValue;
		}
	}
}
