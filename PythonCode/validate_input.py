#! /usr/bin/env python
# -*- coding: utf-8 -*-
import re

def validate():
    first_name = input("Enter the first name:")
    last_name = input("JEnter the last name:")
    zip_code = input("Enter the ZIP code:")
    id = input("Enter an employee ID:")
    if first_name == '':
        print("The first name must be filled in.")
    elif len(first_name) < 2:
        print("\"" + first_name + "\" is not a valid first name. It is too short.")

    if last_name == '':
        print("The last name must be filled in.")
    elif len(last_name) < 2:
        print("\"" + last_name + "\" is not a valid last name. It is too short.")

    if not zip_code.isdigit():
        print("The ZIP code must be numeric.")

    pattern = re.compile(r'[A-Z][A-Z]-\d{4}')
    if not re.match(pattern, id):
        print(id + " is not a valid ID.")

if __name__=='__main__':
    validate()