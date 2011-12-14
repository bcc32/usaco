//TOFIX

/*
ID: zeng.aa1
LANG: C
TASK: dualpal
*/

#include <stdio.h>

int main (void) {
  FILE *f = fopen ("dualpal.in", "r");
  FILE *g = fopen ("dualpal.out", "w");
  int N, S, c = 0, i;
  fscanf (f, "%d %d", &N, &S);
  for (i = S + 1; c < N; i++) {
    int ci = 0, b;
    for (b = 2; b <= 10; b++)
      if (isPalin (radix (i, b)))
	ci++;
    if (ci >= 2) {
      fprintf (g, "%d\n", i);
      c++;
    }
  }
  fclose (f);
  fclose (g);
}

int isPalin (char *num, int len) {
  int i;
  for (i = 0; i < len; i++)
    if (num[i] != num[len - i - 1])
      return 0;
  return 1;
}

char *radix (int n, int b) {
  
}
