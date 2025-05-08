public class MainDog {
    public static void main(String[] args) {

        Dog perro = new Dog();
        perro.name = "Lucky";
        perro.breed = "Hasky";
        perro.weight = 3;
        perro.speed = 5;

        String info = perro.getInfo();
        System.out.println(info);
        perro.run();
    }
}
