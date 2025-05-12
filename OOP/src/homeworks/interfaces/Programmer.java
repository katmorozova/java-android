package homeworks.interfaces;

public class Programmer implements Worker, Driver{
    @Override
    public void work() {
        System.out.println("Programador esta escribiendo un programa.");
    }

    @Override
    public void drive(){
        System.out.println("Soy programador y puedo conducir");
    }
}
