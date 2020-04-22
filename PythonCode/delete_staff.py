"""write your code in method delete_staff"""


def delete_staff(staff_list, del_staff):
    print("There are {} staff:".format(len(staff_list)))
    for i in staff_list:
        print(i)
    print()
    print("remove the staff: " + del_staff)
    print()
    if del_staff in staff_list:
        staff_list.remove(del_staff)
    print("There are {} staff:".format(len(staff_list)))
    for i in staff_list:
        print(i)
    return


if __name__ == '__main__':
    delete_staff([], 'Chris Jones')

