public class MainDog {
    public static void main(String[] args) {

        Dog perro = new Dog();
        perro.name = "Lucky";
        perro.rasa = "Hasky";
        perro.weight = 3;

        String info = perro.getInfo();
        System.out.println(info);
    }
}
