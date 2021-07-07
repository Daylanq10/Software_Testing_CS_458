//Test code generated by ISTA

public class VMSWorkFlowTester_RT{

	private VMSWorkFlow vmsworkflow;
	
	protected void setUp()  throws Exception {
		vmsworkflow = new VMSWorkFlow();
	}
	
	public void test1() throws Exception {
		System.out.println("Test case 1");
		setUp();
		vmsworkflow.createMeeting();
		assert vmsworkflow.inactiveMeeting(T, A, M) : "1_1";
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1";
		vmsworkflow.openMeeting(T, A, M);
		assert vmsworkflow.meetingInSession() : "1_1_1";
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1_1";
		vmsworkflow.closeMeeting();
		assert vmsworkflow.closedMeeting() : "1_1_1_1";
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1_1_1";
	}

	public void test2() throws Exception {
		System.out.println("Test case 2");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.openMeeting(T, A, M);
		vmsworkflow.leave();
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1_1_2";
	}

	public void test3() throws Exception {
		System.out.println("Test case 3");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.openMeeting(T, A, M);
		vmsworkflow.askToSpeak();
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1_1_3";
		assert vmsworkflow.waitingToSpeak() : "1_1_1_3";
		vmsworkflow.handOver();
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1_1_3_1";
		assert vmsworkflow.allowToSpeak() : "1_1_1_3_1";
		vmsworkflow.speak();
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "1_1_1_3_1_1";
		assert vmsworkflow.speaking() : "1_1_1_3_1_1";
		vmsworkflow.closeMeeting();
		assert vmsworkflow.closedMeeting() : "";
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "";
	}

	public void test4() throws Exception {
		System.out.println("Test case 4");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.openMeeting(T, A, M);
		vmsworkflow.askToSpeak();
		vmsworkflow.handOver();
		vmsworkflow.speak();
		vmsworkflow.over();
		assert vmsworkflow.meetingInSession() : "";
		assert vmsworkflow.meetingAttributes(T1, A1, M1) : "";
	}

	public void test5() throws Exception {
		System.out.println("Test case 5");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.setMeetingTitle(T, A, M, T1, A1, M1);
		assert vmsworkflow.inactiveMeeting(T1, A, M) : "1_1_2";
		vmsworkflow.openMeeting(T1, A, M);
		assert vmsworkflow.meetingInSession() : "1_1_2_1";
		vmsworkflow.closeMeeting();
		assert vmsworkflow.closedMeeting() : "1_1_2_1_1";
	}

	public void test6() throws Exception {
		System.out.println("Test case 6");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.setMeetingTitle(T, A, M, T1, A1, M1);
		vmsworkflow.openMeeting(T1, A, M);
		vmsworkflow.leave();
	}

	public void test7() throws Exception {
		System.out.println("Test case 7");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.setMeetingTitle(T, A, M, T1, A1, M1);
		vmsworkflow.openMeeting(T1, A, M);
		vmsworkflow.askToSpeak();
		assert vmsworkflow.waitingToSpeak() : "1_1_2_1_3";
		vmsworkflow.handOver();
		assert vmsworkflow.allowToSpeak() : "1_1_2_1_3_1";
		vmsworkflow.speak();
		assert vmsworkflow.speaking() : "";
		vmsworkflow.closeMeeting();
		assert vmsworkflow.closedMeeting() : "";
	}

	public void test8() throws Exception {
		System.out.println("Test case 8");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.setMeetingTitle(T, A, M, T1, A1, M1);
		vmsworkflow.openMeeting(T1, A, M);
		vmsworkflow.askToSpeak();
		vmsworkflow.handOver();
		vmsworkflow.speak();
		vmsworkflow.over();
		assert vmsworkflow.meetingInSession() : "";
	}

	public void test9() throws Exception {
		System.out.println("Test case 9");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.setMeetingAgenda(T, A, M, T1, A1, M1);
		assert vmsworkflow.inactiveMeeting(T, A1, M) : "1_1_3";
		vmsworkflow.openMeeting(T, A1, M);
		assert vmsworkflow.meetingInSession() : "1_1_3_1";
	}

	public void test10() throws Exception {
		System.out.println("Test case 10");
		setUp();
		vmsworkflow.createMeeting();
		vmsworkflow.setMeetingModerator(T, A, M, T1, A1, M1);
		assert vmsworkflow.inactiveMeeting(T, A, M1) : "1_1_4";
		vmsworkflow.openMeeting(T, A, M1);
		assert vmsworkflow.meetingInSession() : "1_1_4_1";
	}

	public void testAll() throws Exception {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
	}

	public static void main(String[] args) throws Exception {
		 new VMSWorkFlowTester_RT().testAll();
	}

}