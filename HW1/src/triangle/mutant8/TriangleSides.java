package triangle.mutant8;

public class TriangleSides {
	
	public enum TriangleType {EQUILATERAL, SCALENE, ISOSCELES, NOTRIANGLE};
	
	private int a, b, c;

	public TriangleSides(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public TriangleType reportTriangleType() {
		if (a<=0 && b<=0 && c<=0)   //  (a<=0 || b<=0 || c<=0)  
			return TriangleType.NOTRIANGLE;
		
		if (a<b+c && b<a+c && c<b+a){
			if (a==b && b==c)
				return TriangleType.EQUILATERAL;
			else
			if (a==b || b==c || c==a)
				return TriangleType.ISOSCELES;
			else
				return TriangleType.SCALENE;
		}
		else
			return TriangleType.NOTRIANGLE;
	}

}

//Reachability = a or b or c <= 0 but not all
//Necessity = a>0, 0<b<=a
//Propagation = c<=0
//Test Case - (a=1,b=1,c=0) -> NotTriangle (Not possible to hit inside if statement, defaults ot else statement of nottriangle)
