# Towers of hanoi.


def hanoi_solve(n, src, dest, intermediate):
    if n == 0:
        return
    hanoi_solve(n-1, src, intermediate, dest)
    print("Move from", src, "to", dest)
    hanoi_solve(n-1, intermediate, dest, src)


def hanoi(n):
    print('Solving for', n, 'disks')
    hanoi_solve(n, 'L', 'R', 'M')


hanoi(3)
