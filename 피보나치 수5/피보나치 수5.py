import sys

def fibonacci5(n:int, index:int=0, f1:int=0, f2:int=1):
    if index >= n-1:
        return f2
    else:
        index += 1
        _f1 = f2
        _f2 = f1 + f2
        return fibonacci5(n, index, _f1, _f2)

number = int(sys.stdin.readline())
if number == 0:
    print(0)
else:
    print(fibonacci5(number))
