/*
ID: zeng.aa1
LANG: C
TASK: calfflac
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {
    FILE *f = fopen ("calfflac.in", "r");
    FILE *g = fopen ("calfflac.out", "w");
    char *str = (char *) malloc (20000 * sizeof (char));
    char *s = (char *) malloc (80 * sizeof (char));
    char *c = (char *) malloc (20000 * sizeof (char));
    int i, j, m = 0, n = 0;
    while (!feof (f)) {
        fscanf (f, "%s", s);
        strcat (str, s);
    }
    for (i = 0; i < strlen (str); i++) {
        for (j = 0; i + j <= strlen (str); j++) {
            strncpy (c, str + i, j);
            if (j > m) {
                if (isPalin (str)) {
                    m = j;
                    n = i;
                }
            }
        }
    }
    strncpy (c, str + n, m);
    fprintf (g, "%d\n%s\n", m, c);
    free (str);
    free (s);
    free (c);
    return 0;
}

int isPalin (char *str) {
    int i;
    char *s = (char *) malloc (20000 * sizeof (char));
    if (!se (str)) {
        free (s);
        return 0;
    }
    for (i = 0; i < strlen (str); i++) {
        if (isalpha (str[i])) {
            strcat (s, (char *) str[i]);
        }
    }
    for (i = 0; 2 * i < strlen (str); i++) {
        if (str[i] != str[strlen (str) - i - 1]) {
            free (s);
            return 0;
        }
    }
    free (s);
    return 1;
}

int se (char *str) {
    return isalpha (str[0]) && isalpha (str[strlen (str) - 1]);
}

int cc (char *str) {
    int i, c = 0;
    for (i = 0; i < strlen (str); i++)
        if (isalpha (str[i]))
            c++;
    return c;
}
