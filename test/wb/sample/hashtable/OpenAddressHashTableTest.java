package wb.sample.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class OpenAddressHashTableTest {
private OpenAddressHashTable<Integer, String> table = new OpenAddressHashTable<>();
	
	@Test
	public void testIsEmpty() {
		
		boolean result = table.isEmpty();
		boolean expected = true;
		assertEquals(result, expected);
		table.put(1, "one");
		result = table.isEmpty();
		expected = false; 
		assertEquals(result, expected);
	}
	
	@Test
	public void testPut(){
		table.put(1, "one");
		table.put(2, "two");
		table.put(3, "three");
		int result = table.size();
		int expected = 3;
		assertEquals(result, expected);
	}
	
	@Test
	public void testGet(){
		String result = table.get(1);
		assertNull(result);
		table.put(1, "one");
		result = table.get(1);
		String expected = "one";
		assertEquals(result, expected);
		
	}
	
	@Test
	public void testCollisionHandling(){
		for(Integer i = 0; i < 1024 * 1024; i++){
			table.put(i, i.toString());
		}
		for(Integer i = 0; i < 1024*1024; i++){
			String result = table.get(i);
			String expected = i.toString();
			assertEquals(result, expected);
		}
	}
	
	@Test
	public void testClear(){
		for(Integer i = 0; i < 1024; i++){
			table.put(i,  i.toString());
		}
		int result = table.size();
		int expected = 1024;
		assertEquals(result, expected);
		table.clear();
		result = table.size();
		expected = 0;
		assertEquals(result, expected);
		String resultString;
		for(Integer i = 0; i < 1024; i++){
			resultString = table.get(i);
			assertNull(resultString);
		}
	}
	
	@Test
	public void testRemove(){
		for(Integer i = 0; i < 1024; i++){
			table.put(i,  i.toString());
		}
		assertNotNull(table.get(5));
		table.remove(5);
		assertNull(table.get(5));
	}

}
