package blocks;

public class ON {
	private String a, b;
	
	public ON(String a, String b){
		this.a = a;
		this.b = b;
	}
	
	public boolean equals(ON on2){
		return a.equals(on2.a) && b.equals(on2.b);
	}
	
	public String toString(){
		return "on("+a+", "+b+")";
	}
}
