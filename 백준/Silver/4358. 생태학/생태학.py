import sys
from collections import defaultdict

tree_counts = defaultdict(int)
total = 0

for line in sys.stdin:
    tree = line.strip()
    if tree == "":
        break
    tree_counts[tree]+=1
    total += 1

for tree in sorted(tree_counts):
    percentage = (tree_counts[tree] / total) * 100
    print(f"{tree} {percentage:.4f}")