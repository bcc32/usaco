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

bool palinq(string s)
{
    int c = s.size() - 1;
    for (int i = 0; i < s.size() / 2; i++, c--)
        if (s[i] >= 'a' && s[i] <= 'z')
            if (s[c] >= 'a' && s[c] <= 'z' && s[c] == s[i]) continue;
            else if (s[c] == s[i] - 32) continue;
            else return false;
        else
            if (s[c] >= 'A' && s[c] <= 'Z' && s[c] == s[i]) continue;
            else if (s[c] == s[i] + 32) continue;
            else return false;
    return true;
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
            if (!pred(s[i + j - 1])) continue;
            ostringstream a;
            for (int k = i; k < i + j; k++)
                if (pred(s[k]))
                    a << s[k];
            if (palinq(a.str()))
            {
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
