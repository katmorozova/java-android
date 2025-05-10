package interfaces;

public class Dog extends Animal implements AbleToRun{

    @Override
    public void eat() {
        System.out.println("Pedigree");
    }

    @Override
    public void run(){
        System.out.println("Perro esta corriendo");
    }
}
