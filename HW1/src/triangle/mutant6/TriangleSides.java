package triangle.mutant6;

public class TriangleSides {
	
	public enum TriangleType {EQUILATERAL, SCALENE, ISOSCELES, NOTRIANGLE};
	
	private int a, b, c;

	public TriangleSides(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public TriangleType reportTriangleType() {
		if (a<=0 || b<=0 || c<=0)
			return TriangleType.NOTRIANGLE;
		
		if (a<b+c && b<a+c && c<b+a){
			if (a==b && b==c)
				return TriangleType.EQUILATERAL;
			else
			if (a==b || b<=c || c==a)   // b==c
				return TriangleType.ISOSCELES;
			else
				return TriangleType.SCALENE;
		}
		else
			return TriangleType.NOTRIANGLE;
	}

}

//Reachability = a,b,c>0, a<b+c, b<a+c, c<b+a, a!=b
//Necessity = a!=b,c
//Propagation = b<c
//Test Case - (a=2, b=3, c=4) -> SCALENE
