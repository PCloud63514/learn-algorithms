import sys

n = int(sys.stdin.readline())
numSet = set()

for _ in range(0, n):
    num = int(sys.stdin.readline())
    numSet.add(num)

list = list(numSet)
list.sort()

for num in list:
    print(num)

