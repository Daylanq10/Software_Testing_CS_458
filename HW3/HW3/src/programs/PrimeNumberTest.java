package programs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeNumberTest {

	@Test
	// Covers path 1
	public void test1() {
		PrimeNumber.isPrimeNumber(1);
	}
	
	@Test
	// Covers path 3
	public void test2() {
		PrimeNumber.isPrimeNumber(2);
	}
	
	@Test
	// Covers path 4
	public void test3() {
		PrimeNumber.isPrimeNumber(3);
	}

	@Test
	// Covers path 5
	public void test4() {
		PrimeNumber.isPrimeNumber(4);
	}

}
