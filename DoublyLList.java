class Node {
    int data;
    Node prev, next;

    // constructor
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLList {
    Node head;

    // insert at beginning
    public void insertAtBeg(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // insert at specific position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            insertAtBeg(data);
            return;
        }

        Node temp = head;
        Node newNode = new Node(data);
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else if (temp.next == null) {
            insertAtEnd(data);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // delete at beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null) head.prev = null;
    }

    // delete at end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // delete at specific position
    public void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or list is empty");
            return;
        }
        if (position == 1) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }
    }

    // display the list
    public void display() {
        Node temp = head;
        System.out.print("null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // main method
    public static void main(String[] args) {
        DoublyLList list = new DoublyLList();

        list.insertAtBeg(10);
        list.insertAtBeg(20);
        list.insertAtBeg(30);
        list.insertAtBeg(40);
        list.insertAtBeg(50);

        list.insertAtEnd(100);
        list.insertAtPosition(75, 3);

        list.deleteAtBeginning();
        list.deleteAtEnd();
        list.deleteAtPosition(4);

        list.display();
    }
}
