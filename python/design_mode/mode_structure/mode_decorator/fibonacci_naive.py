from timeit import Timer


# 原型的模式
def fibonacci(n):
    assert (n >= 0), 'n must be >= 0'
    return n if n in (0, 1) else fibonacci(n - 1) + fibonacci(n - 2)


# 修饰器模式-----memoization修饰器
known = {0: 0, 1: 1}


def fibonacci1(n):
    assert (n >= 0), 'n must be >= 0'
    if n in known:
        return known[n]
    res = fibonacci1(n - 1) + fibonacci1(n - 2)
    known[n] = res
    return res


if __name__ == '__main__':
    t = Timer('fibonacci1(8)', 'from __main__ import fibonacci1')
    print(t.timeit())
