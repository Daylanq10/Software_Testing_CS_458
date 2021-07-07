Imports System
Imports System.Collections.Generic
Imports System.Linq
Imports System.Text
Imports System.Collections

Namespace Blocks

    Class Block

        Private ontables As New List(Of String)()
        Private clears As New List(Of String)()
        Private ons As New List(Of [OnBlock])()
        Private holding As String = Nothing
        Private handempty As Boolean = True

        Public Sub New()
        End Sub

        Public Sub Pickup(ByVal a As [String])
            If ontables.Contains(a) AndAlso clears.Contains(a) AndAlso handempty Then
                ontables.Remove(a)
                clears.Remove(a)
                handempty = False
                holding = a
            Else
                Console.WriteLine("Cannot pickup " & a)
            End If
        End Sub

        Public Sub Putdown(ByVal a As [String])
            If holding IsNot Nothing Then
                holding = Nothing
                ontables.Add(a)
                clears.Add(a)
                handempty = True
            Else
                Console.WriteLine("Cannot put down " & a)
            End If
        End Sub

        Public Sub Stack(ByVal a As [String], ByVal b As [String])
            If a <> b AndAlso holding IsNot Nothing AndAlso holding = a AndAlso clears.Contains(b) Then
                handempty = True
                ons.Add(New [OnBlock](a, b))
                clears.Remove(b)
                clears.Add(a)
                holding = Nothing
            Else
                Console.WriteLine(("Cannot stack " & a & " on ") + b)
            End If
        End Sub

        Public Sub Unstack(ByVal a As [String], ByVal b As [String])
            If handempty AndAlso clears.Contains(a) AndAlso IsOn(a, b) Then
                handempty = False
                clears.Remove(a)
                RemoveOn(a, b)
                holding = a
                clears.Add(b)
            Else
                Console.WriteLine(("Cannot unstack " & a & " from ") + b)
            End If
        End Sub

        Public Function GetOntables() As List(Of String)
            Return (ontables)
        End Function

        Public Function IsOntable(ByVal a As String) As Boolean
            Return (ontables.Contains(a))
        End Function

        Public Function GetClears() As List(Of String)
            Return (clears)
        End Function

        Public Function IsClear(ByVal a As [String]) As Boolean
            Return (clears.Contains(a))
        End Function

        Public Function GetOns() As List(Of [OnBlock])
            Return (ons)
        End Function

        Public Function IsOn(ByVal a As String, ByVal b As String) As Boolean
            Dim on2 As New [OnBlock](a, b)
            For i As Integer = 0 To ons.Count - 1
                If ons(i).Equals(on2) Then
                    Return (True)
                End If
            Next
            Return (False)
        End Function

        Private Sub RemoveOn(ByVal a As String, ByVal b As String)
            Dim on2 As New [OnBlock](a, b)
            For i As Integer = ons.Count - 1 To 0 Step -1
                If ons(i).Equals(on2) Then
                    ons.RemoveAt(i)
                    Exit Sub
                End If
            Next
        End Sub

        Public Function GetHolding() As String
            Return (holding)
        End Function

        Public Function IsHolding(ByVal thing As String) As Boolean
            Return (holding IsNot Nothing AndAlso holding.Equals(thing))
        End Function

        Public Function IsHandempty() As Boolean
            Return (handempty)
        End Function

        Public Sub SetHandempty(ByVal empty As Boolean)
            handempty = empty
        End Sub

        Public Overloads Overrides Function ToString() As [String]
            Dim str As [String] = ""
            For i As Integer = 0 To ontables.Count - 1
                str += vbLf & vbTab & "ontable(" & ontables(i) & ")"
            Next
            For i As Integer = 0 To clears.Count - 1
                str += vbLf & vbTab & "clear(" & clears(i) & ")"
            Next
            For i As Integer = 0 To ons.Count - 1
                str += vbLf & vbTab & ons(i).ToString()
            Next
            If holding IsNot Nothing Then
                str += vbLf & vbTab & "holding(" & holding & ")"
            End If
            If handempty Then
                str += vbLf & vbTab & "handempty(""r"")"
            End If
            Return (str)
        End Function

        Private Sub Init()
            ontables.Add("3")
            ontables.Add("6")
            clears.Add("1")
            clears.Add("6")
            ons.Add(New [OnBlock]("1", "3"))
            handempty = True
        End Sub

        '        Shared Sub Main()
        '        Dim block As New Block()
        '            block.Init()
        '           block.Unstack("1", "3")
        '           block.Putdown("1")
        '           block.Pickup("6")
        '           block.Stack("6", "1")
        '           Console.WriteLine("Final state: " & block.ToString())
        '       End Sub

    End Class

    Class OnBlock
        Private a As String, b As String

        Public Sub New(ByVal a As String, ByVal b As String)
            Me.a = a
            Me.b = b
        End Sub

        Public Function Equals(ByVal on2 As [OnBlock]) As Boolean
            Return (a.Equals(on2.a) AndAlso b.Equals(on2.b))
        End Function

        Public Overloads Overrides Function ToString() As String
            Return ("on(" & a & ", ") + b & ")"
        End Function

    End Class

End Namespace

