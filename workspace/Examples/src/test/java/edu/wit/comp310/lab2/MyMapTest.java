package edu.wit.comp310.lab2;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyMapTest {
	Map<String, String> map;
	@Before
	public void setUp() throws Exception {
		map = new MyLinkedListMap<String,String>();
	}

	@Test
	public void testClear() {
		map.clear();
		map.put("Michael Jackson", "Thriller");
		map.put("Michael Jackson", "Beat it");
		map.put("Michael Jackson", "Bad");
		assertFalse(map.isEmpty());
		assertThat(map.size(), is(3));
		map.clear();
		assertTrue(map.isEmpty());
		assertThat(map.size(), is(0));
	}

	@Test
	public void testContainsKey() {
		map.clear();
		map.put("Coldplay", "Clocks");
		map.put("Coldplay", "Fix You");
		map.put("Coldplay", "Life in Technicolor");
		map.put("Coldplay", "Viva la Vida");
		assertTrue(map.containsKey("Coldplay"));
		assertFalse(map.containsKey("Clocks"));
		assertFalse(map.containsKey("Michael Jackson"));
	}

	@Test
	public void testContainsValue() {
		map.clear();
		map.put("U2", "Beautiful Day");
		map.put("U2", "Still Haven't Found What I'm Looking For");
		map.put("U2", "Vertigo");
		map.put("U2", "Walk On");
		map.put("U2", "Where The Streets Have No Name");
		assertTrue(map.containsValue("Beautiful Day"));
		assertFalse(map.containsValue("U2"));
		assertFalse(map.containsValue("Lorde"));
	}

	@Test
	public void testEntrySet() {
		map.clear();
		map.put("Lorde", "400 Lux");
		map.put("Lorde", "Ribs");
		map.put("Lorde", "Royals");
		for (Entry<String, String> e : map.entrySet()) {
			assertTrue(e.getKey().equals("Lorde"));
			assertFalse(e.getKey().equals("U2"));
//			assertThat(e.getValue(), is(anyOf("400 Lux", "Ribs", "Royals")));
		}
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeySet() {
		fail("Not yet implemented");
	}

	@Test
	public void testPut() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testValues() {
		fail("Not yet implemented");
	}

}
