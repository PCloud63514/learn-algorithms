import sys
number =  int(sys.stdin.readline())
answer = 0

while True:
    if number % 5 == 0:
        answer += int(number / 5)
        print(answer)
        break
    elif number <= 0:
        print(-1)
        break
    number = number - 3
    answer += 1
