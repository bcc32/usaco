/*
ID: zeng.aa1
LANG: C
TASK: friday
*/

#include <stdio.h>

int l (int y) {
    return !(y % 400) ? 1 : (!(y % 100) ? 0 : (!(y % 4) ? 1 : 0));
}

int main (void) {
    FILE *f, *g;
    f = fopen ("friday.in", "r");
    g = fopen ("friday.out", "w");
    int t[7] = {0};
    int i = 3, y, NP;
    fscanf (f, "%d", &NP);
    for (y = 1900; y < 1900 + NP; y++) {
        i = (i + 3) % 7; t[i]++;
        i = (i + 3) % 7; t[i]++;
        i = (i + l (y)) % 7; t[i]++;
        i = (i + 3) % 7; t[i]++;
        i = (i + 2) % 7; t[i]++;
        i = (i + 3) % 7; t[i]++;
        i = (i + 2) % 7; t[i]++;
        i = (i + 3) % 7; t[i]++;
        i = (i + 3) % 7; t[i]++;
        i = (i + 2) % 7; t[i]++;
        i = (i + 3) % 7; t[i]++;
        i = (i + 2) % 7; t[i]++;
    }
    fprintf (g, "%d %d %d %d %d %d %d\n", t[6], t[0], t[1], t[2], t[3], t[4], t[5]);
    return 0;
}
