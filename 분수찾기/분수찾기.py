"""
no: 1193
"""
import sys
number =  int(sys.stdin.readline().rstrip())
n = 1
A1 = 0
while number <= A1:
    n += 1
    A1 = n * (n + 1) / 2

while True:
    A1 = n * (n + 1) / 2
    if number <= A1:
        min = A1 - number
        if n % 2 == 0:
            print('%d/%d' % (n - min, min + 1))
        else:
            print('%d/%d' % (min + 1, n - min))
        break
    else:
        n += 1
