package sr.unasat.trafficsim.datastructures;

import sr.unasat.trafficsim.entities.Car;

public class LinkedList {
    public Node head;

    public Node getHead() {
        return head;
    }
    public void  show(){
        if (head.data == null)
            return;
        Node n = head;
        while (n.next != null){
            System.out.println(n.data.toString());
            n = n.next;
        }
        if (n.data ==null) return;
        System.out.println(n.data.toString());
    }

    public Car  get(int index){
        if (index < 0){
            return null;
        }
        if (head == null)
            return null;
        Node node = head;
        if (index == 0 && head != null){
            return node.data;
        }

        for (int i = 0; node.next != null && i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    public void insert(Car data){
        Node node = new Node();
        node.next = null;
        node.data = data;


        if (head == null){
            head = node;
        }else{
            Node n = head;
            while (n.next != null){
                n = n.next;
            }
            n.next = node;
        }
    }

    public void  insertAtStart(Car data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = node;
        }else{
            Node oldHead = head;

            head = node;

            head.next = oldHead;
        }
    }

    public void  insertAtMid(Car data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null){
            head = node;
        }else{
            Node n = head;
            int len = getCount();

            int count = ((len % 2) == 0) ? (len / 2) : (len + 1) / 2;

            while (count-- > 1){
                n = n.next;
            }

            node.next = n.next;
            n.next = node;
        }
    }

    public void insertAtIndex(int index, Car data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null){
            head = node;
        }else {
            if (index == 0) {
                node.next = head;
                head = node;
                return;
            }

            Node current = this.head;
            Node previous = null;

            int i = 0;

            while (i < index) {
                previous = current;
                current = current.next;

                if (current == null) {
                    break;
                }

                i++;
            }

            node.next = current;
            previous.next = node;
        }
    }

    public int getCount() {
        Node node = head;
        int count = 0;
        while (node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }



    public boolean isEmpty(){
        return head == null;
    }





    public void delete(int index){
        if (index < 0){
            return;
        }
        if (head == null)
            return;


        Node node = head;

        if (index == 0){
            head = node.next;   // Change head
            return;
        }

        for (int i = 0; node!=null && i<index-1; i++) {
            node = node.next;
        }
        if (node == null || node.next == null)
            return;

        Node next = node.next.next;
        node.next = next;
    }

//    Sorting
public Node mergeSort(Node head) {
    if(head == null || head.next == null) {
        return head;
    }

    Node middle = middleElement(head);
    Node nextofMiddle = middle.next;
    middle.next = null;

    Node left = mergeSort(head);
    Node right = mergeSort(nextofMiddle);

    Node sortedlist = merge(left, right);
    return sortedlist;
}

    Node merge(Node left, Node right) {
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }
        Node temp = null;

        if(left.data.getVolgNr() <= right.data.getVolgNr()) {
            temp = left;
            temp.next = merge(left.next, right);
        } else {
            temp = right;
            temp.next = merge(left, right.next);
        }
        return temp;
    }

    Node middleElement(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
