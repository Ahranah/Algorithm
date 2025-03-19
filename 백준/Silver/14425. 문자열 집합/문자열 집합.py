# 자료구조 - 해시, 트리를 이용한 문자열

n , m = map(int, input().split())

words = []
for _ in range(n+m):
   words.append(input().strip())

proto = set(words[:n]) 
check_words = words[n:]

ans = 0
for word in check_words:
    if word in proto:
        ans += 1

print(ans)