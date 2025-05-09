package inheritance;

public class MainCatFamily {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Lion lion = new Lion();
        System.out.println(cat.isCanEatPerson());
        System.out.println(lion.isCanEatPerson());
    }
}
