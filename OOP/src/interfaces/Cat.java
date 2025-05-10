package interfaces;

public class Cat extends Animal implements AbleToRun{

    @Override
    public void eat() {
        System.out.println("Wiskas");
    }
@Override
    public void run(){
        System.out.println("Gato esta corriendo");
    }
}
