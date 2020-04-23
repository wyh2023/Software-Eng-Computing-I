zero = lambda f: lambda x: x

one = lambda f: lambda x: f(x)

def church_to_int(cn):
    return cn(lambda x: x+1)(0)

def succ(n):
    return lambda f: lambda x: f(n(f)(x))

def plus(m, n):
    return lambda f: lambda x: m(f)(n(f)(x))

def multi(m, n):
    return lambda f: lambda x: (m((n(f))))(x)

def pow(m, n):
    return lambda f: lambda x: (n(m)(f))(x)

church_to_int(zero)

church_to_int(one)

church_to_int(succ(one))

church_to_int(succ(one))

church_to_int(succ(succ(one)))

three = succ(succ(one))

two = succ(one)

# church_to_int(pow(two)(three))

church_to_int(pow(two, three))

church_to_int(pow(three, two))

print(church_to_int(pow(two, three)))

tt = lambda x: lambda y: x
ff = lambda x: lambda y: y

def church2bool(b):
    return b(True)(False)

def c_not(b):
    return lambda x: lambda y: b(y)(x)

def c_and(b1, b2):
    return lambda x: lambda y: b1(b2(x)(y))(y)

def c_and1(b1, b2):
     return b1((b2)(ff))

def c_if(b, e1, e2):
    return b(e1)(e2)

# Homework 1
def fact(f, n):
    if (n==1):
        return 1
    else:
        return n* f(f, n-1)

def realFact(n):
    return fact(fact, n)

