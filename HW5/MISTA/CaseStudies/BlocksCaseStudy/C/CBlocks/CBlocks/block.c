#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Block.h"

LISTSTRPTR ontables = NULL;
LISTSTRPTR clears = NULL;
LISTSTRPTR ons = NULL;
char holding[BLOCK] = "";
int handempty = 1;

struct LISTSTR
{
  char str[STRING];
  char a[BLOCK];
  char b[BLOCK];
  struct LISTSTR *next; // points to next node
};

// LINKLIST ////////////////////////////////////////////////////////////////////////////////////
LISTSTRPTR get_list( char n[] )
{
	LISTSTRPTR node;
	node = malloc( sizeof(LISTSTR) );
	strcpy(node->str, n);
	node->next = NULL;
	return node;	
}

// inserts node at end
LISTSTRPTR insert_str( char n[], LISTSTRPTR first)
{


	LISTSTRPTR node;

    node = get_list(n);

    if (first == NULL)
	{
	   node->next = first;
	   first = node;
	}
	else
	{
	   node->next = first->next;
	   first->next = node;
	}
	//printf("%s is in list\n", node);   
	return first;
}

int in_list(char n[], LISTSTRPTR first)
{
 LISTSTRPTR temp = first;
 while (temp != NULL)
 {
  if(!strcmp(temp->str,n))
  {	
   return 1;
  }
  temp = temp->next;
 }
 
 return 0;
}

// REMOVE node
LISTSTRPTR remove_str(char n[], LISTSTRPTR first)
{
 LISTSTRPTR temp;
 LISTSTRPTR temp2;
 LISTSTRPTR temp3;

 temp = first;
 temp2 = temp;

 if(temp==NULL) // No numbers in list
  {
   return first; // RETURN
  } 
  
 else if(!strcmp(temp->str,n)) // 1 number in list
 {
    temp2 = temp->next;
    first = temp2;

    free(temp); 

    return first;
 }
 else  // more than 1 number in list
 {
  while(temp->next != NULL) // runs through list
   {
    if(!strcmp(temp->next->str,n))
    {
     temp2 = temp->next; 
     temp->next = temp2->next;                    	     
     
     free(temp2);
     
     return first; // RETURN
    }
    
    temp = temp->next;
    temp2 = temp;
    
   }
    return first; // RETURN
 }
 
}

// prints out the value of all nodes
void print_list( LISTSTRPTR first )
{
	LISTSTRPTR move;
	move = first;
	while (move != NULL)
	{
		printf(" %s ", move->str);
		move = move->next;
	}
	printf("\n");
}
///////////////////////////////////////////////////////////////////////////////////////////////////
//LINKLIST ON

LISTSTRPTR ONget_list( char n[], char m[] )
{

	LISTSTRPTR node;
	node = malloc( sizeof(LISTSTR) );
	strcpy(node->a, n);
	strcpy(node->b, m);
	node->next = NULL;
	return node;	
}

// inserts node at end
LISTSTRPTR ONinsert_str( char n[], char m[], LISTSTRPTR first)
{

	LISTSTRPTR node;

    node = ONget_list(n, m);

    if (first == NULL)
	{
	   node->next = first;
	   first = node;
	}
	else
	{
	   node->next = first->next;
	   first->next = node;
	}
 
	return first;
}

int ONin_list(char n[], char m[], LISTSTRPTR first)
{
	
		 LISTSTRPTR temp = first;
 while (temp != NULL)
 {
  if(!strcmp(temp->a,n) && !strcmp(temp->b,m))
  {	
   return 1;
  }
  temp = temp->next;
 }
 return 0;
}

LISTSTRPTR ONremove_str(char n[], char m[], LISTSTRPTR first)
{
 LISTSTRPTR temp;
 LISTSTRPTR temp2;

 temp = first;
 temp2 = temp;

 if(temp==NULL) // No numbers in list
  {
   return first; // RETURN
  } 
  
 else if(!strcmp(temp->a,n) && !strcmp(temp->b,m)) // 1 number in list
 {
    temp2 = temp->next;
    first = temp2;
    free(temp); 

    return first;
 }
 else  // more than 1 number in list
 {
  while(temp->next != NULL) // runs through list
   {
    if(!strcmp(temp->next->a,n) && !strcmp(temp->next->b,m))
    {
     temp2 = temp->next; 
     temp->next = temp2->next;
     
     free(temp2);
     return first ; // RETURN
    }
    temp = temp->next;
    temp2 = temp;
   }
    return first; // RETURN
 }
 
	}

// prints out the value of all nodes
void ONprint_list( LISTSTRPTR first )
{
	LISTSTRPTR move;
	move = first;
	while (move != NULL)
	{
		printf(" %s / %s ", move->a, move->b);
		move = move->next;
	}
	printf("\n");
}
///////////////////////////////////////////////////////////////////////////////////////////////////
	
void print_state()
{
        printf("\n ontables: ");
		print_list(ontables);
		printf("\n clears: ");
		print_list(clears);
		printf("\n ons: ");
		ONprint_list(ons);
		if (strcmp(holding, ""))
		{
		printf("\n holding: ");
		printf(" %s \n", holding);
		}

}	
	
void pickup(char a[]) 
{
        if ((in_list(a, ontables)) && (in_list(a, clears)) && handempty)
		{
			ontables = remove_str(a, ontables );
            clears = remove_str(a, clears );
            
			handempty = 0;
			strcpy(holding, a);
		}
		else
			printf("Cannot pickup %s", a);
}

void putdown(char a[])
{
		if (holding != "")
		{
			strcpy(holding, "");
			ontables = insert_str(a, ontables);
			clears = insert_str(a, clears);
			
			handempty = 1;
		}
		else
			printf("Cannot putdown %s", a);
}

void stack(char a[], char b[])
{
		if (a != b && holding != "" && !strcmp(holding,a) && (in_list(b, clears)))
		{
			handempty = 1;
			
			ons = ONinsert_str(a , b, ons);
			clears = remove_str(b, clears);
			clears = insert_str(a, clears);
			strcpy(holding, "");
		}
		else
			printf("Cannot stack %s on %s",a,b);
}

void unstack(char a[], char b[])
{

        

        
		if (handempty && (in_list(a, clears)) && (ONin_list(a, b, ons)))
		{
		
		   
			handempty = 0;
			clears = remove_str(a, clears);
			
			ons = ONremove_str(a, b, ons);
			strcpy(holding, a);
			clears = insert_str(b, clears);
			
		}
		else
			printf("Cannot unstack %s from %s",a,b);
}


