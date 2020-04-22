"""write your code in method sove"""
def solve():
    k = int(input())
    l = int(input())
    m = int(input())
    n = int(input())
    d = int(input())
    total = 0
    for j in range(d):
        i = j + 1
        if i % k == 0 or i % l == 0 or i % m == 0 or i % n == 0:
            total += 1
    print(total)
    return


if __name__ == '__main__':
    solve()