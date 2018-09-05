# Given a set of non-negative integers, and a value sum, determine if there is a subset of the
# given set with sum equal to given sum.

# Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
# Output:  True  //There is a subset (4, 5) with sum 9.

# More information at : https://www.geeksforgeeks.org/subset-sum-problem-dp-25/


def sum_of_subset(arr, total):
    print('------------------')
    print('Input array is:', arr)
    print('Target total is:', total)
    result = sum_of_subset_recursive(arr, total, len(arr) - 1, [])
    print('# of matching subsets is:', result, '\n')


def sum_of_subset_recursive(arr, total, i, matches):
    # print('Total', total, ' i', i)
    if total == 0:
        print('Subset is:', matches)
        return 1   # Found a match!
    elif i < 0:
        # We have reached the end of array, which means total is too big.
        return 0
    elif total < 0:
        return 0    # Went past total which means this path will not lead to the answer we are looking for
    else:
        # We need to consider 2 paths, one which includes the current element 'i' and one that does not
        with_arr_i = matches[:]
        with_arr_i.append(arr[i])
        return (
            # Include the current element in the final solution
            sum_of_subset_recursive(arr, total - arr[i], i-1, with_arr_i) +
            # Do not include the current element in the final solution.
            sum_of_subset_recursive(arr, total, i-1, matches)
        )


def test1():
    sum_of_subset([2, 4, 6, 10], 16)


def test2():
    sum_of_subset([2, 1, 3], 3)


def test3():
    sum_of_subset([1, 2, 3, 4], 10)


test1()
test2()
test3()
