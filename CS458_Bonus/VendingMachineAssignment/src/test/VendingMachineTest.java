package test;

import vending.Coin;
import vending.VendingMachine;

import javax.swing.JComponent;
import javax.swing.JRadioButton;

import gui.VendingGUI;
import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import junit.framework.*;

public class VendingMachineTest extends JFCTestCase {

	private VendingMachine vending = null;
	private VendingGUI vendingGUI = null;
	
	private TestHelper helper = null;
	public VendingMachineTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		helper = new JFCTestHelper();
		vending = new VendingMachine();
		vending.setDrink(VendingMachine.COFFEE, 85, 3);
		vending.setDrink(VendingMachine.JUICE, 60, 2);
		vending.setDrink(VendingMachine.SODA, 115, 5);
		
		VendingGUI vendingGUI = new VendingGUI(vending);
		vendingGUI.pack();
		vendingGUI.setVisible(true);
	}
	
	protected void tearDown() throws Exception {
		vending = null;
		super.tearDown();
	}

	public void testPurchaseJuice() {
		vending.insertCoin(Coin.DOLLAR);
		assertTrue("", vending.getDeposit()==100);
		vending.purchase(VendingMachine.JUICE);	
		assertTrue("", vending.getJuice().getCount()==1);
		assertTrue("", vending.getDeposit()==0);
	}
	
	public void testButtons() {
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "DollarButton");
		JRadioButton dollarButton = (JRadioButton) finder.find(vendingGUI, 0);
		assertNotNull("Could not find dollar button", dollarButton);
	}
}
