import sys
import math
n = int(sys.stdin.readline())

inputList = list()
for _ in range(0, n):
    inputList.append(int(sys.stdin.readline()))

print(round(sum(inputList) / n))

listCopy = inputList.copy()
listCopy.sort()
print(listCopy[math.trunc(len(listCopy) / 2)])
count = {}
for num in inputList:
    try: count[num] += 1
    except: count[num] = 1

freqKey = list()
maxValue = max(count.values())
for _key, _value in zip(count.keys(), count.values()):
    if maxValue == _value:
        freqKey.append(_key)

freqKey.sort(reverse=True)

if len(freqKey) > 1:
    freqKey.pop((freqKey.index(min(freqKey))))
print(min(freqKey))

print(max(inputList) - min(inputList))
