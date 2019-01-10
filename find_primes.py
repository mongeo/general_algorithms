import math


def find_primes(n):
    primeList = []
    i = 2
    if n < 2:
        return ""
    while i <= n:
        divisible = False
        for j in range(2, int(math.sqrt(i)) + 1):
            if i % j == 0:
                divisible = True
        if not divisible:
            primeList.append(i)
        i += 1
    return ', '.join(map(str, primeList))

print(find_primes(100000))