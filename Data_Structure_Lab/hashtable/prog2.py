class LinkedList:
    def __init__(self):
        """Create a new list with a Sentinel Node"""
        self.head = ListNode()

    def insert(self, x, p):
        """Insert element x in the position after p"""
        temp = ListNode()
        temp.data = x
        temp.next = p.next
        p.next = temp

    def delete(self, p):
        """Delete the node following node p in the linked list."""
        if self.head is None:
            return
        temp = self.head
        if p == self.head:
            self.head = temp.next
            temp = None
            return
        while (p):
            temp = temp.next
            p = p.next
            if temp is None:
                return
        if temp is None:
            return
        if temp.next is None:
            return
        next = temp.next.next
        temp.next = next
        temp = None

    def printlist(self):
        """ Print all the elements of a list in a row."""
        temp = self.head
        while temp.next is not None:
            print(temp.next.data)
            temp = temp.next

    def insertAtIndex(self, x, i):

        """Insert value x at list position i. (The position of the first element is taken to be 0.)"""
        m = self.head
        if m.next is None:
            z = ListNode()
            z.data = x
            m.next = z
        else:
            n = ListNode()
            t = ListNode()
            n.data = x
            t.next = self.head
            for d in range(i + 1):
                t = t.next
            n.next = t.next
            t.next = n

    def search(self, x):
        """Search for value x in the list. Return a reference to the first node with value x; return None if no such node is found."""
        if self.head is None:
            return False
        temp = self.head
        while (temp):
            if (temp.data == x):
                return True
            else:
                temp = temp.next

    def len(self):
        """Return the length (the number of elements) in the Linked List."""
        count = 0
        temp = self.head
        while (temp is not None):
            count += 1
            temp = temp.next
        return count

    def isEmpty(self):
        """Return True if the Linked List has no elements, False otherwise."""
        temp = self.head
        if (temp is None):
            return True
        else:
            return False


class ListNode:
    def __init__(self, val=None, nxt=None):
        self.data = val
        self.next = nxt



class hashtable(object):
    def __init__(self):
        self.T = [None for i in range(30)]

    def keyvalue(self, key):
        t = 0
        for i in range(len(key) - 1, -1, -1):
            t = ord(key[i]) + (33 * t)
        return t % 30

    def insertintable(self, key):
        value = self.keyvalue(key)
        if self.T[value] is None:
            self.T[value] = LinkedList()
            self.T[value].insert(key, self.T[value].head)
        else:
            self.T[value].insert(key, self.T[value].head)

    def searchash(self, y):
        key = self.keyvalue(y)
        if self.T[key] is None:
            return None
        elif self.T[key].search(key) is False:
            return None
        else:
            return 1

    def printtable(self):
        for hr in range(30):
            if self.T[hr] is not None:
                if self.T[hr].isEmpty() is False:
                    self.T[hr].printlist()

def main():
    h = hashtable()
    print("Enter the number of elements you want to enter in hashtable:")
    n = int(raw_input())
    for kt in range(n):
        print("enter key:")
        a1=raw_input()
        h.insertintable(a1)
    h.printtable()
    print("enter a string to search in hashtable:")
    x = raw_input()
    if h.searchash(x) is None:
        print("Not Found")
    else:
        print("found")


if __name__ == '__main__':
    main()
