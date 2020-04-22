"""write your code in method number_2_month"""


def number_2_month():
    Month = {1: 'january', 2: 'February', 3: 'March', 4: 'April', 5: 'May', 6: 'June', 7: 'July', 8: 'August',
             9: 'September',
             10: 'October', 11: 'November', 12: 'December'}
    num = int(input('Please enter the number of the month:'))
    if not num in Month:
        print('Error.')
    else:
        print('The name of the month is {}.'.format(Month[num]))
    return


if __name__ == '__main__':
    number_2_month()