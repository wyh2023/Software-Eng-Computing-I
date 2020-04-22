def is_anagram(str1, str2):
    s1 = str1[:]
    s2 = str2[:]
    lst1 = list(s1)
    lst2 = list(s2)
    lst1.sort()
    lst2.sort()
    return lst1 == lst2


if __name__ == '__main__':
    is_anagram('apple', 'pplea')

