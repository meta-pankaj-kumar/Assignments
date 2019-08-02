/*
 * Class for getting Bowlers according to priority
 * Methods
 * 		BowlerSequencer - parameterized Constructor
 * 		addBowler - adds bowler to list
 * 		getNextBowler - returns the next Bowler 		
 */
package Problem3;
public class BowlerSequencer {
	private int totalNumberOfBowlers;
	private MaxHeap heap;
	/*
	 * @param int type total number of Bowlers
	 * @return null
	 */
	public BowlerSequencer(int totalNumberOfBowlers){
		this.totalNumberOfBowlers=totalNumberOfBowlers;
		this.heap = new MaxHeap(this.totalNumberOfBowlers);
	}
	/*
	 * @param Bowler type bowler
	 * @return true after adding bowler
	 * @exception throws exception if bowler list is full
	 */
	public boolean addBowler(Bowler bowler) throws Exception{
		if(this.totalNumberOfBowlers>0){
			Object object=new Object(bowler.getNameOfBowler(),bowler.getNumberOfBallsLeft());
			heap.insertNode(object);
			this.totalNumberOfBowlers--;
			return true;
		}
		else {
			throw new Exception("Bowlers List is already Full");
		}
	}
	/*
	 * @param null
	 * @return String type Bowlers Name
	 * @exception throws exception if no bowler is left to bowl
	 */
	public String getNextBowler() throws Exception{
		if(this.totalNumberOfBowlers==0){
			if(heap.checkIfAllElmentsAreZero()){
				throw new Exception("No Bowler has balls left to bowl");
			}
			Object object=heap.deleteNode();
			Bowler bowler=new Bowler((String)object.getValue(),object.getPriority());
			totalNumberOfBowlers++;
			bowler.setNumberOfBallsLeft(bowler.getNumberOfBallsLeft()-1);
			addBowler(bowler);
			return bowler.getNameOfBowler();
		}
		else {
			throw new Exception("Complete Addition Of Bowlers First");
		}
	}
}