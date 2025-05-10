package homeworks.interfaces;

import interfaces.AbleToFly;
import interfaces.AbleToRun;
import interfaces.Bird;

import java.util.ArrayList;

public class MainWorker {
    public static void main(String[] args) {

        Director director = new Director();
        Programmer programmer = new Programmer();
        Chef chef = new Chef();

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(director);
        workers.add(programmer);
        workers.add(chef);
        for (Worker worker : workers){
            worker.work();
        }


        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(programmer);
        drivers.add(chef);
        for (Driver driver : drivers){
            driver.drive();
        }


    }
}
