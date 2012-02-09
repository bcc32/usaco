/*
ID: zeng.aa1
LANG: C++
TASK: barn1
*/
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

bool pred(pair<bool, bool> p);

int main(void)
{
    ifstream in("barn1.in");
    ofstream out("barn1.out");
    if (in.fail())
    {
        cerr << "barn1.in not found" << endl;
        return 1;
    }
    int m, s, c;
    in >> m >> s >> c;
    int x_min = 200, x_max = 0;
    vector< pair<bool, bool> > v(s); // has cow, is covered
    for (int i = 0; i < c; i++)
    {
        int x;
        in >> x;
        x--;
        if (x > x_max)
            x_max = x;
        if (x < x_min)
            x_min = x;
        v[x].first = true;
    }
    for (int i = x_min; i <= x_max; i++)
        v[i].second = true; // initial covering
    for (int min = 1; min < m; min++)
    {
        int max_cont = 0, x = 0, y = 0, t;
        int c = 0;
        bool cont = false;
        for (int i = 0; i < v.size(); i++)
            if (!v[i].first && v[i].second)
                if (cont) c++;
                else
                {
                    t = i;
                    cont = true;
                    c = 1;
                }
            else if (cont)
            {
                cont = false;
                if (c > max_cont)
                {
                    max_cont = c;
                    x = t;
                    y = i;
                }
                c = 0;
            }
        for (int i = x; i < y; i++)
            v[i].second = false;
    }
    out << count_if(v.begin(), v.end(), pred) << endl;
}

bool pred(pair<bool, bool> p)
{
    return p.second;
}
