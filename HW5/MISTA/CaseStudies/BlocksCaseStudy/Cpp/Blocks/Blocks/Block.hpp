#include <iostream>
#include <string>
#include <vector>

using namespace std;
class ON
	{
	public:
		ON(string a, string b);
		bool Equals(ON on2);
		string ToString();
		string a, b;
};

class Block
      {

  public:
		private:
		vector<string> ontables;
		vector<string> clears;
		vector<ON> ons;
		string holding;
		bool handempty;

		public:
		void removeOn(string a, string b);
		void pickup(string a);
		void putdown(string a);
		void stack(string a, string b);
		void unstack(string a, string b);
		vector<string> *getOntables();
		bool isOntable(string a);
		vector<string> *getClears();
		bool isClear(string a);
		vector<ON> *getOns();
		bool isOn(string a, string b);
		string getHolding();
		bool isHolding(string thing);
		bool isHandempty();
		void setHandempty(bool empty);
		string ToString();


};



