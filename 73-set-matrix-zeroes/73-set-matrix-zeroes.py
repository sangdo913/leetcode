class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rowZero = False
        colZero = False
        for i in range(0, len(matrix)):
            rowZero = rowZero | (matrix[i][0] == 0)
        for j in range(0, len(matrix[0])):
            colZero = colZero | (matrix[0][j] == 0)
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if(matrix[i][j] == 0): 
                    matrix[0][j] = 0
                    matrix[i][0] = 0
        for i in range(1, len(matrix)):
            if(matrix[i][0] == 0):
                for j in range(1, len(matrix[i])): matrix[i][j] = 0
        for j in range(1, len(matrix[0])):
            if(matrix[0][j] == 0):
                for i in range(1, len(matrix)): matrix[i][j] = 0
        if rowZero:
            for i in range(0, len(matrix)): matrix[i][0] = 0
        if colZero:
            for j in range(0, len(matrix[0])): matrix[0][j] = 0
                 
        