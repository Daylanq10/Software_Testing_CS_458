package mutant1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISBN10PartitioningTest {

	@Test
	public void test1() {
		assertTrue(ISBN10.isValidISBN("0306406152"));
	}
	
	@Test
	public void test2() {
		assertTrue(ISBN10.isValidISBN("000002001X"));
	}
	
	@Test
	public void test3() {
		assertFalse(ISBN10.isValidISBN("12345678"));
	}
	
	@Test
	public void test4() {
		assertFalse(ISBN10.isValidISBN("12345678910"));
	}
	
	@Test
	public void test5() {
		assertFalse(ISBN10.isValidISBN("12345678X9"));
	}
	
	@Test
	public void test6() {
		assertFalse(ISBN10.isValidISBN("X123456789"));
	}
	
	@Test
	public void test7() {
		assertFalse(ISBN10.isValidISBN("123456789!"));
	}
	
	@Test
	public void test8() {
		assertFalse(ISBN10.isValidISBN("123456789x"));
	}
	
	@Test
	public void test9() {
		assertFalse(ISBN10.isValidISBN("0306406153"));
	}
	
	@Test
	public void test10() {
		assertFalse(ISBN10.isValidISBN("0306406151"));
	}

}
