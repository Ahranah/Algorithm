class Solution:
    def pooling(self, matrix, x, y, size):
        # size는 현재 정사각형의 한 변의 길이
        if size == 2:
            values = [
                matrix[x][y],
                matrix[x][y+1],
                matrix[x+1][y],
                matrix[x+1][y+1]
            ]
            values.sort(reverse=True)
            return values[1]  # 두 번째로 큰 값
        
        half = size // 2
        # 4분할
        a = self.pooling(matrix, x, y, half)
        b = self.pooling(matrix, x, y + half, half)
        c = self.pooling(matrix, x + half, y, half)
        d = self.pooling(matrix, x + half, y + half, half)
        
        values = [a, b, c, d]
        values.sort(reverse=True)
        return values[1]
    

if __name__ == "__main__":
    import sys
    input = sys.stdin.readline

    N = int(input())
    matrix = [list(map(int, input().split())) for _ in range(N)]
    
    solution = Solution()
    result = solution.pooling(matrix, 0, 0, N)
    print(result)