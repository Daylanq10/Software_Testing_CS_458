#include <stdio.h>

#define BLOCK 16
#define STRING 256

typedef struct LISTSTR LISTSTR;
typedef struct LISTSTR * LISTSTRPTR;

extern LISTSTRPTR ontables;
extern LISTSTRPTR clears;
extern LISTSTRPTR ons;
extern char holding[BLOCK];
extern int handempty;

extern int in_list(char n[], LISTSTRPTR first);
extern LISTSTRPTR insert_str( char n[], LISTSTRPTR first);

extern int ONin_list(char n[], char m[], LISTSTRPTR first);
extern LISTSTRPTR ONinsert_str( char n[], char m[], LISTSTRPTR first);

extern void pickup(char a[]);
extern void putdown(char a[]);
extern void stack(char a[], char b[]);
extern void unstack(char a[], char b[]);

