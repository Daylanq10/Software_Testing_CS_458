//Test code generated by MISTA

package test;

import vending.Coin;
import vending.VendingMachine;
import org.junit.*;
import static org.junit.Assert.*;

public class VendingMachineTester1_TC_2 {

	private VendingMachine vendingmachine;
	
	@Before
	public void setUp()  throws Exception {
		vendingmachine = new VendingMachine();
		vendingmachine.setDrink(COFFEE, 35, 0);
		vendingmachine.setDrink(JUICE, 110, 0);
		vendingmachine.setDrink(SODA, 105, 0);
	}
	
	@Test
	public void test1() throws Exception {
		System.out.println("Test case 1");
		vendingmachine.insertCoin(Coin.DOLLAR);
		assertTrue("1_1", vendingmachine.getDeposit()==100);
		assertTrue("1_1", ! (vendingmachine.getDeposit()==0));
		vendingmachine.returnCoins();
		assertTrue("1_1_1", vendingmachine.getDeposit()==0);
		assertTrue("1_1_1", ! (vendingmachine.getDeposit()==100));
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
