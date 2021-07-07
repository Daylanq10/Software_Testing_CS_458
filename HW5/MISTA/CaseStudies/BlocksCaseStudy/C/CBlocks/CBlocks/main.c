#include "Block.h"

void init()
{
// init
		ontables = insert_str("3", ontables);
		ontables = insert_str("6", ontables);
		clears = insert_str("1", clears);
		clears = insert_str("6", clears);
		ons = ONinsert_str("1","3", ons);
		handempty = 1;
}
/*
int main()
{    
        init();
		unstack("1", "3");
		putdown("1");
		pickup("6");
	    stack("6", "1");
	    print_state();

     system("PAUSE");
     

    return 0;  
}
*/