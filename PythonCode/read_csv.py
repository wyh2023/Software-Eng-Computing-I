#! /usr/bin/env python
# -*- coding: utf-8 -*-


def read(file):
	f = open(file, 'r')
	lines = f.read().split('\n')
	f.close()
	print('Last    Fisrt    Salary')
	for line in lines:
		columns = line.split(',')
		print(columns[0] + '    ' + columns[1] + '    ' + ("%.2f" % float(columns[2])))
