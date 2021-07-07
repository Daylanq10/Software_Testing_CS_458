#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

#include "Block.hpp"
using namespace std;


//**************************************************************START ON

	
	ON::ON(string a, string b)
	{
		this->a = a;
		this->b = b;
	
	}
	
	bool ON::Equals(ON on2)
	{
		return a == on2.a &&  b == on2.b;
	}

	string ON::ToString()
	{
		return "on("+a+", "+b+")";
	}

// *******************************************************************END ON


	void Block::pickup(string a)
	{
        vector<string>::iterator p;
        vector<string>::iterator p2;
        bool d, d2;
        p = find(ontables.begin(), ontables.end(), a);
        p2 = find(clears.begin(), clears.end(), a);
        if( p == ontables.end() ) {
            d = false;
        }
        else {
             d = true;
        }
        if( p2 == clears.end() ) {
            d2 = false;
        }
        else {
             d2 = true;
        }

        
		if (d && d2 && handempty)
		{
			p = ontables.erase( p );
            p2 = clears.erase( p2 );

			handempty = false;
			holding = a;
		}
		else
			cout << "Cannot pickup " << a;
	}

	void Block::putdown(string a)
	{
		if (holding!="")
		{
			holding = "";
			ontables.push_back(a);
			clears.push_back(a);
			handempty = true;
		}
		else
			cout << "Cannot put down " << a;
	}

	void Block::stack(string a, string b)
	{
        vector<string>::iterator p;
        bool d;
        p = find(clears.begin(), clears.end(), b);
        if( p == clears.end() ) {
            d = false;
        }
        else {
             d = true;
        }
 
		if (a!=b && holding!="" && holding == a && d)
		{
			handempty=true;
			ons.push_back(ON(a , b));
			p = clears.erase( p );
			clears.push_back(a);
			holding = "";
		}
		else
			cout << "Cannot stack " << a << " on " << b;
	}

	void Block::unstack(string a, string b)
	{
        vector<string>::iterator p;
        bool d;
        p = find(clears.begin(), clears.end(), a);
        if( p == clears.end() ) {
            d = false;
        }
        else {
             d = true;
        }
        
		if (handempty && d && (isOn(a, b)))
		{
			handempty = false;
			p = clears.erase( p );
			removeOn(a, b);
			holding = a;
			clears.push_back(b);
		}
		else
			cout << "Cannot unstack " << a << " from " << b;
	}

	vector<string> * Block:: getOntables()
	{
		return &ontables;
	}

	bool Block::isOntable(string a)
	{
        vector<string>::iterator p;
        bool d;
        p = find(ontables.begin(), ontables.end(), a);
        if( p == ontables.end() ) {
            d = false;
        }
        else {
             d = true;
        }
        
		return d;
	} 

	vector<string> * Block:: getClears()
	{
		return &clears;
	}

	bool Block::isClear(string a)
	{
        vector<string>::iterator p;
        bool d;
        p = find(clears.begin(), clears.end(), a);
        if( p == clears.end() ) {
            d = false;
        }
        else {
             d = true;
        }
        
		return d;
	} 

	vector<ON> * Block::getOns()
	{
		return &ons;
	}

	bool Block::isOn(string a, string b)
	{
		ON on2(a, b);
		for (unsigned on = 0; on < ons.size(); on++)
        	if (ons[on].Equals(on2))
				return true;
		return false;
	}

	void Block::removeOn(string a, string b)
	{
         vector<ON>::iterator p;
        
         ON on2(a, b);
		for (unsigned int i=ons.size() - 1; i>=0; i--)
		{            
			if (ons[i].Equals(on2))
			{
               //p = ons[i];
               //p = find(ons.begin(), ons.end(), on2);
               ons.erase(ons.begin()+i);
               // ons[i].erase;
			   //ons.remove(i);
				return;
			}
		}
	}

	string Block::getHolding()
	{
		return holding;
	}

	bool Block::isHolding(string thing)
	{
		return holding != "" && holding == thing;
	}

	bool Block::isHandempty()
	{
		return handempty;
	}

	void Block::setHandempty(bool empty)
	{
		handempty = empty;
	}

	string Block::ToString()
	{
		string str = "";
		unsigned i;
		for(i = 0; i < ontables.size(); i++)
        	str += "\n\tontable("+ontables[i]+")";
		for(i = 0; i < clears.size(); i++)
        	str += "\n\tclear("+clears[i]+")";
		for(i = 0; i < ons.size(); i++)
        	str += "\n\t" +ons[i].a+ " " +ons[i].b;
		if (holding!="")
			str += "\n\tholding("+ holding+")";
		if (handempty)
			str += "\n\thandempty(\"r\")";
		return str;
	}
