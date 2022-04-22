import sys
from itertools import combinations
import numpy as np
#arr = [int (i) for i in sys.stdin.readline().split()]

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))

combi = np.array(list(combinations(arr, 3)))
combi_sum = np.sum(combi, 1)
idx = np.abs(np.array(combi_sum)-M).argmin()

print(combi_sum[idx])