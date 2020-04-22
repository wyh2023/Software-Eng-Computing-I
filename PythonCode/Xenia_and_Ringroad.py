"""write your code in method solve"""
def solve():
    m_n_lst = list(map(int, input().strip().split()))
    n, m = m_n_lst[0], m_n_lst[1]
    a_lst = list(map(int, input().strip().split()))
    point = 1
    count = 0
    for i in range(m):
        while point % n != a_lst[i]:
            point += 1
            count += 1

    print(count)
    return


if __name__ == '__main__':
    solve()