/*
ID: zeng.aa1
LANG: C
TASK: milk2
 */

#include <stdio.h>

int freq (int *list, int len, int num) {
	int c = 0, i;
	for (i = 0; i < len; i++) {
		if (list[i] == num)
			c++;
	}
	return c;
}

int max (int *list, int len) {
	int m = 0, i;
	for (i = 0; i < len; i++)
		if (list[i] > m)
			m = list[i];
	return m;
}

int main (void) {
	FILE *f = fopen ("milk2.in", "r");
	FILE *g = fopen ("milk2.out", "w");
	int N, start[5000], finish[5000], i, end, started, numMilking, trueStart, trueMax, falseStart, falseMax;
	fscanf (f, "%d", &N);
	for (i = 0; i < N; i++)
		fscanf (f, "%d %d", &start[i], &finish[i]);
	end = max (finish, N);
	started = 0;
	numMilking = 0;
	trueStart = -1;
	trueMax = 0;
	falseStart = -1;
	falseMax = 0;
	for (i = 0; i <= end; i++) {
		numMilking += freq (start, N, i);
		numMilking -= freq (finish, N, i);
		if (numMilking > 0)
			started = 1;
		if (numMilking == 0 && started && falseStart == -1)
			falseStart = i;
		if (falseStart != -1 && numMilking > 0) {
			if (i - falseStart > falseMax)
				falseMax = i - falseStart;
			falseStart = -1;
		}
		if (numMilking > 0 && trueStart == -1)
            trueStart = i;
        if (trueStart != -1 && numMilking == 0) {
            if (i - trueStart > trueMax)
                trueMax = i - trueStart;
            trueStart = -1;
        }
	}
	fprintf (g, "%d %d\n", trueMax, falseMax);
	fclose (f); fclose (g);
}