/*
ID: zeng.aa1
LANG: C
TASK: gift1
*/

#include <stdio.h>
#include <string.h>

int find (char name[256], char names[][256], int NP) {
    int i;
    for (i = 0; i < NP; i++)
        if (!strcmp(name, names[i]))
            return i;
    return -1;
}

int main (void) {
    FILE *f, *g;
    f = fopen ("gift1.in", "r");
    g = fopen ("gift1.out", "w");
    int NP;
    fscanf (f, "%d", &NP);
    char names[NP][256], name[256];
    int money[NP], i, j, k, u, m, d;
    for (i = 0; i < NP; i++) {
        fscanf (f, "%s", names[i]);
        money[i] = 0;
    }
    for (i = 0; i < NP; i++) {
        fscanf (f, "%s", name);
        j = find (name, names, NP);
        fscanf (f, "%d %d", &m, &d);
        for (k = 0; k < d; k++) {
            fscanf (f, "%s", name);
            u = find (name, names, NP);
            money[j] -= m / d;
            money[u] += m / d;
        }
    }
    for (i = 0; i < NP; i++)
        fprintf (g, "%s %d\n", names[i], money[i]);
    fclose (f); fclose (g);
    return 0;
}
