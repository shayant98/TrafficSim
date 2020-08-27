package sr.unasat.trafficsim.services;

import sr.unasat.trafficsim.datastructures.LinkedList;
import sr.unasat.trafficsim.entities.Car;
import sr.unasat.trafficsim.entities.Road;

import java.util.ArrayList;

public class RoadBehavior {

    private ArrayList<Road> roadList;
    private LinkedList prioCarList = new LinkedList();

    public RoadBehavior(ArrayList<Road>  roadList) {
        this.roadList = roadList;
    }

    public void returnToPlace(){


        for (Road road : roadList) {
            System.out.println( "----" + road.getName() + "----");
            LinkedList carList = road.getCarList();
            while (!road.getRemovedCars().isEmpty()){
                Car currentRemovedCar = road.getRemovedCars().peek();
                carList.insertAtStart(currentRemovedCar);
                road.getRemovedCars().pop();
            }
            if (road.getPrioCarIndex() > 0){
                Car firstCar = carList.get(0);
                carList.delete(0);
                carList.insertAtIndex(road.getPrioCarIndex(), firstCar);

            }
            for (int i = 0; i < carList.getCount(); i++) {
                Car currentCar = carList.get(i);
                if (currentCar != null){

                    System.out.println("AUTO van soort: "+ currentCar.getPrioType() +" met kenteken: " + currentCar.getKenteken() + " is terug!");
                }
            }

        }
    }

    public void removePrioCars(){
        int count  = prioCarList.getCount();
        for (int i = 0; i < count; i++) {
            Car currentCar = prioCarList.get(i);
            if (currentCar != null){

                System.out.println("PRIO AUTO van soort: "+ currentCar.getPrioType() +" met kenteken: " + currentCar.getKenteken() + " rijdt weg!");
            }
        }

        for (Road road : roadList) {
            Car car = road.getCarList().get(road.getPrioCarIndex());
            if (car != null){
                road.getRemovedCars().push(road.getCarList().get(road.getPrioCarIndex()));
                road.getCarList().delete(road.getPrioCarIndex());
            }

        }

    }

    public void setIntitalPlace(){
        for (Road road :  roadList) {
            System.out.println( "----" + road.getName() + "----");
            for (int i = 0; i < road.getCarCount(); i++) {
                LinkedList carList = road.getCarList();
                String prioType = "";
                if (i == road.getPrioCarIndex()){
                    switch(road.getName()) {
                        case "N":
                            prioType = "A";
                            break;
                        case "Z":
                            prioType = "B";
                            break;
                        case "W":
                            prioType = "P";
                            break;
                        default:
                            // code block
                    }
                }
                Car car = new Car(i, generateKenteken(i, road.getName()), i == road.getPrioCarIndex(), prioType);
                System.out.println("AUTO van soort: "+ car.getPrioType() +" met kenteken: " + car.getKenteken() + " is op plek!");
                switch(car.getPrioType()) {
                    case "A":
                        this.prioCarList.insert(car);
                        break;
                    case "B":
                        prioCarList.insertAtIndex(0, car);
                        break;
                    case "P":
                        prioCarList.insertAtStart(car);
                        break;
                    default:

                }
                carList.insert(car);
                road.setCarList(carList);
            }

        }

    }

    public  void currentState(){
        for (Road road: roadList){
            System.out.println( "----" + road.getName() + "----");
            for (int i = 0; i < road.getCarList().getCount(); i++) {
                Car car = road.getCarList().get(i);
                System.out.println("AUTO van soort: "+ car.getPrioType() +" met kenteken: " + car.getKenteken() + " is op plek!");
            }
        }
    }

    public void calcSensorCycle(){
        for (Road road: roadList){
            int totalCycles = 0 ;
            int carCount = road.getCarCount();
            switch(road.getName()) {
                case "N":
                    while (carCount > 0){
                        totalCycles++;
                        if (carCount < 5){
                            carCount = 0;
                        }else{
                            carCount = carCount - 5;
                        }
                    }
                    break;
                case "Z":
                case "W":

                    while (carCount > 0){
                        totalCycles++;
                        if (carCount <= 10){

                            carCount = carCount-5;
                        }
                        if (carCount > 10){
                            carCount = carCount - 10;
                        }


                    }
                    break;
                case "O":
                    while (carCount > 0){
                        totalCycles++;
                        carCount = carCount-5;
                    }
                    break;
                default:
                    // code block
            }
            System.out.println(road.getName()+": " + totalCycles );
        }
    }

    private static String generateKenteken(int i, String name) {
        return name +"P-" + "00-" + ((i >= 10) ? i : "0" + i);
    }



}
