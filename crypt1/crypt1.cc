/*
ID: zeng.aa1
LANG: C++
TASK: crypt1
 */

#include <iostream>
#include <fstream>
#include <set>
using namespace std;

set<int> digits;

bool dig_test(int n);

int main(void)
{
    ifstream in("crypt1.in");
    ofstream out("crypt1.out");
    if (in.fail())
    {
        cerr << "crypt1.in does not exist" << endl;
        return 1;
    }
    int n, c = 0;
    in >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        in >> x;
        digits.insert(x);
    }
    for (int i = 100; i < 1000; i++)
    {
        if (!dig_test(i)) continue;
        for (int j = 10; j < 100; j++)
        {
            if (i * j > 9999) break;
            if (j % 10 * i > 999) continue;
            if (j / 10 * i > 999) break;
            if (!dig_test(j)) continue;
            if (!dig_test(i * j)) continue;
            if (!dig_test(j % 10 * i)) continue;
            if (!dig_test(j / 10 * i)) continue;
            c++;
        }
    }
    out << c << endl;
    in.close();
    out.close();
}

bool dig_test(int n)
{
    if (n == 0) return false;
    for (; n > 0; n /= 10)
        if (digits.find(n % 10) == digits.end()) return false;
    return true;
}
