def knapsack_rec(weights, values, w, i, acc_w):
    if i < 0 or w == 0:
        return 0
    elif w < 0:
        return 0
    else:
        a2 = acc_w[:]
        a2.append(weights[i])
        r1 = knapsack_rec(weights, values, w -
                          weights[i], i - 1, a2) + values[i]
        r2 = knapsack_rec(weights, values, w, i - 1, acc_w)
        if r1 > r2:
            acc_w = a2
            print('r1. Value', r1, 'Weights are ', a2)
            return r1
        print('r2. Value', r2, 'Weights are ', acc_w)
        return r2


def knapsack(weights, values, w):
    acc_w = []
    v = knapsack_rec(weights, values, w, len(weights) - 1, acc_w)
    print("Value is", v)


# knapsack([9, 13, 153, 50], [150, 35, 200, 160], 200)
knapsack([9, 13, 153], [150, 35, 200], 200)
# knapsack([1, 2, 4, 2, 5], [5, 3, 5, 3, 2], 10)
