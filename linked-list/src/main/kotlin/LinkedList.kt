class Deque<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    inner class Node<T>(val value: T) {
        var next: Node<T>? = null
        var prev: Node<T>? = null
    }

    fun push(value: T) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
    }

    fun pop(): T? {
        val poppedValue = tail?.value
        tail = tail?.prev

        if (tail == null) {
            head = null
        } else {
            tail?.next = null
        }

        return poppedValue
    }

    fun unshift(value: T) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
    }

    fun shift(): T? {
        val shiftedValue = head?.value
        head = head?.next

        if (head == null) {
            tail = null
        } else {
            head?.prev = null
        }

        return shiftedValue
    }
}

