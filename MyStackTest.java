
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	public MyStack<String> stringS;
	public String a = "a", b = "b", c = "c", d = "d", e = "e", f = "f";
	public ArrayList<String> fill = new ArrayList<String>();

	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests

	@Before
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);

		// STUDENT: add setup for doubleS for student tests
	
		doubleS = new MyStack<Double>(5);
		doubleS.push(1.1);
		doubleS.push(2.2);
		doubleS.push(55.55);
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false, stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			// Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		} catch (StackUnderflowException e) {
			assertTrue("This should have caused an StackUnderflowException", true);
		} catch (Exception e) {
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
		try {
			assertTrue("This should have caused an StackUnderflowException", doubleS.pop() == 55.55);
		} catch (StackUnderflowException e) {
			assertTrue("This should not caused an Exception", false);
		}
	}

	@Test
	public void testTop() throws StackOverflowException, StackUnderflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());
	}

	@Test
	public void testSize() throws StackOverflowException, StackUnderflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			// Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		} catch (StackOverflowException e) {
			assertTrue("This should have caused an StackOverflowException", true);
		} catch (Exception e) {
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() {
		try {
			assertEquals(3, doubleS.size());
			assertEquals(true, doubleS.push(4.4));
			assertEquals(4, doubleS.size());
			assertEquals(true, doubleS.push(5.5));
			assertEquals(5, doubleS.size());
			doubleS.push(6.6);
			assertTrue("This should have caused an StackOverflowException", false);
		} catch (StackOverflowException e) {
			assertTrue("This should have caused an StackOverflowException", true);
		} catch (Exception e) {
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	@Test
	public void testToStringStudent() {
		assertEquals("1.12.255.55", doubleS.toString());
	}

	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		// start with an empty queue
		stringS = new MyStack<String>(5);
		// fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3, stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());
	}

}
