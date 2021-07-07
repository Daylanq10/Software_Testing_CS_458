using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace Blocks
{
    class Block
    {
 /*       static void Main(string[] args)
        {
        Block block = new Block();
		block.Init();
		block.Unstack("1", "3");
		block.Putdown("1");
		block.Pickup("6");
		block.Stack("6", "1");
		Console.WriteLine("Final state: "+block.ToString());
        }
        */
        private List<string> ontables = new List<string>();
        private List<string> clears = new List<string>();
        private List<ON> ons = new List<ON>();
        private string holding = null;
        private bool handempty = true;

        public Block()
        {
        }

        public void Pickup(String a){
		if (ontables.Contains(a) && clears.Contains(a) && handempty){
			ontables.Remove(a);
			clears.Remove(a);
			handempty = false;
			holding = a;
		}
		else
            Console.WriteLine("Cannot pickup " + a);
	    }

        public void Putdown(String a){
		if (holding!=null){
			holding = null;
			ontables.Add(a);
			clears.Add(a);
			handempty = true;
		}
		else
            Console.WriteLine("Cannot put down " + a);
	    }

        public void Stack(String a, String b){
		if (a!=b && holding!=null && holding==a && clears.Contains(b)){	
			handempty=true;
			ons.Add(new ON(a,b));
			clears.Remove(b);
			clears.Add(a);
			holding = null;
		}
		else
            Console.WriteLine("Cannot stack " + a + " on " + b);
	    }

        public void Unstack(String a, String b){
		if (handempty && clears.Contains(a) && IsOn(a, b)){
			handempty = false;
			clears.Remove(a);
			RemoveOn(a, b);
			holding = a; 
			clears.Add(b);
		}
		else
            Console.WriteLine("Cannot unstack " + a + " from " + b);
	    }

        public List<string> GetOntables()
        {
            return ontables;
        }

        public bool IsOntable(string a)
        {
            return ontables.Contains(a);
        }

        public List<string> GetClears()
        {
            return clears;
        }

        public bool IsClear(String a)
        {
            return clears.Contains(a);
        }

        public List<ON> GetOns()
        {
            return ons;
        }

        public bool IsOn(string a, string b){
		ON on2 = new ON(a, b);
        for(int i=0; i < ons.Count; i++) 
			if (ons[i].Equals(on2))
				return true;
		return false;
	    }

        private void RemoveOn(string a, string b)
        {
            ON on2 = new ON(a, b);
            for (int i = ons.Count - 1; i >= 0; i--)
            {
                if (ons[i].Equals(on2))
                {
                    ons.RemoveAt(i);
                    return;
                }
            }
        }

        public string GetHolding()
        {
            return holding;
        }

        public bool IsHolding(string thing)
        {
            return holding!=null && holding.Equals(thing);
        }

        public bool IsHandempty()
        {
            return handempty;
        }

        public void SetHandempty(bool empty)
        {
            handempty = empty;
        }

        public override String ToString(){
		String str = "";
        for(int i=0; i < ontables.Count; i++) 
			str += "\n\tontable("+ontables[i]+")";
        for(int i=0; i < clears.Count; i++) 
			str += "\n\tclear("+clears[i]+")";
        for(int i=0; i < ons.Count; i++) 
			str += "\n\t"+ ons[i].ToString();
		if (holding!=null)
			str += "\n\tholding("+ holding+")";
		if (handempty)
			str += "\n\thandempty(\"r\")";
		return str;
	    }

        void Init()
        {
            ontables.Add("3");
            ontables.Add("6");
            clears.Add("1");
            clears.Add("6");
            ons.Add(new ON("1", "3"));
            handempty = true;
        }
    }

    public class ON
    {
        private string a, b;

        public ON(string a, string b)
        {
            this.a = a;
            this.b = b;
        }

        public bool Equals(ON on2)
        {
            return a.Equals(on2.a) && b.Equals(on2.b);
        }

        public override string ToString()
        {
            return "on(" + a + ", " + b + ")";
        }
    }
}
