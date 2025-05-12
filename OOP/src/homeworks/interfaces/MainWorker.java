package homeworks.interfaces;

import java.util.ArrayList;

public class MainWorker {
    public static void main(String[] args) {

        Director director = new Director();
        Programmer programmer = new Programmer();
        Chef chef = new Chef();

        ArrayList<Worker> workers = new ArrayList<>();
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


        //director.force(programmer);
        director.force(new Worker() {
            @Override
            public void work() {
                System.out.println("Work");
            }
        });

    }
}
