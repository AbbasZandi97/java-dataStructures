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

    public void insertAtPosition(int data, int pos) throws Exception {
        Node newNode = new Node(data);
        

        if (head == null) {
            if (pos == 1) {
                head = newNode;
            } else {
                throw new Exception("List is empty. Invalid position.");
            }

        } else if (pos == 1) {
           newNode.next = head;
           head = newNode;
            
        } else {

            int currentPosition = 1;
            Node current = head;
            

            while (currentPosition < pos - 1 && current.next != null) {
                
                current = current.next;
                currentPosition++;
                
            }

            // program exited the previous while loop  too early since list boundry limitation
            if (currentPosition != pos - 1) {
                throw new Exception("Position out of boundary.");
            }

            newNode.next = current.next;
            current.next = newNode;
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

        // single node case
        if (head.next == null) {
            head = null;
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
        System.out.println("Linked list got reversed.");
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

    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty. nothing is available to delete.");
            return;
        }

        // deleting the head case
        if (pos == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        int currentPosition = 1;
        Node before = null;
        
        while (current != null && currentPosition < pos) {
            before = current;
            current = current.next;
            currentPosition++;
        }

        if (current != null) {
            before.next = current.next;
        } else {
            System.out.println("Position is out of range.");
        }

    
    }
    
    
    // this method works on sorted linked lists containing duplicates
    public void removeDuplicates() {
        if (head == null) {
            System.out.println("empty linked list.");
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // insert a node inside a sorted singly linked list
    public void insertNodeInSortedLinkedList(Node newNode) {
        if (head == null) {
            System.out.println("Empty Linked List.");
            return;
        }

        Node current = head;
        Node temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
    }

    public void removeKey(Node key) {
        Node current = head;
        Node temp = head;
        
        if (head == null) {
            System.out.println("List has not been initialized... !!");
            return;
        }
        
        if (current != null && current.data == key.data) {
            head = current.next;
            return;
        }

        while (current != null && current.data != key.data) {
            temp = current;
            current = current.next;
        }

        if (current == null) return;
        temp.next = current.next;
    }

    // this method just creates a chain of nodes to test
    public Node createALoopInLinkedList() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second;

        return first;
    }

    public Node doesContainLoop(Node firstNode) {
        head = firstNode;
        Node fastPtr = firstNode;
        Node slowPtr = firstNode;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                System.out.println("Linked List contains a loop");
                return slowPtr;
            }
        }

        return null;
    }

    /*
    next method is used with doesContainLoop method.
    the method parameter,node, is the node from previous method where slowPtr and fastPtr are equal(==).
     */
    public Node getStartingNode(Node node) {
        Node temp = head;
        while (temp != node) {
            temp = temp.next;
            node = node.next;
        }

        return temp;
    }



}

