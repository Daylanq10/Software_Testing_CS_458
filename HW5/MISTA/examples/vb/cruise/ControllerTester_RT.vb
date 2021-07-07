'Test code generated by FAST

Imports System

Namespace Test

	Public Class ControllerTester_RT

		Private controller As Controller
		
		Public Sub Init() 
			controller = New Controller()
		End Sub
		
		Public Sub Assert(ByVal condition As Boolean, ByVal errorMessage As String)
			If Not condition Then
				Console.WriteLine(errorMessage)
				Throw New ApplicationException
			End If
		End Sub

		Public Sub Test1() 
			Console.WriteLine("Test case 1")
			Init()
			EngineOn()
			Assert(GetState() = ACTIVE, "Test failed at 1_1")
			EngineOff()
			Assert(GetState() = INACTIVE, "Test failed at 1_1_1")
		End Sub

		Public Sub Test2() 
			Console.WriteLine("Test case 2")
			Init()
			EngineOn()
			Accelerator()
			Assert(GetState() = ACTIVE, "Test failed at 1_1_2")
		End Sub

		Public Sub Test3() 
			Console.WriteLine("Test case 3")
			Init()
			EngineOn()
			Brake()
			Assert(GetState() = ACTIVE, "Test failed at 1_1_3")
		End Sub

		Public Sub Test4() 
			Console.WriteLine("Test case 4")
			Init()
			EngineOn()
			On()
			Assert(GetState() = CRUISING, "Test failed at 1_1_4")
			EngineOff()
			Assert(GetState() = INACTIVE, "Test failed at 1_1_4_1")
		End Sub

		Public Sub Test5() 
			Console.WriteLine("Test case 5")
			Init()
			EngineOn()
			On()
			Accelerator()
			Assert(GetState() = STANDBY, "Test failed at 1_1_4_2")
			EngineOff()
			Assert(GetState() = INACTIVE, "Test failed at 1_1_4_2_1")
		End Sub

		Public Sub Test6() 
			Console.WriteLine("Test case 6")
			Init()
			EngineOn()
			On()
			Accelerator()
			On()
			Assert(GetState() = CRUISING, "Test failed at 1_1_4_2_2")
		End Sub

		Public Sub Test7() 
			Console.WriteLine("Test case 7")
			Init()
			EngineOn()
			On()
			Accelerator()
			Resume()
			Assert(GetState() = CRUISING, "Test failed at 1_1_4_2_3")
		End Sub

		Public Sub Test8() 
			Console.WriteLine("Test case 8")
			Init()
			EngineOn()
			On()
			Brake()
			Assert(GetState() = STANDBY, "Test failed at 1_1_4_3")
		End Sub

		Public Sub Test9() 
			Console.WriteLine("Test case 9")
			Init()
			EngineOn()
			On()
			Off()
			Assert(GetState() = STANDBY, "Test failed at 1_1_4_4")
		End Sub

		Public Sub TestAll()
			Test1()
			Test2()
			Test3()
			Test4()
			Test5()
			Test6()
			Test7()
			Test8()
			Test9()
		End Sub

		Public Shared Sub Main()
			Dim Tester As ControllerTester_RT = New ControllerTester_RT
			Tester.TestAll()
		End Sub

	End Class

End Namespace