def calculation():
    principle = int(input('Enter the principal: '))
    interest = float(input('Enter the rate of interest: '))/100
    year = int(input('Enter the number of year: '))
    print('investment:{:.2f}'.format(principle*(1 + interest*year)))


if __name__ == '__main__':
    calculation()
