import sys
number =  int(sys.stdin.readline().rstrip())
n = 0

while True:
    answer = (n * (6 * (n + 1))) / 2
    if answer + 1 >= number:
        break
    else:
        n += 1

print(n + 1)
