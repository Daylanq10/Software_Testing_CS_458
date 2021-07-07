package taxreturn;


import org.junit.Test;


public class TaxReturnTest {
	
	@Test
	public void testSingle_1() {
		TaxReturn aTaxReturn = new TaxReturn(15000, 1);
		System.out.println("Your tax is " + aTaxReturn.getTax());
	}
	
	@Test
	public void testSingle_2() {
		TaxReturn aTaxReturn = new TaxReturn(40000, 1);
		System.out.println("Your tax is " + aTaxReturn.getTax());
	}
	
	@Test
	public void testSingle_3() {
		TaxReturn aTaxReturn = new TaxReturn(60000, 1);
		System.out.println("Your tax is " + aTaxReturn.getTax());
	}
	
	@Test
	public void testMarried_1() {
		TaxReturn aTaxReturn = new TaxReturn(30000, 2);
		System.out.println("Your tax is " + aTaxReturn.getTax());
	}
	
	@Test
	public void testMarried_2() {
		TaxReturn aTaxReturn = new TaxReturn(80000, 2);
		System.out.println("Your tax is " + aTaxReturn.getTax());
	}
	
	@Test
	public void testMarried_3() {
		TaxReturn aTaxReturn = new TaxReturn(100000, 2);
		System.out.println("Your tax is " + aTaxReturn.getTax());
	}
	
}
