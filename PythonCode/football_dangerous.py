"""write your code in method"""


def is_dangerous():
	line = input()
	one_line = line.split('0')
	zero_line = line.split('1')
	flg = 0
	for i in one_line:
		if len(i) >= 7:
			flg = 1
	for i in zero_line:
		if len(i) >= 7:
			flg = 1
	if flg == 1:
		print('YES')
	else:
		print('NO')
	return


if __name__ == '__main__':
	is_dangerous()