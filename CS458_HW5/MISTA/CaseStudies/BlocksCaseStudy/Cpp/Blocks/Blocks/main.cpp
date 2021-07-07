#include <iostream>
#include <string>
#include <vector>

#include "Block.hpp"

using namespace std;

class Blocktester{

	Block block;

	void setUp(void){
		block = Block();
		(*block.getClears()).push_back("B3");
		(*block.getClears()).push_back("B6");
		block.setHandempty(true);
		(*block.getOntables()).push_back("B3");
		(*block.getOntables()).push_back("B6");
		cout << "\nFinal state: " << block.ToString() << endl;

	}

	public: void test1_1_1() {
		cout << "Test case 1_1_1";
		setUp();
		block.pickup("B3");
		block.putdown("B3");
		system("PAUSE");

	}

	void init(void){
		block = Block();
		(*block.getOntables()).push_back("3");
		(*block.getOntables()).push_back("6");
		(*block.getClears()).push_back("1");
		(*block.getClears()).push_back("6");
		(*block.getOns()).push_back(ON("1","3"));
		block.setHandempty(true);
		cout << "\nFinal state: " << block.ToString() << endl;

	}

	public:
	void test1(void){
		cout << "Test 1";
        init();
	    block.unstack("1", "3");
		block.putdown("1");
		block.pickup("6");
	    block.stack("6", "1");
		cout << "\nFinal state: " << block.ToString() << endl;
		system("PAUSE");

	  }

    };
      
//************************************************************END BLOCK
/*
	int main(string args[])
	{
		Blocktester blocktester;
        blocktester.test1_1_1();
//        blocktester.test1();
		return 0;
	}

	*/