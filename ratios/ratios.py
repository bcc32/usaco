'''
ID: zeng.aa1
LANG: PYTHON3
TASK: ratios
'''

class UnevenDivision(Exception):
    pass

def det(col1, col2, col3):
    a1, a2, a3 = col1
    b1, b2, b3 = col2
    c1, c2, c3 = col3

    return a1 * b2 * c3 + a2 * b3 * c1 + a3 * b1 * c2 - \
        (a3 * b2 * c1 + a2 * b1 * c3 + a1 * b3 * c2)

def div(a, b):
    if a % b == 0:
        return a // b
    else:
        raise UnevenDivision

# Solve Cramer's rule
def solve(col1, col2, col3, rhs):
    x = div(det(rhs, col2, col3), det(col1, col2, col3))
    y = div(det(col1, rhs, col3), det(col1, col2, col3))
    z = div(det(col1, col2, rhs), det(col1, col2, col3))
    return x, y, z

def main():
    with open('ratios.in') as f, open('ratios.out', 'w') as out:
        def read():
            return tuple(map(int, f.readline().split()))
        goal = read()
        i1 = read()
        i2 = read()
        i3 = read()

        combos = []

        for mul in range(1, 100):
            try:
                x, y, z = solve(i1, i2, i3, tuple(x * mul for x in goal))
                if x < 0 or y < 0 or z < 0:
                    continue
                combos.append((x, y, z, mul))
            except UnevenDivision:
                pass

        try:
            c1, c2, c3, q = min(combos, key=(lambda t: sum(t[0:3])))
            out.write('{} {} {} {}\n'.format(c1, c2, c3, q))
        except:
            out.write('NONE\n')

if __name__ == '__main__':
    main()
