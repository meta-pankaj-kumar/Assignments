/*
 * Class having attributes of Bowler
 * Methods
 * 		Bowler - Parameterized Constructor
 * 		getNumberOfBallsLeft - returns number of balls left
 * 		setNumberOfBallsLeft - sets number of balls
 * 		getNameOfBowler - returns name of bowler
 */
package Problem3;
public class Bowler {
	private final String nameOfBowler;
	private int numberOfBallsLeft;
	/*
	 * @param String name of Bowler
	 * @param int type number of balls left
	 * @return null
	 */
	public Bowler(String nameOfBowler,int numberOfBallsLeft) {
		this.nameOfBowler=nameOfBowler;
		this.numberOfBallsLeft=numberOfBallsLeft;
	}
	/*
	 * @param null
	 * @return int type number of balls left
	 */
	public int getNumberOfBallsLeft() {
		return this.numberOfBallsLeft;
	}
	/*
	 * @param int type number of balls
	 * @return null
	 */
	public void setNumberOfBallsLeft(int numberOfBallsLeft) {
		this.numberOfBallsLeft = numberOfBallsLeft;
	}
	/*
	 * @param null
	 * @return String type name of bowler
	 */
	public String getNameOfBowler() {
		return this.nameOfBowler;
	}
}