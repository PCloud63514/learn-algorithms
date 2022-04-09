import sys
import numpy as np
n = int(input())

fillList = list()

for _ in range(0, n):
    space = sys.stdin.readline().strip()
    fillList.append(list(map(int, list(space))))


fillList = np.array(fillList)
x = np.array([[2,2],[2,2]])
print(fillList)
print(x * fillList)

