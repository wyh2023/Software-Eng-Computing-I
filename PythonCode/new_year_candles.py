"""write your code in method solve"""
def solve():
    candles = list(map(int, input().split(' ')))
    num = candles[0]
    change = candles[1]
    rest = num
    total = 0
    while rest > 0:
        rest -= 1
        total += 1
        if total % change == 0:
            rest += 1
    print(total)
    return

if __name__ == "__main__":
    solve()