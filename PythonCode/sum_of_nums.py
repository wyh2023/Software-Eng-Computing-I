

def sum_of_nums_calculation():
    sum = 0
    for i in range(5):
        sum += int(input('Enter a number：'))
    print("The total is {}".format(sum))


if __name__ == '__main__':
    sum_of_nums_calculation()