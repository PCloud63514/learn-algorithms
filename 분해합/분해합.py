import sys

def decompositionSum(num):
    arr = [int(i) for i in list(str(num))]
    return num + sum(arr)

N = int(sys.stdin.readline())
ds = 0
M = 1

while True:
    ds = decompositionSum(M)
    if ds == N:
        break
    elif M >= N:
        M = 0
        break
    M += 1

print(M)