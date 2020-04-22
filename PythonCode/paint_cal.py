

def paint_calculation():
	length = int(input('What is the length in feet? '))
	width = int(input('What is the width in feet? '))
	area = length * width
	if area % 350 == 0:
		total = area // 350
	else:
		total = (area // 350) + 1
	print('You will need to purchase {} gallons of paint'.format(total))


if __name__=='__main__':
	paint_calculation()