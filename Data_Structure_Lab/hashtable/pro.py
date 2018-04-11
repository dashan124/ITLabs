def keyvalue(self, key):
    t = 0
    for i in range(len(key) - 1, -1, -1):
        t = ord(key[i]) + (33 * t)
    return t % 30