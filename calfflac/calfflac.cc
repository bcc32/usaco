/*
ID: zeng.aa1
LANG: C++
TASK: calfflac
 */

#include <iostream>
#include <fstream>
#include <sstream>
#include <algorithm>
using namespace std;

bool pred(char ch)
{
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
}

bool npred(char ch)
{
    return !(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z');
}

char tol(char ch)
{
    if (ch >= 'A' && ch <= 'Z') return ch + 32;
    else return ch;
}

int main(void)
{
    ifstream in("calfflac.in");
    ofstream out("calfflac.out");
    ostringstream ss;
    for (char ch = in.get(); !in.eof(); ch = in.get())
        ss << ch;
    string s = ss.str();
    int m = 0, n = 0;
    for (int i = 0; i < s.size(); i++)
    {
        if (!pred(s[i])) continue;
        for (int j = m + 1; i + j <= s.size(); j++)
        {
            cerr << i << "\t" << j << endl;
            if (!pred(s[i + j - 1])) continue;
            bool palin = true;
            int x = i, y = i + j - 1;
            while (x < y)
            {
                while (!pred(s[x])) x++;
                while (!pred(s[y])) y--;
                if (tol(s[x]) != tol(s[y]))
                {
                    palin = false;
                    break;
                }
                else
                {
                    x++;
                    y--;
                }
            }
            if (palin)
            {
                cerr << s.substr(i, j) << endl;
                m = j;
                n = i;
            }
        }
    }
    out << count_if(s.begin() + n, s.begin() + n + m, pred) << endl
        << s.substr(n, m) << endl;
    in.close();
    out.close();
}
