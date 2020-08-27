package sr.unasat.trafficsim.app;

import sr.unasat.trafficsim.datastructures.BinaryTreeNode;
import sr.unasat.trafficsim.entities.Car;
import sr.unasat.trafficsim.entities.Road;
import sr.unasat.trafficsim.services.RoadBehavior;
import sr.unasat.trafficsim.services.Sensors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Road> roadList = new ArrayList<>();
        roadList.add(new Road("N",4, 2));
        roadList.add(new Road("Z",18, 16));
        roadList.add(new Road("O",5, -1));
        roadList.add(new Road("W",14,8));

        RoadBehavior roadBehavior = new RoadBehavior(roadList);

//        STEP 1: INITIAL STATE
        roadBehavior.setIntitalPlace();
        System.out.println();
//        STEP 2: REMOVE PRIO IN VOLGORDE
        System.out.println("PRIO AUTO'S RIJDEN OP");
        roadBehavior.removePrioCars();
        System.out.println();
        System.out.println("HUIDIGE SITUATIE");
        roadBehavior.currentState();
        System.out.println();
//        STEP 3: CALCULATE CYCLES PER SENSOR
        System.out.println("SENSOR CYCLUS CALCULATIE");
        roadBehavior.calcSensorCycle();
        System.out.println();
        System.out.println("SENSOREN STARTEN OP!");

//        STEP 4: START SENSORS

        while (true){
            if
            (
                roadList.get(0).isRoadEmpty() &&
                roadList.get(1).isRoadEmpty() &&
                roadList.get(2).isRoadEmpty() &&
                roadList.get(3).isRoadEmpty()
            )
            {
                System.out.println();
                System.out.println("ALLE AUTO'S ZIJN GWAAN");
                break;
            }
            else {
                for (Road road: roadList)  new Sensors(road);
            }
        }


        System.out.println();
//        STEP 5: REVERSE PLAYBACK
        System.out.println("ALLE AUTO'S OP HUN INITELE PLEK");
        roadBehavior.returnToPlace();
        System.out.println();

//        STEP 6: BINARY TREE MET ALLE AUTO'S
        System.out.println("BUILDING TREE");
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode("PP-00-00", null);
        for (Road road: roadList) {
            for (int i = 0; i < road.getCarCount(); i++) {
                Car car = road.getCarList().get(i);
                binaryTreeNode.put(car.getKenteken(),car);
            }
        }
        System.out.println("TREE BUILD");
        System.out.println();
        System.out.println("BALANCING TREE!");
        binaryTreeNode = binaryTreeNode.buildTree(binaryTreeNode);
        System.out.println("BALANCED TREE!");
        System.out.println();

//        STEP 6: ZOEKEN IN BINARY TREE
        System.out.println("---- ZOEKEN: ----");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Car car = binaryTreeNode.get(input);
        if (car != null){
            System.out.println("Auto Gevonden!");
            System.out.println("Auto met kentekenplaat: " + car.getKenteken()+ " op weg: " + car.getKenteken().charAt(0)+ " met volgnr: " + (car.getVolgNr() + 1));
        }else{
            System.out.println("Geen auto Gevonden!");
        }


    }



}
