def filter_even_numbers(numbers):
    index = []
    ans = []
    for i in range(len(numbers)):
        if numbers[i] % 2 == 0:
            index.append(i)
    for i in range(len(numbers)):
        if i in index:
            ans.append(numbers[i])
    return ans


if __name__ == '__main__':
    print(filter_even_numbers([3, 7]))