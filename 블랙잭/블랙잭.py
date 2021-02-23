import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))
answer = 0

for num in combinations(arr, 3):
    num_sum = sum(num)

    if num_sum == M:
        answer = num_sum
        break
    elif answer < num_sum <= M:
        answer = num_sum
print(answer)