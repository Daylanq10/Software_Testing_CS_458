//Warning: The same setUp method is used for multiple initial states.

package test;

import blocks.*;
import junit.framework.*;

public class BlockTester_RT extends TestCase{

	private Block block;
	
	protected void setUp()  throws Exception {
		block = new Block();
		block.getClears().add("B3");
		block.getClears().add("B6");
		block.getOntables().add("B3");
		block.getOntables().add("B6");
	}
	
	protected void setUp2()  throws Exception {
		block = new Block();
		block.getClears().add("B1");
		block.getClears().add("B6");
		block.getOns().add(new ON("B1", "B3"));
		block.getOntables().add("B3");
		block.getOntables().add("B6");
	}
	
	protected void setUp3()  throws Exception {
		block = new Block();
		block.getClears().add("B2");
		block.getClears().add("B5");
		block.getOns().add(new ON("B2", "B3"));
		block.getOns().add(new ON("B5", "B6"));
		block.getOntables().add("B3");
		block.getOntables().add("B6");
	}
	
	public void test1() throws Exception {
		System.out.println("Test case 1");
		block.pickup("B3");
		assertTrue("1_1", block.isClear("B6"));
		assertTrue("1_1", block.isHolding("B3"));
		assertTrue("1_1", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("1_1_1", block.isClear("B3"));
		assertTrue("1_1_1", block.isClear("B6"));
		assertTrue("1_1_1", block.isOntable("B3"));
		assertTrue("1_1_1", block.isOntable("B6"));
	}

	public void test2() throws Exception {
		System.out.println("Test case 2");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("1_1_2", block.isClear("B3"));
		assertTrue("1_1_2", block.isOn("B3", "B6"));
		assertTrue("1_1_2", block.isOntable("B6"));
		block.unstack("B3", "B6");
		assertTrue("1_1_2_1", block.isClear("B6"));
		assertTrue("1_1_2_1", block.isHolding("B3"));
		assertTrue("1_1_2_1", block.isOntable("B6"));
	}

	public void test3() throws Exception {
		System.out.println("Test case 3");
		block.pickup("B6");
		assertTrue("1_2", block.isClear("B3"));
		assertTrue("1_2", block.isHolding("B6"));
		assertTrue("1_2", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("1_2_1", block.isClear("B3"));
		assertTrue("1_2_1", block.isClear("B6"));
		assertTrue("1_2_1", block.isOntable("B3"));
		assertTrue("1_2_1", block.isOntable("B6"));
	}

	public void test4() throws Exception {
		System.out.println("Test case 4");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("1_2_2", block.isClear("B6"));
		assertTrue("1_2_2", block.isOn("B6", "B3"));
		assertTrue("1_2_2", block.isOntable("B3"));
		block.unstack("B6", "B3");
		assertTrue("1_2_2_1", block.isClear("B3"));
		assertTrue("1_2_2_1", block.isHolding("B6"));
		assertTrue("1_2_2_1", block.isOntable("B3"));
	}

	public void test5() throws Exception {
		System.out.println("Test case 5");
		block.pickup("B6");
		assertTrue("2_1", block.isClear("B1"));
		assertTrue("2_1", block.isHolding("B6"));
		assertTrue("2_1", block.isOn("B1", "B3"));
		assertTrue("2_1", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("2_1_1", block.isClear("B1"));
		assertTrue("2_1_1", block.isClear("B6"));
		assertTrue("2_1_1", block.isOn("B1", "B3"));
		assertTrue("2_1_1", block.isOntable("B3"));
		assertTrue("2_1_1", block.isOntable("B6"));
	}

	public void test6() throws Exception {
		System.out.println("Test case 6");
		block.pickup("B6");
		block.stack("B6", "B1");
		assertTrue("2_1_2", block.isClear("B6"));
		assertTrue("2_1_2", block.isOn("B1", "B3"));
		assertTrue("2_1_2", block.isOn("B6", "B1"));
		assertTrue("2_1_2", block.isOntable("B3"));
		block.unstack("B6", "B1");
		assertTrue("2_1_2_1", block.isClear("B1"));
		assertTrue("2_1_2_1", block.isHolding("B6"));
		assertTrue("2_1_2_1", block.isOn("B1", "B3"));
		assertTrue("2_1_2_1", block.isOntable("B3"));
	}

	public void test7() throws Exception {
		System.out.println("Test case 7");
		block.unstack("B1", "B3");
		assertTrue("2_2", block.isClear("B3"));
		assertTrue("2_2", block.isClear("B6"));
		assertTrue("2_2", block.isHolding("B1"));
		assertTrue("2_2", block.isOntable("B3"));
		assertTrue("2_2", block.isOntable("B6"));
		block.putdown("B1");
		assertTrue("2_2_1", block.isClear("B1"));
		assertTrue("2_2_1", block.isClear("B3"));
		assertTrue("2_2_1", block.isClear("B6"));
		assertTrue("2_2_1", block.isOntable("B1"));
		assertTrue("2_2_1", block.isOntable("B3"));
		assertTrue("2_2_1", block.isOntable("B6"));
		block.pickup("B1");
		assertTrue("2_2_1_1", block.isClear("B3"));
		assertTrue("2_2_1_1", block.isClear("B6"));
		assertTrue("2_2_1_1", block.isHolding("B1"));
		assertTrue("2_2_1_1", block.isOntable("B3"));
		assertTrue("2_2_1_1", block.isOntable("B6"));
	}

	public void test8() throws Exception {
		System.out.println("Test case 8");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		assertTrue("2_2_1_2", block.isClear("B1"));
		assertTrue("2_2_1_2", block.isClear("B6"));
		assertTrue("2_2_1_2", block.isHolding("B3"));
		assertTrue("2_2_1_2", block.isOntable("B1"));
		assertTrue("2_2_1_2", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("2_2_1_2_1", block.isClear("B1"));
		assertTrue("2_2_1_2_1", block.isClear("B3"));
		assertTrue("2_2_1_2_1", block.isClear("B6"));
		assertTrue("2_2_1_2_1", block.isOntable("B1"));
		assertTrue("2_2_1_2_1", block.isOntable("B3"));
		assertTrue("2_2_1_2_1", block.isOntable("B6"));
	}

	public void test9() throws Exception {
		System.out.println("Test case 9");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		block.stack("B3", "B1");
		assertTrue("2_2_1_2_2", block.isClear("B3"));
		assertTrue("2_2_1_2_2", block.isClear("B6"));
		assertTrue("2_2_1_2_2", block.isOn("B3", "B1"));
		assertTrue("2_2_1_2_2", block.isOntable("B1"));
		assertTrue("2_2_1_2_2", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("2_2_1_2_2_1", block.isClear("B3"));
		assertTrue("2_2_1_2_2_1", block.isHolding("B6"));
		assertTrue("2_2_1_2_2_1", block.isOn("B3", "B1"));
		assertTrue("2_2_1_2_2_1", block.isOntable("B1"));
		block.putdown("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B1"));
		assertTrue("", block.isOntable("B1"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test10() throws Exception {
		System.out.println("Test case 10");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		block.stack("B3", "B1");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B1"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B1"));
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B1"));
		assertTrue("", block.isOntable("B1"));
	}

	public void test11() throws Exception {
		System.out.println("Test case 11");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		block.stack("B3", "B1");
		block.unstack("B3", "B1");
		assertTrue("2_2_1_2_2_2", block.isClear("B1"));
		assertTrue("2_2_1_2_2_2", block.isClear("B6"));
		assertTrue("2_2_1_2_2_2", block.isHolding("B3"));
		assertTrue("2_2_1_2_2_2", block.isOntable("B1"));
		assertTrue("2_2_1_2_2_2", block.isOntable("B6"));
	}

	public void test12() throws Exception {
		System.out.println("Test case 12");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("2_2_1_2_3", block.isClear("B1"));
		assertTrue("2_2_1_2_3", block.isClear("B3"));
		assertTrue("2_2_1_2_3", block.isOn("B3", "B6"));
		assertTrue("2_2_1_2_3", block.isOntable("B1"));
		assertTrue("2_2_1_2_3", block.isOntable("B6"));
		block.pickup("B1");
		assertTrue("2_2_1_2_3_1", block.isClear("B3"));
		assertTrue("2_2_1_2_3_1", block.isHolding("B1"));
		assertTrue("2_2_1_2_3_1", block.isOn("B3", "B6"));
		assertTrue("2_2_1_2_3_1", block.isOntable("B6"));
		block.putdown("B1");
		assertTrue("", block.isClear("B1"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B1"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test13() throws Exception {
		System.out.println("Test case 13");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B1");
		block.stack("B1", "B3");
		assertTrue("", block.isClear("B1"));
		assertTrue("", block.isOn("B1", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B1", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B1"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test14() throws Exception {
		System.out.println("Test case 14");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.unstack("B3", "B6");
		assertTrue("2_2_1_2_3_2", block.isClear("B1"));
		assertTrue("2_2_1_2_3_2", block.isClear("B6"));
		assertTrue("2_2_1_2_3_2", block.isHolding("B3"));
		assertTrue("2_2_1_2_3_2", block.isOntable("B1"));
		assertTrue("2_2_1_2_3_2", block.isOntable("B6"));
	}

	public void test15() throws Exception {
		System.out.println("Test case 15");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		assertTrue("2_2_1_3", block.isClear("B1"));
		assertTrue("2_2_1_3", block.isClear("B3"));
		assertTrue("2_2_1_3", block.isHolding("B6"));
		assertTrue("2_2_1_3", block.isOntable("B1"));
		assertTrue("2_2_1_3", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("2_2_1_3_1", block.isClear("B1"));
		assertTrue("2_2_1_3_1", block.isClear("B3"));
		assertTrue("2_2_1_3_1", block.isClear("B6"));
		assertTrue("2_2_1_3_1", block.isOntable("B1"));
		assertTrue("2_2_1_3_1", block.isOntable("B3"));
		assertTrue("2_2_1_3_1", block.isOntable("B6"));
	}

	public void test16() throws Exception {
		System.out.println("Test case 16");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		block.stack("B6", "B1");
		assertTrue("2_2_1_3_2", block.isClear("B3"));
		assertTrue("2_2_1_3_2", block.isClear("B6"));
		assertTrue("2_2_1_3_2", block.isOn("B6", "B1"));
		assertTrue("2_2_1_3_2", block.isOntable("B1"));
		assertTrue("2_2_1_3_2", block.isOntable("B3"));
		block.pickup("B3");
		assertTrue("2_2_1_3_2_1", block.isClear("B6"));
		assertTrue("2_2_1_3_2_1", block.isHolding("B3"));
		assertTrue("2_2_1_3_2_1", block.isOn("B6", "B1"));
		assertTrue("2_2_1_3_2_1", block.isOntable("B1"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B1"));
		assertTrue("", block.isOntable("B1"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test17() throws Exception {
		System.out.println("Test case 17");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		block.stack("B6", "B1");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B1"));
		assertTrue("", block.isOntable("B1"));
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B1"));
		assertTrue("", block.isOntable("B1"));
	}

	public void test18() throws Exception {
		System.out.println("Test case 18");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		block.stack("B6", "B1");
		block.unstack("B6", "B1");
		assertTrue("2_2_1_3_2_2", block.isClear("B1"));
		assertTrue("2_2_1_3_2_2", block.isClear("B3"));
		assertTrue("2_2_1_3_2_2", block.isHolding("B6"));
		assertTrue("2_2_1_3_2_2", block.isOntable("B1"));
		assertTrue("2_2_1_3_2_2", block.isOntable("B3"));
	}

	public void test19() throws Exception {
		System.out.println("Test case 19");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("2_2_1_3_3", block.isClear("B1"));
		assertTrue("2_2_1_3_3", block.isClear("B6"));
		assertTrue("2_2_1_3_3", block.isOn("B6", "B3"));
		assertTrue("2_2_1_3_3", block.isOntable("B1"));
		assertTrue("2_2_1_3_3", block.isOntable("B3"));
		block.pickup("B1");
		assertTrue("2_2_1_3_3_1", block.isClear("B6"));
		assertTrue("2_2_1_3_3_1", block.isHolding("B1"));
		assertTrue("2_2_1_3_3_1", block.isOn("B6", "B3"));
		assertTrue("2_2_1_3_3_1", block.isOntable("B3"));
		block.putdown("B1");
		assertTrue("", block.isClear("B1"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B1"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test20() throws Exception {
		System.out.println("Test case 20");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B1");
		block.stack("B1", "B6");
		assertTrue("", block.isClear("B1"));
		assertTrue("", block.isOn("B1", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B1", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B1"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test21() throws Exception {
		System.out.println("Test case 21");
		block.unstack("B1", "B3");
		block.putdown("B1");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.unstack("B6", "B3");
		assertTrue("2_2_1_3_3_2", block.isClear("B1"));
		assertTrue("2_2_1_3_3_2", block.isClear("B3"));
		assertTrue("2_2_1_3_3_2", block.isHolding("B6"));
		assertTrue("2_2_1_3_3_2", block.isOntable("B1"));
		assertTrue("2_2_1_3_3_2", block.isOntable("B3"));
	}

	public void test22() throws Exception {
		System.out.println("Test case 22");
		block.unstack("B1", "B3");
		block.stack("B1", "B3");
		assertTrue("2_2_2", block.isClear("B1"));
		assertTrue("2_2_2", block.isClear("B6"));
		assertTrue("2_2_2", block.isOn("B1", "B3"));
		assertTrue("2_2_2", block.isOntable("B3"));
		assertTrue("2_2_2", block.isOntable("B6"));
	}

	public void test23() throws Exception {
		System.out.println("Test case 23");
		block.unstack("B1", "B3");
		block.stack("B1", "B6");
		assertTrue("2_2_3", block.isClear("B1"));
		assertTrue("2_2_3", block.isClear("B3"));
		assertTrue("2_2_3", block.isOn("B1", "B6"));
		assertTrue("2_2_3", block.isOntable("B3"));
		assertTrue("2_2_3", block.isOntable("B6"));
		block.pickup("B3");
		assertTrue("2_2_3_1", block.isClear("B1"));
		assertTrue("2_2_3_1", block.isHolding("B3"));
		assertTrue("2_2_3_1", block.isOn("B1", "B6"));
		assertTrue("2_2_3_1", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("2_2_3_1_1", block.isClear("B1"));
		assertTrue("2_2_3_1_1", block.isClear("B3"));
		assertTrue("2_2_3_1_1", block.isOn("B1", "B6"));
		assertTrue("2_2_3_1_1", block.isOntable("B3"));
		assertTrue("2_2_3_1_1", block.isOntable("B6"));
	}

	public void test24() throws Exception {
		System.out.println("Test case 24");
		block.unstack("B1", "B3");
		block.stack("B1", "B6");
		block.pickup("B3");
		block.stack("B3", "B1");
		assertTrue("2_2_3_1_2", block.isClear("B3"));
		assertTrue("2_2_3_1_2", block.isOn("B1", "B6"));
		assertTrue("2_2_3_1_2", block.isOn("B3", "B1"));
		assertTrue("2_2_3_1_2", block.isOntable("B6"));
		block.unstack("B3", "B1");
		assertTrue("2_2_3_1_2_1", block.isClear("B1"));
		assertTrue("2_2_3_1_2_1", block.isHolding("B3"));
		assertTrue("2_2_3_1_2_1", block.isOn("B1", "B6"));
		assertTrue("2_2_3_1_2_1", block.isOntable("B6"));
	}

	public void test25() throws Exception {
		System.out.println("Test case 25");
		block.unstack("B1", "B3");
		block.stack("B1", "B6");
		block.unstack("B1", "B6");
		assertTrue("2_2_3_2", block.isClear("B3"));
		assertTrue("2_2_3_2", block.isClear("B6"));
		assertTrue("2_2_3_2", block.isHolding("B1"));
		assertTrue("2_2_3_2", block.isOntable("B3"));
		assertTrue("2_2_3_2", block.isOntable("B6"));
	}

	public void test26() throws Exception {
		System.out.println("Test case 26");
		block.unstack("B2", "B3");
		assertTrue("3_1", block.isClear("B3"));
		assertTrue("3_1", block.isClear("B5"));
		assertTrue("3_1", block.isHolding("B2"));
		assertTrue("3_1", block.isOn("B5", "B6"));
		assertTrue("3_1", block.isOntable("B3"));
		assertTrue("3_1", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("3_1_1", block.isClear("B2"));
		assertTrue("3_1_1", block.isClear("B3"));
		assertTrue("3_1_1", block.isClear("B5"));
		assertTrue("3_1_1", block.isOn("B5", "B6"));
		assertTrue("3_1_1", block.isOntable("B2"));
		assertTrue("3_1_1", block.isOntable("B3"));
		assertTrue("3_1_1", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("3_1_1_1", block.isClear("B3"));
		assertTrue("3_1_1_1", block.isClear("B5"));
		assertTrue("3_1_1_1", block.isHolding("B2"));
		assertTrue("3_1_1_1", block.isOn("B5", "B6"));
		assertTrue("3_1_1_1", block.isOntable("B3"));
		assertTrue("3_1_1_1", block.isOntable("B6"));
	}

	public void test27() throws Exception {
		System.out.println("Test case 27");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		assertTrue("3_1_1_2", block.isClear("B2"));
		assertTrue("3_1_1_2", block.isClear("B5"));
		assertTrue("3_1_1_2", block.isHolding("B3"));
		assertTrue("3_1_1_2", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2", block.isOntable("B2"));
		assertTrue("3_1_1_2", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("3_1_1_2_1", block.isClear("B2"));
		assertTrue("3_1_1_2_1", block.isClear("B3"));
		assertTrue("3_1_1_2_1", block.isClear("B5"));
		assertTrue("3_1_1_2_1", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2_1", block.isOntable("B2"));
		assertTrue("3_1_1_2_1", block.isOntable("B3"));
		assertTrue("3_1_1_2_1", block.isOntable("B6"));
	}

	public void test28() throws Exception {
		System.out.println("Test case 28");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("3_1_1_2_2", block.isClear("B3"));
		assertTrue("3_1_1_2_2", block.isClear("B5"));
		assertTrue("3_1_1_2_2", block.isOn("B3", "B2"));
		assertTrue("3_1_1_2_2", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2_2", block.isOntable("B2"));
		assertTrue("3_1_1_2_2", block.isOntable("B6"));
		block.unstack("B3", "B2");
		assertTrue("3_1_1_2_2_1", block.isClear("B2"));
		assertTrue("3_1_1_2_2_1", block.isClear("B5"));
		assertTrue("3_1_1_2_2_1", block.isHolding("B3"));
		assertTrue("3_1_1_2_2_1", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2_2_1", block.isOntable("B2"));
		assertTrue("3_1_1_2_2_1", block.isOntable("B6"));
	}

	public void test29() throws Exception {
		System.out.println("Test case 29");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		assertTrue("3_1_1_2_2_2", block.isClear("B3"));
		assertTrue("3_1_1_2_2_2", block.isClear("B6"));
		assertTrue("3_1_1_2_2_2", block.isHolding("B5"));
		assertTrue("3_1_1_2_2_2", block.isOn("B3", "B2"));
		assertTrue("3_1_1_2_2_2", block.isOntable("B2"));
		assertTrue("3_1_1_2_2_2", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test30() throws Exception {
		System.out.println("Test case 30");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test31() throws Exception {
		System.out.println("Test case 31");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B5");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		block.putdown("B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test32() throws Exception {
		System.out.println("Test case 32");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B5");
		block.stack("B5", "B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		block.unstack("B5", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
	}

	public void test33() throws Exception {
		System.out.println("Test case 33");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test34() throws Exception {
		System.out.println("Test case 34");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B3", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test35() throws Exception {
		System.out.println("Test case 35");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B6", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test36() throws Exception {
		System.out.println("Test case 36");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B3", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test37() throws Exception {
		System.out.println("Test case 37");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		block.putdown("B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test38() throws Exception {
		System.out.println("Test case 38");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		block.unstack("B6", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
	}

	public void test39() throws Exception {
		System.out.println("Test case 39");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.unstack("B5", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test40() throws Exception {
		System.out.println("Test case 40");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test41() throws Exception {
		System.out.println("Test case 41");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("3_1_1_2_3", block.isClear("B2"));
		assertTrue("3_1_1_2_3", block.isClear("B3"));
		assertTrue("3_1_1_2_3", block.isOn("B3", "B5"));
		assertTrue("3_1_1_2_3", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2_3", block.isOntable("B2"));
		assertTrue("3_1_1_2_3", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("3_1_1_2_3_1", block.isClear("B3"));
		assertTrue("3_1_1_2_3_1", block.isHolding("B2"));
		assertTrue("3_1_1_2_3_1", block.isOn("B3", "B5"));
		assertTrue("3_1_1_2_3_1", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2_3_1", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test42() throws Exception {
		System.out.println("Test case 42");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B2");
		block.stack("B2", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B2", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test43() throws Exception {
		System.out.println("Test case 43");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.unstack("B3", "B5");
		assertTrue("3_1_1_2_3_2", block.isClear("B2"));
		assertTrue("3_1_1_2_3_2", block.isClear("B5"));
		assertTrue("3_1_1_2_3_2", block.isHolding("B3"));
		assertTrue("3_1_1_2_3_2", block.isOn("B5", "B6"));
		assertTrue("3_1_1_2_3_2", block.isOntable("B2"));
		assertTrue("3_1_1_2_3_2", block.isOntable("B6"));
	}

	public void test44() throws Exception {
		System.out.println("Test case 44");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		assertTrue("3_1_1_3", block.isClear("B2"));
		assertTrue("3_1_1_3", block.isClear("B3"));
		assertTrue("3_1_1_3", block.isClear("B6"));
		assertTrue("3_1_1_3", block.isHolding("B5"));
		assertTrue("3_1_1_3", block.isOntable("B2"));
		assertTrue("3_1_1_3", block.isOntable("B3"));
		assertTrue("3_1_1_3", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("3_1_1_3_1", block.isClear("B2"));
		assertTrue("3_1_1_3_1", block.isClear("B3"));
		assertTrue("3_1_1_3_1", block.isClear("B5"));
		assertTrue("3_1_1_3_1", block.isClear("B6"));
		assertTrue("3_1_1_3_1", block.isOntable("B2"));
		assertTrue("3_1_1_3_1", block.isOntable("B3"));
		assertTrue("3_1_1_3_1", block.isOntable("B5"));
		assertTrue("3_1_1_3_1", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("3_1_1_3_1_1", block.isClear("B3"));
		assertTrue("3_1_1_3_1_1", block.isClear("B5"));
		assertTrue("3_1_1_3_1_1", block.isClear("B6"));
		assertTrue("3_1_1_3_1_1", block.isHolding("B2"));
		assertTrue("3_1_1_3_1_1", block.isOntable("B3"));
		assertTrue("3_1_1_3_1_1", block.isOntable("B5"));
		assertTrue("3_1_1_3_1_1", block.isOntable("B6"));
	}

	public void test45() throws Exception {
		System.out.println("Test case 45");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		assertTrue("3_1_1_3_1_2", block.isClear("B2"));
		assertTrue("3_1_1_3_1_2", block.isClear("B5"));
		assertTrue("3_1_1_3_1_2", block.isClear("B6"));
		assertTrue("3_1_1_3_1_2", block.isHolding("B3"));
		assertTrue("3_1_1_3_1_2", block.isOntable("B2"));
		assertTrue("3_1_1_3_1_2", block.isOntable("B5"));
		assertTrue("3_1_1_3_1_2", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test46() throws Exception {
		System.out.println("Test case 46");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test47() throws Exception {
		System.out.println("Test case 47");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test48() throws Exception {
		System.out.println("Test case 48");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B2");
		block.stack("B2", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test49() throws Exception {
		System.out.println("Test case 49");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B2");
		block.stack("B2", "B3");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B6", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test50() throws Exception {
		System.out.println("Test case 50");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B2");
		block.stack("B2", "B3");
		block.unstack("B2", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test51() throws Exception {
		System.out.println("Test case 51");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B2");
		block.stack("B2", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test52() throws Exception {
		System.out.println("Test case 52");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test53() throws Exception {
		System.out.println("Test case 53");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B3", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test54() throws Exception {
		System.out.println("Test case 54");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.unstack("B6", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test55() throws Exception {
		System.out.println("Test case 55");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B2");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test56() throws Exception {
		System.out.println("Test case 56");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B2");
		block.stack("B2", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B2", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test57() throws Exception {
		System.out.println("Test case 57");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test58() throws Exception {
		System.out.println("Test case 58");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.unstack("B3", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test59() throws Exception {
		System.out.println("Test case 59");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test60() throws Exception {
		System.out.println("Test case 60");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B2");
		block.stack("B2", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test61() throws Exception {
		System.out.println("Test case 61");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B2");
		block.stack("B2", "B3");
		block.pickup("B5");
		block.stack("B5", "B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B5", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test62() throws Exception {
		System.out.println("Test case 62");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B2");
		block.stack("B2", "B3");
		block.unstack("B2", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test63() throws Exception {
		System.out.println("Test case 63");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B2");
		block.stack("B2", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test64() throws Exception {
		System.out.println("Test case 64");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test65() throws Exception {
		System.out.println("Test case 65");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B5");
		block.stack("B5", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test66() throws Exception {
		System.out.println("Test case 66");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B5");
		block.stack("B5", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test67() throws Exception {
		System.out.println("Test case 67");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B5");
		block.stack("B5", "B3");
		block.pickup("B2");
		block.stack("B2", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B2", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test68() throws Exception {
		System.out.println("Test case 68");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B5");
		block.stack("B5", "B3");
		block.unstack("B5", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test69() throws Exception {
		System.out.println("Test case 69");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test70() throws Exception {
		System.out.println("Test case 70");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B5");
		assertTrue("3_1_1_3_1_3", block.isClear("B2"));
		assertTrue("3_1_1_3_1_3", block.isClear("B3"));
		assertTrue("3_1_1_3_1_3", block.isClear("B6"));
		assertTrue("3_1_1_3_1_3", block.isHolding("B5"));
		assertTrue("3_1_1_3_1_3", block.isOntable("B2"));
		assertTrue("3_1_1_3_1_3", block.isOntable("B3"));
		assertTrue("3_1_1_3_1_3", block.isOntable("B6"));
	}

	public void test71() throws Exception {
		System.out.println("Test case 71");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		assertTrue("3_1_1_3_1_4", block.isClear("B2"));
		assertTrue("3_1_1_3_1_4", block.isClear("B3"));
		assertTrue("3_1_1_3_1_4", block.isClear("B5"));
		assertTrue("3_1_1_3_1_4", block.isHolding("B6"));
		assertTrue("3_1_1_3_1_4", block.isOntable("B2"));
		assertTrue("3_1_1_3_1_4", block.isOntable("B3"));
		assertTrue("3_1_1_3_1_4", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test72() throws Exception {
		System.out.println("Test case 72");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test73() throws Exception {
		System.out.println("Test case 73");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test74() throws Exception {
		System.out.println("Test case 74");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		block.putdown("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test75() throws Exception {
		System.out.println("Test case 75");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B5");
		block.stack("B5", "B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		block.unstack("B5", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
	}

	public void test76() throws Exception {
		System.out.println("Test case 76");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test77() throws Exception {
		System.out.println("Test case 77");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.putdown("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test78() throws Exception {
		System.out.println("Test case 78");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B5");
		block.stack("B5", "B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test79() throws Exception {
		System.out.println("Test case 79");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B5");
		block.stack("B5", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.pickup("B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test80() throws Exception {
		System.out.println("Test case 80");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B5");
		block.stack("B5", "B6");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		block.unstack("B3", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
	}

	public void test81() throws Exception {
		System.out.println("Test case 81");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B5");
		block.stack("B5", "B6");
		block.unstack("B5", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test82() throws Exception {
		System.out.println("Test case 82");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.unstack("B6", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test83() throws Exception {
		System.out.println("Test case 83");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test84() throws Exception {
		System.out.println("Test case 84");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B2");
		block.stack("B2", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test85() throws Exception {
		System.out.println("Test case 85");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B2");
		block.stack("B2", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		block.putdown("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test86() throws Exception {
		System.out.println("Test case 86");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B2");
		block.stack("B2", "B6");
		block.pickup("B5");
		block.stack("B5", "B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B5", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test87() throws Exception {
		System.out.println("Test case 87");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B2");
		block.stack("B2", "B6");
		block.unstack("B2", "B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test88() throws Exception {
		System.out.println("Test case 88");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.putdown("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test89() throws Exception {
		System.out.println("Test case 89");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B5");
		block.stack("B5", "B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test90() throws Exception {
		System.out.println("Test case 90");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B5");
		block.stack("B5", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.pickup("B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test91() throws Exception {
		System.out.println("Test case 91");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B5");
		block.stack("B5", "B6");
		block.pickup("B2");
		block.stack("B2", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B2", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test92() throws Exception {
		System.out.println("Test case 92");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.pickup("B5");
		block.stack("B5", "B6");
		block.unstack("B5", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test93() throws Exception {
		System.out.println("Test case 93");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test94() throws Exception {
		System.out.println("Test case 94");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test95() throws Exception {
		System.out.println("Test case 95");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test96() throws Exception {
		System.out.println("Test case 96");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test97() throws Exception {
		System.out.println("Test case 97");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test98() throws Exception {
		System.out.println("Test case 98");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.pickup("B2");
		block.stack("B2", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B2", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test99() throws Exception {
		System.out.println("Test case 99");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test100() throws Exception {
		System.out.println("Test case 100");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B6", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test101() throws Exception {
		System.out.println("Test case 101");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		assertTrue("3_1_1_3_2", block.isClear("B3"));
		assertTrue("3_1_1_3_2", block.isClear("B5"));
		assertTrue("3_1_1_3_2", block.isClear("B6"));
		assertTrue("3_1_1_3_2", block.isOn("B5", "B2"));
		assertTrue("3_1_1_3_2", block.isOntable("B2"));
		assertTrue("3_1_1_3_2", block.isOntable("B3"));
		assertTrue("3_1_1_3_2", block.isOntable("B6"));
		block.pickup("B3");
		assertTrue("3_1_1_3_2_1", block.isClear("B5"));
		assertTrue("3_1_1_3_2_1", block.isClear("B6"));
		assertTrue("3_1_1_3_2_1", block.isHolding("B3"));
		assertTrue("3_1_1_3_2_1", block.isOn("B5", "B2"));
		assertTrue("3_1_1_3_2_1", block.isOntable("B2"));
		assertTrue("3_1_1_3_2_1", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test102() throws Exception {
		System.out.println("Test case 102");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		block.putdown("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test103() throws Exception {
		System.out.println("Test case 103");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
	}

	public void test104() throws Exception {
		System.out.println("Test case 104");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.unstack("B3", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test105() throws Exception {
		System.out.println("Test case 105");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test106() throws Exception {
		System.out.println("Test case 106");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.unstack("B5", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test107() throws Exception {
		System.out.println("Test case 107");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		assertTrue("3_1_1_3_2_2", block.isClear("B3"));
		assertTrue("3_1_1_3_2_2", block.isClear("B5"));
		assertTrue("3_1_1_3_2_2", block.isHolding("B6"));
		assertTrue("3_1_1_3_2_2", block.isOn("B5", "B2"));
		assertTrue("3_1_1_3_2_2", block.isOntable("B2"));
		assertTrue("3_1_1_3_2_2", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test108() throws Exception {
		System.out.println("Test case 108");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B5", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test109() throws Exception {
		System.out.println("Test case 109");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test110() throws Exception {
		System.out.println("Test case 110");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.pickup("B3");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test111() throws Exception {
		System.out.println("Test case 111");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
	}

	public void test112() throws Exception {
		System.out.println("Test case 112");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B6", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test113() throws Exception {
		System.out.println("Test case 113");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.unstack("B5", "B2");
		assertTrue("3_1_1_3_2_3", block.isClear("B2"));
		assertTrue("3_1_1_3_2_3", block.isClear("B3"));
		assertTrue("3_1_1_3_2_3", block.isClear("B6"));
		assertTrue("3_1_1_3_2_3", block.isHolding("B5"));
		assertTrue("3_1_1_3_2_3", block.isOntable("B2"));
		assertTrue("3_1_1_3_2_3", block.isOntable("B3"));
		assertTrue("3_1_1_3_2_3", block.isOntable("B6"));
	}

	public void test114() throws Exception {
		System.out.println("Test case 114");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		assertTrue("3_1_1_3_3", block.isClear("B2"));
		assertTrue("3_1_1_3_3", block.isClear("B5"));
		assertTrue("3_1_1_3_3", block.isClear("B6"));
		assertTrue("3_1_1_3_3", block.isOn("B5", "B3"));
		assertTrue("3_1_1_3_3", block.isOntable("B2"));
		assertTrue("3_1_1_3_3", block.isOntable("B3"));
		assertTrue("3_1_1_3_3", block.isOntable("B6"));
		block.pickup("B2");
		assertTrue("3_1_1_3_3_1", block.isClear("B5"));
		assertTrue("3_1_1_3_3_1", block.isClear("B6"));
		assertTrue("3_1_1_3_3_1", block.isHolding("B2"));
		assertTrue("3_1_1_3_3_1", block.isOn("B5", "B3"));
		assertTrue("3_1_1_3_3_1", block.isOntable("B3"));
		assertTrue("3_1_1_3_3_1", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test115() throws Exception {
		System.out.println("Test case 115");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B2");
		block.stack("B2", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test116() throws Exception {
		System.out.println("Test case 116");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B2");
		block.stack("B2", "B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B6", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test117() throws Exception {
		System.out.println("Test case 117");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B2");
		block.stack("B2", "B5");
		block.unstack("B2", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test118() throws Exception {
		System.out.println("Test case 118");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B2");
		block.stack("B2", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B2", "B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test119() throws Exception {
		System.out.println("Test case 119");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B2");
		block.stack("B2", "B6");
		block.unstack("B5", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test120() throws Exception {
		System.out.println("Test case 120");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		assertTrue("3_1_1_3_3_2", block.isClear("B2"));
		assertTrue("3_1_1_3_3_2", block.isClear("B5"));
		assertTrue("3_1_1_3_3_2", block.isHolding("B6"));
		assertTrue("3_1_1_3_3_2", block.isOn("B5", "B3"));
		assertTrue("3_1_1_3_3_2", block.isOntable("B2"));
		assertTrue("3_1_1_3_3_2", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test121() throws Exception {
		System.out.println("Test case 121");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B5", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test122() throws Exception {
		System.out.println("Test case 122");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.unstack("B6", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test123() throws Exception {
		System.out.println("Test case 123");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		block.pickup("B2");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test124() throws Exception {
		System.out.println("Test case 124");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.pickup("B2");
		block.stack("B2", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B2", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test125() throws Exception {
		System.out.println("Test case 125");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B6", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test126() throws Exception {
		System.out.println("Test case 126");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B3");
		block.unstack("B5", "B3");
		assertTrue("3_1_1_3_3_3", block.isClear("B2"));
		assertTrue("3_1_1_3_3_3", block.isClear("B3"));
		assertTrue("3_1_1_3_3_3", block.isClear("B6"));
		assertTrue("3_1_1_3_3_3", block.isHolding("B5"));
		assertTrue("3_1_1_3_3_3", block.isOntable("B2"));
		assertTrue("3_1_1_3_3_3", block.isOntable("B3"));
		assertTrue("3_1_1_3_3_3", block.isOntable("B6"));
	}

	public void test127() throws Exception {
		System.out.println("Test case 127");
		block.unstack("B2", "B3");
		block.putdown("B2");
		block.unstack("B5", "B6");
		block.stack("B5", "B6");
		assertTrue("3_1_1_3_4", block.isClear("B2"));
		assertTrue("3_1_1_3_4", block.isClear("B3"));
		assertTrue("3_1_1_3_4", block.isClear("B5"));
		assertTrue("3_1_1_3_4", block.isOn("B5", "B6"));
		assertTrue("3_1_1_3_4", block.isOntable("B2"));
		assertTrue("3_1_1_3_4", block.isOntable("B3"));
		assertTrue("3_1_1_3_4", block.isOntable("B6"));
	}

	public void test128() throws Exception {
		System.out.println("Test case 128");
		block.unstack("B2", "B3");
		block.stack("B2", "B3");
		assertTrue("3_1_2", block.isClear("B2"));
		assertTrue("3_1_2", block.isClear("B5"));
		assertTrue("3_1_2", block.isOn("B2", "B3"));
		assertTrue("3_1_2", block.isOn("B5", "B6"));
		assertTrue("3_1_2", block.isOntable("B3"));
		assertTrue("3_1_2", block.isOntable("B6"));
	}

	public void test129() throws Exception {
		System.out.println("Test case 129");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		assertTrue("3_1_3", block.isClear("B2"));
		assertTrue("3_1_3", block.isClear("B3"));
		assertTrue("3_1_3", block.isOn("B2", "B5"));
		assertTrue("3_1_3", block.isOn("B5", "B6"));
		assertTrue("3_1_3", block.isOntable("B3"));
		assertTrue("3_1_3", block.isOntable("B6"));
		block.pickup("B3");
		assertTrue("3_1_3_1", block.isClear("B2"));
		assertTrue("3_1_3_1", block.isHolding("B3"));
		assertTrue("3_1_3_1", block.isOn("B2", "B5"));
		assertTrue("3_1_3_1", block.isOn("B5", "B6"));
		assertTrue("3_1_3_1", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("3_1_3_1_1", block.isClear("B2"));
		assertTrue("3_1_3_1_1", block.isClear("B3"));
		assertTrue("3_1_3_1_1", block.isOn("B2", "B5"));
		assertTrue("3_1_3_1_1", block.isOn("B5", "B6"));
		assertTrue("3_1_3_1_1", block.isOntable("B3"));
		assertTrue("3_1_3_1_1", block.isOntable("B6"));
	}

	public void test130() throws Exception {
		System.out.println("Test case 130");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("3_1_3_1_2", block.isClear("B3"));
		assertTrue("3_1_3_1_2", block.isOn("B2", "B5"));
		assertTrue("3_1_3_1_2", block.isOn("B3", "B2"));
		assertTrue("3_1_3_1_2", block.isOn("B5", "B6"));
		assertTrue("3_1_3_1_2", block.isOntable("B6"));
		block.unstack("B3", "B2");
		assertTrue("3_1_3_1_2_1", block.isClear("B2"));
		assertTrue("3_1_3_1_2_1", block.isHolding("B3"));
		assertTrue("3_1_3_1_2_1", block.isOn("B2", "B5"));
		assertTrue("3_1_3_1_2_1", block.isOn("B5", "B6"));
		assertTrue("3_1_3_1_2_1", block.isOntable("B6"));
	}

	public void test131() throws Exception {
		System.out.println("Test case 131");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.unstack("B2", "B5");
		assertTrue("3_1_3_2", block.isClear("B3"));
		assertTrue("3_1_3_2", block.isClear("B5"));
		assertTrue("3_1_3_2", block.isHolding("B2"));
		assertTrue("3_1_3_2", block.isOn("B5", "B6"));
		assertTrue("3_1_3_2", block.isOntable("B3"));
		assertTrue("3_1_3_2", block.isOntable("B6"));
	}

	public void test132() throws Exception {
		System.out.println("Test case 132");
		block.unstack("B5", "B6");
		assertTrue("3_2", block.isClear("B2"));
		assertTrue("3_2", block.isClear("B6"));
		assertTrue("3_2", block.isHolding("B5"));
		assertTrue("3_2", block.isOn("B2", "B3"));
		assertTrue("3_2", block.isOntable("B3"));
		assertTrue("3_2", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("3_2_1", block.isClear("B2"));
		assertTrue("3_2_1", block.isClear("B5"));
		assertTrue("3_2_1", block.isClear("B6"));
		assertTrue("3_2_1", block.isOn("B2", "B3"));
		assertTrue("3_2_1", block.isOntable("B3"));
		assertTrue("3_2_1", block.isOntable("B5"));
		assertTrue("3_2_1", block.isOntable("B6"));
		block.pickup("B5");
		assertTrue("3_2_1_1", block.isClear("B2"));
		assertTrue("3_2_1_1", block.isClear("B6"));
		assertTrue("3_2_1_1", block.isHolding("B5"));
		assertTrue("3_2_1_1", block.isOn("B2", "B3"));
		assertTrue("3_2_1_1", block.isOntable("B3"));
		assertTrue("3_2_1_1", block.isOntable("B6"));
	}

	public void test133() throws Exception {
		System.out.println("Test case 133");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		assertTrue("3_2_1_2", block.isClear("B2"));
		assertTrue("3_2_1_2", block.isClear("B5"));
		assertTrue("3_2_1_2", block.isHolding("B6"));
		assertTrue("3_2_1_2", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2", block.isOntable("B3"));
		assertTrue("3_2_1_2", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("3_2_1_2_1", block.isClear("B2"));
		assertTrue("3_2_1_2_1", block.isClear("B5"));
		assertTrue("3_2_1_2_1", block.isClear("B6"));
		assertTrue("3_2_1_2_1", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2_1", block.isOntable("B3"));
		assertTrue("3_2_1_2_1", block.isOntable("B5"));
		assertTrue("3_2_1_2_1", block.isOntable("B6"));
	}

	public void test134() throws Exception {
		System.out.println("Test case 134");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("3_2_1_2_2", block.isClear("B5"));
		assertTrue("3_2_1_2_2", block.isClear("B6"));
		assertTrue("3_2_1_2_2", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2_2", block.isOn("B6", "B2"));
		assertTrue("3_2_1_2_2", block.isOntable("B3"));
		assertTrue("3_2_1_2_2", block.isOntable("B5"));
		block.pickup("B5");
		assertTrue("3_2_1_2_2_1", block.isClear("B6"));
		assertTrue("3_2_1_2_2_1", block.isHolding("B5"));
		assertTrue("3_2_1_2_2_1", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2_2_1", block.isOn("B6", "B2"));
		assertTrue("3_2_1_2_2_1", block.isOntable("B3"));
		block.putdown("B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test135() throws Exception {
		System.out.println("Test case 135");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B5");
		block.stack("B5", "B6");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B5", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B3"));
		block.unstack("B5", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B3"));
	}

	public void test136() throws Exception {
		System.out.println("Test case 136");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.unstack("B6", "B2");
		assertTrue("3_2_1_2_2_2", block.isClear("B2"));
		assertTrue("3_2_1_2_2_2", block.isClear("B5"));
		assertTrue("3_2_1_2_2_2", block.isHolding("B6"));
		assertTrue("3_2_1_2_2_2", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2_2_2", block.isOntable("B3"));
		assertTrue("3_2_1_2_2_2", block.isOntable("B5"));
	}

	public void test137() throws Exception {
		System.out.println("Test case 137");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("3_2_1_2_3", block.isClear("B2"));
		assertTrue("3_2_1_2_3", block.isClear("B6"));
		assertTrue("3_2_1_2_3", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2_3", block.isOn("B6", "B5"));
		assertTrue("3_2_1_2_3", block.isOntable("B3"));
		assertTrue("3_2_1_2_3", block.isOntable("B5"));
		block.unstack("B2", "B3");
		assertTrue("3_2_1_2_3_1", block.isClear("B3"));
		assertTrue("3_2_1_2_3_1", block.isClear("B6"));
		assertTrue("3_2_1_2_3_1", block.isHolding("B2"));
		assertTrue("3_2_1_2_3_1", block.isOn("B6", "B5"));
		assertTrue("3_2_1_2_3_1", block.isOntable("B3"));
		assertTrue("3_2_1_2_3_1", block.isOntable("B5"));
		block.putdown("B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test138() throws Exception {
		System.out.println("Test case 138");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B3"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test139() throws Exception {
		System.out.println("Test case 139");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test140() throws Exception {
		System.out.println("Test case 140");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B3", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test141() throws Exception {
		System.out.println("Test case 141");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.unstack("B2", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B6", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test142() throws Exception {
		System.out.println("Test case 142");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.pickup("B6");
		block.stack("B6", "B5");
		block.unstack("B6", "B5");
		assertTrue("3_2_1_2_3_2", block.isClear("B2"));
		assertTrue("3_2_1_2_3_2", block.isClear("B5"));
		assertTrue("3_2_1_2_3_2", block.isHolding("B6"));
		assertTrue("3_2_1_2_3_2", block.isOn("B2", "B3"));
		assertTrue("3_2_1_2_3_2", block.isOntable("B3"));
		assertTrue("3_2_1_2_3_2", block.isOntable("B5"));
	}

	public void test143() throws Exception {
		System.out.println("Test case 143");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		assertTrue("3_2_1_3", block.isClear("B3"));
		assertTrue("3_2_1_3", block.isClear("B5"));
		assertTrue("3_2_1_3", block.isClear("B6"));
		assertTrue("3_2_1_3", block.isHolding("B2"));
		assertTrue("3_2_1_3", block.isOntable("B3"));
		assertTrue("3_2_1_3", block.isOntable("B5"));
		assertTrue("3_2_1_3", block.isOntable("B6"));
		block.putdown("B2");
		assertTrue("3_2_1_3_1", block.isClear("B2"));
		assertTrue("3_2_1_3_1", block.isClear("B3"));
		assertTrue("3_2_1_3_1", block.isClear("B5"));
		assertTrue("3_2_1_3_1", block.isClear("B6"));
		assertTrue("3_2_1_3_1", block.isOntable("B2"));
		assertTrue("3_2_1_3_1", block.isOntable("B3"));
		assertTrue("3_2_1_3_1", block.isOntable("B5"));
		assertTrue("3_2_1_3_1", block.isOntable("B6"));
	}

	public void test144() throws Exception {
		System.out.println("Test case 144");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B3");
		assertTrue("3_2_1_3_2", block.isClear("B2"));
		assertTrue("3_2_1_3_2", block.isClear("B5"));
		assertTrue("3_2_1_3_2", block.isClear("B6"));
		assertTrue("3_2_1_3_2", block.isOn("B2", "B3"));
		assertTrue("3_2_1_3_2", block.isOntable("B3"));
		assertTrue("3_2_1_3_2", block.isOntable("B5"));
		assertTrue("3_2_1_3_2", block.isOntable("B6"));
	}

	public void test145() throws Exception {
		System.out.println("Test case 145");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		assertTrue("3_2_1_3_3", block.isClear("B2"));
		assertTrue("3_2_1_3_3", block.isClear("B3"));
		assertTrue("3_2_1_3_3", block.isClear("B6"));
		assertTrue("3_2_1_3_3", block.isOn("B2", "B5"));
		assertTrue("3_2_1_3_3", block.isOntable("B3"));
		assertTrue("3_2_1_3_3", block.isOntable("B5"));
		assertTrue("3_2_1_3_3", block.isOntable("B6"));
		block.pickup("B3");
		assertTrue("3_2_1_3_3_1", block.isClear("B2"));
		assertTrue("3_2_1_3_3_1", block.isClear("B6"));
		assertTrue("3_2_1_3_3_1", block.isHolding("B3"));
		assertTrue("3_2_1_3_3_1", block.isOn("B2", "B5"));
		assertTrue("3_2_1_3_3_1", block.isOntable("B5"));
		assertTrue("3_2_1_3_3_1", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test146() throws Exception {
		System.out.println("Test case 146");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test147() throws Exception {
		System.out.println("Test case 147");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test148() throws Exception {
		System.out.println("Test case 148");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B3", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test149() throws Exception {
		System.out.println("Test case 149");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B2", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test150() throws Exception {
		System.out.println("Test case 150");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B3");
		block.stack("B3", "B6");
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test151() throws Exception {
		System.out.println("Test case 151");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B6");
		assertTrue("3_2_1_3_3_2", block.isClear("B2"));
		assertTrue("3_2_1_3_3_2", block.isClear("B3"));
		assertTrue("3_2_1_3_3_2", block.isHolding("B6"));
		assertTrue("3_2_1_3_3_2", block.isOn("B2", "B5"));
		assertTrue("3_2_1_3_3_2", block.isOntable("B3"));
		assertTrue("3_2_1_3_3_2", block.isOntable("B5"));
		block.putdown("B6");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test152() throws Exception {
		System.out.println("Test case 152");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.pickup("B3");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B5"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test153() throws Exception {
		System.out.println("Test case 153");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.pickup("B3");
		block.stack("B3", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B3", "B6"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B3", "B6");
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B6", "B2"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test154() throws Exception {
		System.out.println("Test case 154");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B6");
		block.stack("B6", "B2");
		block.unstack("B6", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test155() throws Exception {
		System.out.println("Test case 155");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		block.unstack("B2", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B6", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test156() throws Exception {
		System.out.println("Test case 156");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.pickup("B6");
		block.stack("B6", "B3");
		block.unstack("B6", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B6"));
		assertTrue("", block.isOn("B2", "B5"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
	}

	public void test157() throws Exception {
		System.out.println("Test case 157");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B5");
		block.unstack("B2", "B5");
		assertTrue("3_2_1_3_3_3", block.isClear("B3"));
		assertTrue("3_2_1_3_3_3", block.isClear("B5"));
		assertTrue("3_2_1_3_3_3", block.isClear("B6"));
		assertTrue("3_2_1_3_3_3", block.isHolding("B2"));
		assertTrue("3_2_1_3_3_3", block.isOntable("B3"));
		assertTrue("3_2_1_3_3_3", block.isOntable("B5"));
		assertTrue("3_2_1_3_3_3", block.isOntable("B6"));
	}

	public void test158() throws Exception {
		System.out.println("Test case 158");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		assertTrue("3_2_1_3_4", block.isClear("B2"));
		assertTrue("3_2_1_3_4", block.isClear("B3"));
		assertTrue("3_2_1_3_4", block.isClear("B5"));
		assertTrue("3_2_1_3_4", block.isOn("B2", "B6"));
		assertTrue("3_2_1_3_4", block.isOntable("B3"));
		assertTrue("3_2_1_3_4", block.isOntable("B5"));
		assertTrue("3_2_1_3_4", block.isOntable("B6"));
		block.pickup("B3");
		assertTrue("3_2_1_3_4_1", block.isClear("B2"));
		assertTrue("3_2_1_3_4_1", block.isClear("B5"));
		assertTrue("3_2_1_3_4_1", block.isHolding("B3"));
		assertTrue("3_2_1_3_4_1", block.isOn("B2", "B6"));
		assertTrue("3_2_1_3_4_1", block.isOntable("B5"));
		assertTrue("3_2_1_3_4_1", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test159() throws Exception {
		System.out.println("Test case 159");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B3");
		block.stack("B3", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test160() throws Exception {
		System.out.println("Test case 160");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.pickup("B5");
		block.stack("B5", "B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B5", "B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test161() throws Exception {
		System.out.println("Test case 161");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B3");
		block.stack("B3", "B2");
		block.unstack("B3", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test162() throws Exception {
		System.out.println("Test case 162");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B2", "B6");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B6"));
		assertTrue("", block.isHolding("B2"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test163() throws Exception {
		System.out.println("Test case 163");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B3");
		block.stack("B3", "B5");
		block.unstack("B3", "B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test164() throws Exception {
		System.out.println("Test case 164");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B5");
		assertTrue("3_2_1_3_4_2", block.isClear("B2"));
		assertTrue("3_2_1_3_4_2", block.isClear("B3"));
		assertTrue("3_2_1_3_4_2", block.isHolding("B5"));
		assertTrue("3_2_1_3_4_2", block.isOn("B2", "B6"));
		assertTrue("3_2_1_3_4_2", block.isOntable("B3"));
		assertTrue("3_2_1_3_4_2", block.isOntable("B6"));
		block.putdown("B5");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B5"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test165() throws Exception {
		System.out.println("Test case 165");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B5");
		block.stack("B5", "B2");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
		block.pickup("B3");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B6"));
		block.putdown("B3");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test166() throws Exception {
		System.out.println("Test case 166");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B5");
		block.stack("B5", "B2");
		block.pickup("B3");
		block.stack("B3", "B5");
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B3", "B5"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B6"));
		block.unstack("B3", "B5");
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isHolding("B3"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B2"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test167() throws Exception {
		System.out.println("Test case 167");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B5");
		block.stack("B5", "B2");
		block.unstack("B5", "B2");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B3"));
		assertTrue("", block.isHolding("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test168() throws Exception {
		System.out.println("Test case 168");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.pickup("B5");
		block.stack("B5", "B3");
		assertTrue("", block.isClear("B2"));
		assertTrue("", block.isClear("B5"));
		assertTrue("", block.isOn("B2", "B6"));
		assertTrue("", block.isOn("B5", "B3"));
		assertTrue("", block.isOntable("B3"));
		assertTrue("", block.isOntable("B6"));
	}

	public void test169() throws Exception {
		System.out.println("Test case 169");
		block.unstack("B5", "B6");
		block.putdown("B5");
		block.unstack("B2", "B3");
		block.stack("B2", "B6");
		block.unstack("B2", "B6");
		assertTrue("3_2_1_3_4_3", block.isClear("B3"));
		assertTrue("3_2_1_3_4_3", block.isClear("B5"));
		assertTrue("3_2_1_3_4_3", block.isClear("B6"));
		assertTrue("3_2_1_3_4_3", block.isHolding("B2"));
		assertTrue("3_2_1_3_4_3", block.isOntable("B3"));
		assertTrue("3_2_1_3_4_3", block.isOntable("B5"));
		assertTrue("3_2_1_3_4_3", block.isOntable("B6"));
	}

	public void test170() throws Exception {
		System.out.println("Test case 170");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		assertTrue("3_2_2", block.isClear("B5"));
		assertTrue("3_2_2", block.isClear("B6"));
		assertTrue("3_2_2", block.isOn("B2", "B3"));
		assertTrue("3_2_2", block.isOn("B5", "B2"));
		assertTrue("3_2_2", block.isOntable("B3"));
		assertTrue("3_2_2", block.isOntable("B6"));
		block.pickup("B6");
		assertTrue("3_2_2_1", block.isClear("B5"));
		assertTrue("3_2_2_1", block.isHolding("B6"));
		assertTrue("3_2_2_1", block.isOn("B2", "B3"));
		assertTrue("3_2_2_1", block.isOn("B5", "B2"));
		assertTrue("3_2_2_1", block.isOntable("B3"));
		block.putdown("B6");
		assertTrue("3_2_2_1_1", block.isClear("B5"));
		assertTrue("3_2_2_1_1", block.isClear("B6"));
		assertTrue("3_2_2_1_1", block.isOn("B2", "B3"));
		assertTrue("3_2_2_1_1", block.isOn("B5", "B2"));
		assertTrue("3_2_2_1_1", block.isOntable("B3"));
		assertTrue("3_2_2_1_1", block.isOntable("B6"));
	}

	public void test171() throws Exception {
		System.out.println("Test case 171");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.pickup("B6");
		block.stack("B6", "B5");
		assertTrue("3_2_2_1_2", block.isClear("B6"));
		assertTrue("3_2_2_1_2", block.isOn("B2", "B3"));
		assertTrue("3_2_2_1_2", block.isOn("B5", "B2"));
		assertTrue("3_2_2_1_2", block.isOn("B6", "B5"));
		assertTrue("3_2_2_1_2", block.isOntable("B3"));
		block.unstack("B6", "B5");
		assertTrue("3_2_2_1_2_1", block.isClear("B5"));
		assertTrue("3_2_2_1_2_1", block.isHolding("B6"));
		assertTrue("3_2_2_1_2_1", block.isOn("B2", "B3"));
		assertTrue("3_2_2_1_2_1", block.isOn("B5", "B2"));
		assertTrue("3_2_2_1_2_1", block.isOntable("B3"));
	}

	public void test172() throws Exception {
		System.out.println("Test case 172");
		block.unstack("B5", "B6");
		block.stack("B5", "B2");
		block.unstack("B5", "B2");
		assertTrue("3_2_2_2", block.isClear("B2"));
		assertTrue("3_2_2_2", block.isClear("B6"));
		assertTrue("3_2_2_2", block.isHolding("B5"));
		assertTrue("3_2_2_2", block.isOn("B2", "B3"));
		assertTrue("3_2_2_2", block.isOntable("B3"));
		assertTrue("3_2_2_2", block.isOntable("B6"));
	}

	public void test173() throws Exception {
		System.out.println("Test case 173");
		block.unstack("B5", "B6");
		block.stack("B5", "B6");
		assertTrue("3_2_3", block.isClear("B2"));
		assertTrue("3_2_3", block.isClear("B5"));
		assertTrue("3_2_3", block.isOn("B2", "B3"));
		assertTrue("3_2_3", block.isOn("B5", "B6"));
		assertTrue("3_2_3", block.isOntable("B3"));
		assertTrue("3_2_3", block.isOntable("B6"));
	}

}
