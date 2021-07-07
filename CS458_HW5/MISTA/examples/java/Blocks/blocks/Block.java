package blocks;

import java.util.ArrayList;

public class Block {

	private ArrayList<String> ontables = new ArrayList<String>();
	private ArrayList<String> clears = new ArrayList<String>();
	private ArrayList<ON> ons = new ArrayList<ON>();
	private String holding = null;
	private boolean handempty = true;
	
	public Block(){
	}
	
	public void pickup(String a){
		if (ontables.contains(a) && clears.contains(a) && handempty){
			ontables.remove(a);
			clears.remove(a);
			handempty = false;
			holding = a;
		}
		else 
			System.out.println("Cannot pickup "+a);
	}
	
	public void putdown(String a){
		if (holding!=null){
			holding = null;
			ontables.add(a);
			clears.add(a);
			handempty = true;
		}
		else 
			System.out.println("Cannot put down "+a);
	}
	
	public void stack(String a, String b){
		if (a!=b && holding!=null && holding==a && clears.contains(b)){	
			handempty=true;
			ons.add(new ON(a,b));
			clears.remove(b);
			clears.add(a);
			holding = null;
		}
		else 
			System.out.println("Cannot stack "+a +" on "+b);
	}

	public void unstack(String a, String b){
		if (handempty && clears.contains(a) && isOn(a, b)){
			handempty = false;
			clears.remove(a);
			removeOn(a, b);
			holding = a; 
			clears.add(b);
		}
		else
			System.out.println("Cannot unstack "+a+" from "+b);
	}

	public ArrayList<String> getOntables(){
		return ontables;
	}

	public boolean isOntable(String a){
		return ontables.contains(a);
	}
	
	public ArrayList<String> getClears(){
		return clears;
	}

	public boolean isClear(String a){
		return clears.contains(a);
	}

	public ArrayList<ON> getOns(){
		return ons;
	}
	public boolean isOn(String a, String b){
		ON on2 = new ON(a, b);
		for (ON on: ons)
			if (on.equals(on2))
				return true;
		return false;
	}

	private void removeOn(String a, String b){
		ON on2 = new ON(a, b);
		for (int i=ons.size()-1; i>=0; i--){
			if (ons.get(i).equals(on2)){
				ons.remove(i);
				return;
			}
		}
	}
	
	public String getHolding(){
		return holding;
	}

	public boolean isHolding(String thing){
		return holding!=null && holding.equalsIgnoreCase(thing);
	}
	
	public boolean isHandempty(){
		return handempty;
	}

	public void setHandempty(boolean empty){
		handempty = empty;
	}

	public String toString(){
		String str = "";
		for (String ontable: ontables)
			str += "\n\tontable("+ontable+")";
		for (String clear: clears)
			str += "\n\tclear("+clear+")";
		for (ON on: ons)
			str += "\n\t"+ on;
		if (holding!=null)
			str += "\n\tholding("+ holding+")";
		if (handempty)
			str += "\n\thandempty(\"r\")";
		return str;
	}
	
	void init(){
		ontables.add("3");
		ontables.add("6");
		clears.add("1");
		clears.add("6");
		ons.add(new ON("1","3"));
		handempty = true;
	}
	
	public static void main(String[] args){
		Block block = new Block();
		block.init();
		block.unstack("1", "3");
		block.putdown("1");
		block.pickup("6");
		block.stack("6", "1");
		System.out.println("Final state: "+block);
	}
}
