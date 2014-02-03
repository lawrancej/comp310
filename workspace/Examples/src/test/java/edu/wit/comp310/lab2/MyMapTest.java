package edu.wit.comp310.lab2;

import static org.junit.Assert.*;

import java.util.Map;

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
		fail("Not yet implemented");
	}

	@Test
	public void testContainsValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntrySet() {
		fail("Not yet implemented");
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
