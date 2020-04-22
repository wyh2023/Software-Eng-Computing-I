"""write your code in method solve"""
def solve():
    num = int(input())
    candies = list(map(int, input().split(' ')))
    p1 = 0
    p2 = num - 1
    sum1 = 0
    sum2 = 0
    if p1 == p2:
        sum1 += 1
    while p1 < p2:
        flg_1, flg_2 = p1, p2
        candies[p1] -= 1
        candies[p2] -= 1
        if candies[p1] == 0 and candies[p2] == 0 and (p1 + 1) == (p2 - 1):
            sum1 += 2
            sum2 += 1
            break
        else:
            if candies[p2] == 0:
                p2 -= 1
                sum2 += 1
            if candies[p1] == 0:
                p1 += 1
                sum1 += 1
        if p1 == p2:
            if flg_1 < flg_2:
                sum2 += 1
            else:
                sum1 += 1
    print(sum1, sum2)
    return


if __name__ == '__main__':
    solve()