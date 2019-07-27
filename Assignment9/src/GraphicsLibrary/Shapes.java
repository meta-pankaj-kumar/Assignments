/*
 * Shapes Interface for several Shapes 
 * Contains signature of several methods implemented in all shapes
 */
package GraphicsLibrary;
public interface Shapes  {
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point point);
}