#! /usr/bin/env python
# -*- coding: utf-8 -*-
import re


def wordcount(filepath):
    file = open(filepath, 'r')
    lines = file.readlines()
    dic = {}
    for line in lines:
        wordlst = line.strip().split(' ')
        for word in wordlst:
            if not word in dic:
                dic[word] = 1
            else:
                tmp = dic[word]
                tmp += 1
                dic[word] = tmp

    dic1 = sorted(dic.items(), key=lambda kv: (-kv[1], kv[0]))
    dic2 = []
    lenlst = []
    for tup in dic1:
        dic2.append([tup[0], tup[1]])
        lenlst.append(len(tup[0]))
    blank_len = max(lenlst) + 2
    for i in dic2:
        i[0] += ':'
        num = i[1]
        print(i[0] + ' '*(blank_len - len(i[0])) + '*'*num)


if __name__ == '__main__':
    wordcount(r'C:\Users\669\Desktop\软工一\106-wordcount\files\test1')
