
def password_verification(user, pwd):
    """
    :param user: The username stored in the computer.
    :param pwd: The password for the user stored in the computer.
    """
    input_user = input('What is the user name?')
    input_pwd = input('What is the password?')
    if input_pwd == pwd and input_user == user:
        print('Welcome!')
    else:
        print("I don't know you.")
