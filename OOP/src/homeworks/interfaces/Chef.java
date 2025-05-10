package homeworks.interfaces;

public class Chef extends Worker implements Driver{

    @Override
    public void work() {
        System.out.println("Chef esta cocinando.");
    }

    @Override
    public void drive(){
        System.out.println("Soy cocinero y puedo conducir");
    }
}
