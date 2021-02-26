import sys

def ordSum(str):
    sum = 0
    str_list = list(str)
    for s in str_list:
        sum += ord(s)
    return sum

n = int(sys.stdin.readline())

str_set = set()
for _ in range(0, n):
    str_set.add(sys.stdin.readline().strip('\n'))

sort_list = list(str_set)
# sort_list.sort(key=lambda x: (len(x), x[0])) <- 앞글자만 비교
sort_list.sort(key=lambda x: (len(x), ordSum(x)))

for s in sort_list:
    print(s)