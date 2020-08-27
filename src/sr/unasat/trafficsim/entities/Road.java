package sr.unasat.trafficsim.entities;

import sr.unasat.trafficsim.datastructures.LinkedList;
import sr.unasat.trafficsim.datastructures.Stack;

public class Road {
    private  String name;
    private Stack removedCars = new Stack();
    private LinkedList carList = new LinkedList();
    private int prioCarIndex;
    private int carCount;

    public Road(String name, int carCount) {
        this.name = name;
        this.carCount = carCount;
    }

    public Road(String name, int carCount,  int prioCarIndex) {
        this.name = name;
        this.carCount = carCount;
        this.prioCarIndex = prioCarIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack getRemovedCars() {
        return removedCars;
    }

    public void setRemovedCars(Stack removedCars) {
        this.removedCars = removedCars;
    }

    public int getPrioCarIndex() {
        return prioCarIndex;
    }

    public void setPrioCarIndex(int prioCarIndex) {
        this.prioCarIndex = prioCarIndex;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public LinkedList getCarList() {
        return carList;
    }

    public boolean isRoadEmpty(){
        return this.carList.isEmpty();
    }

    public void setCarList(LinkedList carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", removedCars=" + removedCars +
                ", carList=" + carList +
                ", prioCarIndex=" + prioCarIndex +
                ", carCount=" + carCount +
                '}';
    }
}
