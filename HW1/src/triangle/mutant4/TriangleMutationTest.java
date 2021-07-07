package triangle.mutant4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TriangleMutationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMutation_1() {
		assertEquals("", new TriangleSides(3,1,1).reportTriangleType(), TriangleSides.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testMutation_2() {
		assertEquals("", new TriangleSides(3,4,4).reportTriangleType(), TriangleSides.TriangleType.ISOSCELES);
	}
	
	@Test
	public void testMutation_3() {
		assertEquals("", new TriangleSides(4,3,3).reportTriangleType(), TriangleSides.TriangleType.ISOSCELES);
	}
	
	@Test
	public void testMutation_4() {
		assertEquals("", new TriangleSides(2,3,4).reportTriangleType(), TriangleSides.TriangleType.SCALENE);
	}
	
	@Test
	public void testMutation_5() {
		assertEquals("", new TriangleSides(1,1,3).reportTriangleType(), TriangleSides.TriangleType.NOTRIANGLE);
	}
	
	//same as 4
	@Test
	public void testMutation_6() {
		assertEquals("", new TriangleSides(2,3,4).reportTriangleType(), TriangleSides.TriangleType.SCALENE);
	}
	
	@Test
	public void testMutation_7() {
		assertEquals("", new TriangleSides(2,5,3).reportTriangleType(), TriangleSides.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testMutation_8_9() {
		assertEquals("", new TriangleSides(3,3,0).reportTriangleType(), TriangleSides.TriangleType.NOTRIANGLE);
	}

}
