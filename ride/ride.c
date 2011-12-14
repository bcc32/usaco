/*
ID: zeng.aa1
LANG: C
TASK: ride
*/

#include <stdio.h>
#include <string.h>

#define OFFSET 64

int main (void) {
    FILE *f, *g;
    f = fopen ("ride.in", "r");
    g = fopen ("ride.out", "w");
    char str1[7], str2[7];
    fscanf (f, "%s", str1);
    fscanf (f, "%s", str2);
    long p1 = 1, p2 = 1;
    int i;
    for (i = 0; i < strlen(str1); i++)
        p1 *= (int)str1[i] - OFFSET;
    for (i = 0; i < strlen(str2); i++)
        p2 *= (int)str2[i] - OFFSET;
    if(!((p1 - p2) % 47))
        fprintf (g, "GO\n");
    else
        fprintf (g, "STAY\n");
    fclose(f); fclose(g);
    return 0;
}
