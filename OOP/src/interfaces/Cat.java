package interfaces;

public class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("Wiskas");
    }

    public void run(){
        System.out.println("Gato esta corriendo");
    }
}
