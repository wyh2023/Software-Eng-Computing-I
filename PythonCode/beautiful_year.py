"""write your code in method"""


def get_year():
    year = int(input())
    while year <= 9999:
        year += 1
        unit = year % 10
        tens = (year % 100) // 10
        hundreds = (year % 1000) // 100
        thousands = year // 1000
        if unit != tens and unit != hundreds and unit != thousands and tens != hundreds and tens != thousands and hundreds != thousands:
            print(year)
            break
    return


if __name__ == '__main__':
    get_year()

