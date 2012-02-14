/*
ID: zeng.aa1
LANG: C++
TASK: milk
 */
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

class farmer
{
    public:
        int p, a;

        bool operator<(farmer f) const
        {
            return p < f.p;
        }
};

int main(void)
{
    ifstream in("milk.in");
    ofstream out("milk.out");
    int n, m, x = 0, p = 0;
    in >> n >> m;
    vector<farmer> v(m);
    for (int i = 0; i < m; i++)
        in >> v[i].p >> v[i].a;
    sort(v.begin(), v.end());
    for (vector<farmer>::iterator it = v.begin(); it < v.end(); it++)
    {
        if (it->a >= n - x)
        {
            p += (n - x) * it->p;
            x = n;
            break;
        }
        else
        {
            p += it->a * it->p;
            x += it->a;
        }
    }
    out << p << endl;
}
