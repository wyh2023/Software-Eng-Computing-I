"""write your code in method solve"""


def solve():
    groups = int(input())
    children = list(map(int, input().split(' ')))
    four_groups = children.count(4)
    three_groups = children.count(3)
    two_groups = children.count(2)
    one_groups = children.count(1)
    taxi = 0
    # 4 -> 1
    taxi += four_groups
    # 3 + 1 -> 1
    three2one = min(three_groups, one_groups)
    taxi += three2one
    # 2 + 2 -> 1
    two2two = two_groups // 2
    taxi += two2two
    # rest
    rest_one = one_groups - three2one
    rest_two = two_groups % 2
    rest_three = three2one - three2one
    taxi += rest_three
    if rest_two != 0:
        taxi += 1
        if rest_one <= 2:
            rest_one = 0
        else:
            rest_one -= 2
    taxi += rest_one // 4 + (rest_one % 4 + 3) // 4
    print(taxi)
    return


if __name__ == '__main__':
    solve()
