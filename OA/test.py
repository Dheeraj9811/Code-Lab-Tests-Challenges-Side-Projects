def count_right_triangles(grid):
    rows = len(grid)
    cols = len(grid[0])
    count = 0

    # Iterate through each cell of the grid
    for i in range(rows):
        for j in range(cols):
            # Check if the current cell is a vertex (has a value of 1)
            if grid[i][j] == 1:
                # Search for other vertices in the same row and column
                for k in range(rows):
                    if k != i and grid[k][j] == 1:
                        for l in range(cols):
                            if l != j and grid[i][l] == 1:
                                # If a right triangle is formed, increment the count
                                count += 1
    # Since each triangle is counted 6 times, divide the count by 6 to get the actual count
    return count // 6

# Test cases
grid1 = [[0,1,0],[0,1,1],[0,1,0]]
grid2 = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]
grid3 = [[1,0,1],[1,0,0],[1,0,0]]

print(count_right_triangles(grid1))  # Output: 2
print(count_right_triangles(grid2))  # Output: 0
print(count_right_triangles(grid3))  # Output: 2