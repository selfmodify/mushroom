# Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
# An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
# You may assume all four edges of the grid are all surrounded by water.

# Example 1:

# Input:
# 11110
# 11010
# 11000
# 00000

# Output: 1


# Example 2:

# Input:
# 11000
# 11000
# 00100
# 00011

# Output: 3

# From: https://leetcode.com/problems/number-of-islands/description/

def find_islands(name, a):
    island_count = 0
    ci = -1  # current island
    for i in range(len(a)):
        for j in range(len(a[i])):
            if a[i][j] == 0:
                ci = -1  # No longer on land
            elif a[i][j] == 1:
                # We are on land
                if ci == -1:
                    if i > 0 and a[i-1][j] == 1:
                        ci = island_count
                    else:
                        island_count += 1
                        ci = island_count
    print("Number of islands in test ", name, " is ", island_count)
    return island_count


def test_3_islands():
    a = [
        [1, 0, 0, 0, 0],
        [1, 0, 0, 0, 1],
        [1, 1, 1, 1, 1],
        [0, 0, 0, 1, 0],
    ]
    find_islands("3 Islands", a)


def test_5_islands():
    a = [
        [1, 1, 0, 1, 0],
        [1, 1, 0, 0, 1],
        [0, 0, 1, 0, 0],
        [0, 0, 0, 1, 1],
    ]
    find_islands("5 Islands", a)


def test_0_islands():
    a = [
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
    ]
    find_islands("0 Islands", a)


def test_1_big_island():
    a = [
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
    ]
    find_islands("1 Island", a)


test_3_islands()
test_5_islands()
test_0_islands()
test_1_big_island()
