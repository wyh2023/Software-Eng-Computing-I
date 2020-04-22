"""write your code in method get_max_number"""
def get_max_number():
    num1 = int(input("Enter the first number:"))
    num2 = int(input("Enter the second number:"))
    num3 = int(input("Enter the third number:"))
    numlst = [num1, num2, num3]
    numlst.sort()
    if numlst.count(num1) > 1 or numlst.count(num3) > 1:
        print("Have the same number:" + str(numlst[1]))
    else:
        print("The largest number is " + str(numlst[2]))
    return
