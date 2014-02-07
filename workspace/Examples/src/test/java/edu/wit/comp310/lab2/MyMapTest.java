package edu.wit.comp310.lab2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test [0] is MyLinkedListMap (you implement)
 * Test [1] is MyBSTMap (you implement)
 * Test [2] is HashMap (this already exists)
 * 
 * The test code is the same for all three classes.
 *
 */
@RunWith(Parameterized.class)
public class MyMapTest {
	Map<String, String> map;
	
	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[] {new MyLinkedListMap<String, String>()},
				new Object[]{new MyBSTMap<String, String>()},
				new Object[] {new HashMap<String, String>()});
	}
	
	public MyMapTest(Map<String, String> map) {
		this.map = map;
	}

	@Test
	public void testClear() {
		map.clear();
		map.put("Thriller","Michael Jackson");
		map.put("Beat it","Michael Jackson");
		map.put("Bad","Michael Jackson");
		assertThat(map.size(), is(3));
		map.clear();
		assertThat(map.size(), is(0));
	}

	@Test
	public void testContainsKey() {
		map.clear();
		map.put("Clocks","Coldplay");
		map.put("Fix You","Coldplay");
		map.put("Life in Technicolor","Coldplay");
		map.put("Viva la Vida","Coldplay");
		assertTrue(map.containsKey("Clocks"));
		assertFalse(map.containsKey("Coldplay"));
		assertFalse(map.containsKey("Michael Jackson"));
	}

	@Test
	public void testContainsValue() {
		map.clear();
		map.put("Beautiful Day","U2");
		map.put("Still Haven't Found What I'm Looking For","U2");
		map.put("Vertigo","U2");
		map.put("Walk On","U2");
		map.put("Where The Streets Have No Name","U2");
		assertFalse(map.containsValue("Beautiful Day"));
		assertTrue(map.containsValue("U2"));
	}

	@Test
	public void testEntrySet() {
		map.clear();
		map.put("400 Lux","Lorde");
		map.put("Ribs","Lorde");
		map.put("Royals","Lorde");
		for (Entry<String, String> e : map.entrySet()) {
			assertTrue(e.getValue().equals("Lorde"));
			assertFalse(e.getValue().equals("U2"));
			assertThat(e.getKey(), anyOf(is("400 Lux"), is("Ribs"), is("Royals")));
		}
	}

	@Test
	public void testGet() {
		map.clear();
		map.put("All These Things That I Have Done","Killers");
		map.put("Human","Killers");
		map.put("Evil","Interpol");
		assertThat(map.get("Evil"), is("Interpol"));
		assertThat(map.get("Human"), is("Killers"));
	}

	@Test
	public void testIsEmpty() {
		map.put("Sounds of Silence", "Simon & Garfunkel");
		assertFalse(map.isEmpty());
		map.clear();
		assertTrue(map.isEmpty());
	}

	@Test
	public void testKeySet() {
		map.clear();
		map.put("Dreams", "Cranberries");
		map.put("Sweet Dreams", "Eurythmics");
		assertThat(map.keySet(), hasItems("Dreams","Sweet Dreams"));
		assertThat(map.keySet(), not(hasItems("Cranberries", "Eurythmics")));
	}

	@Test
	public void testPutAll() {
		map.clear();
		Map<String, String> other = new HashMap<String, String>();
		other.put("1812 Overture", "Tchaikovsky");
		other.put("Piano Concerto 1", "Tchaikovsky");
		other.put("The Nutcracker", "Tchaikovsky");
		map.putAll(other);
		assertTrue(map.containsKey("1812 Overture"));
		assertTrue(map.containsKey("Piano Concerto 1"));
		assertTrue(map.containsKey("The Nutcracker"));
	}

	@Test
	public void testRemove() {
		map.clear();
		map.put("Hello, Goodbye", "The Beatles");
		map.put("Imagine", "John Lennon");
		assertThat(map.remove("Hello, Goodbye"), is("The Beatles"));
		assertThat(map.get("Imagine"), is("John Lennon"));
		assertNull(map.get("Hello, Goodbye"));
	}

	@Test
	public void testValues() {
		map.clear();
		map.put("Claire De Lune", "Debussy");
		map.put("Golliwog's Cakewalk", "Debussy");
		assertThat(map.values(), hasItems("Debussy"));
		assertThat(map.values(), not(hasItems("Tchaikovsky")));
	}
}
