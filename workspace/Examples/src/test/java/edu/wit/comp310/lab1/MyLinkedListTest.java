package edu.wit.comp310.lab1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test MyLinkedList
 * 
 * With apologies to Billie Myers for the test data
 *
 */
public class MyLinkedListTest extends TestCase {
	List<String> studentLinkedList;

	@Before
	public void setUp() throws Exception {
		studentLinkedList = new MyLinkedList<String>();
	}

	@Test
	public void testAddValueType() {
		String message = "Hello";
		studentLinkedList.add(message);
		assertThat(studentLinkedList, hasItem(message));
	}

	@Test
	public void testAddOOB() {
		String message = "Can you hear me?";
		boolean result = false;
		try {
			studentLinkedList.add(-1, message);
		} catch (IndexOutOfBoundsException e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test
	public void testAddOOBAgain() {
		String message = "Am I gettin' through to you?";
		boolean result = false;
		try {
			studentLinkedList.add(studentLinkedList.size()+1, message);
		} catch (IndexOutOfBoundsException e) {
			result = true;
		}
		assertTrue(result);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAtIndexNormally() {
		String message = "Hello";
		studentLinkedList.add("Is it late there?");
		studentLinkedList.add("There's a laughter on the line");
		studentLinkedList.add(1, message);
		assertThat(studentLinkedList, hasItem(message));
	}

	@Test
	public void testAddAllCollectionOfQextendsValueType() {
		studentLinkedList.addAll(Arrays.asList(new String[] {
				"Are you sure you're there alone?",
				"Cause I'm",
				"Tryin' to explain"
				}));
		assertThat(studentLinkedList, hasItems("Are you sure you're there alone?", "Cause I'm", "Tryin' to explain"));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAllIntCollectionOfQextendsValueTypeException() {
		boolean result = false;
		try {
			studentLinkedList.addAll(-1, 
					Arrays.asList(new String[] {"Somethin's wrong"}));
		} catch (IndexOutOfBoundsException e) {
			result = true;
		}
		assertTrue(result);
	}

	public void testAddAllIntCollectionOfQextendsValueType() {
		String message = "Ya just don't sound the same";
		int oldSize = studentLinkedList.size();
		studentLinkedList.add(message);
		assertThat(studentLinkedList.indexOf(message),is(oldSize));
		studentLinkedList.addAll(0, Arrays.asList(
				new String[] {"Why don't you", "Why don't you"}));
		assertThat(studentLinkedList.indexOf(message),is(studentLinkedList.size()-1));
	}
	
	@Test
	public void testClear() {
		studentLinkedList.clear();
		assertThat(studentLinkedList,empty());
	}

	@Test
	public void testContains() {
		String message = "Go outsize";
		studentLinkedList.add(message);
		assertTrue(studentLinkedList.contains(message));
	}

	@Test
	public void testContainsAll() {
		Collection<String> things = Arrays.asList(
				new String[] {"Kiss", "the", "rain"});
		studentLinkedList.addAll(things);
		assertTrue(studentLinkedList.containsAll(things));
	}

	@Test
	public void testGet() {
		String message = "Whenever you need me";
		studentLinkedList.add(0, message);
		assertThat(studentLinkedList.get(0), is(message));
	}

	@Test
	public void testIndexOf() {
		studentLinkedList.clear();
		studentLinkedList.add("");
		studentLinkedList.add("Kiss the rain");
		assertThat(studentLinkedList.indexOf("Kiss the rain"), is(1));
	}

	@Test
	public void testIsEmpty() {
		studentLinkedList.add("Whenever I'm gone, too long.");
		assertThat(studentLinkedList, not(empty()));
		studentLinkedList.clear();
		assertThat(studentLinkedList, empty());
	}

	@Test
	public void testIterator() {
		studentLinkedList.clear();
		studentLinkedList.add("If your lips");
		studentLinkedList.add("Feel lonely and thirsty");
		studentLinkedList.add("Kiss the rain");
		for (String element : studentLinkedList) {
			assertThat(element, anyOf(is("If your lips"), is("Kiss the rain"), is("Feel lonely and thirsty")));
		}
	}

	@Test
	public void testLastIndexOf() {
		studentLinkedList.clear();
		studentLinkedList.add("And wait for the dawn");
		studentLinkedList.add("Keep in mind");
		studentLinkedList.add("We're under the same sky");
		studentLinkedList.add("And the nights");
		studentLinkedList.add("As empty for me, as for you");
		studentLinkedList.add("If ya feel");
		studentLinkedList.add("You can't wait till mornin'");
		studentLinkedList.add("Kiss the rain");
		studentLinkedList.add("Kiss the rain");
		studentLinkedList.add("Kiss the rain");
		
		assertThat(studentLinkedList.lastIndexOf("Kiss the rain"), is(studentLinkedList.size() - 1));
	}

	@Test
	public void testListIterator() {
	}

	@Test
	public void testListIteratorInt() {
	}

	@Test
	public void testRemoveObject() {
		studentLinkedList.clear();
		studentLinkedList.add("Hello");
		studentLinkedList.add("Do you miss me?");
		studentLinkedList.remove("Hello");
		assertThat(studentLinkedList.get(0), is("Do you miss me?"));
	}

	@Test
	public void testRemoveInt() {
		studentLinkedList.clear();
		studentLinkedList.add("I hear you say you do");
		studentLinkedList.add("But not the way I'm missin' you");
		studentLinkedList.add("What's new?");
		studentLinkedList.remove("But not the way I'm missin' you");
		assertThat(studentLinkedList.get(0), is("I hear you say you do"));
		assertThat(studentLinkedList.get(1), is("What's new?"));
		studentLinkedList.add("How's the weather?");
		studentLinkedList.remove("Partly cloudy");
		assertThat(studentLinkedList.indexOf("How's the weather?"), is(studentLinkedList.size() -1));
	}

	@Test
	public void testRemoveAll() {
		studentLinkedList.clear();
		studentLinkedList.add("Is it stormy where you are?");
		studentLinkedList.add("Cause you sound so close but it feels like you're so far");
		studentLinkedList.add("Oh would it mean anything");
		studentLinkedList.add("If you knew");
		studentLinkedList.add("What I'm left imagining");
		studentLinkedList.add("In my mind");
		studentLinkedList.add("In my mind");
		studentLinkedList.add("Would you go");
		studentLinkedList.add("Would you go");
		studentLinkedList.removeAll(Arrays.asList(new String[] {"In my mind", "Would you go"}));
		assertThat(studentLinkedList.size(), is(5));
	}

	@Test
	public void testRetainAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		studentLinkedList.clear();
		assertThat(studentLinkedList.size(), is(0));
		studentLinkedList.add("");
		assertThat(studentLinkedList.size(), is(1));
	}

	@Test
	public void testSubList() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArrayTArray() {
		fail("Not yet implemented");
	}

}
