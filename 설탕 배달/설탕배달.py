import sys
number = int(sys.stdin.readline().rstrip())
A = 3
B = 5
n = 1
i = 0

while True:
	result1 = (A * n) + (B * i)
	result2 = (A * i) + (B * n)
	if (result1 % number == 0) or (result2 % number == 0):
		print(n + i)
		break
	elif (result1 > number) or (result2 > number):
		i = 0
		n += 1
	else:
		i += 1