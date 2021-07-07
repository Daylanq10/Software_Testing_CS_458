//Test code generated by MISTA

package test;

import vending.Coin;
import vending.VendingMachine;

import org.junit.*;

import static org.junit.Assert.*;

public class VendingMachine_0_Tester_TC_2 {

	private VendingMachine vendingmachine;
	
	@Before
	public void setUp()  throws Exception {
		vendingmachine = new VendingMachine();
		vendingmachine.setDrink(COFFEE, 85, 1);
		vendingmachine.setDrink(JUICE, 60, 1);
		vendingmachine.setDrink(SODA, 115, 1);
	}
	
	@Test
	public void test1() throws Exception {
		System.out.println("Test case 1");
		vendingmachine.insertCoin(Coin.DIME);
		assertTrue("1_1", vendingmachine.getDeposit()==10);
		assertTrue("1_1", ! (vendingmachine.getDeposit()==0));
		vendingmachine.returnCoins();
		assertTrue("1_1_1", vendingmachine.getDeposit()==0);
		assertTrue("1_1_1", ! (vendingmachine.getDeposit()==10));
	}

	@Test
	public void test2() throws Exception {
		System.out.println("Test case 2");
		vendingmachine.insertCoin(Coin.DOLLAR);
		assertTrue("1_2", vendingmachine.getDeposit()==100);
		assertTrue("1_2", ! (vendingmachine.getDeposit()==0));
		vendingmachine.insertCoin(Coin.QUARTER);
		assertTrue("1_2_1", vendingmachine.getDeposit()==125);
		assertTrue("1_2_1", ! (vendingmachine.getDeposit()==100));
		vendingmachine.purchase(SODA);
		assertTrue("1_2_1_1", vendingmachine.getDeposit()==0);
		assertTrue("1_2_1_1", checkDrink(SODA, 115, 0));
		assertTrue("1_2_1_1", ! (vendingmachine.getDeposit()==125));
		assertTrue("1_2_1_1", ! (checkDrink(SODA, 115, 1)));
		assertTrue("", vendingmachine.getChange()==125-115);
	}

	@Test
	public void test3() throws Exception {
		System.out.println("Test case 3");
		vendingmachine.insertCoin(Coin.DOLLAR);
		vendingmachine.purchase(COFFEE);
		assertTrue("1_2_2", vendingmachine.getDeposit()==0);
		assertTrue("1_2_2", checkDrink(COFFEE, 85, 0));
		assertTrue("1_2_2", ! (vendingmachine.getDeposit()==100));
		assertTrue("1_2_2", ! (checkDrink(COFFEE, 85, 1)));
		assertTrue("", vendingmachine.getChange()==100-85);
	}

	@Test
	public void test4() throws Exception {
		System.out.println("Test case 4");
		vendingmachine.insertCoin(Coin.DOLLAR);
		vendingmachine.purchase(JUICE);
		assertTrue("1_2_3", vendingmachine.getDeposit()==0);
		assertTrue("1_2_3", checkDrink(JUICE, 60, 0));
		assertTrue("1_2_3", ! (vendingmachine.getDeposit()==100));
		assertTrue("1_2_3", ! (checkDrink(JUICE, 60, 1)));
		assertTrue("", vendingmachine.getChange()==100-60);
	}


	public static final String COFFEE = VendingMachine.COFFEE; 
	public static final String JUICE = VendingMachine.JUICE; 
	public static final String SODA = VendingMachine.SODA; 
	
	private boolean checkDrink(String drink, int price, int count) {
		if (drink.equalsIgnoreCase(COFFEE)) 
				return vendingmachine.getCoffee().getPrice()==price && vendingmachine.getCoffee().getCount()==count;
		if (drink.equalsIgnoreCase(JUICE)) 
				return vendingmachine.getJuice().getPrice()==price && vendingmachine.getJuice().getCount()==count;
		if (drink.equalsIgnoreCase(SODA)) 
				return vendingmachine.getSoda().getPrice()==price && vendingmachine.getSoda().getCount()==count;
		else
			return true;
	}
	
	
}
