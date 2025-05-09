package homeworks;

public class MainPersonWrappers {
    public static void main(String[] args) {

        String text = "This is John. He is 27 years old.";
        String name = text.substring(8, 12);

        String date = text.substring(20,22);
        int age = Integer.parseInt(date);

        PersonWrappers person = new PersonWrappers(name, age);
        person.showInfo();
    }
}
