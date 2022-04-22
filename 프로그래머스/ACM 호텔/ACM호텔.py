import sys

T = int(sys.stdin.readline())

for i in range(0,T):
    H, W, N = map(int, sys.stdin.readline().split())
    XX, YY = divmod(N, H) # XX = 몫 YY = 나머지
    if YY != 0:
        XX += 1
    else:
        YY = H
    print('{0}{1:02d}'.format(YY, XX))
