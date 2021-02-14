import sys
number =  int(sys.stdin.readline())

share, rest = divmod(number, 5)
share2, rest2 = divmod(rest, 3)
answer = 0

if(share2 == 0 and rest2 != 0):
    share, rest = divmod(number, 3)
if rest2 == 0:
    print(share + share2)
else:
    print(-1)

# 풀이 중
