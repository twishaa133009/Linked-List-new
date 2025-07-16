class Node {
    int data;
    Node next;

    // constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLList {
    Node head;

    // insert at beginning
    public void insertatbegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // insert at end
    public void insertatend(int data) {
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
    }

    // insert at specific position
    public void insertatspecificposition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            insertatbegin(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // delete at beginning
    public void deleteatbeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // delete at end
    public void deleteatend() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // delete at specific position
    public void deleteatspecificposition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or list is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
    }

    // display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLList list = new SinglyLList();

        list.insertatbegin(10);
        list.insertatbegin(20);
        list.insertatbegin(30);
        list.insertatbegin(40);
        list.insertatbegin(50);

        list.insertatend(100);
        list.insertatend(150);
        list.insertatend(200);

        list.insertatspecificposition(75, 4);

        list.deleteatbeginning();
        list.deleteatend();
        list.deleteatspecificposition(3);

        list.display();
    }
}
