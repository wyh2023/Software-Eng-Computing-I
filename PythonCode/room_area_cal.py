

def room_area_calculation():
	length = int(input('What is the length of the room in feet?'))
	width = int(input('What is the length of the room in feet?'))
	area = length*width
	print("{} square feet".format(area))
	print("{:.3f} square meters".format(area * 0.09290304))


if __name__ == '__main__':
	room_area_calculation()