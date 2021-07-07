//Test code generated by ISTA

public class BankAccountTester_RTD{

	private BankAccount bankaccount;
	
	protected void setUp()  throws Exception {
		bankaccount = new BankAccount();
		bankaccount.deposit(100);
	}
	
	public void test1_1_1() throws Exception {
		System.out.println("Test case 1_1_1");
		setUp();
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_1";
		assert getBalance()==100 : "Test failed at 1_1";
	}

	public void test2_1_2_1() throws Exception {
		System.out.println("Test case 2_1_2_1");
		setUp();
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2";
		assert getBalance()==300 : "Test failed at 1_2";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_1";
		assert getBalance()==300 : "Test failed at 1_2_1";
	}

	public void test3_1_2_2_1() throws Exception {
		System.out.println("Test case 3_1_2_2_1");
		setUp();
		deposit(200);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2";
		assert getBalance()==500 : "Test failed at 1_2_2";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_1";
		assert getBalance()==500 : "Test failed at 1_2_2_1";
	}

	public void test4_1_2_2_2_1() throws Exception {
		System.out.println("Test case 4_1_2_2_2_1");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2";
		assert getBalance()==700 : "Test failed at 1_2_2_2";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_1";
		assert getBalance()==700 : "Test failed at 1_2_2_2_1";
	}

	public void test5_1_2_2_2_2_1() throws Exception {
		System.out.println("Test case 5_1_2_2_2_2_1");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_2";
		assert getBalance()==900 : "Test failed at 1_2_2_2_2";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_2_1";
		assert getBalance()==900 : "Test failed at 1_2_2_2_2_1";
	}

