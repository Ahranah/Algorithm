import sys

lines = sys.stdin.readlines()
numbers = []

for i in lines:
    for j in i.split():
        numbers.append(int(j[::-1]))

numbers = numbers[1:]

numbers.sort()

print('\n'.join(map(str, numbers)))

