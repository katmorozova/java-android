package interfaces;

public class Bird extends Animal implements AbleToRun{

    @Override
    public void eat() {
        System.out.println("Moras");
    }

    @Override
    public void run(){
        System.out.println("Pajaro esta corriendo");
    }
}
