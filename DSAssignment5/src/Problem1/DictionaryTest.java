package Problem1;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
public class DictionaryTest {
	static String keyValuePairsJsonString = "";
	@BeforeClass
	public static void setUpBeforeClass(){
		keyValuePairsJsonString = " {"	+ "\"keys\" : [\"1\"] ,"
										+ "\"values\" : [\"apple\"]"
										+ "}";
	}
	/**
	 * This test method test positive case on add method of Dictionary class
	 * @throws Exception 
	 */
	@Test
	public void addMethodPositiveCasesTest() throws Exception {
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.add(key1, value1));
		assertTrue(dictionary.add(key2, value2));
		assertTrue(dictionary.add(key3, value3));
	}
	/**
	 * This test method test positive case on delete method of Dictionary class
	 * @throws Exception 
	 */
	@Test
	public void deleteMethodPositiveCasesTest() throws Exception {
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertTrue(dictionary.delete("1"));
	}
	/**
	 * This test method test positive case on get method of Dictionary class
	 * @throws Exception 
	 */
	@Test
	public void getMethodPositiveCasesTest() throws Exception {
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertEquals("apple",dictionary.get("1"));
	}

	/**
	 * This test method test positive case on getSortedKeyValuePairs method of Dictionary class
	 * @throws Exception 
	 */
	@Test
	public void getSortedKeyValuePairsMethodPositiveCasesTest() throws Exception {
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.add(key1, value1));
		assertTrue(dictionary.add(key2, value2));
		assertTrue(dictionary.add(key3, value3));
		String expectedKeyValuePairs[][] = new String[][]{{"1","apple"},{"2","banana"},{"3","orange"},{"4","water melon"}};
		assertArrayEquals(expectedKeyValuePairs,dictionary.getSortedKeyValuePairs());
	}
	/**
	 * This test method test positive case on getSortedKeyValuePairs method of Dictionary classwhich return pairs between two given keys 
	 * @throws Exception 
	 */
	@Test
	public void getSortedKeyValuePairsStringStringMethodPositiveCasesTest() throws Exception {
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.add(key1, value1));
		assertTrue(dictionary.add(key2, value2));
		assertTrue(dictionary.add(key3, value3));
		String expectedKeyValuePairs[][] = new String[][]{{"2","banana"},{"3","orange"}};
		assertArrayEquals(expectedKeyValuePairs,dictionary.getSortedKeyValuePairs("2","3"));
	}
	/**
	 * This test method test negative case on add method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void addMethodNegativetiveCasesTest() throws Exception{
		String key1 = "1";
		String value1 = "banana";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.add(key1, value1));
	}
	/**
	 * This test method test negative case on delete method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void deleteMethodNegativeCasesTest() throws Exception{
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.delete("2"));
	}
	/**
	 * This test method test negative case on get method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void getMethodNegativeCasesTest()  throws Exception{
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertEquals("apple",dictionary.get("2"));
	}
	/**
	 * This test method test negative case on getSortedKeyValuePairs method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void getSortedKeyValuePairsMethodNegativeCasesTest() throws Exception{
		String key1 = "1";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.delete(key1));
		dictionary.getSortedKeyValuePairs();
	}
	/**
	 * This test method test negative case on getSortedKeyValuePairs method of Dictionary class which return pairs between two given keys 
	 */
	@Test(expected = Exception.class)
	public void getSortedKeyValuePairsStringStringMethodNegativeCasesTest() throws Exception {
		String key1 = "1";
		String key2 = "2";
		String key3 = "3";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.delete(key1));
		dictionary.getSortedKeyValuePairs(key2, key3);
	}
}