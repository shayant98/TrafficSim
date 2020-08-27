package sr.unasat.trafficsim.datastructures;

import sr.unasat.trafficsim.entities.Car;

public class Node {
    Car data;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
