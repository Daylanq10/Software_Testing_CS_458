package mutant6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISBN10DecisionTableTest {

	@Test
	public void test1() {
		assertFalse(ISBN10.isValidISBN("030640615"));
	}
	
	@Test
		public void test2() {
		assertFalse(ISBN10.isValidISBN("X306406152"));
	}
	
	@Test
	public void test3() {
		assertFalse(ISBN10.isValidISBN("0306406153"));
	}
	
	@Test
	public void test4() {
		assertFalse(ISBN10.isValidISBN("000002002X"));
	}
	
	@Test
	public void test5() {
		assertFalse(ISBN10.isValidISBN("000002001x"));
	}
	
	@Test
	public void test6() {
		assertTrue(ISBN10.isValidISBN("0306406152"));
	}
	
	@Test
	public void test7() {
		assertTrue(ISBN10.isValidISBN("000002001X"));
	}

}
