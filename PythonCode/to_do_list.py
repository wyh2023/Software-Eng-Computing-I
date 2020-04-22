"""write your code in following methods"""
file_path = './tasks.txt'


def to_do():
    def interpret(strings):
        items = strings.split('" "')
        if items[0][0] == '"':
            items[0] = items[0][1:]
        if items[-1][-1] == '"':
            items[-1] = items[-1][:-1]
        return items

    def add(toadd):
        to_a_lst = interpret(toadd)
        with open(file_path, 'a') as file_object:
            for to_a in to_a_lst:
                strs = 'todo:     ' + to_a
                file_object.write(strs + '\n')

    def delete(todel):
        to_d_lst = interpret(todel)
        for to_d in to_d_lst:
            with open(file_path, "r") as f:
                lines = f.readlines()
            with open(file_path, "w") as f_w:
                for line in lines:
                    if to_d in line:
                        continue
                    f_w.write(line)

    def complete(toc):
        to_c_lst = interpret(toc)
        for to_c in to_c_lst:
            with open(file_path, "r") as f:
                lines = f.readlines()
            with open(file_path, "w") as f_w:
                for line in lines:
                    if to_c in line:
                        f_w.write(line.replace("todo:      ", "completed:", 1))
                    else:
                        f_w.write(line)

    def find(tof):
        to_f_lst = interpret(tof)
        for to_f in to_f_lst:
            with open(file_path, "r") as f:
                lines = f.readlines()
                for line in lines:
                    if to_f in line:
                        print(line.replace('\n', ''))

    def findall():
        with open(file_path, "r") as f:
            lines = f.readlines()
            for line in lines:
                print(line.replace('\n', ''))

    while True:
        cmd = input().split(' ', 2)

        if cmd[0] != 'todo':
            print('\033[31m', end='')
            print("Error! Todo_interpreter cannot understand:  " + ' '.join(cmd))
            print("Please try again")
            print('\033[0m', end='')
            continue
        if cmd[1] == '-quit':
            print('\033[31mGoodbye!~\033[31m')
            break
        if cmd[1] == '-a':
            add(cmd[2])
            print('\033[31m' + cmd[2] + ' has/have been added successfully!\033[31m')
        if cmd[1] == '-d':
            delete(cmd[2])
            print('\033[31m' + cmd[2] + ' has/have been deleted successfully!\033[31m')
        if cmd[1] == '-c':
            complete(cmd[2])
            print('\033[31m' + cmd[2] + ' has/have been completed successfully!\033[31m')
        if cmd[1] == '-f':
            print("-title- | -affairs-")
            find(cmd[2])
        if cmd[1] == '-all':
            print("-title- | -affairs-")
            findall()

    return


if __name__ == '__main__':
    to_do()
