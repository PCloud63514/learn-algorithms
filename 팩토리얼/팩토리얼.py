import sys

def factorial(number:int, index:int=1, sum:int=1):
    if (index > number):
        return sum
    else:
        sum *= index
        index += 1
        return factorial(number, index, sum)

number = int(sys.stdin.readline())
print(factorial(number))


