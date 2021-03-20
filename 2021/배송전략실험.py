import sys



user_input = int(input())

data = sys.stdin.readline().strip()
data = list(data)


def recursion(index, move):
    try:
        n1 = recursion(0, 1)
        n1 = recursion(0, 2)
    except:
        return 0
    num = recursion(0, 0)

