/*
ID: zeng.aa1
LANG: C++
TASK: calfflac
 */

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <algorithm>
using namespace std;

bool isPalin(string s)
{
    for (int i = 0; i < s.size(); i++)
        if (s[i] != s[s.size() - i - 1])
            return false;
    return true;
}

string parse(string s)
{
    ostringstream ss;
    for (string::iterator i = s.begin(); i < s.end(); i++)
        if (*i >= 'a' && *i <= 'z')
            ss << *i;
        else if (*i >= 'A' && *i <= 'Z')
            ss << *i + 32;
    return ss.str();
}

bool cc_pred(char ch)
{
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
}

int main(void)
{
    ifstream in;
    in.open("calfflac.in");
    ofstream out;
    out.open("calfflac.out");
    ostringstream ss;
    string line;
    while (!in.eof())
    {
        getline(in, line);
        ss << line;
    }
    line = ss.str();
    int m = 0, n = 0;
    for (int i = 0; i < line.size(); i++)
        for (int j = m + 1; i + j <= line.size(); j++)
        {
            string s = line.substr(i, j);
            cout << s << endl;
            if (s[0] < 'a' && s[0] > 'z' && s[0] < 'A' && s[0] > 'Z')
                break;
            if (*s.end() < 'a' && *s.end() > 'z' &&
                *s.end() < 'A' && *s.end() > 'Z')
                continue;
            if (isPalin(parse(s)))
            {
                m = j;
                n = i;
            }
        }
    string s = line.substr(n, m);
    out << count_if(s.begin(), s.end(), cc_pred) << endl << s << endl;
    in.close();
    out.close();
}
