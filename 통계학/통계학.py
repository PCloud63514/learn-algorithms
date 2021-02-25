import sys
import math
n = int(sys.stdin.readline())

list = list()
for _ in range(0, n):
    list.append(int(sys.stdin.readline()))

print(int(sum(list) / n))

listCopy = list.copy()
listCopy.sort()
print(listCopy[math.trunc(len(listCopy) / 2)])
count = {}
for num in list:
    try: count[num] += 1
    except: count[num] = 1

seq = 0
maxValue = max(count.values())
for i in count:
    if(maxValue == i)

print(list.index(max(count)))
print(max(list) - min(list))
