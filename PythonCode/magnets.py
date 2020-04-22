"""write your code in method solve"""
def solve():
    num = int(input())
    magnets = list(input().split('\n'))
    mag_num = 1
    attri = magnets[0]
    for magnet in magnets:
        if magnet != attri:
            attri = magnet
            mag_num += 1
    print(mag_num)
    return


if __name__ == '__main__':
    solve()