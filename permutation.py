# Permutation


def permutation_rec(a):
    if len(a) == 0:
        return []
    if len(a) == 1:
        return [a]

    l = []
    for i in range(len(a)):
        x = a[:i] + a[i+1:]
        for j in permutation_rec(x):
            str2 = a[i] + j
            l.append(str2)
    return l


count = 0
for r in permutation_rec('chips'):
    count += 1
    print(count, r)
