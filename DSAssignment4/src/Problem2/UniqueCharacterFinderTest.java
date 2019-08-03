package Problem2;
import static org.junit.Assert.*;
import org.junit.Test;
public class UniqueCharacterFinderTest {

	@Test
	public void getNumberOfUniqueCharactersMethodPositiveCasesTest() {
		
		StringCache uniqueChracterFinder = new StringCache();
		String input1 = "abcd";
		String input2 = "aaaa";
		String input3 = "rty567%^&";
		assertEquals(4,uniqueChracterFinder.getLengthOfUniqueCharacters(input1));
		assertEquals(1,uniqueChracterFinder.getLengthOfUniqueCharacters(input2));
		assertEquals(9,uniqueChracterFinder.getLengthOfUniqueCharacters(input3));
	}
}