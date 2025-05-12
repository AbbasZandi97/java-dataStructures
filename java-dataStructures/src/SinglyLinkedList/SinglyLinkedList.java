package SinglyLinkedList;

public class SinglyLinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }    

    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
            
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.print("null");
        }
        
        System.out.println();
        
    }

    public void deleteFirstNode() {
        
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        
        head = head.next;
    }

    public void deleteLastNode() {
        if (head == null) {
            System.out.println("Empty linked list.");
            return;
        }

        Node current = head;
        Node before = null;
        while (current.next != null) {
            before = current;
            current = current.next;
        }

        before.next = null;
    }

    public void deleteAtPosition(int pos) {
        int counter = 1;
        Node current = head; 
        Node previous = null;
        if (head == null) {
            System.out.println("List is empty. Nothing availabe to be deleted from the list.");
        }
        else if (pos == 1) {
            head = head.next;
        } else {
            
            while (counter < pos && current != null) {
                previous = current;
                current = current.next;
                counter++;
            }

            if (current == null) {
                System.out.println("Position " + pos + " is out of bounds.");
                return;
            }

            previous.next = current.next;
        }
    }

    public boolean containsKey(int searchKey) {
        
        if (head == null) {return false;}
        
        Node current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void reverse() {
        Node current = head;
        Node next = null;
        Node previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public int findNthNodeFromEnd(int position) {
        
        if (head == null || position <= 0) {
            throw new IllegalArgumentException("Invalid position");
        }
        
        // position is calculated from end from 1 index.
        Node refPointer = head;
        Node mainPointer = head;
        
        
        // make the gap between 2 pointers equal to position
        for (int i = 0; i < position; i++) {
            if (refPointer == null) {
                throw new IllegalArgumentException("Position is greater than the length of the list");
            }
            refPointer = refPointer.next;
        }

        // move 2 pointers toghether towards end of list.
        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        
        return mainPointer.data;
    }
}

