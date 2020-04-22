
def generate():
    n = int(input('n='))
    for i in range(n + 1):
        for j in range(n + 1):
            print("{} X {} = {}".format(i, j, i*j))


if __name__=='__main__':
    generate()
