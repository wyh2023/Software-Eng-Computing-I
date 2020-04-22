"""write your code in method"""


def calculate():
    num = int(input())
    soldiers = []
    for i in range(num):
        soldiers.append(int(input()))
    ans = 0
    tallest = max(soldiers)
    ans += soldiers.index(tallest)
    soldiers.remove(tallest)
    soldiers.insert(0, tallest)
    soldiers.reverse()
    lowest = min(soldiers)
    ans += soldiers.index(lowest)
    print(ans)


if __name__ == '__main__':
    calculate()