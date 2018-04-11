class LinkedList:
    def _init_(self):
        self.head = ListNode()

    def insert(self, key, p):
        temp = ListNode()
        temp.value = key
        temp.next = p.next
        p.next = temp

    def delete(self, p):
        p.next = p.next.next

    def show(self):
        i = self.head
        while i.next is not None:
            print(i.next.value)
            i = i.next

    def insertAtIndex(self, x, i):
        m = self.head
        if m.next is None:
            z = ListNode()
            z.value = x
            m.next = z
        else:
            n = ListNode()
            t = ListNode()
            n.value = x
            t.next = self.head
            for d in range(i + 1):
                t = t.next
            n.next = t.next
            t.next = n

    def search(self, x):
        h = self.head
        while (h.next):
            h = h.next
            if h.value == x:
                return True
        return False

    def len(self):
        i = self.head
        j = 0
        while (i.next):
            j = j + 1
            i = i.next
        return j

    def isEmpty(self):
        i = self.head
        if i.next is None:
            return True
        else:
            return False


class ListNode:
    def _init_(self, key=None, nxt=None):
        self.next = nxt
        self.key = key


class HashTable(object):
    def _init_(self):
        self.t = [None for i in range(30)]

    def key_value(self, key):
        result = 0
        for i in range(len(key) - 1, -1, -1):
            result = ord(key[i]) + (33 * result)
        return result % 30

    def insertintable(self, key):
        val = self.key_value(key)
        if self.t[val] is None:
            self.t[val] = LinkedList()
            self.t[val].insert(key, self.t[val].head)
        else:
            self.t[val].insert(key, self.t[val].head)

    def hashSearch(self, key):
        a = self.key_value(key)
        if self.t[a] is None:
            return False
        elif self.t[a].search(key) is True:
            return True
        else:
            return False

    def printHash(self):
        for i in range(30):
            if self.t[i] is not None:
                if self.t[i].isEmpty() is False:
                    self.t[i].show()
    def suggestions(self,word):
        l=len(word)
        list_word=[]
        for i in range(l):
            for j in range(97,123):
                k=[c for c in word]
                k[i]=chr(j)
                if self.hashSearch("".join(k)) is not None:
                    list_word.append(''.join(k))
        return list_word

def main():
    h = HashTable()
    with open("ispell.dict") as f:
        for line in f:
            s=line.strip()
            h.insertintable(s)
    print("enter a word to check its spelling:")
    x = input()
    if h.hashSearch(x) is True:
        print("correct")
    else:
        print("Not correct")
    if h.hashSearch(x) is None:
        print("no match found")
        print("suggestions")
        print(h.suggestions(x))

if __name__ == '__main__':
    main()