	public void test6_1_2_2_2_2_2() throws Exception {
		System.out.println("Test case 6_1_2_2_2_2_2");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		deposit(200);
		try {
			deposit(-100);
			System.out.println("Test failed at test 1_2_2_2_2_2: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_2_2";
		assert getBalance()==900 : "Test failed at 1_2_2_2_2_2";
	}

	public void test7_1_2_2_2_2_3() throws Exception {
		System.out.println("Test case 7_1_2_2_2_2_3");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_2_3";
		assert getBalance()==600 : "Test failed at 1_2_2_2_2_3";
	}

	public void test8_1_2_2_2_2_4() throws Exception {
		System.out.println("Test case 8_1_2_2_2_2_4");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(1200);
		assert getBalance()==-300 : "Test failed at 1_2_2_2_2_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_2_4";
	}

	public void test9_1_2_2_2_2_5() throws Exception {
		System.out.println("Test case 9_1_2_2_2_2_5");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		deposit(200);
		close();
		assert getBalance()==0 : "Test failed at 1_2_2_2_2_5";
		assert bankaccount.getClosed() : "Test failed at 1_2_2_2_2_5";
	}

	public void test10_1_2_2_2_3_1() throws Exception {
		System.out.println("Test case 10_1_2_2_2_3_1");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_3";
		assert getBalance()==400 : "Test failed at 1_2_2_2_3";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_3_1";
		assert getBalance()==400 : "Test failed at 1_2_2_2_3_1";
	}

	public void test11_1_2_2_2_3_2() throws Exception {
		System.out.println("Test case 11_1_2_2_2_3_2");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_3_2";
		assert getBalance()==600 : "Test failed at 1_2_2_2_3_2";
	}

	public void test12_1_2_2_2_3_3() throws Exception {
		System.out.println("Test case 12_1_2_2_2_3_3");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_3_3";
		assert getBalance()==900 : "Test failed at 1_2_2_2_3_3";
	}

	public void test13_1_2_2_2_3_4() throws Exception {
		System.out.println("Test case 13_1_2_2_2_3_4");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_3_4";
		assert getBalance()==100 : "Test failed at 1_2_2_2_3_4";
	}

	public void test14_1_2_2_2_3_5_1() throws Exception {
		System.out.println("Test case 14_1_2_2_2_3_5_1");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(1200);
		assert getBalance()==-800 : "Test failed at 1_2_2_2_3_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_3_5";
		getBalance();
		assert getBalance()==-800 : "Test failed at 1_2_2_2_3_5_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_3_5_1";
	}

	public void test15_1_2_2_2_3_5_2() throws Exception {
		System.out.println("Test case 15_1_2_2_2_3_5_2");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(1200);
		deposit(200);
		assert getBalance()==-600 : "Test failed at 1_2_2_2_3_5_2";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_3_5_2";
	}

	public void test16_1_2_2_2_3_5_3() throws Exception {
		System.out.println("Test case 16_1_2_2_2_3_5_3");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(1200);
		deposit(500);
		assert getBalance()==-300 : "Test failed at 1_2_2_2_3_5_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_3_5_3";
	}

	public void test17_1_2_2_2_3_5_4() throws Exception {
		System.out.println("Test case 17_1_2_2_2_3_5_4");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(1200);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_2_2_2_3_5_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-800 : "Test failed at 1_2_2_2_3_5_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_3_5_4";
	}

	public void test18_1_2_2_2_3_5_5() throws Exception {
		System.out.println("Test case 18_1_2_2_2_3_5_5");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(1200);
		try {
			close();
			System.out.println("Test failed at test 1_2_2_2_3_5_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-800 : "Test failed at 1_2_2_2_3_5_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_3_5_5";
	}

	public void test19_1_2_2_2_3_6() throws Exception {
		System.out.println("Test case 19_1_2_2_2_3_6");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(300);
		close();
		assert getBalance()==0 : "Test failed at 1_2_2_2_3_6";
		assert bankaccount.getClosed() : "Test failed at 1_2_2_2_3_6";
	}

	public void test20_1_2_2_2_4_1() throws Exception {
		System.out.println("Test case 20_1_2_2_2_4_1");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(1200);
		assert getBalance()==-500 : "Test failed at 1_2_2_2_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_4";
		getBalance();
		assert getBalance()==-500 : "Test failed at 1_2_2_2_4_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_4_1";
	}

	public void test21_1_2_2_2_4_2() throws Exception {
		System.out.println("Test case 21_1_2_2_2_4_2");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(1200);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_2_4_2";
		assert getBalance()==0 : "Test failed at 1_2_2_2_4_2";
	}

	public void test22_1_2_2_2_4_3() throws Exception {
		System.out.println("Test case 22_1_2_2_2_4_3");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(1200);
		deposit(200);
		assert getBalance()==-300 : "Test failed at 1_2_2_2_4_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_4_3";
	}

	public void test23_1_2_2_2_4_4() throws Exception {
		System.out.println("Test case 23_1_2_2_2_4_4");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(1200);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_2_2_2_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-500 : "Test failed at 1_2_2_2_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_4_4";
	}

	public void test24_1_2_2_2_4_5() throws Exception {
		System.out.println("Test case 24_1_2_2_2_4_5");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		withdraw(1200);
		try {
			close();
			System.out.println("Test failed at test 1_2_2_2_4_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-500 : "Test failed at 1_2_2_2_4_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_2_4_5";
	}

	public void test25_1_2_2_2_5() throws Exception {
		System.out.println("Test case 25_1_2_2_2_5");
		setUp();
		deposit(200);
		deposit(200);
		deposit(200);
		close();
		assert getBalance()==0 : "Test failed at 1_2_2_2_5";
		assert bankaccount.getClosed() : "Test failed at 1_2_2_2_5";
	}

	public void test26_1_2_2_3_1() throws Exception {
		System.out.println("Test case 26_1_2_2_3_1");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_3";
		assert getBalance()==200 : "Test failed at 1_2_2_3";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_3_1";
		assert getBalance()==200 : "Test failed at 1_2_2_3_1";
	}

	public void test27_1_2_2_3_2() throws Exception {
		System.out.println("Test case 27_1_2_2_3_2");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(300);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_3_2";
		assert getBalance()==400 : "Test failed at 1_2_2_3_2";
	}

	public void test28_1_2_2_3_3() throws Exception {
		System.out.println("Test case 28_1_2_2_3_3");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(300);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_2_3_3";
		assert getBalance()==700 : "Test failed at 1_2_2_3_3";
	}

	public void test29_1_2_2_3_4() throws Exception {
		System.out.println("Test case 29_1_2_2_3_4");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(300);
		withdraw(300);
		assert getBalance()==-100 : "Test failed at 1_2_2_3_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_3_4";
	}

	public void test30_1_2_2_3_5() throws Exception {
		System.out.println("Test case 30_1_2_2_3_5");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(300);
		close();
		assert getBalance()==0 : "Test failed at 1_2_2_3_5";
		assert bankaccount.getClosed() : "Test failed at 1_2_2_3_5";
	}

	public void test31_1_2_2_4_1() throws Exception {
		System.out.println("Test case 31_1_2_2_4_1");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(1200);
		assert getBalance()==-700 : "Test failed at 1_2_2_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_4";
		getBalance();
		assert getBalance()==-700 : "Test failed at 1_2_2_4_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_4_1";
	}

	public void test32_1_2_2_4_2() throws Exception {
		System.out.println("Test case 32_1_2_2_4_2");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(1200);
		deposit(200);
		assert getBalance()==-500 : "Test failed at 1_2_2_4_2";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_4_2";
	}

	public void test33_1_2_2_4_3() throws Exception {
		System.out.println("Test case 33_1_2_2_4_3");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(1200);
		deposit(500);
		assert getBalance()==-200 : "Test failed at 1_2_2_4_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_4_3";
	}

	public void test34_1_2_2_4_4() throws Exception {
		System.out.println("Test case 34_1_2_2_4_4");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(1200);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_2_2_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-700 : "Test failed at 1_2_2_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_4_4";
	}

	public void test35_1_2_2_4_5() throws Exception {
		System.out.println("Test case 35_1_2_2_4_5");
		setUp();
		deposit(200);
		deposit(200);
		withdraw(1200);
		try {
			close();
			System.out.println("Test failed at test 1_2_2_4_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-700 : "Test failed at 1_2_2_4_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_2_4_5";
	}

	public void test36_1_2_2_5() throws Exception {
		System.out.println("Test case 36_1_2_2_5");
		setUp();
		deposit(200);
		deposit(200);
		close();
		assert getBalance()==0 : "Test failed at 1_2_2_5";
		assert bankaccount.getClosed() : "Test failed at 1_2_2_5";
	}

	public void test37_1_2_3_1() throws Exception {
		System.out.println("Test case 37_1_2_3_1");
		setUp();
		deposit(200);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_3";
		assert getBalance()==800 : "Test failed at 1_2_3";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_3_1";
		assert getBalance()==800 : "Test failed at 1_2_3_1";
	}

	public void test38_1_2_3_2() throws Exception {
		System.out.println("Test case 38_1_2_3_2");
		setUp();
		deposit(200);
		deposit(500);
		try {
			deposit(-100);
			System.out.println("Test failed at test 1_2_3_2: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_3_2";
		assert getBalance()==800 : "Test failed at 1_2_3_2";
	}

	public void test39_1_2_3_3() throws Exception {
		System.out.println("Test case 39_1_2_3_3");
		setUp();
		deposit(200);
		deposit(500);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_3_3";
		assert getBalance()==500 : "Test failed at 1_2_3_3";
	}

	public void test40_1_2_3_4_1() throws Exception {
		System.out.println("Test case 40_1_2_3_4_1");
		setUp();
		deposit(200);
		deposit(500);
		withdraw(1200);
		assert getBalance()==-400 : "Test failed at 1_2_3_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_3_4";
		getBalance();
		assert getBalance()==-400 : "Test failed at 1_2_3_4_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_3_4_1";
	}

	public void test41_1_2_3_4_2() throws Exception {
		System.out.println("Test case 41_1_2_3_4_2");
		setUp();
		deposit(200);
		deposit(500);
		withdraw(1200);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_3_4_2";
		assert getBalance()==100 : "Test failed at 1_2_3_4_2";
	}

	public void test42_1_2_3_4_3() throws Exception {
		System.out.println("Test case 42_1_2_3_4_3");
		setUp();
		deposit(200);
		deposit(500);
		withdraw(1200);
		deposit(200);
		assert getBalance()==-200 : "Test failed at 1_2_3_4_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_3_4_3";
	}

	public void test43_1_2_3_4_4() throws Exception {
		System.out.println("Test case 43_1_2_3_4_4");
		setUp();
		deposit(200);
		deposit(500);
		withdraw(1200);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_2_3_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-400 : "Test failed at 1_2_3_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_3_4_4";
	}

	public void test44_1_2_3_4_5() throws Exception {
		System.out.println("Test case 44_1_2_3_4_5");
		setUp();
		deposit(200);
		deposit(500);
		withdraw(1200);
		try {
			close();
			System.out.println("Test failed at test 1_2_3_4_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-400 : "Test failed at 1_2_3_4_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_3_4_5";
	}

	public void test45_1_2_3_5() throws Exception {
		System.out.println("Test case 45_1_2_3_5");
		setUp();
		deposit(200);
		deposit(500);
		close();
		assert getBalance()==0 : "Test failed at 1_2_3_5";
		assert bankaccount.getClosed() : "Test failed at 1_2_3_5";
	}

	public void test46_1_2_4_1() throws Exception {
		System.out.println("Test case 46_1_2_4_1");
		setUp();
		deposit(200);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_4";
		assert getBalance()==0 : "Test failed at 1_2_4";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_4_1";
		assert getBalance()==0 : "Test failed at 1_2_4_1";
	}

	public void test47_1_2_4_2() throws Exception {
		System.out.println("Test case 47_1_2_4_2");
		setUp();
		deposit(200);
		withdraw(300);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_4_2";
		assert getBalance()==200 : "Test failed at 1_2_4_2";
	}

	public void test48_1_2_4_3() throws Exception {
		System.out.println("Test case 48_1_2_4_3");
		setUp();
		deposit(200);
		withdraw(300);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_4_3";
		assert getBalance()==500 : "Test failed at 1_2_4_3";
	}

	public void test49_1_2_4_4_1() throws Exception {
		System.out.println("Test case 49_1_2_4_4_1");
		setUp();
		deposit(200);
		withdraw(300);
		withdraw(300);
		assert getBalance()==-300 : "Test failed at 1_2_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_4_4";
		getBalance();
		assert getBalance()==-300 : "Test failed at 1_2_4_4_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_4_4_1";
	}

	public void test50_1_2_4_4_2() throws Exception {
		System.out.println("Test case 50_1_2_4_4_2");
		setUp();
		deposit(200);
		withdraw(300);
		withdraw(300);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_2_4_4_2";
		assert getBalance()==200 : "Test failed at 1_2_4_4_2";
	}

	public void test51_1_2_4_4_3() throws Exception {
		System.out.println("Test case 51_1_2_4_4_3");
		setUp();
		deposit(200);
		withdraw(300);
		withdraw(300);
		deposit(200);
		assert getBalance()==-100 : "Test failed at 1_2_4_4_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_4_4_3";
	}

	public void test52_1_2_4_4_4() throws Exception {
		System.out.println("Test case 52_1_2_4_4_4");
		setUp();
		deposit(200);
		withdraw(300);
		withdraw(300);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_2_4_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-300 : "Test failed at 1_2_4_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_4_4_4";
	}

	public void test53_1_2_4_4_5() throws Exception {
		System.out.println("Test case 53_1_2_4_4_5");
		setUp();
		deposit(200);
		withdraw(300);
		withdraw(300);
		try {
			close();
			System.out.println("Test failed at test 1_2_4_4_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-300 : "Test failed at 1_2_4_4_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_4_4_5";
	}

	public void test54_1_2_4_5() throws Exception {
		System.out.println("Test case 54_1_2_4_5");
		setUp();
		deposit(200);
		withdraw(300);
		close();
		assert getBalance()==0 : "Test failed at 1_2_4_5";
		assert bankaccount.getClosed() : "Test failed at 1_2_4_5";
	}

	public void test55_1_2_5_1() throws Exception {
		System.out.println("Test case 55_1_2_5_1");
		setUp();
		deposit(200);
		withdraw(1200);
		assert getBalance()==-900 : "Test failed at 1_2_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_5";
		getBalance();
		assert getBalance()==-900 : "Test failed at 1_2_5_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_5_1";
	}

	public void test56_1_2_5_2() throws Exception {
		System.out.println("Test case 56_1_2_5_2");
		setUp();
		deposit(200);
		withdraw(1200);
		deposit(200);
		assert getBalance()==-700 : "Test failed at 1_2_5_2";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_5_2";
	}

	public void test57_1_2_5_3() throws Exception {
		System.out.println("Test case 57_1_2_5_3");
		setUp();
		deposit(200);
		withdraw(1200);
		deposit(500);
		assert getBalance()==-400 : "Test failed at 1_2_5_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_5_3";
	}

	public void test58_1_2_5_4() throws Exception {
		System.out.println("Test case 58_1_2_5_4");
		setUp();
		deposit(200);
		withdraw(1200);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_2_5_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-900 : "Test failed at 1_2_5_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_5_4";
	}

	public void test59_1_2_5_5() throws Exception {
		System.out.println("Test case 59_1_2_5_5");
		setUp();
		deposit(200);
		withdraw(1200);
		try {
			close();
			System.out.println("Test failed at test 1_2_5_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-900 : "Test failed at 1_2_5_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_2_5_5";
	}

	public void test60_1_2_6() throws Exception {
		System.out.println("Test case 60_1_2_6");
		setUp();
		deposit(200);
		close();
		assert getBalance()==0 : "Test failed at 1_2_6";
		assert bankaccount.getClosed() : "Test failed at 1_2_6";
	}

	public void test61_1_3_1() throws Exception {
		System.out.println("Test case 61_1_3_1");
		setUp();
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_3";
		assert getBalance()==600 : "Test failed at 1_3";
		getBalance();
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_3_1";
		assert getBalance()==600 : "Test failed at 1_3_1";
	}

	public void test62_1_3_2() throws Exception {
		System.out.println("Test case 62_1_3_2");
		setUp();
		deposit(500);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_3_2";
		assert getBalance()==800 : "Test failed at 1_3_2";
	}

	public void test63_1_3_3() throws Exception {
		System.out.println("Test case 63_1_3_3");
		setUp();
		deposit(500);
		withdraw(300);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_3_3";
		assert getBalance()==300 : "Test failed at 1_3_3";
	}

	public void test64_1_3_4_1() throws Exception {
		System.out.println("Test case 64_1_3_4_1");
		setUp();
		deposit(500);
		withdraw(1200);
		assert getBalance()==-600 : "Test failed at 1_3_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4";
		getBalance();
		assert getBalance()==-600 : "Test failed at 1_3_4_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_1";
	}

	public void test65_1_3_4_2() throws Exception {
		System.out.println("Test case 65_1_3_4_2");
		setUp();
		deposit(500);
		withdraw(1200);
		deposit(200);
		assert getBalance()==-400 : "Test failed at 1_3_4_2";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_2";
	}

	public void test66_1_3_4_3_1() throws Exception {
		System.out.println("Test case 66_1_3_4_3_1");
		setUp();
		deposit(500);
		withdraw(1200);
		deposit(500);
		assert getBalance()==-100 : "Test failed at 1_3_4_3";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_3";
		getBalance();
		assert getBalance()==-100 : "Test failed at 1_3_4_3_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_3_1";
	}

	public void test67_1_3_4_3_2() throws Exception {
		System.out.println("Test case 67_1_3_4_3_2");
		setUp();
		deposit(500);
		withdraw(1200);
		deposit(500);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_3_4_3_2";
		assert getBalance()==100 : "Test failed at 1_3_4_3_2";
	}

	public void test68_1_3_4_3_3() throws Exception {
		System.out.println("Test case 68_1_3_4_3_3");
		setUp();
		deposit(500);
		withdraw(1200);
		deposit(500);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_3_4_3_3";
		assert getBalance()==400 : "Test failed at 1_3_4_3_3";
	}

	public void test69_1_3_4_3_4() throws Exception {
		System.out.println("Test case 69_1_3_4_3_4");
		setUp();
		deposit(500);
		withdraw(1200);
		deposit(500);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_3_4_3_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-100 : "Test failed at 1_3_4_3_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_3_4";
	}

	public void test70_1_3_4_3_5() throws Exception {
		System.out.println("Test case 70_1_3_4_3_5");
		setUp();
		deposit(500);
		withdraw(1200);
		deposit(500);
		try {
			close();
			System.out.println("Test failed at test 1_3_4_3_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-100 : "Test failed at 1_3_4_3_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_3_5";
	}

	public void test71_1_3_4_4() throws Exception {
		System.out.println("Test case 71_1_3_4_4");
		setUp();
		deposit(500);
		withdraw(1200);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_3_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-600 : "Test failed at 1_3_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_4";
	}

	public void test72_1_3_4_5() throws Exception {
		System.out.println("Test case 72_1_3_4_5");
		setUp();
		deposit(500);
		withdraw(1200);
		try {
			close();
			System.out.println("Test failed at test 1_3_4_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-600 : "Test failed at 1_3_4_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_3_4_5";
	}

	public void test73_1_3_5() throws Exception {
		System.out.println("Test case 73_1_3_5");
		setUp();
		deposit(500);
		close();
		assert getBalance()==0 : "Test failed at 1_3_5";
		assert bankaccount.getClosed() : "Test failed at 1_3_5";
	}

	public void test74_1_4_1() throws Exception {
		System.out.println("Test case 74_1_4_1");
		setUp();
		withdraw(300);
		assert getBalance()==-200 : "Test failed at 1_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_4";
		getBalance();
		assert getBalance()==-200 : "Test failed at 1_4_1";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_4_1";
	}

	public void test75_1_4_2() throws Exception {
		System.out.println("Test case 75_1_4_2");
		setUp();
		withdraw(300);
		deposit(200);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_4_2";
		assert getBalance()==0 : "Test failed at 1_4_2";
	}

	public void test76_1_4_3() throws Exception {
		System.out.println("Test case 76_1_4_3");
		setUp();
		withdraw(300);
		deposit(500);
		assert !bankaccount.getClosed() && bankaccount.getBalance() >= 0 : "Test failed at 1_4_3";
		assert getBalance()==300 : "Test failed at 1_4_3";
	}

	public void test77_1_4_4() throws Exception {
		System.out.println("Test case 77_1_4_4");
		setUp();
		withdraw(300);
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_4_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-200 : "Test failed at 1_4_4";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_4_4";
	}

	public void test78_1_4_5() throws Exception {
		System.out.println("Test case 78_1_4_5");
		setUp();
		withdraw(300);
		try {
			close();
			System.out.println("Test failed at test 1_4_5: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==-200 : "Test failed at 1_4_5";
		assert !bankaccount.getClosed() && bankaccount.getBalance()<0 && banaccount.getBalance()>=-1000 : "Test failed at 1_4_5";
	}

	public void test79_1_5_1() throws Exception {
		System.out.println("Test case 79_1_5_1");
		setUp();
		close();
		assert getBalance()==0 : "Test failed at 1_5";
		assert bankaccount.getClosed() : "Test failed at 1_5";
		try {
			getBalance();
			System.out.println("Test failed at test 1_5_1: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==0 : "Test failed at 1_5_1";
		assert bankaccount.getClosed() : "Test failed at 1_5_1";
	}

	public void test80_1_5_2() throws Exception {
		System.out.println("Test case 80_1_5_2");
		setUp();
		close();
		try {
			deposit(-100);
			System.out.println("Test failed at test 1_5_2: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==0 : "Test failed at 1_5_2";
		assert bankaccount.getClosed() : "Test failed at 1_5_2";
	}

	public void test81_1_5_3() throws Exception {
		System.out.println("Test case 81_1_5_3");
		setUp();
		close();
		try {
			withdraw(300);
			System.out.println("Test failed at test 1_5_3: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==0 : "Test failed at 1_5_3";
		assert bankaccount.getClosed() : "Test failed at 1_5_3";
	}

	public void test82_1_5_4() throws Exception {
		System.out.println("Test case 82_1_5_4");
		setUp();
		close();
		try {
			close();
			System.out.println("Test failed at test 1_5_4: an expected exception is not thrown!");
			System.exit(1);
		} catch (Exception e) {}
		assert getBalance()==0 : "Test failed at 1_5_4";
		assert bankaccount.getClosed() : "Test failed at 1_5_4";
	}

	public void testAll() throws Exception {
		test1_1_1();
		test2_1_2_1();
		test3_1_2_2_1();
		test4_1_2_2_2_1();
		test5_1_2_2_2_2_1();
		test6_1_2_2_2_2_2();
		test7_1_2_2_2_2_3();
		test8_1_2_2_2_2_4();
		test9_1_2_2_2_2_5();
		test10_1_2_2_2_3_1();
		test11_1_2_2_2_3_2();
		test12_1_2_2_2_3_3();
		test13_1_2_2_2_3_4();
		test14_1_2_2_2_3_5_1();
		test15_1_2_2_2_3_5_2();
		test16_1_2_2_2_3_5_3();
		test17_1_2_2_2_3_5_4();
		test18_1_2_2_2_3_5_5();
		test19_1_2_2_2_3_6();
		test20_1_2_2_2_4_1();
		test21_1_2_2_2_4_2();
		test22_1_2_2_2_4_3();
		test23_1_2_2_2_4_4();
		test24_1_2_2_2_4_5();
		test25_1_2_2_2_5();
		test26_1_2_2_3_1();
		test27_1_2_2_3_2();
		test28_1_2_2_3_3();
		test29_1_2_2_3_4();
		test30_1_2_2_3_5();
		test31_1_2_2_4_1();
		test32_1_2_2_4_2();
		test33_1_2_2_4_3();
		test34_1_2_2_4_4();
		test35_1_2_2_4_5();
		test36_1_2_2_5();
		test37_1_2_3_1();
		test38_1_2_3_2();
		test39_1_2_3_3();
		test40_1_2_3_4_1();
		test41_1_2_3_4_2();
		test42_1_2_3_4_3();
		test43_1_2_3_4_4();
		test44_1_2_3_4_5();
		test45_1_2_3_5();
		test46_1_2_4_1();
		test47_1_2_4_2();
		test48_1_2_4_3();
		test49_1_2_4_4_1();
		test50_1_2_4_4_2();
		test51_1_2_4_4_3();
		test52_1_2_4_4_4();
		test53_1_2_4_4_5();
		test54_1_2_4_5();
		test55_1_2_5_1();
		test56_1_2_5_2();
		test57_1_2_5_3();
		test58_1_2_5_4();
		test59_1_2_5_5();
		test60_1_2_6();
		test61_1_3_1();
		test62_1_3_2();
		test63_1_3_3();
		test64_1_3_4_1();
		test65_1_3_4_2();
		test66_1_3_4_3_1();
		test67_1_3_4_3_2();
		test68_1_3_4_3_3();
		test69_1_3_4_3_4();
		test70_1_3_4_3_5();
		test71_1_3_4_4();
		test72_1_3_4_5();
		test73_1_3_5();
		test74_1_4_1();
		test75_1_4_2();
		test76_1_4_3();
		test77_1_4_4();
		test78_1_4_5();
		test79_1_5_1();
		test80_1_5_2();
		test81_1_5_3();
		test82_1_5_4();
	}


	private static final int NEGATIVE = -500;
	
	
	
	public static void main(String[] args) throws Exception {
		 new BankAccountTester_RTD().testAll();
	}

}