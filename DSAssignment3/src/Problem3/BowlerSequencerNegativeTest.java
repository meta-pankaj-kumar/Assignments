/*
 * Negative test case class operating under JUnit 4
 */
package Problem3;
import static org.junit.Assert.*;
import org.junit.Test;
public class BowlerSequencerNegativeTest {

	@Test(expected = Exception.class)
	public void testAddBowler() throws Exception {
		BowlerSequencer sequence=new BowlerSequencer(2);
		assertTrue(sequence.addBowler(new Bowler("Bumrah",2)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja",1)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja",1)));
	}

	@Test(expected = Exception.class)
	public void testGetNextBowler() throws Exception {
		BowlerSequencer sequence=new BowlerSequencer(3);
		assertTrue(sequence.addBowler(new Bowler("Bumrah",2)));
		assertTrue(sequence.addBowler(new Bowler("Bhubhneshwar",3)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja",1)));
		assertEquals("Bhubhneshwar",sequence.getNextBowler());
		assertEquals("Bumrah",sequence.getNextBowler());
		assertEquals("Bhubhneshwar",sequence.getNextBowler());
		assertEquals("Bumrah",sequence.getNextBowler());
		assertEquals("Bhubhneshwar",sequence.getNextBowler());
		assertEquals("Jadeja",sequence.getNextBowler());
		
		sequence.getNextBowler();
	}
}