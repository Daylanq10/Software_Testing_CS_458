package triangle.mutant5;

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
		
//		if (a<b+c && b<a+c && c<b+a){  // missing if 
			if (a==b && b==c)
				return TriangleType.EQUILATERAL;
			else
			if (a==b || b==c || c==a)
				return TriangleType.ISOSCELES;
			else
				return TriangleType.SCALENE;
//		}
//		else
//			return TriangleType.NOTRIANGLE;
	}

}

//Reachability = a,b,c>0, 
//Necessity = b=a
//Propagation = c>2a
//Test Case - (a=1, b=1, c=3) -> NoTriangle
