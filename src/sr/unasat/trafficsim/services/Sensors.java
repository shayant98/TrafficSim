package sr.unasat.trafficsim.services;

import sr.unasat.trafficsim.datastructures.LinkedList;
import sr.unasat.trafficsim.entities.Car;
import sr.unasat.trafficsim.entities.Road;

public class Sensors {

    Road road;
    public Sensors(Road road) {
        this.road = road;
        runSensor();
    }


    public void runSensor(){
        System.out.println();
        System.out.println("SENSOR " + this.road.getName() + " IS AAN DE BEURT");

        switch(this.road.getName()) {
            case "N":
                NoordSensor();
                break;
            case "Z":
                ZuidSensor();
                break;
            case "O":
                OostSensor();
                break;
            case "W":
                WestSensor();
                break;
        }
    }

    private void WestSensor() {
        LinkedList carList = road.getCarList();
        if (carList.isEmpty()){
            System.out.println("WEST SKIP");
        }else {
            System.out.println("WEST: GROEN LICHT" );
            if (carList.getCount() > 10){
                removeCars(10);
            }else{
                removeCars(5);
            }
        }
    }

    private void OostSensor() {
        LinkedList carList = road.getCarList();
        if (carList.isEmpty()){
            System.out.println("OOST SKIP");
        }else{
            System.out.println("OOST: GROEN LICHT" );
            removeCars(5);
        }
    }

    private void ZuidSensor() {
        LinkedList carList = road.getCarList();
        if (carList.getCount() > 10){
            System.out.println("ZUID: GROEN LICHT" );

            removeCars(10);
        }else{
            System.out.println("ZUID: GROEN LICHT" );

            removeCars(5);
        }

    }

    private void NoordSensor() {
        LinkedList carList = road.getCarList();
        if (carList.getCount() < 5){
            System.out.println("NOORD: GROEN LICHT" );

            removeCars(carList.getCount());
        }else {
            System.out.println("NOORD: GROEN LICHT" );

            removeCars(4);
        }
    }

    private void removeCars(int count) {
        LinkedList carList = road.getCarList();
        for (int i = 0; i < count; i++) {
            Car currentCar = carList.get(0);
            if (currentCar != null){
                System.out.println("AUTO met kenteken: " + currentCar.getKenteken() + " rijdt weg!");
                road.getRemovedCars().push(currentCar);
                carList.delete(0);
            }
        }
    }


}
