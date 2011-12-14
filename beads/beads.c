//TOFIX
/*
ID: zeng.aa1
LANG: C
TASK: beads
*/

#include <stdio.h>

#define MIN(x, y) x < y ? x : y

//TOFIX
char shift (char *beads, int N) {
    int i;
    char foo[N + 1];
    foo[0] = beads[N - 1];
    for (i = 1; i < N - 1; i++)
        foo[i] = beads[i - 1];
    *beads = *foo;
}

int count (char *beads, int N) {
    int fcount = 0, bcount = 0;
    int i, c = 0;
    char colour = 'w';
    for (i = 0; i < N; i++) {
        if (beads[i] == 'w')
            c++;
        else if (colour == 'w') {
            colour = beads[i];
            c++;
        } else if (beads[i] == colour)
            c++;
        else {
            fcount = c;
            break;
        }
    }
    c = 0;
    colour = 'w';
    for (i = N - 1; i; i++) {
        if (beads[i] == 'w')
            c++;
        else if (colour == 'w') {
            colour = beads[i];
            c++;
        } else if (beads[i] == colour)
            c++;
        else {
            bcount = c;
            break;
        }
    }
    return MIN(N, fcount + bcount);
}

int main (void) {
    FILE *f, *g;
    f = fopen ("beads.in", "r");
    g = fopen ("beads.out", "w");
    int N, i;
    fscanf (f, "%d", &N);
    char beads[N + 1];
    fscanf (f, "%s", beads);
    int m = 0, c;
    for (i = 0; i < N; i++) {
        c = count (beads, N);
        if (c > m)
            m = c;
        shift (&beads, N);
    }
    fprintf (g, "%d\n", m);
    fclose (f); fclose (g);
}
