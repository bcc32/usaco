"""
ID: zeng.aa1
LANG: PYTHON3
TASK: spin
"""

import array

class Mask:
    def __init__(self, speed, bits):
        self.pos = 0
        self.speed = speed
        self.bits = bits

    def rotate(self):
        self.pos += self.speed
        offset = len(self.bits) - self.speed
        self.bits = self.bits[offset:] + self.bits[:offset]

    def __repr__(self):
        return repr(self.bits)

def make_bits(wedges):
    bits = [False] * 360
    for i in range(0, len(wedges), 2):
        offset, extent = wedges[i], wedges[i + 1]
        for j in range(offset, offset + extent + 1):
            bits[j % 360] = True
    return array.array('b', (int(b) for b in bits))

def first_time(masks):
    for t in range(360):
        bits = array.array('b', (1 for _ in range(360)))
        for m in masks:
            for i in range(len(bits)):
                bits[i] &= m.bits[i]

        if any(bits):
            return t

        for m in masks:
            m.rotate()

def main():
    with open('spin.in') as f, open('spin.out', 'w') as out:
        masks = []
        for _ in range(5):
            line = f.readline()
            speed, _, *wedges = map(int, line.split())
            m = Mask(speed, make_bits(wedges))
            masks.append(m)
        ans = first_time(masks)
        out.write('{}\n'.format(ans if ans is not None else 'none'))

if __name__ == '__main__':
    main()
